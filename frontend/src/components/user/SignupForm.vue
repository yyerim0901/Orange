<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="email">id: </label>
      <input id="email" type="text" v-model="email" />
    </div>
    <div>
      <label for="password">pw: </label>
      <input id="password" type="text" v-model="password" />
    </div>
    <div>
      <label for="nickname">nickname: </label>
      <input id="nickname" type="text" v-model="nickname" />
    </div>
    <button type="submit">signup</button>
  </form>
</template>

<script>
export default {
  name: 'SignupForm',
  data() {
    return {
      email: '',
      password: '',
      nickname: '',
    };
  },
  methods: {
    submitForm() {
      console.log("제출")
    },
  },
}
</script>

<style>

</style>