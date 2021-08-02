<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="email">이메일: </label>
      <input id="email" type="text" v-model="email" placeholder="이메일을 입력하세요." autocapitalize="off" />
    </div>
    <div>
      <label for="nickname">닉네임: </label>
      <input id="nickname" type="text" v-model="nickname" placeholder="닉네임을 입력하세요." autocapitalize="off"/>
    </div>
    <div>
      <label for="password">패스워드: </label>
      <input id="password" type="text" v-model="password" placeholder="패스워드를 입력하세요." autocapitalize="off"/>
    </div>
    <div>
      <label for="password-confirm">패스워드 확인: </label>
      <input id="password" type="text" v-model="passwordConfirm" placeholder="패스워드를 다시 한번 입력하세요." autocapitalize="off"/>
    </div>
    <button type="submit">가입</button>
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
      passwordConfirm: '',
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