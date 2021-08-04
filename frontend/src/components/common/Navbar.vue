<template>
  <div>
    <b-navbar variant="navbar-light bg-light justify-content-between px-5" type="light">
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
          <v-tooltip bottom>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                icon
                v-bind="attrs"
                v-on="on"
              >
                <v-icon dark>
                  mdi-trophy
                </v-icon>
              </v-btn>
            </template>
            <span>챌린지 생성</span>
          </v-tooltip>
        </b-nav-item>
        
        <b-nav-item><NotificationForm /></b-nav-item>
        
        <b-nav-item>
          <v-tooltip bottom>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                icon
                v-bind="attrs"
                v-on="on"
                @click="goProfile"
              >
                <v-icon dark>
                  mdi-account
                </v-icon>
              </v-btn>
            </template>
            <span>프로필</span>
          </v-tooltip>
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