<template>
    <div id="recover-password">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="recover">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group-center my-3">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row my-3">
                                <h3 class="card-title">Recover Password</h3>
                            </div>
                            <div class="form-group mb-1">
                                <label for="emailId" class="mb-1">Email address</label>
                                <input type="email" class="form-control" id="emailId" placeholder="Enter email"
                                    v-model="recoverPasswordInput.email" required>
                            </div>
                            <div class="row mb-1">
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
import UserService from "@/services/UserService";
import RecoverPasswordInput from '@/models/input/RecoverPasswordInput';
import RecoverPasswordOutput from '@/models/output/RecoverPasswordOutput';

export default {
    name: 'recover-password',
    data() {
        return {
            recoverPasswordInput: new RecoverPasswordInput(),
            recoverPasswordOutput: new RecoverPasswordOutput(),
        };
    },
    methods: {
        recover() {
                console.log(this.recoverPasswordInput)
                this.recoverPasswordOutput = UserService.recoverPassword(this.recoverPasswordInput);
                console.log('Recovery email sent:', this.recoverPasswordOutput);
        },
        navigateToLogin() {
            this.$router.push('/login');
        }
    },
};
</script>

<style scoped>
#recover-password {
    min-width: 400px;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
