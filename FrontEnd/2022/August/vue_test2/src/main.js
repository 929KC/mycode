/**
 * 该文件是整个项目的入口文件
 */
//引入vue
import Vue from 'vue'
//引入App组件,它是所有组件的父组件
//App的父组件是VM
import App from './App.vue'
//关闭生成提示
Vue.config.productionTip = false

new Vue({
        render: h => h(App),
    }).$mount('#app') //将