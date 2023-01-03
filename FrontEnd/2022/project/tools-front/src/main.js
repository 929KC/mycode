// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'normalize.css/normalize.css'
// import '@/styles/index.scss'
import Cookies from 'js-cookie'
import './icons'
Vue.config.productionTip = false

Vue.use(ElementUI, {
        size: Cookies.get('size') || 'medium'
    })
    /* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
})