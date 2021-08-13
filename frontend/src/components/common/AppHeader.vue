<template>
  <div>
    <div class="d-flex justify-content-end mx-3">
      <v-btn text @click="goChall">
        챌린지피드(임시)
      </v-btn>
      <v-btn text>
        고객센터
      </v-btn>
      <!-- 로그인이 되었을 때 -->
      <template v-if="isUserLogin">
        <v-btn
          text
          @click="logoutUser"
        >
          로그아웃
        </v-btn>
      </template>
      <!-- 로그인이 되지 않았을 때 -->
      <template v-else>
        <v-btn 
          text
          @click="goLogin"
        >
          로그인
        </v-btn>
      </template>
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
    goChall() {
      this.$router.push({path:'/challenge'}).catch(()=>{});
    },
    logoutUser() {
      this.$store.commit('clearUserId')
      this.$router.push({path:'/authentication/login'}).catch(()=>{});
    }
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    }
  }
}
</script>

<style>

</style>