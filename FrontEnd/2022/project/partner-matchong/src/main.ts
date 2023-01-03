import { createApp } from 'vue'
import App from './App.vue'
import { Button,NavBar,Tabbar,TabbarItem } from 'vant'
const app = createApp(App);
app.use(Button);
app.use(NavBar);
app.use(Tabbar);
app.use(TabbarItem);
app.mount('#app')
