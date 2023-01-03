import Vuex from 'vuex';
import Vue from 'vue';
import tab from './tab';
Vue.use(Vuex);
export default new Vuex.Store({
    modules: { tab }
})