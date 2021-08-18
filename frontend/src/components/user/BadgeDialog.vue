<template>
  <v-container>
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
       
        width="300px"
        height="300px"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            outlined
            small
            v-bind="attrs"
            v-on="on"
          >
            Badge
          </v-btn>
        </template>
        <v-spacer></v-spacer>
        <v-card>
          <v-card-text>
            <p class="text-center text-h5 font-weight-bold">나의 배지</p>
          </v-card-text>
          <v-divider></v-divider>

          <v-card v-for="(badge, i) in userbadges" :key="i">
            <v-img
              v-if="badge.badge == '1'"
              src="@/assets/images/badge/badge1.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '2'"
              src="@/assets/images/badge/badge2.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '3'"
              src="@/assets/images/badge/badge3.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '4'"
              src="@/assets/images/badge/badge4.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '5'"
              src="@/assets/images/badge/badge5.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '6'"
              src="@/assets/images/badge/badge6.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '7'"
              src="@/assets/images/badge/badge7.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '8'"
              src="@/assets/images/badge/badge8.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '9'"
              src="@/assets/images/badge/badge9.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '10'"
              src="@/assets/images/badge/badge10.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
            <v-img
              v-if="badge.badge == '11'"
              src="@/assets/images/badge/badge11.png"
              width="100" height="100"
              class="badge-position"
            ></v-img>
          </v-card>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="red darken-1"
              text
              @click="dialog = false"
            >
              close
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios'
import { badgeList } from '@/api/challenge' 

export default {
  name: 'BadgeDialog',
  data () {
    return {
      dialog: false,
      userbadges: [],
      badges: [],
    }
  },
  methods: {
    async getUserBadge() {
      try {
        const userId = this.$store.state.data2
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/badgesusers/${userId}`)
        // console.log(data)
        this.userbadges = data
      } catch (err) {
        console.error(err)
      }
    },
    async getAllBadge() {
      try {
        const { data } = await badgeList()
        // console.log(data)
        this.badges = data
      } catch (err) {
        console.error(err)
      }
    },

  },
  created() {
    this.getUserBadge()
    this.getAllBadge()
  }
}
</script>
<style>
.badge-position {
  display: block; margin: 0px auto;
}
</style>