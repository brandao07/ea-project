<template>
    <div id="login">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="login">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group-center my-3 text-center">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row my-3">
                                <h3 class="card-title text-center">Login</h3>
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
                                <div class="col-6">
                                    <button type="button" class="btn btn-light w-100"
                                        @click="navigateToLogin">Register</button>
                                </div>
                                <div class="col-6">
                                    <button type="submit" class="btn btn-primary w-100">Submit</button>
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
    min-width: 300px;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.div-center {
    width: 100%;
    max-width: 500px;
    padding: 1rem;
}

.content {
    width: 100%;
}

@media (max-width: 768px) {
    .div-center {
        padding: 0.5rem;
    }

    .form-group-center {
        text-align: center;
    }
}
</style>