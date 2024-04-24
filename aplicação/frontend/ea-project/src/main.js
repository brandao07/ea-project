import { createApp } from 'vue'
import App from './App.vue'

/* import bootstrap component */
import 'bootstrap/dist/css/bootstrap.css';

/* import font awesome component */
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { far } from '@fortawesome/free-regular-svg-icons'; // Import regular icons
import { fas } from '@fortawesome/free-solid-svg-icons'; // Import solid icons

// Add both solid and regular icons to the library
library.add(fas, far); 

createApp(App)
  .component('font-awesome-icon', FontAwesomeIcon)
  .mount('#app');

