<template>
    <div id="home">
        <NavigationBar />
        <div class="container">
            <GridLayout :items="getAllNotificationsOutput.notificationList">
                <template v-slot="{ item }">
                    <Card :useImage="true" :title="item.messageHeader" :imageSrc="item.photographyPath"
                        :lastUpdated="item.creationDate" :cardClass="custom - card">{{ item.messageBody }}</Card>
                </template>
            </GridLayout>
        </div>
    <Footer/>
    </div>
</template>

<script>

import NavigationBar from '@/components/NavigationBar.vue';
import GridLayout from '@/components/GridLayout.vue';
import Card from '@/components/Card.vue';
import GetAllNotificationsOutput from '@/models/output/GetAllNotificationsOutput';
import GetAllNotificationsInput from '@/models/input/GetAllNotificationsInput';
import NotificationService from '@/services/NotificationService';
import Footer from '@/components/footer.vue';

export default {
    name: 'home',
    data() {
        return {
            getAllNotificationsInput: new GetAllNotificationsInput(),
            getAllNotificationsOutput: new GetAllNotificationsOutput()
        };
    },
    components: {
        NavigationBar,
        GridLayout,
        Card,
        Footer
    },
    methods: {
        async fetchNotificationInfo() {
            this.getAllNotificationsOutput = await NotificationService.getAllNotifications(this.getAllNotificationsInput);
        }
    },
    async mounted() {
        await this.fetchNotificationInfo()
    }
}

</script>

<style></style>