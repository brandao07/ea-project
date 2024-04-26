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
                <span class="navbar-text" v-if="user">
                    {{ user }}
                </span>
            </div>
        </div>
    </nav>
</template>

<script>

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

//import jwt_decode from 'jwt-decode';

export default {
    name: 'NavigationBar',
    data() {
        /**
         * FIXME: For test purposes -- Do not use it this way!!
         */
        const token = localStorage.getItem('jwt-token');
        let user = '';
        if (token) {
            let decodedToken = JSON.parse(atob(token.split('.')[1]));
            console.log('Decoded Token:', decodedToken);
            user = decodedToken.name;
            console.log('Decoded User:', user);
        }
        else {
            user = ""
        }
        return {
            user: user,
            token: token
        };
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
</style>