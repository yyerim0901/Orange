<template>
  <v-container>
    <v-tabs
      v-model="tabs"
      centered
      class="my-5"
    >
      <v-tab>
        진행 중인 챌린지
      </v-tab>
      <v-tab>
        완료한 챌린지
      </v-tab>
      
    </v-tabs>
    <v-tabs-items v-model="tabs">
      <v-tab-item>
        <!-- 반복되는 카드 -->
        <v-col
          v-for="(myData, title) in myDatas" class="col-3 mb-10 pa-2"
          :key="title"
          :cols="myData.flex"
        >
          <v-card fill-height>
            <router-link :to="`/challenge/${myData.challengeId}`" class="text-decoration-none">
            <v-img
              :src="myData.imagePath"
              class="white--text align-end px-3"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="300px"
            >
              <v-card-title>{{ myData.challengeTitle }}</v-card-title>
              <v-card-text>팀 점수: {{ myData.totalPoint }}</v-card-text>
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
        <!-- 반복되는 카드 끝 -->
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-title class="text-h5">
            An awesome title
          </v-card-title>
          <v-card-text>
            <p>
              Duis lobortis massa imperdiet quam. Donec vitae orci sed dolor rutrum auctor. Vestibulum facilisis, purus nec pulvinar iaculis, ligula mi congue nunc, vitae euismod ligula urna in dolor. Praesent congue erat at massa.
            </p>

            <p>
              Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Pellentesque egestas, neque sit amet convallis pulvinar, justo nulla eleifend augue, ac auctor orci leo non est. Etiam sit amet orci eget eros faucibus tincidunt. Donec sodales sagittis magna.
            </p>

            <p class="mb-0">
              Ut leo. Suspendisse potenti. Duis vel nibh at velit scelerisque suscipit. Fusce pharetra convallis urna.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ProfileTab',
  data() {
    return { 
      tabs: null,
      myDatas: [],
    };
  },
  methods: {
    async userData() {
      try {
        const userId = this.$store.state.data2
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/search/user/${userId}`)
        this.myDatas = data
        // console.log(data)
      } catch(err) {
        console.log(err)
      }  
    }
  },
  created() {
    this.userData()
  }
}
</script>

<style>

</style>