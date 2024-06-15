<template>
    <div class="view-competitions">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllCompetitionsOutput.competitionList" :headers="gridheaders" :editable="false" grid-title="View Competitions"/>
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllCompetitionsInput from '@/models/input/GetAllCompetitionsInput';
import GetAllCompetitionsOutput from '@/models/output/GetAllCompetitionsOutput';
import CompetitionService from '@/services/CompetitionService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "view-competitions",
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getAllCompetitionsInput: new GetAllCompetitionsInput(),
            getAllCompetitionsOutput: new GetAllCompetitionsOutput(),
            gridheaders: ['name', 'startDate', 'endDate', 'creationDate']
        };
    },
    methods: {
        async fetchCompetitionInfo() {
            this.getAllCompetitionsOutput = await CompetitionService.getAllCompetitions(this.getAllCompetitionsInput);
        }
    },
    async mounted() {
        await this.fetchCompetitionInfo()
    }
};
</script>