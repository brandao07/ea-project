<template>
    <div id="recover-password">
        <div class="div-center vertical-center">
            <div class="content">
                <form @submit.prevent="recoverPassword">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group-center my-3">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row my-3">
                                <h3 class="card-title text-center">Recover Password</h3>
                            </div>
                            <div class="form-group mb-4">
                                <label for="emailId" class="mb-1">Email address</label>
                                <input type="email" class="form-control" id="emailId" placeholder="Enter email"
                                    v-model="recoverPasswordInput.email" required>
                            </div>
                            <div class="row mb-1">
                                <div class="col-6">
                                    <button type="button" class="btn btn-light w-100" @click="navigateToLogin">
                                        Login
                                    </button>
                                </div>
                                <div class="col-6">
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
            recoveryInProgress: false, // Flag para indicar se o processo de recuperação está em andamento
        };
    },
    methods: {
        async recoverPassword() {
            // Evita enviar múltiplas vezes enquanto o processo está em andamento
            if (this.recoveryInProgress) return;

            try {
                this.recoveryInProgress = true;
                const response = await UserService.recoverPassword(this.recoverPasswordInput);
                console.log('Recovery email sent:', response);
                
                // Verifica se o email é válido antes de redirecionar para o login
                if (response.successful) {
                    this.navigateToLogin();
                } else {
                    // Lógica para lidar com email inválido (ex: exibir mensagem de erro)
                    console.error('Invalid email entered for recovery');
                    // Exibir mensagem de erro ao usuário, se necessário
                }
            } catch (error) {
                console.error('Failed to send recovery email:', error);
                // Exibir mensagem de erro ao usuário, se necessário
            } finally {
                this.recoveryInProgress = false;
            }
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
