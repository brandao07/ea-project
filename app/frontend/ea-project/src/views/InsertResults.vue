<template>
    <div id="insert-results">
        <NavigationBar />
        <div class="container">
            <h2>Inserir Resultados da Prova de Canoagem</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Modalidade</th>
                        <th>Prova</th>
                        <th>Data</th>
                        <th>Tempo (minutos)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="canoeist in canoeists" :key="canoeist.id">
                        <td>{{ canoeist.name }}</td>
                        <td>{{ canoeist.modalidade }}</td>
                        <td>{{ canoeist.prova }}</td>
                        <td>{{ canoeist.date }}</td>
                        <td>
                            <input type="number" v-model="canoeist.time" placeholder="Colocar tempo aqui">
                        </td>
                    </tr>
                </tbody>
            </table>
            <button @click="submitResults">Enviar Resultados</button>
        </div>
    </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar.vue';
//import CanoeingService from '@/services/RessultsService';

export default {
    name: 'InsertResults',
    data() {
        return {
            canoeists: []
        };
    },
    components: {
        NavigationBar
    },
    methods: {
        async fetchCanoeists() {
            try {
                //this.canoeists = await CanoeingService.getAllCanoeists();
            } catch (error) {
                console.error('Erro ao buscar os atletas:', error);
            }
        },
        async submitResults() {
            try {
                //await CanoeingService.submitResults(this.canoeists);
                alert('Resultados enviados com sucesso!');
                // Opcional: Atualizar a lista de canoístas após enviar os resultados
                await this.fetchCanoeists();
            } catch (error) {
                alert('Erro ao enviar resultados: ' + error.message);
            }
        }
    },
    async mounted() {
        await this.fetchCanoeists();
    }
}
</script>

<style scoped>
.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}

input[type="number"] {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
