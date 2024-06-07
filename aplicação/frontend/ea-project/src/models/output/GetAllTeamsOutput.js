import BaseOutput from './BaseOutput';

export default class GetAllTeamsOutput extends BaseOutput {
    constructor(users = [], club = null, teamList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.teamList = teamList.map(item => new GetAllTeamsOutput.TeamProperties(item));
        this.club = club;
        this.users = users.map(item => new GetAllTeamsOutput.UserProperties(item));
    }

    static TeamProperties = class {
        constructor(id = 0, name = '', isActive = false, creationDate = new Date(), club = null, users = []) {
            this.id = id;
            this.name = name;
            this.isActive = isActive;
            this.creationDate = creationDate;
            this.club = club;
            this.users = users;
        }
    };

    static ClubProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static UserProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };
}
