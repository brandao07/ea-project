<template>
    <div class="competition-filter" style="background-color: #f0f0f0; padding: 20px; border-radius: 8px;">
        <div class="row mb-3">
            <div class="col-md-4">
                <label for="competitionName" class="form-label">Competition Name</label>
                <input type="text" v-model="filters.competitionName" class="form-control" id="competitionName">
            </div>
            <div class="col-md-2">
                <label for="gender" class="form-label">Gender</label>
                <select v-model="filters.gender" class="form-select" id="gender">
                    <option value="">All</option>
                    <option v-for="gender,label in genderEnum" :key="label" :value="label">{{ gender }}</option>
                </select>
            </div>
            <div class="col-md-5">
                <label class="form-label">Category</label>
                <div>
                    <label v-for="category in categoryEnum" :key="category" class="form-check form-check-inline">
                        <input type="checkbox" v-model="filters.category" :value="category" class="form-check-input">
                        {{ category }}
                    </label>
                </div>
            </div>
            <div class="col-md-3 mt-3">
                <label for="startDate" class="form-label">Start Date</label>
                <input type="date" v-model="filters.startDate" class="form-control" id="startDate">
            </div>
            <div class="col-md-3 mt-3">
                <label for="endDate" class="form-label">End Date</label>
                <input type="date" v-model="filters.endDate" class="form-control" id="endDate" @change="validateDates">
                <div v-if="!datesValid" class="text-danger">End Date must be after Start Date</div>
            </div>
            <div class="row mb-0"></div>
            <label class="form-label mt-3">Grade</label>
            <div>
                <label v-for="grade in gradeEnum" :key="grade" class="form-check form-check-inline">
                    <input type="checkbox" v-model="filters.grade" :value="grade" class="form-check-input">
                    {{ grade }}
                </label>
            </div>
        </div>
        <div class="row d-flex justify-content-end">
            <div class="col-md-3">
                <button type="button" class="btn btn-outline-secondary me-2" @click="resetFilters">Reset</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-primary" @click="applyFilters">Apply</button>
            </div>
        </div>
    </div>
</template>

<script>
import GenderEnumerator from '@/models/enums/Gender';
import GradeEnumerator from '@/models/enums/Grade';
import CategoryEnumerator from '@/models/enums/Category';

export default {
    name: 'CompetitionFilter',
    props: {
        // If additional configuration properties are needed, they can be declared here
    },
    data() {
        return {
            genderEnum: GenderEnumerator,
            gradeEnum: GradeEnumerator,
            categoryEnum: CategoryEnumerator,
            filters: {
                competitionName: '',
                grade: [],
                gender: '',
                category: [],
                startDate: '',
                endDate: '',
            },
            datesValid: true
        };
    },
    methods: {
        applyFilters() {
            if (this.validateDates()) {
                this.$emit('apply-filters', this.filters);
            }
        },
        resetFilters() {
            this.filters = {
                competitionName: '',
                grade: [],
                gender: '',
                category: [],
                startDate: '',
                endDate: '',
            };
            this.datesValid = true;
            this.$emit('apply-filters', this.filters);
        },
        validateDates() {
            if (this.filters.startDate && this.filters.endDate) {
                if (this.filters.startDate > this.filters.endDate) {
                    this.datesValid = false;
                    return false;
                } else {
                    this.datesValid = true;
                    return true;
                }
            }
            this.datesValid = true;
            return true;
        }
    },
    watch: {
        filters: {
            deep: true,
            handler() {
                this.validateDates();
            }
        }
    }
};
</script>

<style scoped></style>
