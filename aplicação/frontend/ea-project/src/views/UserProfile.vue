<template>
    <div id="profile">
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveProfile" title="Edit Profile">
            <template v-slot>
                <div class="form-group mb-1 justify-content-start">
                    <label for="name" class="mb-2">Name</label>
                    <input type="text" class="form-control" id="name" v-model="userRegisterInput.name" required>
                </div>
                <div class="form-group mb-1 justify-content-start">
                    <label for="email" class="mb-2">Email address</label>
                    <input type="email" class="form-control" id="email" v-model="userRegisterInput.email" required>
                </div>
                <div class="form-group mb-1">
                    <label for="gender" class="mb-2">Gender</label>
                    <input type="text" class="form-control" id="gender" v-model="userRegisterInput.gender" required>
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
import Modal from '../components/Modal.vue';
import UserService from '@/services/UserService';
import UpdateUserInfoInput from '@/models/input/UpdateUserInfoInput';
import UpdateUserInfoOutput from '@/models/output/UpdateUserInfoOutput';
import BasicUserInfoInput from '@/models/input/BasicUserInfoInput';
import BasicUserInfoOutput from '@/models/output/BasicUserInfoOutput';

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
            userId: Number(localStorage.getItem('idUser')),
            userRegisterInput: new UpdateUserInfoInput(),
            updateUserInfoOutput: new UpdateUserInfoOutput(),
            basicUserInfoOutput: new BasicUserInfoOutput(),
            modalVisible: this.isVisible
        };
    },
    methods: {
        async fetchUserInfo() {
            this.basicUserInfoOutput = await UserService.getBasicUserInfo(new BasicUserInfoInput(this.userId));
            this.userRegisterInput = new UpdateUserInfoInput(
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
                this.$emit('close');
            }
        }
    }
};
</script>

<style></style>
