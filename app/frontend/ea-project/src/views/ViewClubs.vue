<template>
    <div class="view-clubs">
        <NavigationBar />
        <div class="container">
            <generic-grid :data="getAllClubsOutput.clubList" :headers="gridheaders" :editable="false" grid-title="View Clubs"/>
        </div>
    </div>
</template>

<script>
import GenericGrid from '@/components/Grid.vue';
import GetAllClubsInput from '@/models/input/GetAllClubsInput';
import GetAllClubsOutput from '@/models/output/GetAllClubsOutput';
import ClubService from '@/services/ClubService';
import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: "view-clubs",
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            getAllClubsInput: new GetAllClubsInput(),
            getAllClubsOutput: new GetAllClubsOutput(),
            gridheaders: ['name', 'isActive', 'creationDate']
        };
    },
    methods: {
        async fetchClubInfo() {
            this.getAllCLubsOutput = await ClubService.getAllClubs({});
        }
    },
    async mounted() {
        await this.fetchClubInfo()
    }
};
</script>