<template>
    <div class="race-details">
        <NavigationBar />
        <div class="container my-5">
            <div class="row align-items-center">
                <div class="col-md-6">
                    <h1 class="display-4">{{ race.name }}</h1>
                    <p class="lead">Modality: {{ race.modality }}</p>
                    <p class="lead">Date: {{ formatDate(race.date) }}</p>
                    <p class="lead">Category: {{ competition.category }}</p>
                    <p class="lead">Distance: {{ race.Distance }} {{ race.Distanceunit }}</p>
                    <p class="lead">Start Time: {{ formatDate(race.Startdate) }}</p>
                    <p class="lead">Location: {{ race.locationId }}</p>
                    <p class="lead">Judge: {{ race.judgeName }}</p>
                    <p class="lead">
                        <img :src="'https://openweathermap.org/img/wn/' + race.weather.icon + '@2x.png'" :alt="race.weather.main"> 
                        {{ convertKelvinToCelsius(race.weather.temp) }} °C
                    </p>
                    <p class="lead">Wind Speed: {{ race.weather.windSpeed }} m/s</p>
                    <p class="lead">Pressure: {{ race.weather.pressure }} hPa</p>
                    <p class="lead">Humidity: {{ race.weather.humidity }}%</p>
                </div>
                <div class="col-md-6 text-center">
                    <img v-if="race.modality === 'Velocidade'" src="../assets/default_images/sprint.jpg" class="img-fluid rounded" :alt="'Imagem da Prova'">
                    <img v-if="race.modality === 'Slalom'" src="../assets/default_images/slalom.jpeg" class="img-fluid rounded" :alt="'Imagem da Prova'">
                    <img v-if="race.modality === 'Maratona'" src="../assets/default_images/maratona.jpg" class="img-fluid rounded" :alt="'Imagem da Prova'">
                </div>
            </div>
            <div v-if="events.length > 0" class="events mt-4">
                <h2 class="display-6">Eventos</h2>
                <ul class="list-group">
                    <li v-for="event in events" :key="event.id" class="list-group-item">
                        <p><strong>{{ event.type }}</strong>: {{ event.description }}</p>
                        <p><small>Time: {{ formatDate(event.time) }}</small></p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar.vue';
import TrialService from '@/services/TrialService';

export default {
    name: 'RaceDetails',
    props: ['raceId'],
    components: {
        NavigationBar
    },
    data() {
        return {
            race: {},
            events: []
        };
    },
    created() {
        this.fetchRaceDetails();
        this.fetchRaceEvents();
    },
    methods: {
        async fetchRaceDetails() {
            // Replace with the actual service call to fetch race details by ID
            const race = await TrialService.getTrialById(this.raceId);
            this.race = race;
        },
        async fetchRaceEvents() {
            // Replace with the actual service call to fetch events for this race
            //const events = await TrialService.getTrialEvents(this.raceId);
            this.events = [];
        },
        convertKelvinToCelsius(temp) {
            return (temp - 273.15).toFixed(1);
        },
        formatDate(date) {
            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
            return new Date(date).toLocaleDateString('pt-BR', options);
        }
    }
};
</script>

<style scoped>
.race-details h1 {
    color: #343a40;
    font-weight: bold;
}

.race-details p {
    color: #6c757d;
    margin-bottom: 0.5rem;
}

.race-details img {
    max-height: 400px;
    object-fit: cover;
}

.events ul {
    padding: 0;
    list-style-type: none;
}

.events ul li {
    background-color: #fff;
    padding: 15px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
}
</style>
