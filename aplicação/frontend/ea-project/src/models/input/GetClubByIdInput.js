import BaseInput from './BaseInput';

export default class GetClubByIdInput extends BaseInput {
    constructor(id = 0, lazyLoad = false) {
        super(lazyLoad);
        this.id = id;
    }
}
