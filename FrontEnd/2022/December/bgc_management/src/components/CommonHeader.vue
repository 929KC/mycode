<template>
    <div class="header-comtainer">
        <div class="l-content">
            <el-button icon="el-icon-menu" size="minin" @click="handMenu()" style="margin-right:20px"></el-button>
            <el-breadcrumb separator="/">
                <el-breadcrumb-item v-for="item in tags" :key="item.path" :to="{ path: item.path }">{{ item.label }}</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="r-content">
            <el-dropdown>
                <span class="el-dropdown-link">
                    <img src="../assets/images/m39pp9.jpg" alt="" class="user">
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>个人中心</el-dropdown-item>
                    <el-dropdown-item>退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: "CommonHeader",
    methods: {
        handMenu() {
            this.$store.commit('collapseMenu');
        }
    },
    computed:{
        ...mapState({
            tags:state=>state.tab.tabList
        })
    }
}
</script>

<style lang="less">
.header-comtainer {
    background-color: #333;
    height: 60px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;

    .text {
        color: #fff;
        font-size: 14px;
        margin-left: 10px;
    }

    .r-content {
        .user {
            widows: 40px;
            height: 40px;
            border-radius: 50%;
        }
    }
    .l-content {
        display: flex;
        align-items: center;
        /deep/.el-breadcrumb__item {
            .el-breadcrumb__inner{
                font-weight: normal;
                &.is-link{
                    color: #fff;
                }
            }
            &:last-child{
                .el-breadcrumb__inner{
                    color:#fff;
                }
            }
        }
    }
}

.el-header {
    padding: 0;
}

.el-menu {
    border-right: none;
}
</style>