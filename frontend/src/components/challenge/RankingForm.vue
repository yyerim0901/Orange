<template>
  <v-container>
    <div class="text-h3 text-center mb-10">랭킹</div>
    <v-data-table
      :headers="headers"
      :items="teams"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'RankingForm.vue',
  data() {
    return {
      headers: [
        {
          text: '챌린지 랭킹',
          align: 'start',
          sortable: true,
          value: 'challengeTitle',
        },
        { text: '점수', value: 'totalPoint' }
      ],
      teams: [],
    }
  },
  created() {
    axios.get('http://i5b102.p.ssafy.io:8181/api/challenge/ranking/point')
    .then(res => {
      console.log(res.data)
      this.teams = res.data
    })
    .catch(err=> {
      console.error(err)
    })
  }
}
</script>

<style>

</style>