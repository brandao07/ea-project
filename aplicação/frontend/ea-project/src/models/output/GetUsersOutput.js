import BaseOutput from "./BaseOutput";

export default class GetUsersOutput extends BaseOutput {
  constructor(getuserList = [], feedbackMessages = []) {
    super(feedbackMessages);
    this.getuserList = getuserList.map(
      (getuser) =>
        new GetUsersOutput.GetUserProperties(
          getuser.id,
          getuser.name,
          getuser.email,
          getuser.gender,
          getuser.age,
          getuser.height,
          getuser.weight,
          getuser.registerDate,
          getuser.photographyPath
        )
    );
  }

  static GetUserProperties = class {
    constructor(
      id,
      name,
      email,
      gender,
      age,
      height,
      weight,
      registerDate,
      photographyPath
    ) {
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
