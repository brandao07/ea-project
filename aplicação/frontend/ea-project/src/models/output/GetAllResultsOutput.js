import BaseOutput from './BaseOutput';

export default class GetAllResultsOutput extends BaseOutput {
    constructor(resultList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.resultList = resultList.map(item => new GetAllResultsOutput.ResultProperties(item));
    }

    static ResultProperties = class {
        constructor(id = 0, position = 0, time = new Date(), observations = '', penaltyTime = new Date(), creationDate = new Date()) {
            this.id = id;
            this.position = position;
            this.time = time;
            this.observations = observations;
            this.penaltyTime = penaltyTime;
            this.creationDate = creationDate;
        }
    };
}
