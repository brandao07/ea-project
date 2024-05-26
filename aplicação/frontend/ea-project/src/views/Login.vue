<template>
    <div id="login">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="login">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group-center mb-3 mt-3">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row mb-3 mt-3">
                                <h3 class="card-title">Login</h3>
                            </div>
                            <div class="form-group mb-1 justify-content-start">
                                <label for="emailId" class="mb-2">Email address</label>
                                <input type="email" class="form-control" id="emailId" placeholder="Enter email"
                                    v-model="authenticationInput.email" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="passwordId" class="mb-2">Password</label>
                                <input type="password" class="form-control" id="passwordId" placeholder="Password"
                                    v-model="authenticationInput.password" required>
                            </div>
                            <div class="form-group-right mb-1">
                                <button type="button" class="btn btn-light mx-2"
                                    @click="navigateToLogin">Register</button>
                                <button type="submit" class="btn btn-primary">Submit</button>
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
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: left;
}

.div-center {
    width: 100%;
    max-width: 400px;
}

.content {
    padding: 2em;
    background: #fff;
    border-radius: 0.5em;
    box-shadow: 0 0 1em rgba(0, 0, 0, 0.1);
}

.vertical-center {
    margin: 0;
    position: absolute;
    top: 50%;
    -ms-transform: translateY(-50%);
    transform: translateY(-50%);
}

.form-group {
    padding: 10px 5px;
    display: block;
    text-align: justify;
}

.form-group-right {
    padding: 10px 5px;
    display: block;
    text-align: right !important;
}

.form-group-center {
    padding: 10px 5px;
    display: block;
    text-align: center !important;
}

.icon-color {
    color: #008970;
}
</style>