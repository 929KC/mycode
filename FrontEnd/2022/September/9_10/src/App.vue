<template>
  <div>
    <a href="#/buttonel">点我显示按钮</a>
    <router-view></router-view>
  </div>
</template>

<script>
import ButtonEl from "./components/ButtonEl.vue";
export default {
  name: "App",
  components: { ButtonEl },
};
</script>

<style>
</style>