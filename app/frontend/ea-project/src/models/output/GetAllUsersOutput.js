import BaseOutput from "./BaseOutput";
import GenderEnumerator from "../enums/Gender";

export default class GetAllUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.usersList = Array.isArray(usersList) ? usersList.map(item => new GetAllUsersOutput.UserProperties(item)) : [];
  }

  static UserProperties = class {
    constructor({id = 0, name = '',clubid='',email = '', gender = '', age = 0, weight = 0.0, registerDate = new Date(), photographyPath = ''}) {
      this.id = id;
      this.name = name;
      this.clubid= clubid;
      this.email = email;
      for (const key in GenderEnumerator) {
        if (key === gender) {
          this.gender = GenderEnumerator[key];
          break;
        }
      }
      this.age = age;
      this.weight = weight;
      this.registerDate = registerDate;
      this.photographyPath = photographyPath;
    }
  };
}