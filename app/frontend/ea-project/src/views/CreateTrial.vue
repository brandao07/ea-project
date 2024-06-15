<template>
  <div id="create-Trial">
    <NavigationBar />
    <div class="container">
      <CreateEntity formTitle="Create Trial" @create="handleCreate" @reset="resetForm">
        <template v-slot>
          <div class="form-group mb-1">
            <label for="name" class="mb-2">Name</label>
            <input type="text" class="form-control" id="name" v-model="createTrialInput.name" required>
          </div>
          <div class="form-group mb-1">
            <label for="startDate" class="mb-2">Start Date</label>
            <input type="date" class="form-control" id="startDate" v-model="createTrialInput.startDate" required>
          </div>
          <div class="form-group mb-1">
            <label for="distance" class="mb-2">Distance</label>
            <input type="decimal" step="0.01" class="form-control" id="distance" v-model="createTrialInput.distance"
              required>
          </div>
          <div class="form-group mb-1">
            <label for="distanceUnit" class="mb-2">Distance Unit</label>
            <select class="form-select" v-model="createTrialInput.distanceUnit" id="distanceUnit" required>
              <option v-for="(label, key) in unitsEnumerator" :key="key" :value="key">{{ label }}</option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="stateId" class="mb-2">State</label>
            <select class="form-select" v-model="createTrialInput.stateId" id="stateId" required>
              <option v-for="state in getAllStatesOutput.stateList" :key="state.id" :value="state.id">{{ state.name }}
              </option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="competitionId" class="mb-2">Competition</label>
            <select class="form-select" v-model="createTrialInput.competitionId" id="competitionId" required>
              <option v-for="competition in getAllCompetitionsOutput.competitionList" :key="competition.id"
                :value="competition.id">{{ competition.name }}</option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="gradeId" class="mb-2">Grade</label>
            <select class="form-select" v-model="createTrialInput.gradeId" id="gradeId" required>
              <option v-for="grade in getAllGradesOutput.gradeList" :key="grade.id" :value="grade.id">{{ grade.name }}
              </option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="typeId" class="mb-2">Type</label>
            <select class="form-select" v-model="createTrialInput.typeId" id="typeId" required>
              <option v-for="type in getAllTypesOutput.types" :key="type.id" :value="type.id">{{ type.name }}</option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="locationId" class="mb-2">Location</label>
            <select class="form-select" v-model="createTrialInput.locationId" id="locationId" required>
              <option v-for="location in getAllLocationsOutput.locationList" :key="location.id" :value="location.id">
                {{ location.postalCode }} {{ location.address }} {{ location.city }} {{ location.latitude }} {{ location.longitude }}
                </option>
            </select>
          </div>
        </template>
      </CreateEntity>
    </div>
  </div>
</template>

<script>
import CreateEntity from '@/components/CreateEntity.vue';
import TrialService from '@/services/TrialService';
import StateService from '@/services/StateService';
import GradeService from '@/services/GradeService';
import TypeService from '@/services/TypeService';
import CompetitionService from '@/services/CompetitionService';
import LocationService from '@/services/LocationService';
import CreateTrialInput from '@/models/input/CreateTrialInput';
import CreateTrialOutput from '@/models/output/CreateTrialOutput';
import GetAllStatesInput from '@/models/input/GetAllStatesInput';
import GetAllStatesOutput from '@/models/output/GetAllStatesOutput';
import GetAllCompetitionsInput from '@/models/input/GetAllCompetitionsInput';
import GetAllCompetitionsOutput from '@/models/output/GetAllCompetitionsOutput';
import GetAllGradesInput from '@/models/input/GetAllGradesInput';
import GetAllGradesOutput from '@/models/output/GetAllGradesOutput';
import GetAllTypesInput from '@/models/input/GetAllTypesInput';
import GetAllTypesOutput from '@/models/output/GetAllTypesOutput';
import GetAllLocationsInput from '@/models/input/GetAllLocationsInput';
import GetAllLocationsOutput from '@/models/output/GetAllLocationsOutput';
import NavigationBar from '@/components/NavigationBar.vue';
import UnitsEnumerator from '@/models/enums/Units';

export default {
  name: 'create-trial',
  components: {
    CreateEntity,
    NavigationBar
  },
  data() {
    return {
      createTrialInput: new CreateTrialInput(),
      createTrialOutput: new CreateTrialOutput(),
      getAllStatesInput: new GetAllStatesInput(),
      getAllStatesOutput: new GetAllStatesOutput(),
      getAllCompetitionsInput: new GetAllCompetitionsInput(),
      getAllCompetitionsOutput: new GetAllCompetitionsOutput(),
      getAllGradesInput: new GetAllGradesInput(),
      getAllGradesOutput: new GetAllGradesOutput(),
      getAllTypesInput: new GetAllTypesInput(),
      getAllTypesOutput: new GetAllTypesOutput(),
      getAllLocationsInput: new GetAllLocationsInput(),
      getAllLocationsOutput: new GetAllLocationsOutput(),
      unitsEnumerator: UnitsEnumerator
    };
  },
  async created() {
    await this.fetchData();
  },
  methods: {
    async fetchData() {
      this.getAllStatesOutput = await StateService.getAllStates(this.getAllStatesInput);
      this.getAllCompetitionsOutput = await CompetitionService.getAllCompetitions(this.getAllCompetitionsInput);
      this.getAllGradesOutput = await GradeService.getAllGrades(this.getAllGradesInput);
      this.getAllTypesOutput = await TypeService.getAllTypes(this.getAllTypesInput);
      this.getAllLocationsOutput = await LocationService.getAllLocations(this.getAllLocationsInput);
    },
    async handleCreate() {
      this.createTrialInput.isActive = true;
      this.createTrialOutput = await TrialService.createTrialEntity(this.createTrialInput);
      if (this.createTrialOutput.updateSuccessful) {
        this.resetForm();
      }
    },
    resetForm() {
      this.createTrialInput = new CreateTrialInput();
    }
  }
};
</script>

<style scoped>
.create-Trial {
  margin: 20px;
  background: var(--color-white);
  border-radius: 8px;
  padding: 20px;
  box-shadow: 0 0 1em var(--color-black-rgba);
}
</style>
