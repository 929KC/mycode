//引入Vuex
import Vue from "vue"
import Vuex from "vuex"
Vue.use(Vuex)

const personOptions = {
    // namespaced: true,
    namespaced: true,
    actions: {

    },
    mutations: {

    },
    state: {
        personList: [{ id: "001", name: "叶秋涵" }]
    },
    getters: {

    }
}

const countOptions = {
        //    namespaced: true,
        namespaced: true,
        actions: {
            addOdd(context, value) {
                if (context.state.sum % 2) {
                    context.commit("ADD", value)
                }
            },
            addWait(context, value) {
                setTimeout(() => {
                    context.commit("ADD", value)
                }, 500)
            }
        },
        mutations: {
            ADD(state, value) {
                state.sum += value
            },
            SUB(state, value) {
                state.sum -= value
            },
            ADD_PERSON(state, value) {
                state.personList.unshift(value)
            }
        },
        state: {
            sum: 0,
            school: "B站大学",
            subject: "JavaEE",
        },
        getters: {
            bigSum(state) {
                return state.sum * 10
            }
        }
    }
    //准备actions----用于组件响应中的动作
    // const actions = {
    //         // add(context, value) {
    //         //     context.commit("ADD", value)
    //         // },
    //         // sub(context, value) {
    //         //     context.commit("SUB", value)
    //         // },
    //     }
    //     //准备mutations---用于操作数据
    // const mutations = {}
    //     //准备state----用于储存数据
    // const state = {

// }
// const getters = {}
export default new Vuex.Store({
    // actions: actions,
    // mutations: mutations,
    // state: state,
    // getters: getters,
    methods: {
        countAbout: countOptions,
        personAbout: personOptions
    }
})