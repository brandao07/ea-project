import BaseOutput from './BaseOutput';

export default class GetAllTrialsOutput extends BaseOutput {
    constructor(getalltrialList = [], feedbackMessages = []) {
        super(feedbackMessages);
        this.getalltrialList = getalltrialList.map(
            (getalltrial) => new GetAllTrialsOutput.GetAllTrialProperties(
                getalltrial.id,
                getalltrial.name,
                getalltrial.startDate,
                getalltrial.distance,
                getalltrial.distanceUnit,
                getalltrial.isActive,
                getalltrial.creationDate
            )
        );
    }

    static GetAllTrialProperties = class {
        constructor(id, name, startDate, distance, distanceUnit, isActive, creationDate) {
            this.id = id;
            this.name = name;
            this.startDate = startDate;
            this.distance = distance;
            this.distanceUnit = distanceUnit;
            this.isActive = isActive;
            this.creationDate = creationDate;
        }
    };
}
