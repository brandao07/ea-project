import BaseInput from "./BaseInput";

export default class UpdateUserRoleInput extends BaseInput {
  constructor(userId = 0, roleId = 0) {
    super();
    this.userId = userId;
    this.roleId = roleId;
  }
}
