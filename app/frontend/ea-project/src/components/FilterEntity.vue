<template>
    <div class="filter-entity">
        <div class="form-container">
            <form @submit.prevent="submitForm">
                <slot></slot>
                <div class="row form-actions">
                    <div class="col-8"></div>
                    <div class="col">
                        <button type="button" @click="resetForm" class="btn btn-light">Reset</button>
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: "filter-entity",
    props: {
        formTitle: {
            type: String,
            default: "Filter Entity",
        },
    },
    methods: {
        submitForm() {
            this.$emit("filter");
        },
        resetForm() {
            this.$emit("reset");
        },
    },
};
</script>

<style scoped>
.filter-entity {
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