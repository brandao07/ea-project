import BaseInput from "./BaseInput";

export default class UpdateUserInfoInput extends BaseInput {
  constructor(
    userId = 0,
    name = "",
    email = "",
    gender = "",
    age = 0,
    height = 0.0,
    weight = 0.0
  ) {
    super();
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}
