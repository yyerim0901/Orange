<template>
  <v-container class="fill-height">
    <v-row class="justify-content-center my-5">
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
                @submit.prevent="signUp"
              >
                <div class="text-h4 font-weight-black mb-10">
                  회원가입
                </div>
                <validation-provider
                  v-slot="{ errors }"
                  name="이메일"
                  :rules="{
                    required: true,
                    email: true,
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
                  name="이름"
                  :rules="{
                    required: true,
                    kor: true,
                  }"
                >
                  <v-text-field
                    v-model="username"
                    label="이름"
                    clearable
                    prepend-icon="mdi-account"
                    :error-messages="errors"
                  />
                </validation-provider>

                <validation-provider
                  v-slot="{ errors }"
                  name="닉네임"
                  :rules="{
                    required: true,
                    korAlphaNum: true,
                  }"
                >
                  <v-text-field
                    v-model="nickname"
                    label="닉네임"
                    clearable
                    prepend-icon="mdi-alphabetical"
                    :error-messages="errors"
                  />
                </validation-provider>

                <validation-provider
                  v-slot="{ errors }"
                  name="비밀번호"
                  :rules="{
                    required: true,
                    min: 8,
                  }"
                >
                  <v-text-field
                    v-model="password"
                    type="password"
                    label="비밀번호"
                    clearable
                    prepend-icon="mdi-lock-outline"
                    :error-messages="errors"
                  />
                </validation-provider>
                <validation-provider
                  v-slot="{ errors }"
                  name="비밀번호 확인"
                  :rules="{
                    confirmed: '비밀번호',
                    required: true,
                    min: 8,
                  }"
                >
                  <v-text-field
                    v-model="passwordConfirm"
                    label="비밀번호 확인"
                    type="password"
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
                  가입하기
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
                    to="/authentication/login"
                  >
                    로그인
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
  name: 'SignupForm',
  data: () => ({
    email: null,
    username: null,
    nickname: null,
    password: null,
    passwordConfirm: null,
  }),
  methods: {
    async signUp () {
      const result = await this.$refs.observer.validate()
      if (result) {
        alert('가입 완료')
      }
    }
  }
}
</script>

<style>

</style>