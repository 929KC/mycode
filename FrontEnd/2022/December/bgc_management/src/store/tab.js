export default {
    state: {
        collapse: false,
        tabList: [{
            path: "/",
            name: "home",
            label: "首页",
            icon: "s-home",
            url: "Home/Home",
        }, ],
    },
    mutations: {
        collapseMenu(state) {
            state.collapse = !state.collapse;
        },
        selectMenu(state, val) {
            if (val.name !== 'home') {
                const index = state.tabList.findIndex(item => item.name === val.name);
                if (index === -1) {
                    state.tabList.push(val);
                }
            }
        },
        closeTag(state, item) {
            console.log(state)
            console.log(item + "hello");
            console.log(item);
            const index = state.tabList.findIndex(val => val.name === item.name);
            state.tabList.splice(index, 1);
        }
    },
};