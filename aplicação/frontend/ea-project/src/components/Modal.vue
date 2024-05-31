<!-- Modal.vue -->
<template>
    <div v-if="isVisible" class="modal-overlay" @click="cancel">
        <div class="modal" @click.stop>
            <div class="modal-header">
                <h5 class="modal-title">
                    {{ title }}
                </h5>
            </div>
            <div class="modal-body">
                <slot></slot>
            </div>
            <div class="modal-footer">
                <button class="btn btn-light mx-2" @click="cancel">Cancel</button>
                <button class="btn btn-primary mx-0" @click="save">Save</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Modal',
    props: {
        isVisible: {
            type: Boolean,
            default: false
        },
        title: {
            type: String,
            default: ''
        }
    },
    methods: {
        cancel() {
            this.$emit('cancel');
        },
        save() {
            this.$emit('save');
        }
    }
}
</script>

<style scoped>
.modal-footer {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
}

.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal {
    background: white;
    padding: 20px;
    border-radius: 8px;
    position: relative;
    display: block;
    width: auto;
    height: auto;
}
</style>