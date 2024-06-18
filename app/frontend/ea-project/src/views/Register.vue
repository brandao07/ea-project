<template>
    <div id="register">
        <div class="div-center">
            <div class="content">
                <form @submit.prevent="register">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group-center my-3 text-center">
                                <font-awesome-icon :icon="['fas', 'trophy']" class="icon-color fa-lg" /> | Canoeing
                            </div>
                            <div class="row my-3">
                                <h3 class="card-title text-center">Register</h3>
                            </div>
                            <div class="form-group mb-1">
                                <label for="name" class="mb-2">Name</label>
                                <input type="text" class="form-control" id="name" v-model="userRegisterInput.name"
                                    required>
                            </div>
                            <div class="form-group mb-1">
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
                                <label for="rep_password" class="mb-2">Repeat Password</label>
                                <div class="input-group">
                                    <input type="password" class="form-control" id="rep_password"
                                        v-model="password" required>
                                    <span class="input-group-text">
                                        <font-awesome-icon :icon="['fas', 'key']" />
                                    </span>
                                </div>
                                <!-- Mostra mensagem de erro se as senhas forem diferentes -->
                                <small v-if="!check_password" class="text-danger">Passwords do not match.</small>
                            </div>
                            <div class="form-group mb-1">
                                <label for="gender" class="mb-2">Gender</label>
                                <select class="form-select" v-model="userRegisterInput.gender" id="gender" required>
                                    <option v-for="(label, value) in genderEnum" :key="value" :value="value">
                                        {{ label }}
                                    </option>
                                </select>
                            </div>
                            <div class="form-group mb-1">
                                <label for="age" class="mb-2">Age</label>
                                <input type="number" class="form-control" id="age" min="0"
                                    v-model="userRegisterInput.age" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="weight" class="mb-2">Weight (kg)</label>
                                <input type="number" step="0.01" min="0" class="form-control" id="weight"
                                    v-model="userRegisterInput.weight" required>
                            </div>
                            <div class="form-group mb-4">
                                <label for="role" class="mb-2">Role</label>
                                <select class="form-select" v-model="userRegisterInput.role" id="role" required>
                                    <option v-for="(label, value) in roleEnum" :key="value" :value="value">
                                        {{ label }}
                                    </option>
                                </select>
                            </div>
                            <div class="row mb-1">
                                <div class="col-6">
                                    <router-link to="/login" class="btn btn-light w-100">
                                        <font-awesome-icon :icon="['fas', 'right-left']"
                                            class="font-awesome-icon"/> Login
                                    </router-link>
                                </div>
                                <div class="col-6">
                                    <button type="submit" class="btn btn-primary w-100">Register</button>
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
import CreateUserInput from '@/models/input/CreateUserInput';
import GenderEnumerator from '@/models/enums/Gender';
import RoleEnumerator from '@/models/enums/Role';

export default {
    name: 'register',
    data() {
        return {
            roleEnum: RoleEnumerator,
            genderEnum: GenderEnumerator,
            password: '',
            userRegisterInput: new CreateUserInput(),
            userRegisterOutput: null,
        };
    },
    methods: {
        async register() {
            // Verifica se as senhas são iguais antes de registrar o usuário
            if (this.check_password) {
                this.userRegisterOutput = await UserService.registerUser(this.userRegisterInput);
                if (this.userRegisterOutput.registrationSuccessful) {
                    this.$router.push('/login');
                }
            } else {
                // Se as senhas não são iguais, exibe um alerta ou outra ação apropriada
                alert('Passwords do not match. Please try again.');
                // Ou pode limpar os campos de senha, etc.
                this.password = '';
                this.userRegisterInput.password = '';
            }
        }
    },
    computed: {
        check_password() {
            return this.userRegisterInput.password === this.password;
        }
    }
};
</script>

<style scoped>
#register {
    height: 100%;
    margin-top: 0rem;
    margin-bottom: 0rem;
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

.font-awesome-icon {
    margin-right: 10px;
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
