<template>
    <div class="user-photo-upload">
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="uploadUserPhoto" title="Upload User Photo">
            <template v-slot>
                <div class="form-group mb-1">
                    <label for="name" class="mb-2">User Photo</label>
                    <FileUpload accept="image/*" @file-content="handleFileSelected"></FileUpload>
                </div>
            </template>
        </Modal>
    </div>
</template>

<script>
import FileUpload from '@/components/FileUpload.vue';
import UserService from '@/services/UserService';
import UploadUserPhotoInput from '@/models/input/UploadUserPhotoInput';
import UploadUserPhotoOutput from '@/models/output/UploadUserPhotoOutput';
import Modal from '@/components/Modal.vue';
import { setLocalStorageItems, removeLocalStorageItems } from "@/utils/storageUtils";
import { StorageKeys } from "@/constants/storageKeys";
import ApiService from "@/services/ApiService";

export default {
    name: 'user-photo-upload',
    data() {
        return {
            userId: Number(localStorage.getItem('idUser')),
            uploadUserPhotoOutput: new UploadUserPhotoOutput(),
            selectedFile: null,
            selectedFileBase64: null,
            modalVisible: this.isVisible
        };
    },
    components: {
        FileUpload,
        Modal
    },
    props: {
        isVisible: {
            type: Boolean,
            default: false
        }
    },
    methods: {
        async uploadUserPhoto() {
            this.uploadUserPhotoOutput = await UserService.uploadUserPhoto(
                new UploadUserPhotoInput(
                    this.userId,
                    this.selectedFileBase64,
                    this.selectedFile.name,
                    this.selectedFile.type));
            if (this.uploadUserPhotoOutput.updateSuccessful) {
                // Remove the token and claims from localStorage
                removeLocalStorageItems([
                    StorageKeys.JWT_TOKEN,
                    StorageKeys.ID_USER,
                    StorageKeys.NAME,
                    StorageKeys.IS_ACTIVE,
                    StorageKeys.REGISTER_DATE,
                    StorageKeys.PHOTO,
                    StorageKeys.ROLE,
                ]);

                // Clear the token in ApiService
                ApiService.clearToken();

                // Import JWT Decode
                const jwt_decode = require("jwt-decode");

                // Decode the token to get the claims
                const decodedToken = jwt_decode.jwtDecode(this.uploadUserPhotoOutput.token);

                // Store the token and claims in localStorage
                setLocalStorageItems({
                    [StorageKeys.JWT_TOKEN]: this.uploadUserPhotoOutput.token,
                    [StorageKeys.ID_USER]: decodedToken.idUser,
                    [StorageKeys.NAME]: decodedToken.name,
                    [StorageKeys.IS_ACTIVE]: decodedToken.isActive,
                    [StorageKeys.REGISTER_DATE]: decodedToken.registerDate,
                    [StorageKeys.PHOTO]: decodedToken.photo,
                    [StorageKeys.ROLE]: decodedToken.role
                });

                // Set the token in ApiService
                ApiService.setToken(this.uploadUserPhotoOutput.token);

                this.closeModal();

                window.location.reload();
            }
        },
        cancelEdit() {
            this.closeModal();
        },
        closeModal() {
            this.modalVisible = false;
            this.$emit('close');
        },
        handleFileSelected(file) {
            this.selectedFile = file;
            this.selectedFileBase64 = file.base64;
        }
    },
    watch: {
        async isVisible(val) {
            this.modalVisible = val;
        },
        modalVisible(val) {
            if (!val) {
                this.$emit('close');
            }
        }
    }
};
</script>

<style>
</style>