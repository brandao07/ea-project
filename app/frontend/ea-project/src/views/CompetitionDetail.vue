<template>
    <div class="CompetitionDetails">
        <NavigationBar />
        <h1>Detalhes da Competição</h1>
        <div v-if="competition">
            <p><strong>Nome:</strong> {{ competition.name }}</p>
            <p><strong>Data de Início:</strong> {{ competition.startDate }}</p>
            <p><strong>Data de Fim:</strong> {{ competition.endDate }}</p>
            <p><strong>Data de Criação:</strong> {{ competition.creationDate }}</p>
            <p><strong>Gênero:</strong> {{ competition.gender}}</p>
        </div>
        <div v-else>
            <p>Carregando...</p>
        </div>
    </div>
</template>


<script>
import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
import CompetitionService from '@/services/CompetitionService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: 'CompetitionDetails',
    props: ['id'],
    components: {
        NavigationBar
    },
    data() {
        return {
            competition: new GetCompetitionByIdOutput(),
        };
    },
    created() {
        this.fetchCompetition();
    },
    methods: {
        async fetchCompetition() {
            this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(this.id));
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