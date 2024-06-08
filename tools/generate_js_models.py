import os
import re

def read_files_from_directory(directory):
    file_contents = {}
    for filename in os.listdir(directory):
        if filename.endswith(".java"):
            with open(os.path.join(directory, filename), 'r') as file:
                file_contents[filename] = file.read()
    return file_contents

def extract_class_name(java_content):
    match = re.search(r'public class (\w+)', java_content)
    if match:
        return match.group(1)
    return None

def extract_fields(java_content):
    fields = []
    matches = re.findall(r'private\s+(\w+(\<\w+\>)?)\s+(\w+);', java_content)
    for match in matches:
        field_type, _, field_name = match
        fields.append({
            'field_type': field_type,
            'field_name': field_name
        })
    return fields

def extract_getters_and_setters(java_content):
    fields = {}
    matches = re.findall(r'public\s+(\w+)\s+(\w+)\(\)\s*{.*?return\s+(\w+);.*?}', java_content, re.DOTALL)
    for match in matches:
        field_type, getter_name, var_name = match
        field_name = getter_name[3:] if getter_name.startswith('is') else getter_name[2:]
        field_name = field_name[0].lower() + field_name[1:]
        fields[field_name] = {
            'field_type': field_type,
            'field_name': var_name
        }
    return list(fields.values())

def convert_type(java_type):
    type_mapping = {
        'String': ('String', "''"),
        'int': ('Number', '0'),
        'boolean': ('Boolean', 'false'),
        'double': ('Number', '0.0'),
        'Timestamp': ('Date', 'new Date()'),
        'List': ('Array', '[]')
    }
    return type_mapping.get(java_type.split('<')[0], ('Object', 'null'))

def extract_nested_classes(java_content):
    nested_classes = {}
    matches = re.findall(r'public static class (\w+) .*?{(.*?)}', java_content, re.DOTALL)
    for match in matches:
        class_name, class_content = match
        nested_classes[class_name] = extract_fields(class_content)
    return nested_classes

def generate_input_js_content(class_name, fields):
    constructor_params = ""
    constructor_body = ""
    for field in fields:
        js_type, default_value = convert_type(field['field_type'])
        constructor_params += f"{field['field_name']} = {default_value}, "
        constructor_body += f"        this.{field['field_name']} = {field['field_name']};\n"

    constructor_params += "lazyLoad = false"
    constructor_body = "        super(lazyLoad);\n" + constructor_body

    js_content = f"""import BaseInput from './BaseInput';

export default class {class_name} extends BaseInput {{
    constructor({constructor_params}) {{
{constructor_body}    }}
}}
"""
    return js_content

def generate_output_js_content(class_name, fields, nested_classes):
    constructor_params = "feedbackMessages = []"
    constructor_body = "        super(feedbackMessages);\n"
    field_names = set()
    for field in fields:
        if field['field_name'] not in field_names:
            js_type, default_value = convert_type(field['field_type'])
            if js_type == 'Array':
                item_type = field['field_type'].split('<')[1].rstrip('>')
                constructor_body += f"        this.{field['field_name']} = {field['field_name']}.map(item => new {class_name}.{item_type}(item));\n"
                constructor_params = f"{field['field_name']} = {default_value}, " + constructor_params
            else:
                constructor_body += f"        this.{field['field_name']} = {field['field_name']};\n"
                constructor_params = f"{field['field_name']} = {default_value}, " + constructor_params
            field_names.add(field['field_name'])

    constructor_params = constructor_params.rstrip(", ")

    js_content = f"""import BaseOutput from './BaseOutput';

export default class {class_name} extends BaseOutput {{
    constructor({constructor_params}) {{
{constructor_body}    }}
"""
    for nested_class, nested_fields in nested_classes.items():
        nested_constructor_params = ", ".join([f"{f['field_name']} = {convert_type(f['field_type'])[1]}" for f in nested_fields])
        nested_constructor_body = "\n".join([f"            this.{f['field_name']} = {f['field_name']};" for f in nested_fields])

        js_content += f"""
    static {nested_class} = class {{
        constructor({nested_constructor_params}) {{
{nested_constructor_body}
        }}
    }};
"""

    js_content += "}\n"
    return js_content

def generate_base_input_js_content(output_dir):
    base_input_content = """export default class BaseInput {
    constructor(lazyLoad = false) {
        this.lazyLoad = lazyLoad;
    }
}
"""
    base_input_path = os.path.join(output_dir, 'BaseInput.js')
    with open(base_input_path, 'w') as file:
        file.write(base_input_content)

def generate_base_output_js_content(output_dir):
    base_output_content = """import FeedbackMessage from "../base/FeedbackMessage";

export default class BaseOutput {
    constructor(feedbackMessages = []) {
        this.feedbackMessages = [];
        this.setFeedbackMessages(feedbackMessages);
    }

    setFeedbackMessages(feedbackMessages) {
        this.feedbackMessages = feedbackMessages.map(
            (msg) => new FeedbackMessage(msg.message, msg.severity)
        );
    }

    addFeedbackMessage(message, severity) {
        this.feedbackMessages.push(new FeedbackMessage(message, severity));
    }
}
"""
    base_output_path = os.path.join(output_dir, 'BaseOutput.js')
    with open(base_output_path, 'w') as file:
        file.write(base_output_content)

def main(input_dir, output_dir, js_input_dir, js_output_dir):
    input_files = read_files_from_directory(input_dir)
    output_files = read_files_from_directory(output_dir)

    os.makedirs(js_input_dir, exist_ok=True)
    os.makedirs(js_output_dir, exist_ok=True)

    generate_base_input_js_content(js_input_dir)
    generate_base_output_js_content(js_output_dir)

    for filename, content in input_files.items():
        class_name = extract_class_name(content)
        if not class_name:
            continue
        fields = extract_fields(content)
        js_content = generate_input_js_content(class_name, fields)
        js_file_path = os.path.join(js_input_dir, f'{class_name}.js')
        with open(js_file_path, 'w') as js_file:
            js_file.write(js_content)

    for filename, content in output_files.items():
        class_name = extract_class_name(content)
        if not class_name:
            continue
        fields = extract_fields(content)
        getter_fields = extract_getters_and_setters(content)
        for field in getter_fields:
            if field not in fields:
                fields.append(field)
        nested_classes = extract_nested_classes(content)
        js_content = generate_output_js_content(class_name, fields, nested_classes)
        js_file_path = os.path.join(js_output_dir, f'{class_name}.js')
        with open(js_file_path, 'w') as js_file:
            js_file.write(js_content)

    print('Arquivos JavaScript gerados. \n\n WiP -------->>>>>> Validar os objetos JS !!!!')

if __name__ == "__main__":
    input_dir = '../aplicação/backend/src/main/java/eaproject/input'
    output_dir = '../aplicação/backend/src/main/java/eaproject/output'
    js_input_dir = '../aplicação/frontend/ea-project/src/models/input'
    js_output_dir = '../aplicação/frontend/ea-project/src/models/output'
    main(input_dir, output_dir, js_input_dir, js_output_dir)
