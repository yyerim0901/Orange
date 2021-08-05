<template>
  <v-container>
    <v-card>
      <v-img
        src="https://cdn.pixabay.com/photo/2020/07/12/07/47/bee-5396362_1280.jpg"
        height="400"
        class="white--text align-center"
      >
        <v-card-title class="justify-center text-h2 font-weight-bold">
          {{ extext }}
        </v-card-title>
        <div class="text-center">
          <v-chip
            class="ma-2 mt-8"
            outlined
            color="white"
          >
            참여 : {{ expeople }}
          </v-chip>
        </div>
      </v-img>
    </v-card>
    <FeedTab />
  </v-container>
</template>

<script>
import FeedTab from '@/components/challenge/FeedTab.vue'
export default {
  name: 'FeedForm',
  components: {
    FeedTab,
  },
  data() {
    return {
      extext: '나도 김종국',
      expeople: "0명"
    }
  }
}
</script>

<style>

</style>