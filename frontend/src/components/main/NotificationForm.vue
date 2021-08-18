<template>
  <div class="text-center">
    <v-menu offset-y open-on-hover max-height="200" max-width="400">
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
        <v-list-item-title class="mx-3 mt-3">
          <div class="d-flex">
            <v-icon>mdi-email-open-outline</v-icon>
            <v-flex class="mx-3">알림</v-flex>
          </div>
        </v-list-item-title>
        <v-divider></v-divider>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
        >
          <v-list-item-content>{{ item.notificationContent }}</v-list-item-content>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'NotificationForm',
  data() {
    return {
      items: []
    }
  },
  methods: {
    async notificationItem() {
      try {
        const userId = this.$store.state.data2
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/notification/select/${userId}`)
        // console.log(data)
        this.items = data
      } catch (err) {
        console.log(err)
      }
    }
  },
  created() {
    this.notificationItem()
  }
}
</script>