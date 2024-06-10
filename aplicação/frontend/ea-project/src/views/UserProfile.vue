<template>
    <div id="profile">
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveProfile" title="Edit Profile">
            <template v-slot>
                <div class="form-group mb-1">
                    <label for="name" class="mb-2">Name</label>
                    <input type="text" class="form-control" id="name" v-model="userRegisterInput.name" required>
                </div>
                <div class="form-group mb-1">
                    <label for="email" class="mb-2">Email address</label>
                    <input type="email" class="form-control" id="email" v-model="userRegisterInput.email" required>
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
                    <input type="number" class="form-control" id="age" min="0" v-model="userRegisterInput.age" required>
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
            </template>
        </Modal>
    </div>
</template>

<script>
import Modal from '@/components/Modal.vue';
import GenderEnumerator from '@/models/enums/Gender';
import UserService from '@/services/UserService';
import UpdateUserInput from '@/models/input/UpdateUserInput';
import UpdateUserOutput from '@/models/output/UpdateUserOutput';
import GetUserByIdOutput from '@/models/output/GetUserByIdOutput';
import GetUserByIdInput from '@/models/input/GetUserByIdInput';

export default {
    name: 'profile',
    components: {
        Modal
    },
    props: {
        isVisible: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            genderEnum: GenderEnumerator,
            userId: Number(localStorage.getItem('idUser')),
            userRegisterInput: new UpdateUserInput(),
            updateUserInfoOutput: new UpdateUserOutput(),
            basicUserInfoOutput: new GetUserByIdOutput(),
            modalVisible: this.isVisible
        };
    },
    methods: {
        async fetchUserInfo() {
            this.basicUserInfoOutput = await UserService.getBasicUserInfo(new GetUserByIdInput(this.userId));
            this.userRegisterInput = new UpdateUserInput(
                this.userId,
                this.basicUserInfoOutput.name,
                this.basicUserInfoOutput.email,
                this.basicUserInfoOutput.gender,
                this.basicUserInfoOutput.age,
                this.basicUserInfoOutput.height,
                this.basicUserInfoOutput.weight
            );
        },
        async saveProfile() {
            this.updateUserInfoOutput = await UserService.updateBasicUserInfo(this.userRegisterInput);
            if (this.updateUserInfoOutput.updateSuccessful) {
                this.closeModal();
            }
        },
        cancelEdit() {
            this.closeModal();
        },
        closeModal() {
            this.modalVisible = false;
            this.$emit('close');
        }
    },
    watch: {
        async isVisible(val) {
            this.modalVisible = val;
            if (val) {
                await this.fetchUserInfo();
            }
        },
        modalVisible(val) {
            if (!val) {
                this.basicUserInfoOutput = null;
                this.$emit('close');
            }
        }
    }
};
</script>

<style></style>
