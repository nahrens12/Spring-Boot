<template>
  <div class="accounts">
     <h2>Create Account</h2>
    <ul>
      <li>
    <input type="text" v-model="Accounts.firstName" placeholder="first name">
    <input type="text" v-model="Accounts.lastName" placeholder="last name">
    <input type="text" v-model="Accounts.accountNumber" placeholder="account number">
    <button @click="createAccounts()">Create Accounts</button>
    </li>
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
      Accounts: {firstName: '', lastName: '', accountNumber: ''}
    }
  },
  methods: {
    createAccounts () {
      axios.post('http://localhost:8081/Accounts/', {
        firstName: this.Accounts.firstName,
        lastName: this.Accounts.lastName,
        accountNumber: this.Accounts.accountNumber
      })
    },
    retrieveAccounts () {
      axios.get(`http://localhost:8080/Accounts/`)
        .then(response => {
        // JSON responses are automatically parsed.
          this.retrieveAccounts = response.data
          console.log(response.data)
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
