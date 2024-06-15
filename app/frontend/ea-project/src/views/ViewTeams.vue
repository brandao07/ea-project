<template>
    <div class="view-teams">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllTeamsOutput.teamList" :headers="gridheaders" :editable="false" grid-title="View Teams"/>
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllTeamsInput from '@/models/input/GetAllTeamsInput';
import GetAllTeamsOutput from '@/models/output/GetAllTeamsOutput';
import TeamService from '@/services/TeamService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "view-teams",
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getAllTeamsInput: new GetAllTeamsInput(),
            getAllTeamsOutput: new GetAllTeamsOutput(),
            gridheaders: ['name', 'isActive', 'creationDate']
        };
    },
    methods: {
        async fetchTeamInfo() {
            this.getAllTeamsOutput = await TeamService.getAllTeams(this.getAllTeamsInput);
        }
    },
    async mounted() {
        await this.fetchTeamInfo()
    }
};
</script>