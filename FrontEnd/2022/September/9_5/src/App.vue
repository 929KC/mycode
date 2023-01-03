<template>
  <div class="container">
    <Category title="美食">
      <img slot="center" src="1.jpg" alt="" />
      <a slot="footer" href="http://www.baidu.com">更多美食</a>
    </Category>
    <Category title="游戏">
      <ul slot="center">
        <li v-for="(g, index) in games" :key="index">{{ g }}</li>
      </ul>
      <div slot="footer" class="foot">
        <a href="http://www.baidu.com">单机游戏</a>
        <a href="http://www.baidu.com">网络游戏</a>
      </div>
    </Category>
    <Category title="电影">
      <template v-slot:footer>
        <img slot="center" src="2.jpeg" alt="" />
        <div class="foot">
          <a href="">热门电影</a>
          <a href="">经典电影</a>
          <a href="">推荐电影</a>
        </div>
      </template>
    </Category>
  </div>
</template>

<script>
import Category from "./components/Category.vue";
export default {
  name: "App",
  components: { Category },
  data() {
    return {
      foods: ["火锅", "青椒炒肉", "番茄炒鸡蛋", "牛排"],
      games: ["绝地求生", "LOL", "王者农药", "天天酷跑"],
      moves: ["霸王别姬", "寄生虫", "声之形", "天空之城"],
    };
  },
};
</script>

<style>
.container,
.foot {
  display: flex;
  justify-content: space-around;
}
img {
  width: 100%;
  height: 40%;
}
video {
  width: 100%;
}
</style>