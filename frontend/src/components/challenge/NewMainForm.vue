<template>
  <v-container fluid class="mx-auto">
    <v-row dense>
      <v-col
        v-for="(card, title) in cards" class="col-3 mb-10 pa-2"
        :key="title"
        :cols="card.flex"
      >
        <v-card fill-height>
          <router-link :to="`/challenge/${card.challengeId}`" class="text-decoration-none">
          <v-img
            :src="card.imagePath"
            class="white--text align-end px-3"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="300px"
          >
            <v-card-title>{{ card.challengeTitle }}</v-card-title>
            <v-card-text>팀 점수: {{ card.totalPoint }}</v-card-text>
          </v-img>
          </router-link>

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
import { newMain } from '@/api/main'

export default {
  name: 'NewMainForm',
  data() {
    return {
      cards: [],
    }
  },
  methods: {
    async newFeed() {
      try {
        const { data } = await newMain()
        this.cards = data.slice(0, 8)
        // console.log(data)
      } catch(err) {
        console.log(err)
      }
    }
  },
  created() {
    this.newFeed()
  }
}
</script>