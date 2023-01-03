//引入VueRouter
import VueRouter from 'vue-router'
// import ButtonEl from "@/components/ButtonEl";
import MyIndex from "@/components/MyIndex";
import MyList from "@/components/users/MyList";
//创建router实例对象，去管理一组一组的路由规则
const router = new VueRouter({
    routes: [
        // {
        //     path: '/button',
        //     component: ButtonEl
        // },
        {
            path: "/MyIndex",
            component: MyIndex
        }, {//设置默认访问主页
            path: "/",
            redirect: "/MyIndex"
        },{
        path:"/MyUsers",
            component:MyList
        }

    ]
})
//暴露router
export default router