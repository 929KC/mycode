//引入VueRouter
import VueRouter from 'vue-router'
import ButtonEl from "@/components/ButtonEl";
//创建router实例对象，去管理一组一组的路由规则
const router = new VueRouter({
        routes: [{
            path: '/buttonel',
            component: ButtonEl
        }, ]
    })
    //暴露router
export default router