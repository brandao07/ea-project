import BaseInput from "./BaseInput";

export default class CreateUserInput extends BaseInput {
  constructor(name = '', email = '', password = '', gender = '', age = 0, height = 0.0, weight = 0.0, role="",lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.role = role;
  }
}