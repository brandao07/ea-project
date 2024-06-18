<template>
    <div class="competition-details">
        <NavigationBar />

        <!-- Detalhes da Competição -->
        <div class="competition-info container my-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h1 class="display-4">{{ this.competition.name }}</h1>
                <div v-if="this.role==='Administrator'" class="admin-buttons">
                    <button class="btn btn-primary me-2" @click="editCompetition">Edit</button>
                    <button class="btn btn-danger" @click="removeCompetition">Delete</button>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-md-6">
                    <p class="lead">Gender: {{ this.competition.gender }}</p>
                    <p class="lead">Grade: {{ this.competition.grade }}</p>
                    <p class="lead">Category: {{ this.competition.type }}</p>
                    <p class="lead">Data de Início: {{ new Date(this.competition.startDate).toISOString().slice(0, 16) }}</p>
                    <p class="lead">Data de Término: {{ new Date(this.competition.endDate).toISOString().slice(0, 16) }}</p>
                </div>
                <div class="col-md-6 text-center">
                    <img :src="this.competition.imageUrl" class="img-fluid rounded" :alt="competition.name">
                </div>
            </div>
        </div>

        <!-- Carousel de Provas -->
        <div v-if="this.competition.trials.length > 0" class="race-carousel mt-4 container">
            <div id="raceCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div v-for="(race, index) in this.competition.trials" :key="index" :class="['carousel-item', { 'active': index === currentCard }]">
                        <div class="row">
                            <div class="col-md-6">
                                <img v-if="race.modality==='Velocidade'" src="../assets/default_images/sprint.jpg" class="img-fluid rounded" :alt="'Imagem da Prova ' + (index + 1)">
                                <img v-if="race.modality==='Slalom'" src="../assets/default_images/slalom.jpeg" class="img-fluid rounded" :alt="'Imagem da Prova ' + (index + 1)">
                                <img v-if="race.modality==='Maratona'" src="../assets/default_images/maratona.jpg" class="img-fluid rounded" :alt="'Imagem da Prova ' + (index + 1)">
                            </div>
                            <div class="col-md-6 d-flex flex-column justify-content-center p-3 bg-white rounded caption-box">
                                <h5 class="display-6">{{ race.name }}</h5>
                                <p class="lead">Prova de {{ race.modality }}</p>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p><small><strong>Distance:</strong> {{ race.distance }} {{ race.distanceUnit }}</small></p>
                                        <p><small><strong>Start Date:</strong> {{ race.startDate }}</small></p>
                                        <p><small><strong>Location:</strong> {{ race.location }}</small></p>
                                    </div>
                                    <div class="col-sm-6" v-if ="race.weather">
                                        <p><small> <i class="weather-icon"> </i> <img :src="'https://openweathermap.org/img/wn/' + race.weather.icon + '@2x.png'" :alt="race.weather.main"> {{ convertKelvinToCelsius(race.weather.temp) }} °C</small></p>
                                        <p><small><font-awesome-icon :icon="['fas', 'wind']" class="font-awesome-icon" /> {{ race.weather.windSpeed }} m/s</small></p>
                                        <p><small><font-awesome-icon :icon="['fas', 'cloud-arrow-down']" class="font-awesome-icon" /> {{ race.weather.pressure }} hPa</small></p>
                                        <p><small><font-awesome-icon :icon="['fas', 'droplet']" class="font-awesome-icon"/>{{ race.weather.humidity }}%</small></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#raceCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Anterior</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#raceCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Próximo</span>
                </button>
            </div>
        </div>
        <div v-else class="container mt-4">
            <generic-grid :data="this.competition.trials" :headers=[] :editable="false"
                :deletable="false" grid-title="Trials" @edit="openEditModal" @delete="confirmRemoveTrial" />
        </div>
    </div>
</template>

<script>
import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
import CompetitionService from '@/services/CompetitionService';
import NavigationBar from '@/components/NavigationBar.vue';
import GenericGrid from '@/components/Grid.vue';
import { StorageKeys } from '@/constants/storageKeys';

