<template>
    <div id="change-role">
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveProfile" title="Change User Role">
            <template v-slot>
                <form>
                    <div class="form-group mb-1">
                        <label for="user" class="mb-2">User</label>
                        <select class="form-control" id="user" v-model="updateUserRoleInput.userId" required>
                            <option v-for="user in getUsersOutput.usersList" :key="user.email" :value="user.userId">
                                {{ user.email }}
                            </option>
                        </select>
                    </div>
                    <div class="form-group mb-1">
                        <label for="role" class="mb-2">Role</label>
                        <select class="form-control" id="role" v-model="updateUserRoleInput.roleId" required>
                            <option v-for="role in getRolesOutput.rolesList" :key="role.name" :value="role.roleId">
                                {{ role.name }}
                            </option>
                        </select>
                    </div>
                </form>
            </template>
        </Modal>
    </div>
</template>

<script>
import Modal from '@/components/Modal.vue';
import UserService from '@/services/UserService';
import RoleService from '@/services/RoleService';
import GetRolesInput from '@/models/input/GetRolesInput';
import GetRolesOutput from '@/models/output/GetRolesOutput';
import GetUsersInput from '@/models/input/GetUsersInput';
import GetUsersOutput from '@/models/output/GetUsersOutput';
import UpdateUserRoleInput from '@/models/input/UpdateUserRoleInput';
import UpdateUserRoleOutput from '@/models/output/UpdateUserRoleOutput';

export default {
    name: 'change-role',
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
            getRolesOutput: new GetRolesOutput(),
            getUsersOutput: new GetUsersOutput(),
            updateUserRoleInput: new UpdateUserRoleInput(),
            updateUserRoleOutput: new UpdateUserRoleOutput(),
            modalVisible: this.isVisible
        };
    },
    methods: {
        async fetchUserInfo() {
            this.getUsersOutput = await UserService.getAllUsers(new GetUsersInput());
        },
        async fetchRoleInfo() {
            this.getRolesOutput = await RoleService.getAllRoles(new GetRolesInput());
        },
        async saveProfile() {
            this.updateUserRoleOutput = await UserService.updateUserCurrentRole(this.updateUserRoleInput);
            if (this.updateUserRoleOutput.updateSuccessful) {
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
                await this.fetchRoleInfo();
            }
        },
        modalVisible(val) {
            if (!val) {
                this.updateUserRoleInput = new UpdateUserRoleInput(),
                this.updateUserRoleOutput = new UpdateUserRoleOutput(),
                this.$emit('close');
            }
        }
    }
};
</script>

<style></style>
