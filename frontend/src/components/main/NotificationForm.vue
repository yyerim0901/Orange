<template>
  <div class="text-center">
    <v-menu offset-y open-on-hover>
      <template v-slot:activator="{ on, attrs }">
        <v-btn 
          icon
          v-bind="attrs"
          v-on="on"
        >
          <v-icon>mdi-bell-ring-outline</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
import axios from 'axios'
  export default {
    name: 'NotificationForm',
    data: () => ({
      items: [
      ],
    }),
    created() {
      const userId = this.$store.state.data2
      axios.get(`http://i5b102.p.ssafy.io:8181/api/notification/select/${userId}`)
        .then(res => {
        console.log(res.data)
        this.items = res.data
      })
      .catch(err=> {
        console.error(err)
      })
    },
  }
</script>