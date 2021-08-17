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
            @click="goPage"
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
      challengeId: null,
    }
  },
  methods: {
    async recommendFeed() {
      try {
        const { data } = await recommendMain()
        this.cards = data
        for (var key in data) {
          this.challengeId = data[key].challengeId
          console.log(data[key].challengeId)
        }
        console.log(data)
      } catch(err) {
        console.log(err)
      }
    },
    goPage() {
      const id = this.challengeId
      console.log(id)
      this.$router.push(`challenge/${id}`)
    }
  },
  created() {
    this.recommendFeed()
  }
}
</script>