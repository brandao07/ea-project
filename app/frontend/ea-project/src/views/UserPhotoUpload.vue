<template>
    <div class="user-photo-upload">
        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="uploadUserPhoto" title="Upload User Photo">
            <template v-slot>
                <div class="form-group mb-1">
                    <label for="name" class="mb-2">User Photo</label>
                    <FileUpload accept="image/*" @file-selected="handleFileSelected"></FileUpload>
                </div>
            </template>
        </Modal>
    </div>
</template>

<script>
import FileUpload from '@/components/FileUpload.vue';
import UserService from '@/services/UserService';
import UploadUserPhotoOutput from '@/models/output/UploadUserPhotoOutput';
import Modal from '@/components/Modal.vue';

export default {
    name: 'user-photo-upload',
    data() {
        return {
            userId: Number(localStorage.getItem('idUser')),
            uploadUserPhotoOutput: new UploadUserPhotoOutput(),
            selectedFile: null,
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
            const formData = new FormData();
            formData.append('photo', this.selectedFile);
            formData.append('id', this.userId);
            this.uploadUserPhotoOutput = await UserService.uploadUserPhoto(formData);
            if (this.uploadUserPhotoOutput.updateSuccessful) {
                this.closeModal();
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

<style></style>