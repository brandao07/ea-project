<template>
    <div class="create-entity">
        <div class="form-container">
            <h2 class="form-title">{{ formTitle }}</h2>
            <form @submit.prevent="submitForm">
                <slot></slot>
                <div class="row form-actions">
                    <div class="col-8"></div>
                    <div class="col">
                        <button type="btn" class="btn btn-danger" @click="Cancel">Cancel</button>
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </div>
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
        Cancel() {
            this.$emit("cancel");
        },
        submitForm() {
            this.$emit("edit");
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

@media (max-width: 768px) {
    .form-title {
        font-size: 1.25rem;
    }
}
</style>