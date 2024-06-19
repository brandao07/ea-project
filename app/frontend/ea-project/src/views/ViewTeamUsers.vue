<template>
    <div class="team-users">
        <NavigationBar />
        <div class="container">
            <generic-grid v-if="this.userRole == 'Administrator'" :data="getUsersByTeamIdOutput.userList"
                :headers="gridheaders" :editable="true" :deletable="true" :grid-title="`View ${this.team.name} Athletes`"
                @delete="deleteUser" />
            <generic-grid v-else :data="getUsersByTeamIdOutput.userList"
                :headers="gridheaders" :editable="false" :deletable="false" :grid-title="`View ${this.team.name} Athletes`"/>
        </div>
        <Footer style=" position: absolute; bottom: 0; width: 100%;"/>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetTeamByIdOutput from '@/models/output/GetTeamByIdOutput';
import GetTeamByIdInput from '@/models/input/GetTeamByIdInput';
import GetUsersByTeamIdInput from '@/models/input/GetTeamsByClubIdInput';
import GetUsersByTeamIdOutput from '@/models/output/GetTeamsByClubIdOutput';
import UserService from '@/services/UserService';
import TeamService from '@/services/TeamService';
import NavigationBar from '@/components/NavigationBar.vue';
import Footer from '@/components/footer.vue';

export default {
    name: "team-users",
    props: ['id', 'userRole'],
    components: {
        GenericGrid,
        NavigationBar,
        Footer
    },
    data() {
        return {
            team: new GetTeamByIdOutput(),
            getUsersByTeamIdOutput: new GetUsersByTeamIdOutput(),
            getUsersByTeamIdInput: new GetUsersByTeamIdInput(this.id),
            gridheaders: ['name', 'isActive', 'creationDate'],
            selectedItem: {
                name: '',
            }
        };
    },
    created() {
        this.fetchUsersInfo();
    },
    methods: {
        async fetchUsersInfo() {
            this.team = await TeamService.getTeamById(new GetTeamByIdInput(this.id));
            this.getUsersByTeamIdOutput = await UserService.getUsersByTeamId(this.getUsersByTeamIdInput);
        },
        // delete user from Team
        // async deleteUserFromTeam() {
        //     await UserService.deleteTeam(this.updateTeamInput);
        //     await this.fetchTeamInfo(); // Atualiza a lista de clubs após excluir
        // },
        // viewTeamDetails(team) {
        //     // Navega para a página de detalhes da competição
        //     router.push({ name: 'team-detail', params: { id: team.id } });
        // }
    },
    async mounted() {
        await this.fetchUsersInfo()
    }
};
</script>