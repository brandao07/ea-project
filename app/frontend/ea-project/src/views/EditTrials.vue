<template>
    <div class="edit-trials">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllTrialsOutput.trials" :headers="gridheaders" :editable="true" :deletable="false"
                grid-title="Edit Trials" @edit="openEditModal" />
        </div>

        <Modal :isVisible="modalVisible" @cancel="cancelEdit" @save="saveTrial" title="Edit Trials">
            <template v-slot>
                <form>
                    <div class="form-group mb-1">
                        <label for="name" class="mb-2">Name</label>
                        <input type="text" class="form-control" id="name" v-model="updateTrialInput.name" required>
                    </div>
                    <div class="form-group mb-1">
                        <label for="startDate" class="mb-2">Start Date</label>
                        <input type="datetime-local" class="form-control" id="startDate"
                            v-model="selectedItem.startDate" required />
                    </div>
                    <div class="form-group mb-1">
                        <label for="distance" class="mb-2">Distance</label>
                        <input type="decimal" step="0.01" class="form-control" id="distance"
                            v-model="updateTrialInput.distance" required>
                    </div>
                    <div class="form-group mb-1">
                        <label for="distanceUnit" class="mb-2">Distance Unit</label>
                        <select class="form-select" v-model="updateTrialInput.distanceUnit" id="distanceUnit" required>
                            <option v-for="(label, key) in unitsEnumerator" :key="key" :value="key">{{ label }}</option>
                        </select>
                    </div>
                </form>
            </template>
        </Modal>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllTrialsInput from '@/models/input/GetAllTrialsInput';
import GetAllTrialsOutput from '@/models/output/GetAllTrialsOutput';
import UpdateTrialInput from '@/models/input/UpdateTrialInput';
import UpdateTrialOutput from '@/models/output/UpdateTrialOutput';
import TrialService from '@/services/TrialService';
import NavigationBar from '@/components/NavigationBar.vue';
import Modal from '@/components/Modal.vue';
import UnitsEnumerator from '@/models/enums/Units';

export default {
    name: "edit-trials",
    components: {
        GenericGrid,
        NavigationBar,
        Modal
    },
    data() {
        return {
            getAllTrialsInput: new GetAllTrialsInput(),
            getAllTrialsOutput: new GetAllTrialsOutput(),
            updateTrialInput: new UpdateTrialInput(),
            updateTrialOutput: new UpdateTrialOutput(),
            gridheaders: ['name', 'startDate', 'distance', 'distanceUnit', 'creationDate'],
            modalVisible: false,
            selectedItem: {
                name: '',
                startDate: '',
            },
            unitsEnumerator: UnitsEnumerator
        };
    },
    methods: {
        async fetchTrialInfo() {
            this.getAllTrialsOutput = await TrialService.getAllTrials(this.getAllTrialsInput);
        },
        openEditModal(item) {
            this.selectedItem = {
                ...item,
                startDate: new Date(item.startDate).toISOString().slice(0, 16), // to match the datetime-local format
            };
            this.updateTrialInput = { ...item };
            this.modalVisible = true;
        },
        cancelEdit() {
            this.modalVisible = false;
            this.selectedItem = {
                name: '',
                startDate: '',
            };
        },
        async saveTrial() {
            this.updateTrialInput.startDate = new Date(this.selectedItem.startDate).toISOString();
            this.updateTrialOutput = await TrialService.updateTrialEntity(this.updateTrialInput);
            this.modalVisible = false;
            this.updateTrialInput = new UpdateTrialInput();
            await this.fetchTrialInfo(); // Refresh the trial list after save
        }
    },
    async mounted() {
        this.getAllTrialsOutput = new GetAllTrialsOutput();
        await this.fetchTrialInfo();
    }
};
</script>
