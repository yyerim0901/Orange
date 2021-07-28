<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="email">id: </label>
      <input id="email" type="text" v-model="email">
    </div>
    <div>
      <label for="password">pw: </label>
      <input id="password" type="text" v-model="password">
    </div>
    <button type="submit">로그인</button>
  </form>
</template>

<script>
export default {
  name: 'LoginForm',
  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    submitForm() {
      console.log("로그인 완료")
    }
  }
}
</script>

<style>

</style>