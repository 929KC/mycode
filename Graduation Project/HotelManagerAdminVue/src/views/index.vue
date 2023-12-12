<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-03-11 13:37:23
-->
<template>
  <el-row>
    
    <el-col :span="24" class="text-center">
      
      <p class="title1">
        欢迎使用酒店管理系统
      </p>
    </el-col>
    <el-col :span="24" class="text-center" id="homeCol">
      <img :src="require('@/assets/home.jpg')" style="width: 80%;">
    </el-col>
  </el-row>
</template>

<script>
</script>

<style scoped="scoped">
  .title1, .title2 {
    font-weight: 600;

  }

  .title1 {
    font-size: 40px;
  }

  .title2 {
    font-size: 1.5rem;
  }

  #homeCol {
    background-size: cover;
    color: white;
  }
</style>