export default {
    name: 'CompetitionDetails',
    props: ['id', 'userRole'],
    components: {
        NavigationBar,
        GenericGrid
    },
    data() {
        return {
            competition: new GetCompetitionByIdOutput(),
            races: [],
            currentCard: 0, // Índice do slide atual
            role: localStorage.getItem(StorageKeys.ROLE)
        };
    },
    created() {
        this.fetchCompetition();
    },
    methods: {
        async fetchCompetition() {
            this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(this.id));
            console.log("TESTEEEEEEEEEEEEEEEEEEEE")
            console.log(this.competition);
            // Simule o carregamento das provas
            this.races = [
                {
                    name: 'Prova 1',
                    description: 'Descrição da Prova 1',
                    date: '01/07/2024',
                    imageUrl: 'https://via.placeholder.com/600x400',
                    Id: 1,
                    stateId: 1,
                    modality: "Velocidade",
                    competitionId: 1,
                    typeId: 1,
                    locationId: 'Praia de Copacabana, Rio de Janeiro',
                    judgeName: 'Carlos Silva',
                    Startdate: '2024-06-15 08:00:00',
                    Distance: 5,
                    Distanceunit: 'km',
                    Isactive: true,
                    Creationdate: '2024-01-01 00:00:00',
                    weather: {
                        main: 'Rain',
                        description: 'chuva leve',
                        temp: 299.5,
                        icon: '10d',
                        tempMin: 299.5,
                        tempMax: 299.5,
                        pressure: 1015,
                        humidity: 80,
                        seaLevel: 1015,
                        windSpeed: 10.48
                    }
                },
                {
                    name: 'Prova 2',
                    description: 'Descrição da Prova 2',
                    date: '15/07/2024',
                    imageUrl: 'https://via.placeholder.com/600x400',
                    Id: 2,
                    stateId: 1,
                    modality: "Slalom",
                    competitionId: 1,
                    typeId: 1,
                    locationId: 'Parque Ibirapuera, São Paulo',
                    judgeName: 'Ana Souza',
                    Startdate: '2024-06-15 08:00:00',
                    Distance: 10,
                    Distanceunit: 'km',
                    Isactive: true,
                    Creationdate: '2024-01-01 00:00:00',
                    weather: {
                        main: 'Clouds',
                        description: 'nublado',
                        temp: 301.5,
                        tempMin: 301.5,
                        icon: '10d',
                        tempMax: 301.5,
                        pressure: 1013,
                        humidity: 75,
                        seaLevel: 1013,
                        windSpeed: 5.0
                    }
                },
                {
                    name: 'Prova 3',
                    description: 'Descrição da Prova 3',
                    date: '30/07/2024',
                    imageUrl: 'https://via.placeholder.com/600x400',
                    Id: 3,
                    stateId: 1,
                    competitionId: 1,
                    typeId: 1,
                    modality: "Maratona",
                    locationId: 'Lagoa Rodrigo de Freitas, Rio de Janeiro',
                    judgeName: 'João Pereira',
                    Startdate: '2024-06-15 08:00:00',
                    Distance: 21,
                    Distanceunit: 'km',
                    Isactive: true,
                    Creationdate: '2024-01-01 00:00:00',
                    weather: {
                        main: 'Clear',
                        description: 'céu limpo',
                        temp: 303.0,
                        icon: '10d',
                        tempMin: 303.0,
                        tempMax: 303.0,
                        pressure: 1012,
                        humidity: 60,
                        seaLevel: 1012,
                        windSpeed: 3.0
                    }
                }
                // Adicione mais provas conforme necessário
            ];
        },
        convertKelvinToCelsius(temp) {
            return (temp - 273.15).toFixed(1);
        },
        formatDate(date) {
            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
            return new Date(date).toLocaleDateString('pt-PT', options);
        },
        editCompetition() {
            // Lógica para editar campeonato
        },
        removeCompetition() {
            // Lógica para remover campeonato
        }
    }
};
</script>

<style scoped>
.competition-info h1 {
    color: #343a40;
    font-weight: bold;
}

.competition-info p {
    color: #6c757d;
    margin-bottom: 0.5rem;
}

.race-carousel .carousel-inner .carousel-item {
    transition: transform 0.6s ease;
    margin-bottom: 50px;
}

.race-carousel .carousel-item img {
    max-height: 400px;
    object-fit: cover;
}

.carousel-control-prev-icon,
.carousel-control-next-icon {
    background-color: rgba(0, 0, 0, 0.5);
    border-radius: 50%;
    padding: 10px;
}

.carousel-control-prev,
.carousel-control-next {
    width: 5%;
}

.carousel-inner .row {
    align-items: center;
    justify-content: center;
}

.carousel-item h5 {
    color: #343a40;
    font-weight: bold;
}

.carousel-item p {
    color: #6c757d;
}

.carousel-item small {
    display: block;
    color: #6c757d;
    margin-bottom: 0.5rem;
    font-size: 1.1rem; /* Aumenta o tamanho da fonte */
}

.caption-box {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.weather-icon {
    font-size: 1.2rem;
    margin-right: 5px;
}

@media (max-width: 576px) {
    .carousel-item .col-md-6 {
        flex: 0 0 100%;
        max-width: 100%;
    }
}

.font-awesome-icon {
    margin-right: 10px;
}

.admin-buttons {
    display: flex;
    gap: 10px;
}
</style>
