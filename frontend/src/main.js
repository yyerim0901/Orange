import Vue from "vue";
import App from "./App.vue";
import router from "@/router";
import vuetify from "./plugins/vuetify";
import store from '@/store/index'
import './plugins';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'

Vue.use(BootstrapVueIcons)
Vue.use(BootstrapVue)

// const apiKey = '1b50b6f16f3de7cfc77ffb4275f7291f'
// Vue.use(VueKakaoSdk, { apiKey })

window.Kakao.init('1b50b6f16f3de7cfc77ffb4275f7291f');

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
