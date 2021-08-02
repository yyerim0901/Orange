<template>
  <v-container class="fill-height">
    <v-row justify="center">
      <v-col cols="auto">
        <v-card
          width="460"
        >
          <v-card-text class="text-center px-12 py-16">
            <validation-observer
              ref="observer"
              v-slot="{ invalid }"
            >
              <v-form
                ref="form"
                @submit.prevent="signIn"
              >
                <div class="text-h4 font-weight-black mb-10">
                  로그인
                </div>
                <validation-provider
                  v-slot="{ errors }"
                  name="이메일"
                  :rules="{
                    required: true,
                  }"
                >
                  <v-text-field
                    v-model="email"
                    label="이메일"
                    clearable
                    prepend-icon="mdi-email"
                    :error-messages="errors"
                  />
                </validation-provider>
                <validation-provider
                  v-slot="{ errors }"
                  name="비밀번호"
                  :rules="{
                    required: true,
                  }"
                >
                  <v-text-field
                    v-model="password"
                    label="비밀번호"
                    clearable
                    prepend-icon="mdi-lock-outline"
                    :error-messages="errors"
                  />
                </validation-provider>
                <v-btn
                  class="mt-6"
                  type="submit"
                  block
                  x-large
                  rounded
                  color="primary"
                  :disabled="invalid"
                >
                  로그인
                </v-btn>
                <div class="mt-5">
                  <router-link
                    class="text-decoration-none"
                    to="/"
                  >
                    홈
                  </router-link> |
                  <router-link
                    class="text-decoration-none"
                    to="/signup"
                  >
                    회원가입
                  </router-link>
                </div>
              </v-form>
            </validation-observer>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'LoginForm',
    data: () => ({
    email: null,
    password: null,
  }),
  methods: {
    signIn () {
      this.$refs.observer.validate().then(result => {
        if (result) {
          alert('로그인 성공')
        }
      })
    }
  }
  // data() {
  //   return {
  //     state:'ins',
  //     email: '',
  //     emailRules: [
  //       v => !!v || '이메일은 필수 입력사항입니다.',
  //       v => /.+@.+\..+/.test(v) || '해당 이메일을 사용할 수 없습니다.',
  //     ],
  //     passwordRules: [
  //       v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
  //       v => !(v && v.length >= 20) || '패스워드는 20자 이상 입력할 수 없습니다.',
  //       v => v.length >= 8 || 'At least 8 characters',
  //     ],
  //     password: '',
  //     checkbox: false,
  //   }
  // },
  
  // methods: {
  //   submitForm() {
  //     console.log("로그인 완료")
  //   },
  //   validate () {
  //     this.$refs.form.validate()
  //   },
  // }
}
</script>

<style>
.btn-color {
  color: #FF9800;
}
</style>