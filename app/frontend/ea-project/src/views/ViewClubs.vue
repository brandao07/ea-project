<template>
    <div class="view-clubs">
        <NavigationBar />
        <div class="container">
            <generic-grid v-if="this.role == 'Administrator'" :data="getAllClubsOutput.clubList"
                :headers="gridheaders" :editable="true" :deletable="true" grid-title="View Clubs"
                @row-click="viewClubTeams" @edit="openEditModal" @delete="deleteClub" />
            <generic-grid v-else :data="getAllClubsOutput.clubList"
                :headers="gridheaders" :editable="false" :deletable="false" grid-title="View Clubs"
                @row-click="viewClubTeams" />
        </div>
        <!-- Modal para Editar Clube -->
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveClub" @delete="deleteClub"
            title="Edit Club">
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
import GetAllClubsInput from '@/models/input/GetAllClubsInput';
import GetAllClubsOutput from '@/models/output/GetAllClubsOutput';
import UpdateClubInput from '@/models/input/UpdateClubInput';
import UpdateClubOutput from '@/models/output/UpdateClubOutput';
import ClubService from '@/services/ClubService';
import NavigationBar from '@/components/NavigationBar.vue';
import Modal from '@/components/Modal.vue';
import router from '@/router'; // Importe o router se ainda não estiver importado
import { StorageKeys } from "@/constants/storageKeys";
import Footer from '@/components/footer.vue';

export default {
    name: "view-clubs",
    components: {
        GenericGrid,
        NavigationBar,
        Modal,
        Footer
    },
    data() {
        return {
            getAllClubsInput: new GetAllClubsInput(),
            getAllClubsOutput: new GetAllClubsOutput(),
            updateClubInput: new UpdateClubInput(),
            updateClubOutput: new UpdateClubOutput(),
            gridheaders: ['name', 'isActive', 'creationDate'],
            modalVisible: false,
            role:localStorage.getItem(StorageKeys.ROLE),
            StorageKeys:StorageKeys,
            selectedItem: {
                name: '',
                startDate: '',
                endDate: ''
            }
        };
    },
    methods: {
        async fetchClubInfo() {
            this.getAllClubsOutput = await ClubService.getAllClubs(this.getAllClubsInput);
        },
        openEditModal(item) {
            this.selectedItem = {
                ...item,
            };
            this.updateClubInput = { ...item };
            this.modalVisible = true;
        },
        cancelEdit() {
            this.modalVisible = false;
            this.selectedItem = {
                name: ''
            };
        },
        async deleteClub() {
            await ClubService.deleteClub(this.updateClubInput);
            this.modalVisible = false;
            await this.fetchClubInfo(); // Atualiza a lista de clubs após excluir
        },
        async saveClub() {
            this.updateClubOutput = await ClubService.updateClubEntity(this.updateClubInput);
            this.modalVisible = false;
            this.updateClubInput = new UpdateClubInput();
            await this.fetchClubInfo(); // Refresh the Club list after save
        },
        viewClubTeams(club) {
            router.push({ name: 'club-teams', params: { id: club.id } });
        }
    },
    async mounted() {
        await this.fetchClubInfo()
    }
};
</script>