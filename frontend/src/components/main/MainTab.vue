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
            <NewMainForm />
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-text>
            <RecommendMainForm />
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-container>
</template>

<script>
import PopularMainForm from '@/components/challenge/PopularMainForm.vue'
import NewMainForm from '@/components/challenge/NewMainForm.vue'
import RecommendMainForm from '@/components/challenge/RecommendMainForm.vue'

export default {
  name: 'MainTab',
  components: {
    PopularMainForm,
    NewMainForm,
    RecommendMainForm,
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