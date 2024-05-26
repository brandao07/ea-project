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
                <span class="navbar-text mx-2" v-if="user">
                    {{ user }}
                </span>
                <a href="#" @click="logout" class="navbar-text" v-if="user">
                    <font-awesome-icon :icon="['fa', 'sign-out']" />
                </a>
            </div>
        </div>
    </nav>
</template>

<script>

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import AuthService from "@/services/AuthService";

export default {
    name: 'NavigationBar',
    data() {
        let user = localStorage.getItem('name');
        return {
            user: user
        };
    },
    methods: {
        logout() {
            AuthService.logout(this.$router);
        },
    },
    components: {
        FontAwesomeIcon
    },
};
</script>

<style scoped>
.icon-color {
    color: #008970;
}

.navbar-light {
    background-color: #fcfcfc !important;
    border: 1px solid #ccc;
}

.a {
  cursor: pointer !important;
}
</style>