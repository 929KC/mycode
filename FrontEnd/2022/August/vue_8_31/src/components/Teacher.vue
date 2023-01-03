<template>
  <div>
    <h1>老师姓名:{{name}}</h1>
    <h1>老师年龄:{{age}}</h1>
    <h1>老师住址:{{address}}</h1>
    <button @click="show">显示信息</button>
  </div>
</template>

<script>
import {maxin} from "../mixin"
export default {
    name:"Worker",
    data() {
      return {
        name:"叶秋涵",
        age:19,
        address:"长沙"
      }
    },
    mixins:[maxin]
}
</script>

