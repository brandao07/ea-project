<template>
    <div class="competition-details">
        <NavigationBar />

        <!-- Detalhes da Competição -->
        <div class="competition-info container my-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h1 class="display-4">{{ this.competition.name }}</h1>
                <div v-if="this.role==='Administrator'" class="admin-buttons">
                    <button v-if="Date.now() < new Date(this.competition.startDate) " class="btn btn-success me-2" @click="registerTeam">Register Team</button>
                    <button class="btn btn-primary me-2" @click="editCompetition">Edit</button>
                    <button class="btn btn-danger me-2" @click="confirmRemoveCompetition">Delete</button>
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
                                <img v-if="race.modality==='Marathon'" src="../assets/default_images/maratona.jpg" class="img-fluid rounded" :alt="'Imagem da Prova ' + (index + 1)">
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
                :deletable="false" grid-title="Trials" />
        </div>
    <Footer></Footer>
    </div>
</template>

<script>
import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
import CompetitionService from '@/services/CompetitionService';
import NavigationBar from '@/components/NavigationBar.vue';
import GenericGrid from '@/components/Grid.vue';
import { StorageKeys } from '@/constants/storageKeys';
import router from '@/router';
import Footer from '@/components/footer.vue';

export default {
    name: 'CompetitionDetails',
    props: ['id', 'userRole'],
    components: {
        NavigationBar,
        GenericGrid,
        Footer
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
            this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(this.$route.params.id));
        },
        convertKelvinToCelsius(temp) {
            return (temp - 273.15).toFixed(1);
        },
        formatDate(date) {
            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
            return new Date(date).toLocaleDateString('pt-PT', options);
        },
        editCompetition() {
            router.push({ name: 'edit-competitions', params: { id: this.competition.id } });
        },
        registerTeam() {
            router.push({ name: 'register-team', params: { competitionId: this.competition.id } });
        },
        confirmRemoveCompetition() {
            if (confirm("Are you sure you want to delete this competition?")) {
                this.removeCompetition();
            }
        },
        async removeCompetition() {
            await CompetitionService.deleteCompetition({id:this.competition.id,isActive:false});
            router.push({ name: 'view-competitions' });
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
}
</style>