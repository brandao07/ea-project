<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <span class="navbar-brand">
                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color" />
                | Canoeing
            </span>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" @click="toggleMenu">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link class="nav-link" to="/">Home</router-link>
                    </li>
                    <li class="nav-item" v-if="role == roleEnum.Administrator">
                        <router-link class="nav-link" to="/administration">Administration</router-link>
                    </li>
                    <li class="nav-item"><!-- v-if="role == roleEnum.Administrator">-->
                        <router-link class="nav-link" to="/insert-results">Insert Results</router-link>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            View Entities
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><router-link class="nav-link" to="/competitions">Competitions</router-link></li>
                            <li><router-link class="nav-link" to="/trials">Trials</router-link></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Create Entities
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><router-link class="nav-link" to="/create-competition">Competitions</router-link></li>
                            <li><router-link class="nav-link" to="/create-trial">Trials</router-link></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Edit Entities
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><router-link class="nav-link" to="/edit-competition">Competitions</router-link></li>
                            <li><router-link class="nav-link" to="/edit-trial">Trials</router-link></li>
                        </ul>
                    </li>
                </ul>
                <div class="dropdown ms-lg-auto" v-if="user">
                    <button class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false" ref="profileMenuButton">
                        <div v-if="!hasUserPhoto" class="user-avatar user-initials">
                            {{ userInitials }}
                        </div>
                        <div v-else class="user-avatar">
                            <img :src="userPhoto" class="rounded-circle" alt="User Photo">
                        </div>
                        <span>
                            {{ user }}
                        </span>
                    </button>
                    <ul class="action dropdown-menu" ref="profileMenu">
                        <div class="menu">
                            <div class="profile">
                                <div v-if="!hasUserPhoto" class="user-avatar user-initials">
                                    {{ userInitials }}
                                </div>
                                <div v-else class="user-avatar">
                                    <img :src="userPhoto" class="rounded-circle" alt="User Photo">
                                </div>
                                <span>
                                    {{ user }}
                                </span>
                            </div>
                            <div class="dropdown-divider"></div>
                            <li><a href="#" @click="showProfileModal = true"><font-awesome-icon
                                        :icon="['fas', 'user']" />
                                    Profile</a></li>
                            <li><a href="#" @click="showPhotoUploadModal = true"><font-awesome-icon
                                        :icon="['fa', 'camera']" />
                                    Photo</a></li>
                            <div class="dropdown-divider"></div>
                            <li><a href="#" @click="logout"><font-awesome-icon :icon="['fas', 'sign-out-alt']" />
                                    Logout</a>
                            </li>
                        </div>
                    </ul>
                </div>
            </div>
        <router-view :key="$route.path"></router-view>
        </div>
        <UserProfile :isVisible="showProfileModal" @close="showProfileModal = false" />
        <UserPhotoUpload :isVisible="showPhotoUploadModal" @close="showPhotoUploadModal = false" />
    </nav>
</template>

<script>
import FontAwesomeIcon from '@fortawesome/vue-fontawesome';
import AuthService from "@/services/AuthService";
import UserProfile from '@/views/UserProfile.vue';
import UserPhotoUpload from '@/views/UserPhotoUpload.vue';
import RoleEnumerator from '@/models/enums/Role';

export default {
    name: 'NavigationBar',
    data() {
        let user = localStorage.getItem('name');
        let role = localStorage.getItem('role');
        return {
            roleEnum: RoleEnumerator,
            user: user,
            role: role,
            showProfileModal: false,
            showPhotoUploadModal: false,
            isMenuToggled: false
        };
    },
    computed: {
        userPhoto() {
            return localStorage.getItem('photo');
        },
        hasUserPhoto() {
            const photo = localStorage.getItem('photo');
            return (photo != null || photo != undefined) && photo !== '' && photo !== 'undefined';
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
        toggleMenu() {
            this.isMenuToggled = !this.isMenuToggled;
            if (this.isMenuToggled) {
                this.$refs.profileMenu.classList.add('profile-menu-left');
            } else {
                this.$refs.profileMenu.classList.remove('profile-menu-left');
            }
        },
        logout() {
            AuthService.logout(this.$router);
        },
    },
    components: {
        FontAwesomeIcon,
        UserProfile,
        UserPhotoUpload
    },
};
</script>

<style scoped>
.navbar {
    padding: 10px 20px;
}

.navbar-light {
    background-color: var(--navbar-bg-color) !important;
    border: 1px solid var(--color-grey);
}

.nav-link img {
    margin-right: 8px;
}

button span {
    padding: 0px 12px;
}

.navbar-toggler {
    border: none !important;
}

.navbar-toggler-icon {
    display: inline-block;
    width: 24px;
    height: 24px;
    border: none;
}

.user-avatar {
    display: inline;
    justify-content: center;
    align-items: center;
    width: fit-content;
    height: 30px;
    border-radius: 50%;
    font-size: medium;
    object-fit: scale-down;
    background-size: cover;

    &.user-initials {
        display: inline-flex;
        width: 30px;
        border-radius: 50%;
        background-color: var(--user-initials-bg-color);
        color: var(--color-white);
    }

    img {
        width: inherit;
        height: inherit;
    }
}

.action {
    padding: 10px 20px;
    width: auto;
    background: var(--color-white);
    border-radius: 0.5em;
    box-shadow: 0 0 1em var(--color-black-rgba);
    border: 0px;
    align-self: left;
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

.profile-menu-left {
    right: auto !important;
    left: 0 !important;
}
</style>
