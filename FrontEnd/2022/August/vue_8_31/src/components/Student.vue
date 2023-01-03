<template>
  <div>
    <h1>{{mes}}</h1>
    <h1>姓名:{{name}}</h1>
    <h1>性别:{{sex}}</h1>
    <h1>年龄:{{myAge}}</h1>
    <button @click="updateAge">年龄加+</button>
  </div>
</template>

<script>
export default {
    name:"Student",
    data() {
      return {
        mes:"我是B站大学学生",
        myAge:this.age
      }
    },
   // props:["name","age","sex"]
   props:{
      name:{
        required:true,
        type:String
      },
      age:{
        type:Number,
        default:19
      },
      sex:{
        required:true,
        type:String
      }
   },
   methods:{
    updateAge(){
      this.myAge++
    }
   }
}
</script>

