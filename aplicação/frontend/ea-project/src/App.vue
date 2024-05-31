<template>
  <v-app id="app">
    <FeedbackMessage />
    <router-view></router-view>
  </v-app>
</template>

<script>
import FeedbackMessage from './components/FeedbackMessage.vue';

export default {
  name: 'app',
  components: {
    FeedbackMessage,
  }
}
</script>
