<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item index="/MyIndex">主页</el-menu-item>
          <el-menu-item index="/MyUsers">用户管理</el-menu-item>
          <el-menu-item index="/MyMsgs">消息管理</el-menu-item>
          <el-menu-item index="/MyOrders">订单管理</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
//import ButtonEl from "@/components/ButtonEl";
export default {
  name: 'App',
  components: {}, data() {
      return {
        activeIndex: this.$route.path,
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
        this.$router.push(key)
      }
    }
}
</script>

<style>
</style>
