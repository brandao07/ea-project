import os
import re

# Input and output directories
java_dirs = [
    '../app/backend/src/main/java/eaproject/input',
    '../app/backend/src/main/java/eaproject/output',
    '../app/backend/src/main/java/eaproject/controller'  # Added controller directory
]
js_dirs = [
    '../app/frontend/ea-project/src/models/input',
    '../app/frontend/ea-project/src/models/output',
    '../app/frontend/ea-project/src/services'  # Added services directory
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

# Function to extract constructor parameters of output models


def get_output_model_constructor_params(output_dir):
    constructor_params = {}
    for root, _, files in os.walk(output_dir):
        for filename in files:
            if filename.endswith('.js'):
                class_name = filename.replace('.js', '')
                with open(os.path.join(root, filename), 'r') as file:
                    content = file.read()
                constructor_match = re.search(
                    r'constructor\(([^)]*)\)', content)
                if constructor_match:
                    params = [param.strip().split('=')[0].strip()
                              for param in constructor_match.group(1).split(',')]
                    constructor_params[class_name] = params
    return constructor_params

# Function to convert Java code to JavaScript


def java_to_js(java_code):
    # Extract class name and base class
    class_name_match = re.search(
        r'public (abstract )?class (\w+)( extends (\w+))?', java_code)
    if not class_name_match:
        raise ValueError("Class name not found in Java code")

    class_name = class_name_match.group(2)
    base_class = class_name_match.group(
        4) if class_name_match.group(4) else None

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
        js_code += f'export default class {
            class_name} extends {base_class} ' + '{\n'
    else:
        js_code += f'export default class {class_name} ' + '{\n'
    js_code += '  constructor('

    constructor_params = []
    constructor_body = []
    for field_type, field_name in fields:
        if field_type.startswith('ArrayList<'):
            inner_class_name = re.search(
                r'ArrayList<(\w+)>', field_type).group(1)
            constructor_params.append(
                f"{field_name} = {js_type_default['ArrayList']}")
            constructor_body.append(
                f"    this.{field_name} = {field_name}.map(item => new {class_name}.{
                    inner_class_name}(item));"
            )
        elif field_type.startswith('List<'):
            inner_class_name = re.search(r'List<(\w+)>', field_type).group(1)
            constructor_params.append(
                f"{field_name} = {js_type_default['List']}")
            constructor_body.append(
                f"    this.{field_name} = {field_name}.map(item => new {class_name}.{
                    inner_class_name}(item));"
            )
        elif field_type in js_type_default:
            default_value = js_type_default.get(field_type, 'null')
            constructor_params.append(f"{field_name} = {default_value}")
            constructor_body.append(f"    this.{field_name} = {field_name};")
        else:
            # Default initialization for unknown types
            constructor_params.append(f"{field_name} = {{}}")
            constructor_body.append(f"    this.{field_name} = new {
                                    class_name}.{field_type}({field_name});")

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
        inner_classes = re.findall(
            inner_class_pattern, inner_classes_code, re.DOTALL)

        # Add inner classes
        for inner_class in inner_classes:
            inner_class_name = inner_class[0]
            inner_class_body = inner_class[2]

            inner_fields = re.findall(
                r'private (\w+) (\w+);', inner_class_body)
            inner_public_fields = re.findall(
                r'public (\w+) (\w+);', inner_class_body)
            inner_fields += inner_public_fields

            js_code += f'\n  static {inner_class_name} = class ' + '{\n'
            js_code += '    constructor('
            inner_constructor_params = []
            for field in inner_fields:
                field_type = field[0]
                field_name = field[1]
                default_value = js_type_default.get(field_type, 'null')
                inner_constructor_params.append(
                    f"{field_name} = {default_value}")
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
        # Clear output directories but keep specific files
        clear_directory_but_keep(js_dir, keep_files)
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

# Function to parse controllers and generate service files


