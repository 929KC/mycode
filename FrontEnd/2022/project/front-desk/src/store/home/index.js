import { reqCategoryList } from "@/api"
//仓库存储数据的地方
const state = {
    category: [],
};
//唯一修改state的地方
const mutations = {
    CATEGORYLIST(state, categoryList) {
        state.category = categoryList
    }
};
//书写业务逻辑
const actions = {
    async getCategoryList({ commit }) {
        let result = await reqCategoryList();
        console.log(result);
        if (result.code == 200) {
            commit("CATEGORYLIST", result.data);
        }
    }
};
//给组件获取数据
const getters = {};
export default {
    state,
    mutations,
    actions,
    getters
};