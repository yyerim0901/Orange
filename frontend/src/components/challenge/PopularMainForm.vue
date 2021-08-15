<template>
  <v-container fluid class="mx-auto">
    <v-row dense>
      <v-col
        v-for="(card, index) in cards"
        :key="index"
        :cols="card.flex"
      >
        <v-card>
          <v-img
            :src="card.imagePath"
            class="white--text align-end px-3"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="300px"
          >
            <v-card-title>{{ card.challengeTitle }}</v-card-title>
            <v-card-text>팀 점수: {{ card.totalPoint }}</v-card-text>
          </v-img>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn icon>
              <v-icon>mdi-account-plus</v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'PopularMainForm',
  data: () => ({
    cards: []
  }),
  created() {
    axios.get('http://i5b102.p.ssafy.io:8181/api/challenge/list')
      .then(res => {
        // console.log(res.data)
        this.cards = res.data
      })
      .catch(err=> {
        console.error(err)
      })
  }
}
</script>