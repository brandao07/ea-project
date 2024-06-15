<template>
    <div class="create-entity">
        <div class="form-container">
            <h2 class="form-title">{{ formTitle }}</h2>
            <form @submit.prevent="submitForm">
                <slot></slot>
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Create</button>
                    <button type="button" @click="resetForm" class="btn btn-secondary">Reset</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: "create-entity",
    props: {
        formTitle: {
            type: String,
            default: "Create Entity",
        },
    },
    methods: {
        submitForm() {
            this.$emit("create");
        },
        resetForm() {
            this.$emit("reset");
        },
    },
};
</script>

<style scoped>
.create-entity {
    margin: 20px;
    background: var(--color-white);
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 1em var(--color-black-rgba);
}

.form-title {
    font-size: 1.5rem;
    color: #343a40;
    font-weight: 300;
    margin-bottom: 1rem;
}

.form-actions {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.btn {
    padding: 0.5rem 1rem;
    border-radius: 4px;
    border: none;
}

.btn-primary {
    background-color: var(--button-primary);
    color: var(--color-white);
}

.btn-secondary {
    background-color: var(--button-secondary);
    color: var(--color-white);
}

@media (max-width: 768px) {
    .form-title {
        font-size: 1.25rem;
    }
}
</style>