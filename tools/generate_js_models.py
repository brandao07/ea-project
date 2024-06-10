import os
import re
import shutil

# Input and output directories
java_dirs = [
    '../aplicação/backend/src/main/java/eaproject/input',
    '../aplicação/backend/src/main/java/eaproject/output'
]
js_dirs = [
    '../aplicação/frontend/ea-project/src/models/input',
    '../aplicação/frontend/ea-project/src/models/output'
]
js_type_default = {
    'String': "''",
    'int': '0',
    'boolean': 'false',
    'double': '0.0',
    'Double': '0.0',
    'float': '0.0',
    'Float': '0.0',
    'Timestamp': 'new Date()',
    'Datetime': 'new Date()',
    'Integer': '0',
    'ArrayList': '[]',
    'List': '[]'
}

# Function to convert Java code to JavaScript
def java_to_js(java_code):
    # Extract class name and base class
    class_name_match = re.search(r'public (abstract )?class (\w+)( extends (\w+))?', java_code)
    if not class_name_match:
        raise ValueError("Class name not found in Java code")
    
    class_name = class_name_match.group(2)
    base_class = class_name_match.group(4) if class_name_match.group(4) else None

    # Ignore base input and base output classes
    if class_name in ['BaseInput', 'BaseOutput']:
        return None

    # Extract fields
    java_class_code = re.split(r'public static ', java_code, maxsplit=1)
    fields = re.findall(r'private (\w+(?:<\w+>)?) (\w+);', java_class_code[0])
    public_fields = re.findall(r'public (\w+) (\w+);', java_class_code[0])
    fields += public_fields

    # Generate JavaScript code for all classes
    js_code = ''
    if base_class:
        js_code += f'import {base_class} from "./{base_class}";\n\n'
        js_code += f'export default class {class_name} extends {base_class} ' + '{\n'
    else:
        js_code += f'export default class {class_name} ' + '{\n'
    js_code += '  constructor('
    
    constructor_params = []
    constructor_body = []
    for field_type, field_name in fields:
        if field_type.startswith('ArrayList<'):
            inner_class_name = re.search(r'ArrayList<(\w+)>', field_type).group(1)
            constructor_params.append(f"{field_name} = {js_type_default['ArrayList']}")
            constructor_body.append(
                f"    this.{field_name} = {field_name}.map(item => new {class_name}.{inner_class_name}(item));"
            )
        elif field_type.startswith('List<'):
            inner_class_name = re.search(r'List<(\w+)>', field_type).group(1)
            constructor_params.append(f"{field_name} = {js_type_default['List']}")
            constructor_body.append(
                f"    this.{field_name} = {field_name}.map(item => new {class_name}.{inner_class_name}(item));"
            )
        elif field_type in js_type_default:
            default_value = js_type_default.get(field_type, 'null')
            constructor_params.append(f"{field_name} = {default_value}")
            constructor_body.append(f"    this.{field_name} = {field_name};")
        else:
            constructor_params.append(f"{field_name} = {{}}")  # Default initialization for unknown types
            constructor_body.append(f"    this.{field_name} = new {class_name}.{field_type}({field_name});")

    if base_class:
        if base_class == 'BaseInput':
            constructor_params.append("lazyLoad = false")
            constructor_body.insert(0, "    super(lazyLoad);")
        elif base_class == 'BaseOutput':
            constructor_params.append("feedbackMessages = []")
            constructor_body.insert(0, "    super(feedbackMessages);")
        else:
            constructor_body.insert(0, "    super();")

    js_code += ', '.join(constructor_params)
    js_code += ') {\n'
    js_code += '\n'.join(constructor_body)
    js_code += '\n  }\n'

    if len(java_class_code) > 1:
        # Add inner classes
        inner_classes_code = java_class_code[1]
        inner_class_pattern = r'class\s+(\w+)( implements \w+)? \{(.*?)\n\s*\}'
        inner_classes = re.findall(inner_class_pattern, inner_classes_code, re.DOTALL)

        # Add inner classes
        for inner_class in inner_classes:
            inner_class_name = inner_class[0]
            inner_class_body = inner_class[2]
            
            inner_fields = re.findall(r'private (\w+) (\w+);', inner_class_body)
            inner_public_fields = re.findall(r'public (\w+) (\w+);', inner_class_body)
            inner_fields += inner_public_fields
            
            js_code += f'\n  static {inner_class_name} = class ' + '{\n'
            js_code += '    constructor('
            inner_constructor_params = []
            for field in inner_fields:
                field_type = field[0]
                field_name = field[1]
                default_value = js_type_default.get(field_type, 'null')
                inner_constructor_params.append(f"{field_name} = {default_value}")
            js_code += ', '.join(inner_constructor_params)
            js_code += ') {\n'
            for field in inner_fields:
                js_code += f'      this.{field[1]} = {field[1]};\n'
            js_code += '    }\n'
            js_code += '  };\n'
        
    js_code += '}'
        
    return js_code

# Function to clear output directories but keep specific files
def clear_directory_but_keep(directory, keep_files):
    if os.path.exists(directory):
        for root, _, files in os.walk(directory):
            for file in files:
                file_path = os.path.join(root, file)
                if file not in keep_files:
                    os.remove(file_path)
    else:
        os.makedirs(directory)

# Function to process files in a directory and generate corresponding JS files
def process_files(java_dirs, js_dirs):
    keep_files = ['BaseInput.js', 'BaseOutput.js']
    for java_dir, js_dir in zip(java_dirs, js_dirs):
        clear_directory_but_keep(js_dir, keep_files)  # Clear output directories but keep specific files
        for root, _, files in os.walk(java_dir):
            for filename in files:
                if filename.endswith('.java'):
                    with open(os.path.join(root, filename), 'r') as file:
                        java_code = file.read()
                    
                    js_code = java_to_js(java_code)
                    
                    if js_code:  # Ensure js_code is not None
                        js_filename = filename.replace('.java', '.js')
                        with open(os.path.join(js_dir, js_filename), 'w') as file:
                            file.write(js_code)
                        print(f'Generated {js_filename} from {filename}')
                    else:
                        print(f'Skipped {filename} as it is a base class.')

# Process input and output files
process_files(java_dirs, js_dirs)
