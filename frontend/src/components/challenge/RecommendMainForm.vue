<template>
  <v-container fluid class="mx-auto">
    <v-row dense>
      <v-col
        v-for="(card, title) in cards"
        :key="title"
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
import { recommendMain } from '@/api/main'

export default {
  name: 'RecommendMainForm',
  data() {
    return {
      cards: [],
    }
  },
  methods: {
    async recommendFeed() {
      const { data } = await recommendMain()
      this.cards = data
      // console.log(data)
    }
  },
  created() {
    this.recommendFeed()
  }
}
</script>