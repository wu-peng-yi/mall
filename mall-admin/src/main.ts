import {createApp} from 'vue'
import App from './App.vue'

import router from "./router";
import store from './store'

import ElementPlus from 'element-plus'

createApp(App).use(router)
    .use(ElementPlus)
    .use(store)
    .mount('#app')
