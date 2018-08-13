<template>
  <div class="accounts">
    <h1>Accounts</h1>
    <table id="firstTable">
      <thead>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Account Number</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="row in rows">
        <td>{{row.id}}</td>
        <td>{{row.firstName}}</td>
        <td>{{row.lastName}}</td>
        <td>{{row.accountNumber}}</td>
        <input type="button" id="edit_button2" value="Edit" class="edit" onclick="edit_row()">
        <input type="button" id="delete_button2" value="Delete" class="delete" onclick="delete_row()">
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'AllAccounts',
  data () {
    return {
      rows: []
    }
  },
  mounted () {
    this.fetchData()
  },

  methods: {
    fetchData () {
      axios.get('http://localhost:8080/Accounts/')
        .then(response => {
          this.rows = response.data
          console.log(response.data)
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  .accounts{
    width:100%;
  }
  table {
    font-family: 'Open Sans', sans-serif;
    width: 750px;
    border-collapse: collapse;
    border: 3px solid #44475C;
    margin: 10px 10px 0 10px;
  }

  table th {
    text-transform: uppercase;
    text-align: left;
    background: #44475C;
    color: #FFF;
    padding: 8px;
    min-width: 30px;
  }

  table td {
    text-align: left;
    padding: 8px;
    border-right: 2px solid #7D82A8;
  }
  table td:last-child {
    border-right: none;
  }
  table tbody tr:nth-child(2n) td {
    background: #D4D8F9;
  }
</style>
