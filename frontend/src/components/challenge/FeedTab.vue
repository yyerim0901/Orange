<template>
  <v-card>
    <v-tabs
      v-model="tab"
      centered
    >
      <v-tab>
        소개
      </v-tab>
      <v-tab>
        인증목록
      </v-tab>
      <v-tab>
        1:1 배틀
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item>
        <IntroduceForm />
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            인증목록
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            1:1 배틀
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import IntroduceForm from '@/components/challenge/IntroduceForm.vue'
export default {
  name: 'FeedTab',
  components: {
    IntroduceForm,
  },
  data () {
    return {
      tab: null,
    }
  },
}
</script>

<style>

</style>