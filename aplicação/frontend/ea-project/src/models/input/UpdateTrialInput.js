import BaseInput from "./BaseInput";

export default class UpdateTrialInput extends BaseInput {
  constructor(id = 0, name = '', startDate = new Date(), distance = 0.0, distanceUnit = '', isActive = false, creationDate = new Date(), stateId = 0, competitionId = 0, gradeId = 0, typeId = 0, locationId = 0, resultIds = [], teamIds = [], lazyLoad = false) {
    super(lazyLoad);
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.distance = distance;
    this.distanceUnit = distanceUnit;
    this.isActive = isActive;
    this.creationDate = creationDate;
    this.stateId = stateId;
    this.competitionId = competitionId;
    this.gradeId = gradeId;
    this.typeId = typeId;
    this.locationId = locationId;
    this.resultIds = resultIds.map(item => new UpdateTrialInput.Integer(item));
    this.teamIds = teamIds.map(item => new UpdateTrialInput.Integer(item));
  }
}