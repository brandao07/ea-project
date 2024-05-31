<template>
    <div id="register">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="register">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group-center mb-3 mt-3">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row mb-3 mt-3">
                                <h3 class="card-title">Register</h3>
                            </div>
                            <div class="form-group mb-1 justify-content-start">
                                <label for="name" class="mb-2">Name</label>
                                <input type="text" class="form-control" id="name" v-model="userRegisterInput.name"
                                    required>
                            </div>
                            <div class="form-group mb-1 justify-content-start">
                                <label for="email" class="mb-2">Email address</label>
                                <input type="email" class="form-control" id="email" v-model="userRegisterInput.email"
                                    required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="password" class="mb-2">Password</label>
                                <input type="password" class="form-control" id="password"
                                    v-model="userRegisterInput.password" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="gender" class="mb-2">Gender</label>
                                <input type="text" class="form-control" id="gender" v-model="userRegisterInput.gender"
                                    required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="age" class="mb-2">Age</label>
                                <input type="number" class="form-control" id="age" min="0"
                                    v-model="userRegisterInput.age" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="height" class="mb-2">Height (cm)</label>
                                <input type="number" step="0.01" min="0" class="form-control" id="height"
                                    v-model="userRegisterInput.height" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="weight" class="mb-2">Weight (kg)</label>
                                <input type="number" step="0.01" min="0" class="form-control" id="weight"
                                    v-model="userRegisterInput.weight" required>
                            </div>
                            <div class="form-group-right mb-1">
                                <button type="button" class="btn btn-light mx-2" @click="navigateToLogin">Login</button>
                                <button type="submit" class="btn btn-primary">Register</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import UserService from '@/services/UserService';
import UserRegisterInput from '@/models/input/UserRegisterInput';
import UserRegisterOutput from '@/models/output/UserRegisterOutput';

export default {
    name: 'register',
    data() {
        return {
            userRegisterInput: new UserRegisterInput(),
            userRegisterOutput: new UserRegisterOutput(),
        };
    },
    methods: {
        async register() {
            this.userRegisterOutput = await UserService.registerUser(this.userRegisterInput);
            if (this.userRegisterOutput.registrationSuccessful) {
                this.$router.push('/login');
            }
        },
        navigateToLogin() {
            this.$router.push('/login');
        },
    },
};
</script>

<style scoped>
#register {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: left;
}
</style>