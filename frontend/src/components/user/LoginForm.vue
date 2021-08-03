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
                @submit.prevent="LoginForm"
              >
                <div class="text-h4 font-weight-black mb-10">
                  로그인
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
                <KakaoLogin
                v-on:click="KakaoLogin()">
                </KakaoLogin>
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
import KakaoLogin from '@/components/user/KakaoLogin.vue';

export default {
  components: {
    KakaoLogin,
  },
  name: 'LoginForm',
    data: () => ({
    email: null,
    password: null,
  }),
  methods: {
    async LoginForm () {
      const result = await this.$refs.observer.validate()
        if (result) {
          alert('로그인 성공')
        }
      },
    KakaoLogin: function () {
      window.Kakao.Auth.authorize({
        redirectUri: "http://localhost:8080/auth/kakao/callback",
      });  
    }
  },
  beforeMount(){
  
  }
}


</script>

<style>

</style>