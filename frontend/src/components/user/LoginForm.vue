<template>
  <v-form ref="form" lazy-validation>
    <v-row class="container">
      <v-col cols="12">
        <v-text-field
        v-model="email"
        id="email"
        label="email"
        :rules="emailRules"
        required
        ></v-text-field>
      </v-col>
      <v-col cols="12">
        <v-text-field
          v-model="password"
          id="password"
          :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
          :rules="passwordRules"
          type="password"
          label="password"
          hint="At least 8 characters"
          counter
          @click:append="show1 = !show1"
        ></v-text-field>
      </v-col>

      <v-checkbox
        v-model="checkbox"
        id="checkbox"
        :rules="[v => !!v || 'You must agree to continue!']"
        label="약관에 동의하시겠습니까?"
        required
      ></v-checkbox>

      <v-btn class="mr-4" @click="submitForm">
        로그인
      </v-btn>
    </v-row>
  </v-form>
</template>

<script>
export default {
  name: 'LoginForm',
  data() {
    return {
      state:'ins',
      email: '',
      emailRules: [
        v => !!v || '이메일은 필수 입력사항입니다.',
        v => /.+@.+\..+/.test(v) || '해당 이메일을 사용할 수 없습니다.',
      ],
      passwordRules: [
        v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
        v => !(v && v.length >= 20) || '패스워드는 20자 이상 입력할 수 없습니다.',
        v => v.length >= 8 || 'At least 8 characters',
      ],
      show1: false,
      password: '',
      checkbox: false,
    }
  },
  
  methods: {
    submitForm() {
      console.log("로그인 완료")
    },
    validate () {
      this.$refs.form.validate()
    },
  }
}
</script>

<style>
.btn-color {
  color: #FF9800;
}
</style>