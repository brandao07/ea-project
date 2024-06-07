import BaseOutput from './BaseOutput';

export default class GetUsersOutput extends BaseOutput {
  constructor(usersList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.usersList = usersList.map(item => new GetUsersOutput.UserProperties(item));
    }

    static UserProperties = class {
        constructor(id = 0, name = '', email = '', gender = '', age = 0, height = 0.0, weight = 0.0, registerDate = new Date(), photographyPath = '') {
            this.id = id;
            this.name = name;
            this.email = email;
            this.gender = gender;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.registerDate = registerDate;
            this.photographyPath = photographyPath;
        }
    };
}
