const webpack = require('webpack')
const path = require('path')

module.exports = {
    // indexPath: "../../2_backend/histree/src/main/resources/templates/index.html",
    outputDir: '../../2_backend/histree/src/main/resources/static',
    devServer: {
      proxy: { // proxyTable 설정
        '/api': {
          target: 'http://localhost:3000/api',
          changeOrigin: true,
          pathRewrite: {
            '^/api': ''
          }
        }
      },
      port: 8080
    }
  }