import BaseOutput from './BaseOutput';

export default class GetAllTeamsOutput extends BaseOutput {
    constructor(teamList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.teamList = teamList.map(item => new GetAllTeamsOutput.TeamProperties(item));
    }

    static TeamProperties = class {
        constructor(id = 0, name = '', isActive = false, creationDate = new Date()) {
            this.id = id;
            this.name = name;
            this.isActive = isActive;
            this.creationDate = creationDate;
        }
    };
}
