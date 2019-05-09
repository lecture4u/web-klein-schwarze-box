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
      redirect: '/security'
    },
    {
      path: '/security',
      component: () => import(`${views}/security.vue`)
    },
    {
      path: '/hashing',
      component: () => import(`${views}/hashing.vue`)
    },
    {
      path: '/about',
      component: () => import(`${views}/about.vue`)
    },
    {
      path: '/404',
      component: () => import(`${views}/ready-temp.vue`)
    },
    {
      //otherwise, goto 404
      path: '*',
      redirect: '/404'
    }
  ]
})
