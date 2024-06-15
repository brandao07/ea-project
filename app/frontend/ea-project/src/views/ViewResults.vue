<template>
    <div class="view-results">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllResultsOutput.resultList" :headers="gridheaders" :editable="false" grid-title="View Results"/>
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllResultsInput from '@/models/input/GetAllResultsInput';
import GetAllResultsOutput from '@/models/output/GetAllResultsOutput';
import ResultService from '@/services/ResultService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "view-results",
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getAllResultsInput: new GetAllResultsInput(),
            getAllResultsOutput: new GetAllResultsOutput(),
            gridheaders: ['name', 'position', 'time']
        };
    },
    methods: {
        async fetchResultInfo() {
            this.getAllResultsOutput = await ResultService.getAllResults(this.getAllResultsInput);
        }
    },
    async mounted() {
        await this.fetchResultInfo()
    }
};
</script>