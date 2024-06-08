import BaseOutput from './BaseOutput';

export default class GetTrialByIdOutput extends BaseOutput {
    constructor(teams = [], results = [], location = null, type = null, grade = null, competition = null, state = null, creationDate = new Date(), isActive = false, distanceUnit = '', distance = 0.0, startDate = new Date(), name = '', id = 0, feedbackMessages = []) {
        super(feedbackMessages);
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.state = new GetTrialByIdOutput.StateProperties(state);
        this.competition = new GetTrialByIdOutput.CompetitionProperties(competition);
        this.grade = new GetTrialByIdOutput.GradeProperties(grade);
        this.type = new GetTrialByIdOutput.TypeProperties(type);
        this.location = new GetTrialByIdOutput.LocationProperties(location);
        this.results = results.map(item => new GetTrialByIdOutput.ResultProperties(item));
        this.teams = teams.map(item => new GetTrialByIdOutput.TeamProperties(item));
    }

    static StateProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static CompetitionProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static GradeProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static TypeProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static LocationProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static ResultProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };

    static TeamProperties = class {
        constructor(id = 0, name = '') {
            this.id = id;
            this.name = name;
        }
    };
}
