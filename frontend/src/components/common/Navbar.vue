<template>
  <div>
    <b-navbar variant="navbar-light bg-light justify-content-between" type="light">
      <b-navbar-brand tag="h1">
        <v-btn 
          text
          color="orange"
          @click="goHome"
        >
        Orange</v-btn>
      </b-navbar-brand>
      <b-navbar-nav class="d-flex">
        <b-nav-item>
          <v-btn text> About </v-btn></b-nav-item>
        
        <b-nav-item><NotificationForm /></b-nav-item>
        
        <b-nav-item>
          <v-btn 
            icon
            @click="goProfile"
          >
            <v-icon>mdi-account</v-icon>
          </v-btn>
        </b-nav-item>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import NotificationForm from '@/components/main/NotificationForm.vue'

export default {
  name: 'Navbar',
  components: {
    NotificationForm,
  },
  methods: {
    goProfile() {
      this.$router.push({path:'/profile'}).catch(()=> {});
    },
    goHome() {
      this.$router.push({path:'/'}).catch(()=> {});
    },
  }
}
</script>

<style>

</style>