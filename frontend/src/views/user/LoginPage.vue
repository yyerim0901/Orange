<template>
  <div>
    <h1>로그인 페이지</h1>
    <LoginForm></LoginForm>
  </div>
</template>

<script>
import LoginForm from '@/components/user/LoginForm.vue'

export default {
  name: "Login",
  components: {
    LoginForm
  },
}
</script>

<style>

</style>