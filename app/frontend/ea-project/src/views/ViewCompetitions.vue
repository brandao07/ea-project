<template>
    <div class="competitions">
      <NavigationBar />
      <div class="container">
        <!-- Grid para Editar Competições -->
        <generic-grid
          :data="getAllCompetitionsOutput.competitionList"
          :headers="gridheaders"
          :editable="true"
          :deletable="true"
          grid-title="Edit Competitions"
          @row-click="viewCompetition"
          @edit="openEditModal"
          @delete="deleteCompetition"
        />
      </div>
  
      <!-- Modal para Editar Competição -->
      <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveCompetition" @delete="deleteCompetition" title="Edit Competition">
        <template v-slot>
          <form>
            <div class="form-group mb-1">
              <label for="name" class="mb-2">Name</label>
              <input type="text" class="form-control" id="name" v-model="selectedItem.name" required />
            </div>
            <div class="form-group mb-1">
              <label for="startDate" class="mb-2">Start Date</label>
              <input type="datetime-local" class="form-control" id="startDate" v-model="selectedItem.startDate" required />
            </div>
            <div class="form-group mb-1">
              <label for="endDate" class="mb-2">End Date</label>
              <input type="datetime-local" class="form-control" id="endDate" v-model="selectedItem.endDate" required />
            </div>
          </form>
        </template>
      </Modal>
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
  import router from '@/router'; // Importe o router se ainda não estiver importado
  
  export default {
    name: "Competitions",
    components: {
      GenericGrid,
      NavigationBar,
      Modal
    },
    data() {
      return {
        getAllCompetitionsInput: new GetAllCompetitionsInput(),
        getAllCompetitionsOutput: new GetAllCompetitionsOutput(),
        updateCompetitionInput: new UpdateCompetitionInput(),
        updateCompetitionOutput: new UpdateCompetitionOutput(),
        gridheaders: ['name', 'startDate', 'endDate', 'creationDate'],
        modalVisible: false,
        selectedItem: {
          name: '',
          startDate: '',
          endDate: ''
        }
      };
    },
    computed: {
      editable() {
        // Determina se estamos na visualização de edição ou visualização
        return this.$route.name === 'edit-competitions';
      }
    },
    methods: {
      async fetchCompetitionInfo() {
        this.getAllCompetitionsOutput = await CompetitionService.getAllCompetitions(this.getAllCompetitionsInput);
      },
      openEditModal(item) {
        this.selectedItem = {
          ...item,
          startDate: new Date(item.startDate).toISOString().slice(0, 16), // para coincidir com o formato datetime-local
          endDate: new Date(item.endDate).toISOString().slice(0, 16) // para coincidir com o formato datetime-local
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
        await this.fetchCompetitionInfo(); // Atualiza a lista de competições após excluir
      },
      async saveCompetition() {
        this.updateCompetitionInput.startDate = new Date(this.selectedItem.startDate).toISOString();
        this.updateCompetitionInput.endDate = new Date(this.selectedItem.endDate).toISOString();
        this.updateCompetitionOutput = await CompetitionService.updateCompetitionEntity(this.updateCompetitionInput);
        this.modalVisible = false;
        this.updateCompetitionInput = new UpdateCompetitionInput();
        await this.fetchCompetitionInfo(); // Refresh the competition list after save
      },
      viewCompetition(competition) {
        // Navega para a página de detalhes da competição
        router.push({ name: 'competition-detail', params: { id: competition.id } });
      }
    },
    async mounted() {
      await this.fetchCompetitionInfo();
    }
  };
  </script>
  
  <style scoped>
  /* Estilos específicos podem ser adicionados aqui conforme necessário */
  </style>
  