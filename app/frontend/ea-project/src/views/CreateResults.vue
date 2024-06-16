<template>
    <div id="create-results">
        <NavigationBar />
        <div class="container">
            <CreateEntity formTitle="Insert Results" @create="handleCreate" @reset="resetForm">
                <template v-slot>
                    <div class="form-group mb-1">
                        <label for="trialId" class="mb-2">Trial</label>
                        <select class="form-select" v-model="fetchTeams" id="trialId" required>
                            <option v-for="trial in getAllTrialsOutput.trials" :key="trial.id" :value="trial.id">{{
                                trial.name }}
                            </option>
                        </select>
                    </div>
                    <div class="form-group mb-1">
                        <label for="teamId" class="mb-2">Team</label>
                        <select class="form-select" v-model="getAllTrialsOutput.gradeId" id="teamId" required>
                            <option v-for="trial in getAllTeamsByTrialIdOutput.trials" :key="trial.id"
                                :value="trial.id">{{
                                    trial.name }}
                            </option>
                        </select>
                    </div>
                    <div class="form-group mb-1">
                        <label for="time" class="mb-2">Time (ms)</label>
                        <input type="time" step="0.001" class="form-control" id="time" v-model="createResultInput.time"
                            required>
                    </div>
                    <div class="form-group mb-1">
                        <label for="penalty" class="mb-2">Penalti Time (ms)</label>
                        <input type="time" step="0.001" class="form-control" id="penalty"
                            v-model="createResultInput.penaltyTime" required>
                    </div>
                    <div class="form-group mb-1">
                        <label for="observations" class="mb-2">Observations</label>
                        <input type="text" class="form-control" id="observations"
                            v-model="createResultInput.observations" required>
                    </div>
                    <div class="form-group mb-1">
                        <label for="position" class="mb-2">Position</label>
                        <input type="number" class="form-control" id="position" v-model="createResultInput.position"
                            required>
                    </div>
                </template>
            </CreateEntity>
        </div>
    </div>
</template>

<script>
import CreateEntity from '@/components/CreateEntity.vue';
import NavigationBar from '@/components/NavigationBar.vue';
import TrialService from '@/services/TrialService';
import ResultService from '@/services/ResultService';
import TeamService from '@/services/TeamService';
import GetAllTrialsInput from '@/models/input/GetAllTrialsInput';
import GetAllTrialsOutput from '@/models/output/GetAllTrialsOutput';
import GetAllTeamsByTrialIdInput from '@/models/input/GetAllTeamsByTrialIdInput';
import GetAllTeamsByTrialIdOutput from '@/models/output/GetAllTeamsByTrialIdOutput';
import CreateResultInput from '@/models/input/CreateResultInput';
import CreateResultOutput from '@/models/output/CreateResultOutput';

export default {
    name: 'create-results',
    data() {
        return {
            getAllTrialsInput: new GetAllTrialsInput(),
            getAllTrialsOutput: new GetAllTrialsOutput(),
            getAllTeamsByTrialIdInput: new GetAllTeamsByTrialIdInput(),
            getAllTeamsByTrialIdOutput: new GetAllTeamsByTrialIdOutput(),
            createResultInput: new CreateResultInput(),
            createResultOutput: new CreateResultOutput()
        };
    },
    components: {
        CreateEntity,
        NavigationBar
    },
    methods: {
        async fetchTrials() {
            this.getAllTrialsOutput = await TrialService.getAllTrials(this.getAllTrialsInput);
        },
        async handleCreate() {
            this.createResultOutput = await ResultService.createResultEntity(this.createResultInput);
            if (this.createResultInput.updateSuccessful) {
                this.resetForm();
            }
        },
        resetForm() {
            this.getAllTrialsInput = new GetAllTrialsInput();
            this.createResultInput = new CreateResultInput();
            this.getAllTeamsByTrialIdInput = new GetAllTeamsByTrialIdInput();
            this.getAllTeamsByTrialIdInput = new GetAllTeamsByTrialIdOutput();
            this.getAllTrialsInput = new GetAllTrialsOutput();
            this.createResultInput = new CreateResultOutput();
        }
    },
    watch: {
        async fetchTeams(value) {
            this.getAllTeamsByTrialIdOutput = await TeamService.getAllTeamsByTrialId(new this.getAllTeamsByTrialIdInput(value));
        },
    },
    async mounted() {
        await this.fetchTrials();
    }
}
</script>

<style scoped>
.create-results {
    margin: 20px;
    background: var(--color-white);
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 1em var(--color-black-rgba);
}
</style>
