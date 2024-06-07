import BaseOutput from './BaseOutput';

export default class GetClubByIdOutput extends BaseOutput {
    constructor(creationDate = new Date(), isActive = false, name = '', id = 0, feedbackMessages = []) {
        super(feedbackMessages);
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.creationDate = creationDate;
    }
}
