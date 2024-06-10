import BaseInput from "./BaseInput";

export default class UpdateUserInput extends BaseInput {
  constructor(id = 0, name = '', email = '', gender = '', age = 0, height = null, weight = null, lazyLoad = false) {
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