<template>
  <div id="create-competition">
    <NavigationBar />
    <div class="container">
      <CreateEntity formTitle="Create Competition" @create="handleCreate" @reset="resetForm">
        <template v-slot>
          <div class="form-group mb-1">
            <label for="name" class="mb-2">Name</label>
            <input type="text" class="form-control" id="name" v-model="createCompetitionInput.name" required>
          </div>
          <div class="form-group mb-1">
            <label for="startDate" class="mb-2">Start Date</label>
            <input type="date" class="form-control" id="startDate" v-model="createCompetitionInput.startDate" required>
          </div>
          <div class="form-group mb-1">
            <label for="endDate" class="mb-2">End Date</label>
            <input type="date" class="form-control" id="endDate" v-model="createCompetitionInput.endDate" required>
          </div>
          <div class="form-group mb-1">
            <label for="gender" class="mb-2">Gender</label>
            <select class="form-select" v-model="createCompetitionInput.gender" id="gender" required>
              <option v-for="(label, value) in genderEnum" :key="value" :value="value">
                {{ label }}
              </option>
            </select>
          </div>
          <div class="form-group mb-1">
            <label for="category" class="mb-2">Category</label>
            <select class="form-select" v-model="createCompetitionInput.category" id="category" required>
              <option v-for="(label, value) in categoryEnum" :key="value" :value="value">
                {{ label }}
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
import CompetitionService from '@/services/CompetitionService';
import CreateCompetitionInput from '@/models/input/CreateCompetitionInput';
import CreateCompetitionOutput from '@/models/output/CreateCompetitionOutput';
import NavigationBar from '@/components/NavigationBar.vue';
import GenderEnumerator from '@/models/enums/Gender';
import CategoryEnumerator from '@/models/enums/Category';

export default {
  name: 'create-competition',
  components: {
    CreateEntity,
    NavigationBar
  },
  data() {
    return {
      genderEnum: GenderEnumerator,
      categoryEnum: CategoryEnumerator,
      createCompetitionInput: new CreateCompetitionInput(),
      createCompetitionOutput: new CreateCompetitionOutput(),
    };
  },
  methods: {
    async handleCreate() {
      this.createCompetitionInput.isActive = true;
      this.createCompetitionOutput = await CompetitionService.createCompetitionEntity(this.createCompetitionInput);
      if (this.createCompetitionOutput.updateSuccessful) {
        this.resetForm();
      }
    },
    resetForm() {
      this.createCompetitionInput = new CreateCompetitionInput();
    }
  }
};
</script>

<style scoped>
.create-competition {
  margin: 20px;
  background: var(--color-white);
  border-radius: 8px;
  padding: 20px;
  box-shadow: 0 0 1em var(--color-black-rgba);
}
</style>