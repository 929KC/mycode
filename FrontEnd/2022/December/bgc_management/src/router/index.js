import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import User from "../views/User.vue";
import Main from "../views/Main.vue";
import Mall from "../views/Mall.vue";
import PageOne from "../views/pageOne.vue";
import PageTwo from "../views/pageTwo.vue";
Vue.use(VueRouter);
const routes = [{
    path: "/",
    component: Main,
    redirect: "/home",
    children: [{
            path: "/home",
            name: "home",
            component: Home
        },
        {
            path: "/user",
            name: "user",
            component: User
        },
        {
            path: "/mall",
            component: Mall,
            name: 'mall'
        },
        {
            path: "/page1",
            component: PageOne,
            name: "page1"
        },
        {
            path: "/page2",
            component: PageTwo,
            name: "page2"
        }
    ],
}, ];
const router = new VueRouter({
    routes,
});
export default router;