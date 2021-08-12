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
export default {
  name: 'RankingForm.vue',
  data() {
    return {
      headers: [
        {
          text: '챌린지 랭킹',
          align: 'start',
          sortable: true,
          value: 'team',
        },
        { text: '점수', value: 'score' }
      ],
      teams: [
        {
          team: '챌린지 1',
          score: 1234
        },
        {
          team: '챌린지 2',
          score: 12345
        },
        {
          team: '챌린지 3',
          score: 123456
        },
        {
          team: '챌린지 4',
          score: 124
        },
        {
          team: '챌린지 5',
          score: 135
        },
        {
          team: '챌린지 6',
          score: 2345
        },
      ]
    }
  }
}
</script>

<style>

</style>