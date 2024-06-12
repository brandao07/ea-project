<!-- Modal.vue -->
<template>
    <div v-if="isVisible" class="modal-overlay">
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
                <div class="col">
                    <button class="btn btn-light" @click="cancel">Cancel</button>
                </div>
                <div class="col">
                    <button class="btn btn-primary" @click="save">Save</button>
                </div>
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
    width: 100%;
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
    pointer-events: all; /* Capture all pointer events */
}

.modal {
    background: white;
    padding: 2em 1em;
    border-radius: 8px;
    position: relative;
    display: block;
    min-width: 400px;
    width: auto;
    height: auto;
    pointer-events: all; /* Enable pointer events on the modal content */
}
</style>