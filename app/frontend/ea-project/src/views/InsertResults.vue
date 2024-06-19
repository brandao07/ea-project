<template>
    <div id="insert-results">
        <NavigationBar />
        <div class="container">
            <CreateEntity formTitle="Insert Results" @create="handleCreate" @reset="resetForm">
                <template v-slot>
                    <div class="form-group mb-1">
                        <label for="trialId" class="mb-2">Trial</label>
                        <select class="form-select" v-model="selectedTrial" @change="fetchTeams">
                            <option v-for="trial in getAllTrialsOutput.trials" :key="trial.id" :value="trial.id">{{
                                trial.name }}
                            </option>
                        </select>
                    </div>
                    <div class="form-group mb-1">
                        <label for="teamId" class="mb-2">Team</label>
                        <div v-if="getTeamsByTrialIdInput.id">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Time (ms)</th>
                                        <th>Penalti Time (ms)</th>
                                        <th>Position</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(team, index) in getTeamsByTrialIdOutput.teamList" :key="team.id">
                                        <td>{{ team.name }}</td>
                                        <td><input type="time" step="0.001" class="form-control" id="time" v-model="teamData[index].time" required></td>
                                        <td><input type="time" step="0.001" class="form-control" id="penalty" v-model="teamData[index].penaltyTime" required></td>
                                        <td><input type="number" class="form-control" id="position" v-model="teamData[index].position" required></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </template>
            </CreateEntity>
        </div>
        <Footer style=" position: absolute;

bottom: 0;

width: 100%;"/>
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
import GetTeamsByTrialIdInput from '@/models/input/GetTeamsByTrialIdInput';
import GetTeamsByTrialIdOutput from '@/models/output/GetTeamsByTrialIdOutput';
import CreateResultInput from '@/models/input/CreateResultInput';
import CreateResultOutput from '@/models/output/CreateResultOutput';
import Footer from '@/components/footer.vue';

export default {
    name: 'insert-results',
    data() {
        return {
            selectedTrial: null,
            getAllTrialsInput: new GetAllTrialsInput(),
            getAllTrialsOutput: new GetAllTrialsOutput(),
            getTeamsByTrialIdInput: new GetTeamsByTrialIdInput(),
            getTeamsByTrialIdOutput: new GetTeamsByTrialIdOutput(),
            teamData: [],
            createResultOutput: new CreateResultOutput()
        };
    },
    components: {
        CreateEntity,
        NavigationBar,
        Footer,
    },
    methods: {
        async fetchTrials() {
            this.getAllTrialsOutput = await TrialService.getAllTrials(this.getAllTrialsInput);
        },
        async handleCreate() {
            for (let i = 0; i < this.teamData.length; i++) {
                let createResultInput = new CreateResultInput();
                createResultInput.time = this.convertToTimestamp(this.teamData[i].time);
                createResultInput.penaltyTime = this.convertToTimestamp(this.teamData[i].penaltyTime);
                createResultInput.position = this.teamData[i].position;
                createResultInput.teamId = this.getTeamsByTrialIdOutput.teamList[i].id;
                this.createResultOutput = await ResultService.createResultEntity(createResultInput);
                if (this.createResultOutput.updateSuccessful) {
                    this.resetForm();
                }
            }
        },
        resetForm() {
            this.getAllTrialsInput = new GetAllTrialsInput();
            this.getTeamsByTrialIdInput = new GetTeamsByTrialIdInput();
            this.getTeamsByTrialIdOutput = new GetTeamsByTrialIdOutput();
            this.teamData = [];
            this.createResultOutput = new CreateResultOutput();
        },
        convertToTimestamp(timeStr) {
            const date = new Date();
            const [hours, minutes, seconds] = timeStr.split(':');
            const [secs, millis] = seconds.split('.');
            
            date.setHours(+hours);
            date.setMinutes(+minutes);
            date.setSeconds(+secs);
            date.setMilliseconds(+millis || 0);
            
            const year = date.getFullYear();
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const day = String(date.getDate()).padStart(2, '0');
            const hoursStr = String(date.getHours()).padStart(2, '0');
            const minutesStr = String(date.getMinutes()).padStart(2, '0');
            const secondsStr = String(date.getSeconds()).padStart(2, '0');
            const millisecondsStr = String(date.getMilliseconds()).padStart(3, '0');
            const microsecondsStr = millisecondsStr + '000'; // Convert milliseconds to microseconds
            
            return `${year}-${month}-${day}T${hoursStr}:${minutesStr}:${secondsStr}.${microsecondsStr}Z`;
        },
        async fetchTeams() {
            this.getTeamsByTrialIdInput.id = this.selectedTrial;
            this.getTeamsByTrialIdOutput = await TeamService.getTeamsByTrialIdOutput(this.getTeamsByTrialIdInput);
            this.teamData = this.getTeamsByTrialIdOutput.teamList.map(() => {
                return {
                    time: '',
                    penaltyTime: '',
                    position: ''
                };
            });
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

input {
    width: auto !important;
}
</style>

take this vue code and convert the penalty time and time from team to timestamp 
=======

<style scoped>
.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}

input[type="number"] {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
