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
      <v-tab-item
        v-for="item in items"
        :key="item.tab"
      >
        <v-card flat>
          <v-card-text>{{ item.content }}</v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
export default {
  name: 'FeedTab',
  data () {
    return {
      tab: null,
      items: [
        { tab: '소개', content: 'Tab 1 Content' },
        { tab: '인증 목록', content: 'Tab 2 Content' },
        { tab: '커뮤니티', content: 'Tab 3 Content' },
      ],
    }
  },
}
</script>

<style>

</style>