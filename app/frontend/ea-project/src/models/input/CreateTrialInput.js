import BaseInput from "./BaseInput";

export default class CreateTrialInput extends BaseInput {
  constructor(name = '', startDate = new Date(), distance = 0.0, distanceUnit = '', isActive = false, creationDate = new Date(), stateId = 0, competitionId = 0, modality = "", typeId = 0, locationId = 0, lazyLoad = false) {
    super(lazyLoad);
    this.name = name;
    this.startDate = startDate;
    this.distance = distance;
    this.distanceUnit = distanceUnit;
    this.isActive = isActive;
    this.creationDate = creationDate;
    this.stateId = stateId;
    this.competitionId = competitionId;
    this.modality=modality;
    this.typeId = typeId;
    this.locationId = locationId;
  }
}