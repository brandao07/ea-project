<template>
    <div>
        <NavigationBar />
        <div class="register-team container my-5">
            <h1 class="display-4 mb-4">Register Team for {{ competition.name }} {{ competition.type }}</h1>
            <form @submit.prevent="submitForm">
                <div class="mb-3">
                    <label for="club" class="form-label">Club</label>
                    <select class="form-control" id="club" v-model="selectedClub" @change="fetchClubData">
                        <option v-for="club in clubs" :key="club.id" :value="club.id">{{ club.name }}</option>
                    </select>
                </div>
                <div v-if="selectedClub">
                    <div class="mb-3">
                        <label for="teamName" class="form-label">Team Name</label>
                        <input type="text" class="form-control" id="teamName" v-model="team.name" required>
                    </div>
                    <div class="mb-3">
                        <label for="teamMembers" class="form-label">Team Members</label>
                        <generic-grid :data="this.team.members" :headers="['name', 'email']" :editable="false"
                            :deletable="true" grid-title="Selected Members" @delete="deleteMember" />
                    </div>
                    <div class="mb-3" v-if="validateCategories_teste()">
                        <label for="addMember" class="form-label">Add Member</label>
                        <select class="form-control" id="addMember" v-model="selectedMember">
                            <option v-for="member in availableMembers" :key="member.id" :value="member">
                                {{ member.name }}, {{ member.email }}
                            </option>
                        </select>
                        <button type="button" class="btn btn-primary mt-2" @click="addMember">Add Member</button>
                    </div>
                    <div class="mb-3">
                        <label for="coach" class="form-label">Coach</label>
                        <select class="form-control" id="coach" v-model="team.coach">
                            <option v-for="member in availableCoaches" :key="member.id" :value="member">
                                {{ member.name }}, {{ member.email }}
                            </option>
                        </select>
                    </div>
                </div>
                <div v-else>
                    <p>Please select a club to see available members and coaches.</p>
                </div>
                <button type="submit" class="btn btn-success" :disabled="!selectedClub">Submit</button>
                <button type="button" class="btn btn-danger" @click="cancel">Cancel</button>
            </form>
        </div>
        <Footer/>
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
import TeamService from '@/services/TeamService';

export default {
    name: 'RegisterTeam',
    props: [],
    components: {
        GenericGrid,
        NavigationBar,
    },
    data() {
        return {
            competition: new GetCompetitionByIdOutput(),
            clubs: [],
            selectedClub: null,
            users: [],
            availableMembers: [],
            availableCoaches: [],
            selectedMember: null,
            team: {
                name: '',
                members: [],
                coach: null,
                clubid: null,

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
            ],
        };
    },
    async created() {
        const competitionData = await CompetitionService.getCompetitionById(new GetCompetitionByIdInput(this.$route.params.id));
        this.competition = competitionData;
        const clubsData = await ClubService.getAllClubs(new GetAllClubsInput());
        this.clubs = clubsData.clubList;
        const usersData = await UserService.getAllUsers(new GetAllUsersInput());
        this.users = usersData.usersList;
    },
    methods: {
        fetchClubData() {
            if (this.selectedClub) {
                this.team.clubid = this.selectedClub;
                this.availableMembers = this.users.filter(user => 
                    user.clubid === this.selectedClub && 
                    this.competition.gender === user.gender && 
                    this.mapAgeToCategory(user.age) === this.competition.grade
                );
                this.fetchCoaches();
            }
        },
        fetchCoaches() {
            this.availableCoaches = this.users.filter(user => 
                user.clubid === this.selectedClub && 
                !this.team.members.includes(user)
            );
            this.availableMembers = this.availableMembers.filter(member => !this.team.members.includes(member));
        },
        mapAgeToCategory(age) {
            const category = this.categories.find(cat => age >= cat.minAge && age <= cat.maxAge);
            return category ? `${category.name}${category.sub ? ` ${category.sub}` : ''}` : 'Invalid age';
        },
        addMember() {
            if (this.selectedMember && !this.team.members.includes(this.selectedMember)) {
               if (this.validateCategories_teste()) {
                this.team.members.push(this.selectedMember);
                this.selectedMember = null;
                this.fetchCoaches();
               }
               else {
                    alert('You can\'t add more members to this category');
               }
            }
        },
        deleteMember(member) {
            this.team.members = this.team.members.filter(m => m.id !== member.id);
        },
        validateCategories() {
            const category = parseInt(this.competition.type[1]);
            const memberCount = this.team.members.length;
            return memberCount ===  category;
        },
        validateCategories_teste() {
            const category = parseInt(this.competition.type[1]);
            const memberCount = this.team.members.length;
            return memberCount +1<= category;
        },
        async submitForm() {
            if (!this.validateCategories()) {
                alert(`Please ensure the number of members for the ${this.competition.categoria} category is correct.`);
                return;
            }

            const registerTeamInput = {
                competitionId: this.competitionId,
                name: this.team.name,
                members: this.team.members.map(member => member.id),
                coach: this.team.coach.id,
                clubid: this.team.clubid,
            };

            await TeamService.createTeamEntity(registerTeamInput);
            alert('Team registered successfully!');
            router.push({ name: 'competition-detail', params: { id: this.competition.id } });
        },
        cancel() {
            // Redireciona o usuário para outra página ou limpa o formulário
            if (confirm('Are you sure you want to cancel?')) {
            router.push({ name: 'competition-detail', params: { id: this.competition.id } });
            }
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
