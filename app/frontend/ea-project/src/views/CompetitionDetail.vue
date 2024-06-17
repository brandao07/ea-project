<template>
    <div>
      <h1>Detalhes da Competição</h1>
      <div v-if="competition">
        <p><strong>Nome:</strong> {{ competition.name }}</p>
        <p><strong>Data de Início:</strong> {{ competition.startDate }}</p>
        <p><strong>Data de Fim:</strong> {{ competition.endDate }}</p>
        <p><strong>Data de Criação:</strong> {{ competition.creationDate }}</p>
      </div>
      <div v-else>
        <p>Carregando...</p>
      </div>
    </div>
  </template>
  
  <script>
  import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
  import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
  
  export default {
    name: 'CompetitionDetails',
    props: ['id'],
    data() {
      return {
        competition: new GetCompetitionByIdOutput(),
      };
    },
    created() {
      this.fetchCompetition();
    },
    methods: {
      fetchCompetition() {
        // Simular uma chamada de API para buscar os detalhes da competição
        this.competition = competitions.find(c => c.id === this.id);
      },
    },
  };
  </script>
  
  <style scoped>
  h1 {
    font-size: 2em;
    margin-bottom: 20px;
  }
  p {
    font-size: 1.2em;
    margin: 10px 0;
  }
  </style>
  