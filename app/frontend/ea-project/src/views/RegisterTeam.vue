<template>
    <div>
        <NavigationBar />
        <div class="register-team container my-5">
            <h1 class="display-4 mb-4">Register Team for {{ competition.name }}</h1>
            <form @submit.prevent="submitForm">
                <div class="mb-3">
                    {{ this.clubs }}
                    <label for="club" class="form-label">Club</label>
                    <select class="form-control" id="club" v-model="selectedClub" @change="fetchClubData">
                        <option v-for="club in this.clubs" :key="club.id" :value="club.id">{{ club.name }}</option>
                    </select>
                </div>
                <div v-if="selectedClub">
                    <div class="mb-3">
                        <label for="teamName" class="form-label">Team Name</label>
                        <input type="text" class="form-control" id="teamName" v-model="team.name" required>
                    </div>
                    <div class="mb-3">
                        <label for="teamMembers" class="form-label">Team Members</label>
                        <generic-grid :data="team.members" :headers="['Name', 'Role']" :editable="false" :deletable="true"
                            grid-title="Selected Members" @delete="deleteMember" />
                    </div>
                    <div class="mb-3">
                        <label for="addMember" class="form-label">Add Member</label>
                        <select class="form-control" id="addMember" v-model="selectedMember">
                            <option v-for="member in availableMembers" :key="member.id" :value="member">{{ member.name }}
                            </option>
                        </select>
                        <button type="button" class="btn btn-primary mt-2" @click="addMember">Add Member</button>
                    </div>
                    <div class="mb-3">
                        <label for="coach" class="form-label">Coach</label>
                        <v-select v-model="team.coach" :options="availableCoaches" label="name"
                            placeholder="Select a coach"></v-select>
                    </div>
                </div>
                <div v-else>
                    <p>Please select a club to see available members and coaches.</p>
                </div>
                <button type="submit" class="btn btn-success" :disabled="!selectedClub">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>
import CompetitionService from '@/services/CompetitionService';
import GenericGrid from '@/components/Grid.vue'; // Assuming this is the correct path to your generic-grid component
import router from '@/router';
import ClubService from '@/services/ClubService';
import GetCompetitionByIdInput from '@/models/input/GetCompetitionByIdInput';
import GetCompetitionByIdOutput from '@/models/output/GetCompetitionByIdOutput';
import NavigationBar from '@/components/NavigationBar.vue';
import GetAllClubsInput from '@/models/input/GetAllClubsInput';
import UserService from '@/services/UserService';
import GetAllUsersInput from '@/models/input/GetAllUsersInput';
import GetAllUsersOutput from '@/models/output/GetAllUsersOutput';

export default {
    name: 'RegisterTeam',
    props: ['competitionId'],
    components: {
        GenericGrid,
        NavigationBar
    },
    data() {
        return {
            competition: new GetCompetitionByIdOutput(),
            clubs: [],
            selectedClub: null,
            users: new GetAllUsersOutput().usersList,
            availableMembers: [],
            availableCoaches: [],
            selectedMember: null,
            team: {
                name: '',
                members: [],
                coach: '',
                contactEmail: ''
            },
            categories: [
                { name: 'Minimum', sub: '', minAge: 5, maxAge: 8 },
                { name: 'Minor', sub: '', minAge: 9, maxAge: 10 },
                { name: 'Initiate', sub: 'A', minAge: 11, maxAge: 11 },
                { name: 'Initiate', sub: 'B', minAge: 12, maxAge: 12 },
                { name: 'Infant', sub: 'A', minAge: 13, maxAge: 13 },
                { name: 'Infant', sub: 'B', minAge: 14, maxAge: 14 },
                { name: 'Cadet', sub: '', minAge: 15, maxAge: 16 },
                { name: 'Sub16', sub: '', minAge: 12, maxAge: 16 },
                { name: 'Junior', sub: '', minAge: 17, maxAge: 18 },
                { name: 'Senior', sub: '', minAge: 19, maxAge: 19 },
                { name: 'Sub23', sub: '', minAge: 19, maxAge: 23 },
                { name: 'Master', sub: 'A', minAge: 35, maxAge: 44 },
                { name: 'Master', sub: 'B', minAge: 45, maxAge: 54 },
                { name: 'Master', sub: 'C', minAge: 55, maxAge: 64 },
                { name: 'Master', sub: 'D', minAge: 65, maxAge: Infinity }
            ]
        };
    },
    async created() {
        this.competition = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(this.$route.params.id));
        this.clubs = await (await ClubService.getAllClubs(new GetAllClubsInput())).clubList;
        this.users = await (await UserService.getAllUsers(new GetAllUsersInput())).usersList;
        console.log(this.users);
        console.log(this.clubs);
    },
    methods: {
        async fetchClubData() {
            console.log(this.competition.grade);
            if (this.selectedClub) {
                this.availableMembers = this.users.filter(user =>  this.competition.gender === user.gender && this.mapAgeToCategory(user.age) === this.competition.grade);
                this.availableCoaches = this.users.filter(user => user.clubid === this.selectedClub && user.role === 'Coach');
            }
        },
        mapAgeToCategory(age) {
            const category = this.categories.find(cat => age >= cat.minAge && age <= cat.maxAge);
            return category ? `${category.name}${category.sub ? ` ${category.sub}` : ''}` : 'Invalid age';
        },
        addMember() {
            if (this.selectedMember && !this.team.members.includes(this.selectedMember)) {
                this.team.members.push(this.selectedMember);
                this.selectedMember = null;
            }
        },
        deleteMember(member) {
            this.team.members = this.team.members.filter(m => m.id !== member.id);
        },
        async submitForm() {
            const registerTeamInput = {
                competitionId: this.competitionId,
                name: this.team.name,
                members: this.team.members.map(member => member.id),
                coach: this.team.coach.id,
                contactEmail: this.team.contactEmail
            };

            await CompetitionService.registerTeam(registerTeamInput);
            alert('Team registered successfully!');
            router.push({ name: 'competition-details', params: { id: this.competitionId } });
        }
    }
};
</script>

<style scoped>
.register-team h1 {
    color: #343a40;
    font-weight: bold;
}

.form-label {
    font-weight: bold;
    color: #343a40;
}

.form-text {
    color: #6c757d;
}

.btn-success {
    background-color: #28a745;
    border: none;
}

.v-select {
    margin-bottom: 1rem;
}
</style>
