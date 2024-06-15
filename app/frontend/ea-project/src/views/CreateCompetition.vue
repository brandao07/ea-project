<template>
  <div id="create-competition">
    <NavigationBar />
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
      </template>
    </CreateEntity>
  </div>
</template>

<script>
import CreateEntity from '@/components/CreateEntity.vue';
import CompetitionService from '@/services/CompetitionService';
import CreateCompetitionInput from '@/models/input/CreateCompetitionInput';
import CreateCompetitionOutput from '@/models/output/CreateCompetitionOutput';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
  name: 'create-competition',
  components: {
    CreateEntity,
    NavigationBar
  },
  data() {
    return {
      createCompetitionInput: new CreateCompetitionInput(),
      createCompetitionOutput: new CreateCompetitionOutput(),
    };
  },
  methods: {
    async handleCreate() {
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

.form-group {
  margin-bottom: 1rem;
}

.form-control,
.form-select {
  width: 100%;
}

.btn {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  border: none;
}

.btn-primary {
  background-color: var(--button-primary);
  color: var(--color-white);
}

.btn-secondary {
  background-color: var(--button-secondary);
  color: var(--color-white);
}
</style>