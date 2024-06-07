import BaseOutput from './BaseOutput';

export default class GetTypeByIdOutput extends BaseOutput {
    constructor(creationDate = new Date(), numberOfPersons = 0, name = '', id = 0, feedbackMessages = []) {
        super(feedbackMessages);
        this.id = id;
        this.name = name;
        this.numberOfPersons = numberOfPersons;
        this.creationDate = creationDate;
    }
}
