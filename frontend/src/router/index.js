import Vue from 'vue'
import Router from 'vue-router'
import Accounts from '@/components/Accounts'
import AllAccounts from '@/components/AllAccounts'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Accounts',
      component: Accounts
    },

    {
      path: '/AllAccounts',
      name: 'AllAccounts',
      component: AllAccounts
    }
  ]
})
