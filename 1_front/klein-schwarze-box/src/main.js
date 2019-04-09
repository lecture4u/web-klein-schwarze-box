import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import moment from 'moment'

Vue.config.productionTip = false

Vue.prototype.moment = moment
Vue.prototype.getDateFormat = dateString => {
  const date = new Date(dateString)
  return moment(date).format('YYYY. MM. DD HH:mm')
}
Vue.prototype.contentPreview = (text, limit) => text.length > limit ? text.substring(0, limit) + '...' : text

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
