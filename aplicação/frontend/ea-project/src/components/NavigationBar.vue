<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">
                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color" />
                | Canoeing
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Utilizadores</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    {{this.user.name}}
                </span>
            </div>
        </div>
    </nav>
</template>

<script>
import axios from 'axios'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

export default {
    name: 'NavigationBar',
    data() {
        return {
            user: ''
        }
    },
    components: {
        FontAwesomeIcon
    },
    created() {
        axios({
            method: "get",
            url: "http://localhost:7000/GetAllUsers",
        })
        .then(data => {
            this.user = data.data[0]; // FIXME: TEST
        })
        .catch(err => {
            console.log(err)
        })    
    },
};

</script>

<style scoped>
.icon-color {
    color: #008970;
}
</style>