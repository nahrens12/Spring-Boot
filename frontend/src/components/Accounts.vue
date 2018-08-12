<template>
  <div class="accounts">
    <h1>{{ msg }}</h1>
    <h2>Create Account</h2>
    <ul>
      <li>
    <input type="text" v-model="Accounts.firstName" placeholder="first name">
    <input type="text" v-model="Accounts.lastName" placeholder="last name">
    <input type="text" v-model="Accounts.accountNumber" placeholder="account number">
    <button @click="createAccounts()">Create Accounts</button>
    </li>
    <div v-if="showResponse"><h6>Accounts created with Id: {{ response }}</h6></div>

    <button v-if="showResponse" @click="retrieveAccounts()">Retrieve Accounts {{Accounts.id}} data from database</button>

      <h4 v-if="showRetrieveAccounts">Retrieved Accounts {{retrieveAccounts.firstName}} {{retrieveAccounts.lastName}} {{retrieveAccounts.accountNumber}}</h4>
    </ul>
      <ul>
      <br>
      <li>
        <a
          href="http://vuejs-templates.github.io/webpack/"
          target="_blank"
        >
          Having Fun
        </a>
      </li>
    </ul>
    <h2>HAHAHA</h2>
    <ul>
      <li>
        <a
          href="http://router.vuejs.org/"
          target="_blank"
        >
          It's been a long
        </a>
      </li>
      <li>
        <a
          href="http://vuex.vuejs.org/"
          target="_blank"
        >
          day in the office
        </a>
      </li>
      <li>
        <a
          href="http://vue-loader.vuejs.org/"
          target="_blank"
        >
          doing frontend
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
      Accounts: {
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
    params.append('firstName', this.Accounts.firstName)
    params.append('lastName', this.Accounts.lastName)
    params.append('accountNumber', this.Accounts.accountNumber)
    axios.post(`/Accounts/`, params)
      .then(response => {
        // JSON responses are automatically parsed.
        this.response = response.data
        this.Accounts.id = response.data
        console.log(response.data)
        this.showResponse = true
      })
      .catch(e => {
        this.errors.push(e)
      })
  },
  retrieveAccounts () {
    axios.get(`/Accounts/` + this.Accounts.id)
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
