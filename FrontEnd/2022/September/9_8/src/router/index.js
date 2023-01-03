import VueRouter from "vue-router"
import Home from "../components/About.vue"
import About from "../components/Home.vue"
export default new VueRouter({
    routes: [{
            path: "/about",
            component: About
        },
        {
            path: "/Home",
            component: Home
        }
    ]
})