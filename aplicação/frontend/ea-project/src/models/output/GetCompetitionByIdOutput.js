import BaseOutput from './BaseOutput';

export default class GetCompetitionByIdOutput extends BaseOutput {
    constructor(creationDate = new Date(), isActive = false, endDate = new Date(), startDate = new Date(), name = '', id = 0, feedbackMessages = []) {
        super(feedbackMessages);
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.creationDate = creationDate;
    }
}
