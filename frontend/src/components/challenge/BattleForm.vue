<template>
 <v-container>
   <v-row class="justify-space-around">
     <v-col>
       <v-card class="text-center">
          <v-card-title>
            {{ myTeamDatas.challengeTitle }}
          </v-card-title>
          <v-divider></v-divider>
          <v-card-subtitle>{{ myTeamDatas.challengeDescribe }}</v-card-subtitle>
          <v-card-text>
            현재 인원: {{ myTeamDatas.currentMembers }}명
          </v-card-text>
          <v-chip
            class="ma-2"
            color="orange accent-4"
            outlined
          >
            {{ myTeamDatas.totalPoint }} 점
          </v-chip>
          <v-btn @click="goMyTeam()" text color="orange">우리팀 응원하기</v-btn>
      </v-card>
     </v-col>
     <v-col class="justify-center align-self-center">
      <p class="text-center h1">VS</p>
     </v-col>
     <v-col>
        <v-card class="text-center">
          <v-card-title>
            {{ yourTeamDatas.challengeTitle }}
          </v-card-title>
          <v-divider></v-divider>
          <v-card-subtitle>{{ yourTeamDatas.challengeDescribe }}</v-card-subtitle>
          <v-card-text>
            현재 인원: {{ yourTeamDatas.currentMembers }}명
          </v-card-text>
          <v-chip
            class="ma-2"
            color="purple accent-4"
            outlined
          >
            {{ yourTeamDatas.totalPoint }} 점
          </v-chip>
          <v-btn @click="goYourTeam()" text color="purple">상대팀 구경가기</v-btn>
        </v-card>
     </v-col>
   </v-row>
 </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'BattleForm',
  data() {
    return {
      myTeamDatas: [],
      yourTeamDatas: [],
      myTeamId: '',
      yourTeamId: '',
    }
  },
  methods: {
    async getMyTeam() {
      try {
        const challengeId = this.$route.params.id
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/${challengeId}`)
        // console.log(data)
        this.myTeamDatas = data
        this.myTeamId = data.challengeId
      } catch (err) {
        console.log(err)
      }
    },
    async getYourTeam() {
      try {
        const challengeId = this.$route.params.id
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/opponent/${challengeId}`)
        // console.log(data)
        this.yourTeamDatas = data
        this.yourTeamId = data.challengeId
      } catch (err) {
        console.log(err)
      }
    },
    goYourTeam() {
      this.$router.push(`/challenge/${this.yourTeamId}`)
      location.reload()
    },
    goMyTeam() {
      this.$router.push(`/challenge/${this.myTeamId}`)
      location.reload()
    }
  },
  created() {
    this.getMyTeam()
    this.getYourTeam()
  }
}
</script>

<style>

</style>