<template>
  <div>
    <CarouselForm />
    <MainTab />
  </div>
</template>

<script>
import CarouselForm from '@/components/main/CarouselForm.vue'
import MainTab from '@/components/main/MainTab.vue'

export default {
  name: 'IndexFeed',
  components: {
    CarouselForm,
    MainTab,
  }
}
</script>

<style>

</style>