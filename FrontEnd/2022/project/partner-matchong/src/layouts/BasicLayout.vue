<template>
  <van-nav-bar
  title="标题"
  left-text="返回"
  right-text="按钮"
  left-arrow
  @click-left="onClickLeft"
  @click-right="onClickRight"
/>
<div id="content">
  <template v-if="active==='index'">
    <index/>
  </template>
  <template v-if="active==='team'">
    <team/>
  </template>
</div>
  <van-tabbar v-model="active" @change="onChange">
  <van-tabbar-item icon="home-o" name="index">主页</van-tabbar-item>
  <van-tabbar-item icon="search" name="team">队伍</van-tabbar-item>
  <van-tabbar-item icon="friends-o" name="user">个人</van-tabbar-item>
</van-tabbar>
</template>
<script setup>
import {ref} from "vue";
import {Toast} from "vant";
import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";

const onClickLeft = () => alert("左");
const onClickRight = () => alert("右");

const active = ref("index");
const onChange = (index) => Toast(`标签 ${index}`);
</script>
<style scoped>
</style>