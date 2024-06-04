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
                        <router-link class="nav-link" to="/">Home</router-link>
                    </li>
                    <li class="nav-item" v-if="role == roleEnum.Administrator">
                        <router-link class="nav-link" to="/administration">Administração</router-link>
                    </li>
                </ul>
                <div class="dropdown" v-if="user">
                    <button class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <div v-if="!hasUserPhoto" class="user-avatar user-initials">
                            {{ userInitials }}
                        </div>
                        <div v-else class="user-avatar">
                            <img :src="userPhoto" class="user-photo rounded-circle" alt="User Photo">
                        </div>
                        {{ user }}
                    </button>
                    <ul class="action dropdown-menu">
                        <div class="menu">
                            <div class="profile">
                                <div v-if="!hasUserPhoto" class="user-avatar user-initials">
                                    {{ userInitials }}
                                </div>
                                <div v-else class="user-avatar">
                                    <img :src="userPhoto" class="user-photo rounded-circle" alt="User Photo">
                                </div>
                                <span>
                                    {{ user }}
                                </span>
                            </div>
                            <div class="dropdown-divider"></div>
                            <li><a class="list-group-item list-group-item-action" href="#" @click="showProfileModal = true"><font-awesome-icon :icon="['fas', 'user']" /> Profile</a></li>
                            <li><a class="list-group-item list-group-item-action" href="#"><font-awesome-icon :icon="['fas', 'cog']" /> Settings</a></li>
                            <div class="dropdown-divider"></div>
                            <li><a class="list-group-item list-group-item-action" href="#" @click="logout"><font-awesome-icon :icon="['fas', 'sign-out-alt']" /> Logout</a></li>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
        <UserProfile :isVisible="showProfileModal" @close="showProfileModal = false" />
    </nav>
</template>

<script>

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import AuthService from "@/services/AuthService";
import UserProfile from '../views/UserProfile.vue';
import RoleEnumerator from '@/models/enums/Roles';

export default {
    name: 'NavigationBar',
    data() {
        let user = localStorage.getItem('name');
        let role = localStorage.getItem('role');
        return {
            roleEnum: RoleEnumerator,
            user: user,
            role: role,
            showProfileModal: false
        };
    },
    computed: {
        userPhoto() {
            return localStorage.getItem('photo');
        },
        hasUserPhoto() {
            const photo = localStorage.getItem('photo');
            return photo !== null && photo !== undefined && photo !== '';
        },
        userInitials() {
            if (this.user) {
                const nameParts = this.user.split(' ');
                const initials = nameParts.map(part => part.charAt(0)).join('').toUpperCase();
                return initials.length > 2 ? initials.charAt(0) + initials.charAt(initials.length - 1) : initials;
            }
            return '';
        }
    },
    methods: {
        logout() {
            AuthService.logout(this.$router);
        },
    },
    components: {
        FontAwesomeIcon,
        UserProfile
    },
};
</script>

<style scoped>
.navbar-light {
    background-color: #fcfcfc !important;
    border: 1px solid #ccc;
}

.nav-link img {
    margin-right: 8px;
}

.user-avatar {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    margin-right: 8px;
    font-size: small;

    &.user-initials {
        background-color: #6c757d;
        color: #fff;
    }

    &.user-photo {
        img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }
    }
}

.action {
    position: absolute;
    top: 48px;
    right: -10px;
    padding: 10px 20px;
    background: #fff;
    width: auto;
    box-sizing: 0 5px 25px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

.action .menu ul li a {
    display: inline-block;
    text-decoration: none;
}

ul li a svg {
    width: 24px;
}

.menu li {
    position: relative;
    display: block;
    padding: 5px 0px;
}

.action .menu .profile {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding: 15px 0px;
}

.action .menu .profile .user-avatar {
    width: 60px;
    height: 60px;
    margin-bottom: 10px;
    font-size: xx-large;
}
</style>