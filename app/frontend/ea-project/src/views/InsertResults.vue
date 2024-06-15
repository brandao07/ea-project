<template>
    <div id="insert-results">
        <NavigationBar />
        <div class="container">
            <div>
                <label for="trialSelect">Select Trial:</label>
                <select v-model="selectedTrial" @change="fetchTeams">
                    <option v-for="trial in getAllTrialsOutput.trials" :key="trial.id" :value="trial.id">{{ trial.name }}</option>
                </select>
            </div>

            <div v-if="getTeamsByTrialIdInput.id">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Creation Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="team in getTeamsByTrialIdOutput.teamList" :key="team.id">
                            <td>{{ team.name }}</td>
                            <td>{{ team.creationDate }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import GetAllTrialsInput from '@/models/input/GetAllTrialsInput';
import GetAllTrialsOutput from '@/models/output/GetAllTrialsOutput';
import GetTeamsByTrialIdInput from '@/models/input/GetTeamsByTrialIdInput';
import GetTeamsByTrialIdOutput from '@/models/output/GetTeamsByTrialIdOutput';
import TrialService from '@/services/TrialService';
import TeamService from '@/services/TeamService';
import NavigationBar from '@/components/NavigationBar.vue';
//import GenericGrid from '@/components/Grid.vue';

export default {
    name: 'InsertResults',
    components: {
        //GenericGrid,
        NavigationBar
    },
    data() {
        return {
            selectedTrial: null,
            getAllTrialsInput: new GetAllTrialsInput(),
            getAllTrialsOutput: new GetAllTrialsOutput(),
            getTeamsByTrialIdInput: new GetTeamsByTrialIdInput(),
            getTeamsByTrialIdOutput: new GetTeamsByTrialIdOutput(),
        }
    },
    methods: {
        async fetchTeams() {
            this.getTeamsByTrialIdInput.id = this.selectedTrial;
            this.getTeamsByTrialIdOutput = await TeamService.getTeamsByTrialIdOutput(this.getTeamsByTrialIdInput);
            console.log(this.getTeamsByTrialIdOutput);
        },
        async fetchTrialInfo() {
            this.getAllTrialsOutput = await TrialService.getAllTrials(this.getAllTrialsInput);
        },
        handleCreate() {
            // Implement your create logic if needed
        },
        resetForm() {
            // Implement reset form logic if needed
        }
    },
    async mounted() {
        await this.fetchTrialInfo()
    }
};
</script>
