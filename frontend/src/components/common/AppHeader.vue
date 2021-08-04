<template>
  <div>
    <div class="d-flex justify-content-end mx-3">
      <v-btn text>
      고객센터
      </v-btn>
      <v-btn 
        text
        @click="goLogin"
      >
        로그인
      </v-btn>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AppHeader',
  methods: {
    goLogin() {
      this.$router.push({path:'/authentication/login'}).catch(()=> {});
    },
  }
}
</script>

<style>

</style>