<template>
  <v-card
    class="mx-auto my-12"
    max-width="500"
  >

    <v-card-title>우리 챌린지를 소개합니다.</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <div class="grey--text my-2">
          현재 포인트 : {{ challengeItems.totalPoint }}
        </div>
      </v-row>

      <div class="mt-4 text-subtitle-1">
        시작일 : {{ challengeItems.startDate }}
      </div>
      <div class="mb-4 text-subtitle-1">
        종료일 : {{ challengeItems.endDate }}
      </div>

    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>팀소개</v-card-title>

    <v-card-text>
      {{ challengeItems.challengeDescribe }}
    </v-card-text>
  </v-card>
</template>

<script>
import axios from 'axios'
export default {
  name: 'IntroduceForm',
  data() {
    return {
      challengeItems: []
    }
  },
  methods: {
    async getChallenge() {
      try {
        const challengeId = this.$route.params.id
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/${challengeId}`)
        // console.log(data)
        this.challengeItems = data
      } catch (err) {
        console.log(err)
      }
    }
  },
  created() {
    this.getChallenge()
  }
}
</script>

<style>

</style>