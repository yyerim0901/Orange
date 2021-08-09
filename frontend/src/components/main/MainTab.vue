<template>
  <v-container>
    <v-tabs
      v-model="tabs"
      centered
      class="my-5"
    >
      <v-tab
        v-for="item in items"
        :key="item.tabs"
      >
        {{ item.tab }}
      </v-tab>
    </v-tabs>
    <v-tabs-items v-model="tabs">
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <PopularMainForm />
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
  </v-container>
</template>

<script>
import PopularMainForm from '@/components/challenge/PopularMainForm.vue'
export default {
  name: 'MainTab',
  components: {
    PopularMainForm,
  },
  data: () => {
    return { 
      tabs: null,
      items: [
        { tab: '인기' },
        { tab: '신규' },
        { tab: '추천' },
      ]
    };
  },
}
</script>

<style>

</style>