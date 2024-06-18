<template>
    <div class="competitions">
        <NavigationBar />
        <div class="container">
            <!-- Botão para mostrar/ocultar o filtro -->
            <button @click="toggleFilter" class="toggle-filter-btn">Filtro</button>
            <CompetitionFilter v-if="filterVisible" @apply-filters="applyFilters" />

            <!-- Grid para Editar Competições -->
            <generic-grid v-if="role === 'Administrator'" 
                :data="filteredCompetitions"
                :headers="gridHeaders" 
                :editable="true" 
                :deletable="true" 
                grid-title="Competições"
                @row-click="viewCompetition" 
                @edit="openEditModal" 
                @delete="deleteCompetition" 
            />
            <generic-grid v-else 
                :data="filteredCompetitions"
                :headers="gridHeaders" 
                :editable="false" 
                :deletable="false" 
                grid-title="Competições"
                @row-click="viewCompetition" 
            />
        </div>

        <!-- Modal para Editar Competição -->
        <Modal :isVisible="modalVisible" 
            @cancel="cancelEdit" 
            @save="saveCompetition" 
            @delete="deleteCompetition"
            title="Editar Competição"
        >
            <template v-slot>
                <form>
                    <div class="form-group mb-1">
                        <label for="name" class="mb-2">Nome</label>
                        <input type="text" class="form-control" id="name" v-model="selectedItem.name" required />
                    </div>
                    <div class="form-group mb-1">
                        <label for="startDate" class="mb-2">Data de Início</label>
                        <input type="datetime-local" class="form-control" id="startDate"
                            v-model="selectedItem.startDate" required />
                    </div>
                    <div class="form-group mb-1">
                        <label for="endDate" class="mb-2">Data de Fim</label>
                        <input type="datetime-local" class="form-control" id="endDate" v-model="selectedItem.endDate"
                            required />
                    </div>
                </form>
            </template>
        </Modal>
        <Footer />
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllCompetitionsInput from '@/models/input/GetAllCompetitionsInput';
import GetAllCompetitionsOutput from '@/models/output/GetAllCompetitionsOutput';
import UpdateCompetitionInput from '@/models/input/UpdateCompetitionInput';
import UpdateCompetitionOutput from '@/models/output/UpdateCompetitionOutput';
import CompetitionService from '@/services/CompetitionService';
import NavigationBar from '@/components/NavigationBar.vue';
import Modal from '@/components/Modal.vue';
import router from '@/router';
import { StorageKeys } from "@/constants/storageKeys";
import Footer from '@/components/footer.vue';
import CompetitionFilter from '@/components/CompetitionFilter.vue';

export default {
    name: "Competitions",
    components: {
        GenericGrid,
        NavigationBar,
        Modal,
        Footer,
        CompetitionFilter
    },
    data() {
        return {
            getAllCompetitionsInput: new GetAllCompetitionsInput(),
            getAllCompetitionsOutput: new GetAllCompetitionsOutput(),
            updateCompetitionInput: new UpdateCompetitionInput(),
            updateCompetitionOutput: new UpdateCompetitionOutput(),
            gridHeaders: ['name', 'startDate', 'endDate', 'creationDate'],
            modalVisible: false,
            role: localStorage.getItem(StorageKeys.ROLE),
            StorageKeys: StorageKeys,
            selectedItem: {
                name: '',
                startDate: '',
                endDate: ''
            },
            filters: {},
            filteredCompetitions: [],
            filterVisible: false // Controla a visibilidade do filtro
        };
    },
    computed: {
        editable() {
            return this.$route.name === 'edit-competitions';
        }
    },
    methods: {
        async fetchCompetitionInfo() {
            this.getAllCompetitionsOutput = await CompetitionService.getAllCompetitions(this.getAllCompetitionsInput);
            this.applyFilters(); // Aplica os filtros após buscar as competições
        },
        openEditModal(item) {
            this.selectedItem = {
                ...item,
                startDate: new Date(item.startDate).toISOString().slice(0, 16),
                endDate: new Date(item.endDate).toISOString().slice(0, 16)
            };
            this.updateCompetitionInput = { ...item };
            this.modalVisible = true;
        },
        cancelEdit() {
            this.modalVisible = false;
            this.selectedItem = {
                name: '',
                startDate: '',
                endDate: ''
            };
        },
        async deleteCompetition() {
            await CompetitionService.deleteCompetition(this.updateCompetitionInput);
            this.modalVisible = false;
            await this.fetchCompetitionInfo();
        },
        async saveCompetition() {
            this.updateCompetitionInput.startDate = new Date(this.selectedItem.startDate).toISOString();
            this.updateCompetitionInput.endDate = new Date(this.selectedItem.endDate).toISOString();
            this.updateCompetitionOutput = await CompetitionService.updateCompetitionEntity(this.updateCompetitionInput);
            this.modalVisible = false;
            this.updateCompetitionInput = new UpdateCompetitionInput();
            await this.fetchCompetitionInfo();
        },
        viewCompetition(competition) {
            router.push({ name: 'competition-detail', params: { id: competition.id } });
        },
        applyFilters(filters) {
            console.log('filters')
            console.log(this.getAllCompetitionsOutput.competitionList)
            this.filters = filters;
            this.filteredCompetitions = this.getAllCompetitionsOutput.competitionList.filter(competition => {
                return !this.filters || (!this.filters.competitionName || competition.name.toLowerCase().includes(this.filters.competitionName.toLowerCase())) &&
                    (!this.filters.gender || competition.gender === this.filters.gender) &&
                    (!this.filters.category.length || this.filters.category.includes(competition.category)) &&
                    (!this.filters.startDate || new Date(competition.startDate) >= new Date(this.filters.startDate)) &&
                    (!this.filters.endDate || new Date(competition.endDate) <= new Date(this.filters.endDate)) &&
                    (!this.filters.grade.length || this.filters.grade.includes(competition.grade));
            });
        },
        toggleFilter() {
            this.filterVisible = !this.filterVisible;
        }
    },
    async mounted() {
        await this.fetchCompetitionInfo();
    }
};
</script>

<style scoped>
.toggle-filter-btn {
    background-color: #f0f0f0; /* Cor de fundo clara */
    border: 1px solid #ccc; /* Borda discreta */
    color: #333; /* Cor do texto */
    padding: 5px 10px;
    border-radius: 4px;
    cursor: pointer;
    margin-bottom: 10px; /* Espaço abaixo do botão */
}

.toggle-filter-btn:hover {
    background-color: #e0e0e0; /* Cor de fundo ao passar o mouse */
}
</style>
