import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)
export const constantRouterMap = [{
    path: '/login',
    component: () =>
        import ('@/views/login/login')
}]
export default new Router({
    // routes: [{
    //     path: '/',
    //     name: 'HelloWorld',
    //     component: HelloWorld
    // }]
    routes: constantRouterMap
})