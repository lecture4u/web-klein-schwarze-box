import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const views = './views'
// const tutorial = `${views}/tutorial`
// const dashboard = `${views}/dashboard`
// const consensus = `${views}/consensus`

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/about'
    },
    {
      path: '/about',
      component: () => import(`${views}/about.vue`)
    }
  ]
})
