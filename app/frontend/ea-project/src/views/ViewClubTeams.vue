<template>
    <div class="club-teams">
        <NavigationBar />
        <div class="container">
            <!-- Grid para Editar Competições -->
            <generic-grid v-if="this.role == 'Administrator'" :data="getTeamsByClubIdOutput.teamList"
                :headers="gridheaders" :editable="true" :deletable="true" grid-title="View {{ this.club.name }} Teams"
                @row-click="viewTeamDetails" @edit="openEditModal" @delete="deleteCompetition" />
            <generic-grid v-else :data="getTeamsByClubIdOutput.teamList"
                :headers="gridheaders" :editable="false" :deletable="false" grid-title="View {{ this.club.name }} Teams"
                @row-click="viewTeamDetails" />
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetClubByIdInput from '@/models/input/GetClubByIdInput';
import GetTeamsByClubIdInput from '@/models/input/GetTeamsByClubIdInput';
import GetTeamsByClubIdOutput from '@/models/output/GetTeamsByClubIdOutput';
import ClubService from '@/services/ClubService';
import TeamService from '@/services/TeamService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "club-teams",
    props: ['id', 'userRole'],
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getTeamsByClubIdInput: new GetTeamsByClubIdInput(this.id),
            getTeamsByClubIdOutput: new GetTeamsByClubIdOutput(),
            gridheaders: ['name', 'isActive', 'creationDate']
        };
    },
    methods: {
        async fetchTeamInfo() {
            this.club = await ClubService.getClubById(new GetClubByIdInput(this.id));
            this.getTeamsByClubIdOutput = await TeamService.getTeamsByClubId(this.GetTeamsByClubIdInput)
        },
        // viewTeamDetails(team) {
        //     // Navega para a página de detalhes da competição
        //     router.push({ name: 'team-detail', params: { id: team.id } });
        // }
    },
    async mounted() {
        await this.fetchTeamInfo()
    }
};
</script>