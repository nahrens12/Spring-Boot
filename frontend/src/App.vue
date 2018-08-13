<template>
  <div id="app">
    <router-link :to="{name: 'Accounts' }">Create Accounts</router-link>
    <router-link to="/AllAccounts">Display Accounts</router-link>
    <!--<all-accounts></all-accounts>-->
    <router-view/>
  </div>
</template>

<script>
import allAccounts from './components/AllAccounts.vue'
export default {
  name: 'App',
  components: {
    'allAccounts': allAccounts
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
