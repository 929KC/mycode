/*
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-03-11 13:37:23
 */
import Vue from 'vue'
import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en' // lang i18n

import '@/styles/index.scss' // global css
import './assets/font/iconfont.css'

import App from './App'
import store from './store'
import router from './router'
import request from '@/utils/request'

import './assets/font2/iconfont.css'
import '@/icons' // icon
import '@/permission' // permission control
import '@/utils/initialize'
import '@/assets/custom.css'

import axios from 'axios'
import VueAxios from 'vue-axios'

axios.defaults.withCredentials = true;

Vue.use(VueAxios, axios);

// set ElementUI lang to EN
Vue.use(ElementUI, { locale })

Vue.prototype.req = request

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
