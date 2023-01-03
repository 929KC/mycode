import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui';
import axios from "axios";

//导入路由
import router from "./router/index";
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(axios)

new Vue({
  render: h => h(App),
  //注册路由
  router:router
}).$mount('#app')
