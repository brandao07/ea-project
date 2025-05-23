<template>
    <div id="edit-competition">
      <NavigationBar />
      <div class="container">
        <EditEntity formTitle="Edit Competition" @edit="handleUpdate" @cancel="handleCancel">
          <template v-slot>
            <!-- Competition Form Section -->
            <div class="competition-form">
              <div class="form-group mb-1">
                <label for="name" class="mb-2">Name</label>
                <input type="text" class="form-control" id="name" v-model="competition.name" required>
              </div>
              <div class="form-group mb-1">
                <label for="startDate" class="mb-2">Start Date</label>
                <input type="date" class="form-control" id="startDate" v-model="competition.startDate" required>
              </div>
              <div class="form-group mb-1">
                <label for="endDate" class="mb-2">End Date</label>
                <input type="date" class="form-control" id="endDate" v-model="competition.endDate" required>
              </div>
              <div class="form-group mb-1">
                <label for="gender" class="mb-2">Gender</label>
                <select class="form-select" ref="competition.gender" id="gender" required>
                  <option v-for="(label, value) in genderEnum" :key="value" :value="value">
                    {{ label }}
                  </option>
                </select>
              </div>
              <div class="form-group mb-1">
                <label for="grade" class="mb-2">Grade</label>
                <select class="form-select" ref="competition.grade" id="grade" required>
                  <option v-for="(label, value) in gradeEnum" :key="value" :value="value" >
                    {{ label }}
                  </option>
                </select>
              </div>
              <div class="form-group mb-1">
                <label for="category" class="mb-2">Category</label>
                <select class="form-select" ref="competition.type" id="category" required>
                  <option v-for="(label, value) in categoryEnum" :key="value" :value="value">
                    {{ label }}
                  </option>
                </select>
              </div>
            </div>
  
            <!-- Trials Section -->
            <div class="trials-section">
              <div class="form-group mb-1">
                <form @submit.prevent="addTrial">
                  <label class="mb-2">Trials</label>
                  <button class="btn btn-primary mb-2" @click="initializeTrial" :disabled="newTrial !== null">Add Trial</button>
                  <div v-if="newTrial" class="trial-form mb-2">
                    <div class="form-group mb-1">
                      <label for="trialName" class="mb-2">Trial Name</label>
                      <input type="text" class="form-control" v-model="newTrial.name" required>
                    </div>
                    <div class="form-group mb-1">
                      <label for="modality" class="mb-2">Modality</label>
                      <select class="form-select" v-model="newTrial.modality" id="modality" required>
                        <option v-for="(label, value) in modalityEnum" :key="value" :value="value" :selected="newTrial.modality === value">
                          {{ value }}
                        </option>
                      </select>
                    </div>
                    <div class="form-group mb-1">
                      <label for="trialStartDate" class="mb-2">Trial Start Date</label>
                      <input type="date" class="form-control" v-model="newTrial.startDate" required>
                    </div>
                    <div class="form-group mb-1">
                      <label for="trialDistance" class="mb-2">Trial Distance</label>
                      <input type="number" step="0.01" class="form-control" v-model="newTrial.distance" required>
                    </div>
                    <div class="form-group mb-1">
                      <label for="trialDistanceUnit" class="mb-2">Distance Unit</label>
                      <select class="form-select" v-model="newTrial.distanceUnit" required>
                        <option v-for="(label, key) in unitsEnumerator" :key="key" :value="key" :selected="newTrial.distanceUnit === key">{{ label }}</option>
                      </select>
                    </div>
                    <div class="form-group mb-1">
                      <label for="trialLocationId" class="mb-2">Location</label>
                      <select class="form-select" v-model="newTrial.locationId" required>
                        <option v-for="location in getAllLocationsOutput.locationList" :key="location.id" :value="location.id" :selected="newTrial.locationId === location.id">
                          {{ location.postalCode }} {{ location.address }} {{ location.city }} {{ location.latitude }} {{ location.longitude }}
                        </option>
                      </select>
                    </div>
                    <button class="btn btn-success mb-2" type="submit">Save Trial</button>
                    <button class="btn btn-light mb-2" @click="cancelTrial">Cancel</button>
                  </div>
                </form>
                <!-- Trials Table -->
                <div class="container mt-4">
                  <generic-grid :data="competition.trials" :headers="gridHeaders" :editable="true" :deletable="true" grid-title="Edit Trials" @edit="openEditModal" @delete="confirmRemoveTrial" />
                </div>
              </div>
            </div>
  
          </template>
        </EditEntity>
      </div>
      <!-- Edit Trials-->
      <b-modal v-if="editTrial" id="edit-trial-modal" ref="editTrialModal" title="Edit Trial" @ok="updateTrial">
        <div class="form-group mb-1">
          <label for="editTrialName" class="mb-2">Trial Name</label>
          <input type="text" class="form-control" v-model="editTrial.name" required>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialStartDate" class="mb-2">Trial Start Date</label>
          <input type="date" class="form-control" v-model="editTrial.startDate" required>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialDistance" class="mb-2">Trial Distance</label>
          <input type="number" step="0.01" class="form-control" v-model="editTrial.distance" required>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialDistanceUnit" class="mb-2">Distance Unit</label>
          <select class="form-select" v-model="editTrial.distanceUnit" required>
            <option v-for="(label, key) in unitsEnumerator" :key="key" :value="key" :selected="editTrial.distanceUnit === key">{{ label }}</option>
          </select>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialStateId" class="mb-2">State</label>
          <select class="form-select" v-model="editTrial.stateId" required>
            <option v-for="state in getAllStatesOutput.stateList" :key="state.id" :value="state.id" :selected="editTrial.stateId === state.id">{{ state.name }}</option>
          </select>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialGradeId" class="mb-2">Grade</label>
          <select class="form-select" v-model="editTrial.gradeId" required>
            <option v-for="grade in getAllGradesOutput.gradeList" :key="grade.id" :value="grade.id" :selected="editTrial.gradeId === grade.id">{{ grade.name }}</option>
          </select>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialTypeId" class="mb-2">Type</label>
          <select class="form-select" v-model="editTrial.typeId" required>
            <option v-for="type in getAllTypesOutput.types" :key="type.id" :value="type.id" :selected="editTrial.typeId === type.id">{{ type.name }}</option>
          </select>
        </div>
        <div class="form-group mb-1">
          <label for="editTrialLocationId" class="mb-2">Location</label>
          <select class="form-select" v-model="editTrial.locationId" required>
            <option v-for="location in getAllLocationsOutput.locationList" :key="location.id" :value="location.id" :selected="editTrial.locationId === location.id">
              {{ location.postalCode }} {{ location.address }} {{ location.city }} {{ location.latitude }} {{ location.longitude }}
            </option>
          </select>
        </div>
      </b-modal>
    </div>
  </template>
  
  
  <script>
  import EditEntity from '@/components/EditEntity.vue';
  import CompetitionService from '@/services/CompetitionService';
  import TrialService from '@/services/TrialService';
  import StateService from '@/services/StateService';
  import TypeService from '@/services/TypeService';
  import LocationService from '@/services/LocationService';
  import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
  import CreateTrialInput from '@/models/input/CreateTrialInput';
  import NavigationBar from '@/components/NavigationBar.vue';
  import GenderEnumerator from '@/models/enums/Gender';
  import GradeEnumerator from '@/models/enums/Grade';
  import categoryEnumerator from '@/models/enums/Category';
  import UnitsEnumerator from '@/models/enums/Units';
  import modalityEnumerator from '@/models/enums/modality';
  import GetAllStatesInput from '@/models/input/GetAllStatesInput';
  import GetAllStatesOutput from '@/models/output/GetAllStatesOutput';
  import GetAllTypesInput from '@/models/input/GetAllTypesInput';
  import GetAllTypesOutput from '@/models/output/GetAllTypesOutput';
  import GetAllLocationsInput from '@/models/input/GetAllLocationsInput';
  import GetAllLocationsOutput from '@/models/output/GetAllLocationsOutput';
  import GenericGrid from '@/components/Grid.vue'; // Assuming the generic grid component is in components folder
  import { StorageKeys } from '@/constants/storageKeys';
  import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
  import router from '@/router';
  
  export default {
    name: 'edit-competition',
    components: {
      EditEntity,
      NavigationBar,
      GenericGrid
    },
    data() {
      return {
        genderEnum: GenderEnumerator,
        gradeEnum: GradeEnumerator,
        unitsEnumerator: UnitsEnumerator,
        categoryEnum: categoryEnumerator,
        modalityEnum: modalityEnumerator,
        competition: new GetCompetitionByIdOutput(),
        getAllStatesInput: new GetAllStatesInput(),
        getAllStatesOutput: new GetAllStatesOutput(),
        getAllTypesInput: new GetAllTypesInput(),
        getAllTypesOutput: new GetAllTypesOutput(),
        getAllLocationsInput: new GetAllLocationsInput(),
        getAllLocationsOutput: new GetAllLocationsOutput(),
        newTrial: null,
        editTrial: null,
        gridHeaders: ['name', 'startDate', 'modality', 'distance', 'distanceUnit']
      };
    },
    async created() {
      await this.fetchData();
      const competitionId = this.$route.params.id;
      this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(competitionId));
      this.competition.startDate = new Date(this.competition.startDate).toISOString().slice(0, 10);
      this.competition.endDate = new Date(this.competition.endDate).toISOString().slice(0, 10);
    },
    methods: {
      async fetchData() {
        this.getAllStatesOutput = await StateService.getAllStates(this.getAllStatesInput);
        this.getAllTypesOutput = await TypeService.getAllTypes(this.getAllTypesInput);
        this.getAllLocationsOutput = await LocationService.getAllLocations(this.getAllLocationsInput);
      },
      initializeTrial() {
        this.newTrial = new CreateTrialInput();
      },
      addTrial() {
        this.competition.trials.push(this.newTrial);
        this.newTrial = null;
      },
      cancelTrial() {
        this.newTrial = null;
      },
      confirmRemoveTrial(index) {
        if (confirm("Are you sure you want to remove this trial?")) {
          this.competition.trials.splice(index, 1);
        }
      },
      getStateName(stateId) {
        return this.getAllStatesOutput.stateList.find(state => state.id === stateId)?.name || 'Unknown';
      },
      getGradeName(gradeId) {
        return this.getAllGradesOutput.gradeList.find(grade => grade.id === gradeId)?.name || 'Unknown';
      },
      getTypeName(typeId) {
        return this.getAllTypesOutput.types.find(type => type.id === typeId)?.name || 'Unknown';
      },
      getLocationDetails(locationId) {
        const location = this.getAllLocationsOutput.locationList.find(location => location.id === locationId);
        return location ? `${location.postalCode} ${location.address} ${location.city}` : 'Unknown';
      },
      openEditModal(trial) {
        this.editTrial = { ...trial };
        this.$refs.editTrialModal.show();
      },
      updateTrial() {
        const trialIndex = this.competition.trials.findIndex(trial => trial.id === this.editTrial.id);
        if (trialIndex !== -1) {
          this.competition.trials.splice(trialIndex, 1, this.editTrial);
        }
        this.$refs.editTrialModal.hide();
      },
      async handleUpdate() {
        this.competition.isActive = true;
        this.competition.userId = localStorage.getItem(StorageKeys.ID_USER);
        const updateCompetitionResponse = await CompetitionService.updateCompetitionEntity(this.competition);
        if (updateCompetitionResponse.updateSuccessful) {
          for (let trial of this.competition.trials) {
            trial.competitionId = this.competition.id;
            await TrialService.updateTrialEntity(trial);
          }
          this.resetForm();
        }
      },
      handleCancel() {
        console.log('cancel');
        router.push({ name: 'competition-detail' }, { params: { id: this.competition.id } });
      },
      async resetForm() {
        const competitionId = this.$route.params.id;
        this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(competitionId));
        this.newTrial = null;
      }
    }
  };
  </script>
  
  <style scoped>
  .edit-competition {
    margin: 20px;
    background: var(--color-white);
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 1em var(--color-black-rgba);
  }
  
  .trials-section {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 1em var(--color-black-rgba);
    margin-top: 20px;
  }
  
  .trial-form {
    background-color: #e9ecef;
    padding: 10px;
    border-radius: 5px;
  }
  </style>
  