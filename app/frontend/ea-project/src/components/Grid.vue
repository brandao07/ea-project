<template>
    <div class="data-grid">
        <div class="table-responsive-sm">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2 class="grid-title">{{ gridTitle }}</h2>
                <div class="d-flex" v-if="hasData">
                    <input type="text" v-model="localFilterCriteria" class="form-control filter-input"
                        placeholder="Filter..." />
                </div>
            </div>
            <table class="table table-striped table-hover table-bordered" v-if="hasData">
                <thead class="table-light">
                    <tr>
                        <th v-for="(header, index) in formattedHeaders" :key="index">{{ header }}</th>
                        <th v-if="editable || deletable">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item, rowIndex) in paginatedData" :key="rowIndex">
                        <td v-for="(header, index) in headers" :key="index">{{ formatValue(item[header]) }}</td>
                        <td v-if="editable || deletable">
                            <div class="row">
                                <div class="col">
                                    <button @click="editRow(item)" class="btn btn-primary btn-sm me-2" :disabled="!editable">
                                        <font-awesome-icon :icon="['fas', 'edit']" class="icon-color fa-md" />
                                    </button>
                                </div>
                                <div class="col">
                                    <button @click="deleteRow(item)" class="btn btn-danger btn-sm" :disabled="!deletable">
                                        <font-awesome-icon :icon="['fas', 'trash-alt']" class="icon-color fa-md" />
                                    </button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div v-else class="no-data">No data available</div>
            <div class="row mt-4" v-if="hasData">
                <div class="col"></div>
                <div class="col-6">
                    <nav>
                        <ul class="pagination">
                            <li class="page-item" :class="{ disabled: currentPage === 1 }"
                                @click="changePage(currentPage - 1)">
                                <a class="page-link" href="#">Previous</a>
                            </li>
                            <li class="page-item" v-for="page in totalPages" :key="page"
                                :class="{ active: currentPage === page }" @click="changePage(page)">
                                <a class="page-link" href="#">{{ page }}</a>
                            </li>
                            <li class="page-item" :class="{ disabled: currentPage === totalPages }"
                                @click="changePage(currentPage + 1)">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="col-3">
                    <div class="row">
                        <div class="col">
                            <label for="itemsPerPageSelect" class="me-2">Items per page:</label>
                        </div>
                        <div class="col">
                            <select v-model="itemsPerPage" class="form-select items-per-page-select"
                                id="itemsPerPageSelect">
                                <option v-for="option in itemsPerPageOptions" :key="option" :value="option">{{
                                    option }}
                                </option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "data-grid",
    props: {
        data: {
            type: Array,
            required: true
        },
        headers: {
            type: Array,
            required: true
        },
        editable: {
            type: Boolean,
            default: false
        },
        deletable: {
            type: Boolean,
            default: false
        },
        filterCriteria: {
            type: String,
            default: ''
        },
        gridTitle: {
            type: String,
            default: 'Data Grid'
        },
        defaultItemsPerPage: {
            type: Number,
            default: 10
        }
    },
    data() {
        return {
            currentPage: 1,
            itemsPerPage: this.defaultItemsPerPage,
            itemsPerPageOptions: [10, 25, 50, 75, 100],
            localFilterCriteria: this.filterCriteria,
        };
    },
    computed: {
        filteredData() {
            if (this.localFilterCriteria) {
                return this.data.filter(item => {
                    return this.headers.some(header =>
                        item[header] && item[header].toString().toLowerCase().includes(this.localFilterCriteria.toLowerCase())
                    );
                });
            }
            return this.data;
        },
        totalPages() {
            return Math.ceil(this.filteredData.length / this.itemsPerPage);
        },
        paginatedData() {
            const start = (this.currentPage - 1) * this.itemsPerPage;
            const end = start + this.itemsPerPage;
            return this.filteredData.slice(start, end);
        },
        formattedHeaders() {
            return this.headers.map(header => this.camelCaseToSpaces(header));
        },
        hasData() {
            return this.data && this.data.length > 0;
        }
    },
    watch: {
        itemsPerPage() {
            this.currentPage = 1;
        }
    },
    methods: {
        changePage(page) {
            if (page > 0 && page <= this.totalPages) {
                this.currentPage = page;
            }
        },
        editRow(item) {
            this.$emit('edit', item);
        },
        deleteRow(item) {
            this.$emit('delete', item);
        },
        camelCaseToSpaces(str) {
            return str.replace(/([a-z])([A-Z])/g, '$1 $2')
                .replace(/^./, function (str) { return str.toUpperCase(); });
        },
        formatValue(value) {
            if (typeof value === 'string' && this.isIsoDateString(value)) {
                const date = new Date(value);
                return date.toLocaleString();
            }
            return value;
        },
        isIsoDateString(value) {
            const isoDatePattern = /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}(?:\.\d+)?(?:Z|[+-]\d{2}:\d{2})$/;
            return isoDatePattern.test(value);
        }
    }
};
</script>

<style scoped>
.data-grid {
    margin: 20px;
    background: var(--color-white);
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 1em var(--color-black-rgba);
}

.grid-title {
    font-size: 1.5rem;
    color: #343a40;
    font-weight: 300;
}

.filter-input,
.items-per-page-select {
    margin-left: auto;
    margin-right: 10px;
}

.filter-input {
    width: 200px;
}

.table {
    margin-bottom: 1rem;
    border-radius: 8px;
    overflow: hidden;
}

.no-data {
    text-align: center;
    font-size: 1.2rem;
    color: #777;
    font-style: italic;
    margin: 20px 0;
}

.pagination {
    justify-content: center;
}

.page-item .page-link {
    color: var(--color-grey-dark) !important;
}

.page-item.hover .page-link {
    background-color: var(--button-primary) !important;
    border-color: var(--button-primary-darker) !important;
}

.page-item.active .page-link {
    background-color: var(--button-primary-darker) !important;
    border-color: var(--button-primary-darker) !important;
    color: var(--color-white) !important;
}

svg {
    color: var(--color-white) !important;
}

@media (max-width: 768px) {
    .filter-input {
        width: 100%;
        margin: 0;
        margin-top: 1rem;
    }

    .grid-title {
        font-size: 1.25rem;
    }
}
</style>
