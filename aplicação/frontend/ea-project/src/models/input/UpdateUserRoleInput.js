import BaseInput from './BaseInput';

export default class UpdateUserRoleInput extends BaseInput {
    constructor(roleId = 0, userId = 0) {
        super();
        this.roleId = roleId;
        this.userId = userId;
    }
}
