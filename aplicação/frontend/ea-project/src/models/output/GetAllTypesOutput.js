import BaseOutput from './BaseOutput';

export default class GetAllTypesOutput extends BaseOutput {
    constructor(getalltypeList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.getalltypeList = getalltypeList.map(
            (getalltype) => new GetAllTypesOutput.GetAllTypeProperties(
                getalltype.id,
                getalltype.name,
                getalltype.numberOfPersons,
                getalltype.creationDate
            )
        );
    }

    static GetAllTypeProperties = class {
        constructor(id, name, numberOfPersons, creationDate) {
            this.id = id;
            this.name = name;
            this.numberOfPersons = numberOfPersons;
            this.creationDate = creationDate;
        }
    };
}