def parse_controllers_and_generate_services(controller_dir, service_dir, api_config_path, output_model_constructor_params):
    api_endpoints = {}
    service_files = {}

    for root, _, files in os.walk(controller_dir):
        for filename in files:
            if filename.endswith('.java'):
                with open(os.path.join(root, filename), 'r') as file:
                    java_code = file.read()

                # Extract class name
                class_name_match = re.search(
                    r'class (\w+)Controller', java_code)
                if not class_name_match:
                    continue
                class_name = class_name_match.group(1)

                # Extract methods
                methods = re.findall(
                    r'@PostMapping\("(/[\w]+)"\)\s+public (\w+) (\w+)\(@RequestBody (\w+) (\w+)', java_code)

                service_code = f'import ApiService from "@/services/ApiService";\n'
                service_code += f'import API_ENDPOINTS from "@/config/api";\n'
                service_code += f'import FeedbackMessage from "@/models/base/FeedbackMessage";\n'
                service_code += f'import FeedbackSeverity from "@/models/enums/FeedbackSeverity";\n'
                service_code += f'import EventBus from "@/eventBus";\n\n'

                service_code += f'class {class_name}Service {{\n'

                for endpoint, return_type, method_name, input_type, input_name in methods:
                    # Format endpoint constant correctly
                    endpoint_constant = re.sub(
                        r'([a-z0-9])([A-Z])', r'\1_\2', endpoint.replace('/', '')).upper()
                    api_endpoints[endpoint_constant] = f"{endpoint}"

                    # Add import statements for output objects
                    output_import = f'import {
                        return_type} from "@/models/output/{return_type}";\n'
                    service_files.setdefault(
                        class_name, set()).update([output_import])

                    # Generate generic comment
                    comment = f'''  /**
   * {method_name.replace("_", " ").capitalize()}
   * @param {{{input_type}}} {input_name} - The {input_name.replace('_', ' ')}
   * @returns {{Promise<{return_type}>}} The {return_type.replace('_', ' ')}
   */\n'''

                    # Generate service method
                    service_code += comment
                    service_code += f'  async {method_name}({input_name}) {{\n'
                    service_code += f'    try {{\n'
                    service_code += f'      const response = await ApiService.post(API_ENDPOINTS.{
                        endpoint_constant}, {input_name});\n'

                    constructor_params = output_model_constructor_params.get(
                        return_type, [])
                    constructor_args = ', '.join([f'response.{
                                                 param}' if param != 'feedbackMessages' else 'feedbackMessages' for param in constructor_params])

                    if 'feedbackMessages' in constructor_params:
                        service_code += f'      const feedbackMessages = response.feedbackMessages.map(\n'
                        service_code += f'        (msg) => new FeedbackMessage(msg.message, FeedbackSeverity[msg.severity])\n'
                        service_code += f'      );\n'

                    service_code += f'      const output = new {
                        return_type}({constructor_args});\n'

                    if 'feedbackMessages' in constructor_params:
                        service_code += f'      output.feedbackMessages.forEach((msg) => {{\n'
                        service_code += f'        EventBus.emit("feedback-message", msg);\n'
                        service_code += f'      }});\n'

                    service_code += f'      return output;\n'
                    service_code += f'    }} catch (error) {{\n'
                    service_code += f'      const errorMessage = new FeedbackMessage(\n'
                    service_code += f'        "An error occurred during {
                        method_name}.",\n'
                    service_code += f'        FeedbackSeverity.DANGER\n'
                    service_code += f'      );\n'
                    error_args = ', '.join(
                        ['""' if param != 'feedbackMessages' else '[errorMessage]' for param in constructor_params])
                    service_code += f'      const output = new {
                        return_type}({error_args});\n'
                    service_code += f'      EventBus.emit("feedback-message", errorMessage);\n'
                    service_code += f'      return output;\n'
                    service_code += f'    }}\n'
                    service_code += f'  }}\n\n'

                service_code += '}\n\n'
                service_code += f'export default new {class_name}Service();\n'

                # Write the service file
                service_filename = f'{class_name}Service.js'
                with open(os.path.join(service_dir, service_filename), 'w') as file:
                    file.write(service_code)
                print(f'Generated {service_filename} from {filename}')

    # Generate API endpoints config file
    api_config_code = 'const BASE_URL = \'http://localhost:7000/api\'; // Adjust based on backend URL\n\n'
    api_config_code += 'const API_ENDPOINTS = {\n'
    for endpoint_constant, endpoint in api_endpoints.items():
        api_config_code += f'  {endpoint_constant}: `${{BASE_URL}}{endpoint}`,\n'
    api_config_code += '};\n\n'
    api_config_code += 'export default API_ENDPOINTS;\n'

    with open(api_config_path, 'w') as file:
        file.write(api_config_code)
    print('Generated API endpoints configuration')

    # Write the service files with correct imports
    for class_name, imports in service_files.items():
        service_filename = f'{class_name}Service.js'
        with open(os.path.join(service_dir, service_filename), 'r+') as file:
            existing_code = file.read()
            file.seek(0)
            file.write(''.join(sorted(imports)) + '\n' + existing_code)
            file.truncate()


# Process input and output files
process_files(java_dirs[:2], js_dirs[:2])

# Extract output model constructor parameters
output_model_constructor_params = get_output_model_constructor_params(
    js_dirs[1])

# Process controllers to generate services and API config
parse_controllers_and_generate_services(
    '../app/backend/src/main/java/eaproject/controller',
    '../app/frontend/ea-project/src/services',
    '../app/frontend/ea-project/src/config/api.js',
    output_model_constructor_params
)
