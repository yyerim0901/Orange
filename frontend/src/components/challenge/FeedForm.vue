<template>
  <v-container>
    <v-card>
      <v-img
        src="https://cdn.pixabay.com/photo/2020/07/12/07/47/bee-5396362_1280.jpg"
        height="400"
        class="white--text align-center"
      >
        <v-card-title class="justify-center text-h2 font-weight-bold">
          {{ challengeItems.challengeTitle }}
        </v-card-title>
        <div class="text-center">
          <v-chip
            class="ma-2 mt-8"
            outlined
            color="white"
          >
          참여 : {{challengeItems.currentMembers}} 명
          </v-chip>
        </div>
      </v-img>
      <v-card-actions>
        <v-spacer></v-spacer>
        <div class="btn-flex d-flex">
          <v-col>
            <v-btn 
              text 
              color="blue"
              @click="goRanking"
            >
              랭킹
            </v-btn>
          </v-col>
          
          <JoinDialog />
        </div>
        
      </v-card-actions>
    </v-card>
    <FeedTab />
  </v-container>
</template>

<script>
import FeedTab from '@/components/challenge/FeedTab.vue'
import JoinDialog from '@/components/challenge/JoinDialog.vue'
import { challengeDetail } from '@/api/challenge'
export default {
  name: 'FeedForm',
  components: {
    FeedTab,
    JoinDialog,
  },
  data() {
    return {
      challengeItems: [],
    }
  },
  methods: {
    goRanking() {
      this.$router.push({path:'/ranking'}).catch(()=> {});
    },
  },
  async created() {
    const challengeId = this.$route.params.id
    const { data } = await challengeDetail(challengeId)
    // console.log(data)
    this.challengeItems = data
  }
}
</script>

<style>
.btn-flex {
  justify-content: end;
}
</style>