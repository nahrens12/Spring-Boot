import Vue from 'vue'
import Router from 'vue-router'
import Accounts from '@/components/Accounts'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Accounts',
      component: Accounts
    }
  ]
})
