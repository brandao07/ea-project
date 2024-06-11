import BaseInput from "./BaseInput";

export default class UpdateUserInput extends BaseInput {
  constructor(id = 0, name = '', email = '', gender = '', age = 0, height = 0.0, weight = 0.0, lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}