<template>
    <div class="competitions">
        <NavigationBar />
        <div class="container">
            <div class="row">
                <div class="col-md-12 bg-light mt-3">
                    <button @click="toggleFilter" type="button" class="btn btn-secondary">Filter</button>
                    
                </div>
            </div>
        </div>
        <div class="container">
            <!-- Botão para mostrar/ocultar o filtro -->
            <CompetitionFilter v-if="filterVisible" @apply-filters="applyFilters" />

            <!-- Grid para Editar Competições -->
            <generic-grid v-if="role === 'Administrator'" :data="filteredCompetitions" :headers="gridHeaders"
                :editable="true" :deletable="true" grid-title="Competições" @row-click="viewCompetition"
                @edit="openEditModal" @delete="deleteCompetition" />
            <generic-grid v-else :data="filteredCompetitions" :headers="gridHeaders" :editable="false"
                :deletable="false" grid-title="Competições" @row-click="viewCompetition" />
        </div>
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
import router from '@/router';
import { StorageKeys } from "@/constants/storageKeys";
import Footer from '@/components/footer.vue';
import CompetitionFilter from '@/components/CompetitionFilter.vue';

export default {
    name: "Competitions",
    components: {
        GenericGrid,
        NavigationBar,
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
           this.$router.push({ name: 'edit-competitions', params: { id: item.id } });
        },
        async deleteCompetition() {
            await CompetitionService.deleteCompetition(this.updateCompetitionInput);
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
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    color: #333;
    padding: 5px 10px;
    border-radius: 4px;
    cursor: pointer;
    margin-bottom: 10px;
    width: 100%;
}

.toggle-filter-btn:hover {
    background-color: #e0e0e0;
}
</style>
