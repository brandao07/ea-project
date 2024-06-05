<template>
    <div id="login">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="login">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group-center my-3">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row my-3">
                                <h3 class="card-title">Login</h3>
                            </div>
                            <div class="form-group mb-1">
                                <label for="emailId" class="mb-1">Email address</label>
                                <input type="email" class="form-control" id="emailId" placeholder="Enter email"
                                    v-model="authenticationInput.email" required>
                            </div>
                            <div class="form-group mb-4">
                                <label for="passwordId" class="mb-1">Password</label>
                                <input type="password" class="form-control" id="passwordId" placeholder="Password"
                                    v-model="authenticationInput.password" required>
                            </div>
                            <div class="row mb-1">
                                <div class="col">
                                    <button type="button" class="btn btn-light"
                                        @click="navigateToLogin">Register</button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
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
import AuthenticationInput from '@/models/input/AuthenticationInput';
import AuthenticationOutput from '@/models/output/AuthenticationOutput';
import AuthService from "@/services/AuthService";

export default {
    name: 'login',
    data() {
        return {
            authenticationInput: new AuthenticationInput(),
            authenticationOutput: new AuthenticationOutput(),
        };
    },
    methods: {
        async login() {
            this.authenticationOutput = await UserService.loginUser(this.authenticationInput);
            if (this.authenticationOutput.token) {
                AuthService.login(this.authenticationOutput.token, this.$router);
            }
        },
        navigateToLogin() {
            this.$router.push('/register');
        },
    },
};

</script>

<style scoped>
#login {
    min-width: 400px;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: left;
}
</style>