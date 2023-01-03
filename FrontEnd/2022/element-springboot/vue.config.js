const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false ,
   outputDir:'dist',
   assetsDir:'static'

})
