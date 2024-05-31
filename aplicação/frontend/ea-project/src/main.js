import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";

/* import bootstrap component */
import 'bootstrap/dist/js/bootstrap';
import 'bootstrap/dist/css/bootstrap.css'

/* import font awesome component */
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { far } from "@fortawesome/free-regular-svg-icons"; // Import regular icons
import { fas } from "@fortawesome/free-solid-svg-icons"; // Import solid icons

/* import cascade style sheets */
import "./assets/global.css"; // Import global styles
import "./assets/common.css"; // Import common styles

// Add both solid and regular icons to the library
library.add(fas, far);

const app = createApp(App);

// Register Font Awesome icon component globally
app.component("font-awesome-icon", FontAwesomeIcon);

// Use the router instance
app.use(router);

// Mount the app to the #app element
app.mount("#app");
