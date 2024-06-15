<template>
    <div class="view-trials">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllTrialsOutput.competitionList" :headers="gridheaders" :editable="false" grid-title="View Trials"/>
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllTrialsInput from '@/models/input/GetAllTrialsInput';
import GetAllTrialsOutput from '@/models/output/GetAllTrialsOutput';
import TrialService from '@/services/TrialService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "view-trials",
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getAllTrialsInput: new GetAllTrialsInput(),
            getAllTrialsOutput: new GetAllTrialsOutput(),
            gridheaders: ['name', 'startDate', 'endDate', 'distance', 'distanceUnit', 'creationDate']
        }
    },
    methods: {
        async fetchTrialInfo() {
            this.getAllTrialsOutput = await TrialService.getAllTrials(this.getAllTrialsInput);
        }
    },
    async mounted() {
        await this.fetchTrialInfo()
    }
};
</script>