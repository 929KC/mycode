<template>
  <div>
    <h1>工人姓名:{{name}}</h1>
    <h1>工人年龄:{{age}}</h1>
    <h1>工人住址:{{address}}</h1>
    <button @click="show">显示信息</button>
  </div>
</template>

<script>
import {maxin} from "../mixin"
export default {
    name:"Worker",
    data() {
      return {
        name:"黄茂云",
        age:19,
        address:"郴州"
      }
    },
    mixins:[maxin]
}
</script>

