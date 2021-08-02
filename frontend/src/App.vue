<template>
  <div>
    <Navbar></Navbar>
    <center>
      <router-link to="/">홈</router-link> |
      <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link> |
    </center>
    <router-view></router-view>
  </div>
</template>

<script>
import Navbar from '@/components/common/Navbar.vue';

export default {
  components: {
    Navbar,
  },
}
</script>

<style>

</style>