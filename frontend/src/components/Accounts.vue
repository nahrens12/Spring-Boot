<template>
  <div class="accounts">
    <h1>{{ msg }}</h1>
    <h2> <a href="">Get Accounts</a></h2>
    <h2>Create Account</h2>
    <input type="text" v-model="accounts.firstName" placeholder="first name">
    <input type="text" v-model="accounts.lastName" placeholder="last name">
    <input type="text" v-model="accounts.accountNumber" placeholder="account number">
    <button @click="createAccounts()">Create Accounts</button>

    <div v-if="showResponse"><h6>User created with Id: {{ response }}</h6></div>

    <button v-if="showResponse" @click="retrieveAccounts()">Retrieve accounts {{Accounts.id}} data from database</button>

    <h4 v-if="showRetrieveAccounts">Retrieved Accounts {{retrieveAccounts.firstName}} {{retrieveAccounts.lastName}} {{retrieveAccounts.accountNumber}}</h4>
    <ul>
      <li>
        <a
          href="https://vuejs.org"
          target="_blank"
        >
          Core Docs
        </a>
      </li>
      <li>
        <a
          href="https://forum.vuejs.org"
          target="_blank"
        >
          Forum
        </a>
      </li>
      <li>
        <a
          href="https://chat.vuejs.org"
          target="_blank"
        >
          Community Chat
        </a>
      </li>
      <li>
        <a
          href="https://twitter.com/vuejs"
          target="_blank"
        >
          Twitter
        </a>
      </li>
      <br>
      <li>
        <a
          href="http://vuejs-templates.github.io/webpack/"
          target="_blank"
        >
          Docs for This Template
        </a>
      </li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li>
        <a
          href="http://router.vuejs.org/"
          target="_blank"
        >
          vue-router
        </a>
      </li>
      <li>
        <a
          href="http://vuex.vuejs.org/"
          target="_blank"
        >
          vuex
        </a>
      </li>
      <li>
        <a
          href="http://vue-loader.vuejs.org/"
          target="_blank"
        >
          vue-loader
        </a>
      </li>
      <li>
        <a
          href="https://github.com/vuejs/awesome-vue"
          target="_blank"
        >
          awesome-vue
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Accounts',
  data () {
    return {
      response: [],
      accounts: {
        firstName: '',
        lastName: '',
        accountNumber: '',
        id: 0,
        msg: 'Account Management System'
      }
    }
  },
  methods: { createAccounts () {
    var params = new URLSearchParams()
    params.append('firstName', this.accounts.firstName)
    params.append('lastName', this.accounts.lastName)
    params.append('accountNumber', this.accounts.accountNumber)
    axios.post(`/Accounts`, params)
      .then(response => {
        // JSON responses are automatically parsed.
        this.response = response.data
        this.accounts.id = response.data
        console.log(response.data)
        this.showResponse = true
      })
      .catch(e => {
        this.errors.push(e)
      })
  },
  retrieveAccounts () {
    axios.get(`/Accounts/` + this.accounts.id)
      .then(response => {
        // JSON responses are automatically parsed.
        this.retrieveAccounts = response.data
        console.log(response.data)
        this.showRetrieveAccounts = true
      })
      .catch(e => {
        this.errors.push(e)
      })
  }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
