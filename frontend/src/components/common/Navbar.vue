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
          <v-autocomplete
            prepend-icon="mdi-magnify"
            v-model="model"
            :loading="isloading"
            :items="items"
            :search-input.sync="search"
            cache-items
            class="mx-4"
            flat
            hide-no-data
            hide-details
            hide-selected
            label="야너두 할 수 있어!"
            solo
          ></v-autocomplete>
        </b-nav-item>
        <b-nav-item>
          <v-tooltip bottom>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                icon
                v-bind="attrs"
                v-on="on"
                @click="goCreateChallenge"
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
  data () {
    return {
      isloading: false,
      items: [],
      search: null,
      model: null,
    }
  },
  methods: {
    goProfile() {
      this.$router.push({path:'/profile'}).catch(()=> {});
    },
    goHome() {
      this.$router.push({path:'/'}).catch(()=> {});
    },
    goCreateChallenge() {
      this.$router.push({path:'/create-challenge'}).catch(()=> {});
    }
  },
  // watch: {
  //   model (val) {
  //     if (val != null) this.tab = 0
  //     else this.tab = null
  //   },
  //   search (val) {
  //     if (this.items.length > 0) return

  //     this.isLoading = true
  //   }
  // }
}
</script>

<style>

</style>