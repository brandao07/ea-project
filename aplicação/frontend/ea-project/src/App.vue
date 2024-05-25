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

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

body {
  background-color: #f8f9fa !important;
}

.a {
  cursor: pointer !important;
}
</style>
