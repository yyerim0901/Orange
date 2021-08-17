<template>
  <v-container>
    <v-row>
      <v-col align-self="center">
        <v-img
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          class="profile_image"
        ></v-img> 
      </v-col>
      <v-col class="my-auto">
        <v-row justify="space-between">
          <v-col cols="auto" class="align-self-center">
            {{ userDatas.username }}
          </v-col>
          <v-col cols="auto">
            <v-btn outlined>프로필 편집</v-btn>
          </v-col>
        </v-row>
        <v-col>
          <v-row justify="space-between">
            <v-col cols="auto">
              <v-icon>
                mdi-trophy-outline
              </v-icon>
            </v-col>
            <v-col cols="auto">
              <BadgeDialog />
            </v-col>
          </v-row>
        </v-col>
        <v-divider class="ma-4"></v-divider>
        <v-col>
        <v-container class="d-flex flex-row justify-space-between text-center">
          <v-flex>
            <div>
              <div class="subtitle-2">{{ challengeDates.length }}</div>
              <div class="caption grey--text">JOIN</div>
            </div>
          </v-flex>
          <v-flex>
            <FollowerDialog />
          </v-flex>
          <v-flex>
            <FollowingDialog />
          </v-flex>
        </v-container>
        </v-col>
        <v-divider class="ma-4"></v-divider>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import BadgeDialog from '@/components/user/BadgeDialog.vue'
import FollowerDialog from '@/components/user/FollowerDialog.vue'
import FollowingDialog from '@/components/user/FollowingDialog.vue'
import axios from 'axios'

export default {
  name: 'ProfileForm',
  components: {
    BadgeDialog,
    FollowerDialog,
    FollowingDialog,
  },
  data() {
    return {
      userDatas: [],
      challengeDates: [],
    }
  },
  methods: {
    async myProfile() {
      try {
        const userId = this.$store.state.data2
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/user/userinfo/${userId}`)
        // console.log(data)
        this.userDatas = data.data1
      } catch (err) {
        console.log(err)
      }
    },
    async challengeDate() {
      try {
        const userId = this.$store.state.data2
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/search/user/${userId}`)
        this.challengeDates = data
        // console.log(data)
      } catch(err) {
        console.log(err)
      }  
    }
  },
  created() {
    this.myProfile()
    this.challengeDate()
  }
}
</script>

<style>
.profile_image {
  width: 200px;
  height: 200px; 
  border-radius: 70%;
  overflow: hidden;
  display: block;
  margin: auto;
}
</style>