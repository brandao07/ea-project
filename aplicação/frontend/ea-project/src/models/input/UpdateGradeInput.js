import BaseInput from './BaseInput';

export default class UpdateGradeInput extends BaseInput {
    constructor(id = 0, name = '', minAge = 0, maxAge = 0, gender = '', creationDate = new Date(), lazyLoad = false) {
        super(lazyLoad);
        this.id = id;
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
        this.creationDate = creationDate;
    }
}
