import BaseOutput from './BaseOutput';

export default class GetStateByIdOutput extends BaseOutput {
    constructor(creationDate = new Date(), name = '', id = 0, feedbackMessages = []) {
        super(feedbackMessages);
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }
}
