<template>
  <v-card>
    <v-tabs
      v-model="tab"
      centered
    >
      <v-tab
        v-for="item in items"
        :key="item.tab"
      >
        {{ item.tab }}
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            소개
          </v-card-text>
        </v-card>
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
export default {
  name: 'FeedTab',
  conponents: {
    
  },
  data () {
    return {
      tab: null,
      items: [
        { tab: '소개' },
        { tab: '인증 목록' },
        { tab: '1:1 배틀' },
      ],
    }
  },
}
</script>

<style>

</style>