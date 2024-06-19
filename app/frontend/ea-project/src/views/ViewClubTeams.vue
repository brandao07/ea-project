<template>
    <div class="club-teams">
        <NavigationBar />
        <div class="container">
            <generic-grid v-if="this.userRole == 'Administrator'" :data="getTeamsByClubIdOutput.teamList"
                :headers="gridheaders" :editable="true" :deletable="true" :grid-title="`View ${this.club.name} Teams`"
                @row-click="viewTeamDetails" @edit="openEditModal" @delete="deleteCompetition" /> 
            <generic-grid v-else :data="getTeamsByClubIdOutput.teamList"
                :headers="gridheaders" :editable="false" :deletable="false" :grid-title="`View ${this.club.name} Teams`"
                @row-click="viewTeamDetails" />
        </div>

        <!-- Modal para Editar Team -->
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveTeam" @delete="deleteTeam"
            title="Edit Team">
            <template v-slot>
                <form>
                    <div class="form-group mb-1">
                        <label for="name" class="mb-2">Name</label>
                        <input type="text" class="form-control" id="name" v-model="selectedItem.name" required />
                    </div>
                </form>
            </template>
        </Modal>
        <Footer style=" position: absolute; bottom: 0; width: 100%;"/>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import UpdateTeamInput from '@/models/input/UpdateTeamInput';
import UpdateTeamOutput from '@/models/output/UpdateTeamOutput';
import GetClubByIdOutput from '@/models/output/GetClubByIdOutput';
import GetClubByIdInput from '@/models/input/GetClubByIdInput';
import GetTeamsByClubIdInput from '@/models/input/GetTeamsByClubIdInput';
import GetTeamsByClubIdOutput from '@/models/output/GetTeamsByClubIdOutput';
import ClubService from '@/services/ClubService';
import TeamService from '@/services/TeamService';
import Modal from '@/components/Modal.vue';
import router from '@/router';
import NavigationBar from '@/components/NavigationBar.vue';
import Footer from '@/components/footer.vue';

export default {
    name: "club-teams",
    props: {
        id: {
            type: Number,
            required: true
        },
        userRole: {
            type: String,
            required: true
        }
    },
    components: {
        GenericGrid,
        NavigationBar,
        Modal,
        Footer
    },
    data() {
        return {
            club: new GetClubByIdOutput(),
            getTeamsByClubIdOutput: new GetTeamsByClubIdOutput(),
            getTeamsByClubIdInput: new GetTeamsByClubIdInput(this.id),
            updateTeamInput: new UpdateTeamInput(),
            updateTeamOutput: new UpdateTeamOutput(),
            gridheaders: ['name', 'isActive', 'creationDate'],
            selectedItem: {
                name: '',
            }
        };
    },
    created() {
        this.fetchTeamInfo();
    },
    methods: {
        async fetchTeamInfo() {
            this.club = await ClubService.getClubById(new GetClubByIdInput(this.id));
            this.getTeamsByClubIdOutput = await TeamService.getTeamsByClubId(this.getTeamsByClubIdInput);
        },
        openEditModal(item) {
            this.selectedItem = {
                ...item,
            };
            this.updateTeamInput = { ...item };
            this.modalVisible = true;
        },
        cancelEdit() {
            this.modalVisible = false;
            this.selectedItem = {
                name: ''
            };
        },
        async deleteTeam() {
            await TeamService.deleteTeam(this.updateTeamInput);
            this.modalVisible = false;
            await this.fetchTeamInfo(); // Atualiza a lista de clubs após excluir
        },
        async saveTeam() {
            this.updateTeamOutput = await TeamService.updateTeamEntity(this.updateTeamInput);
            this.modalVisible = false;
            this.updateTeamInput = new UpdateTeamInput();
            await this.fetchTeamInfo(); // Refresh the Club list after save
        },
        viewTeamDetails(team) {
            router.push({ name: 'team-users', params: { id: team.id } });
        }
    },
    async mounted() {
        await this.fetchTeamInfo()
    }
};
</script>