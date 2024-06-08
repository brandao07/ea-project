import BaseOutput from './BaseOutput';

export default class GetAllClubsOutput extends BaseOutput {
    constructor(getallclubList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.getallclubList = getallclubList.map(
            (getallclub) => new GetAllClubsOutput.GetAllClubProperties(
                getallclub.id,
                getallclub.name,
                getallclub.isActive,
                getallclub.creationDate
            )
        );
    }

    static GetAllClubProperties = class {
        constructor(id, name, isActive, creationDate) {
            this.id = id;
            this.name = name;
            this.isActive = isActive;
            this.creationDate = creationDate;
        }
    };
}
