import BaseInput from './BaseInput';

export default class UpdateUserRoleInput extends BaseInput {
    constructor(roleId = 0, userId = 0, lazyLoad = false) {
        super(lazyLoad);
        this.roleId = roleId;
        this.userId = userId;
    }
}
