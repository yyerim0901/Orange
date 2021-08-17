<template>
  <v-container class="fill-height">
        <v-row class="justify-content-center my-5">
        <v-col>
          <v-card
            outlined
          >
          <v-row>
          <v-col cols="7">
            <v-img
              max-height="550"
                src="@/assets/images/loginFormImage.jpg"
              ></v-img>
          </v-col>
          <v-col cols="5">
            <v-card-text class="text-center px-12 py-16">
              <validation-observer
                ref="observer"
                v-slot="{ invalid }"
              >
                <v-form
                  ref="form"
                  @submit.prevent="checkForm"
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
                    large
                    color="primary"
                    :disabled="invalid"
                    @click="loginForm"
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
                      to="/authentication/sign-up"
                    >
                      회원가입
                    </router-link>
                  </div>
                </v-form>
              </validation-observer>
            </v-card-text>
          </v-col>
          </v-row>
          </v-card>
        </v-col>
      </v-row>
  </v-container>
</template>

<script>
import loginFormImage from '@/assets/images/loginFormImage.jpg'
import KakaoLogin from '@/components/user/KakaoLogin.vue';

export default {
  data() {
    return {
      src : loginFormImage
    }
  },
  components: {
    KakaoLogin,
    loginFormImage
  },
  name: 'LoginForm',
    data: () => ({
    email: "",
    password: "",
  }),
  methods: {
    async checkForm () {
      await this.$refs.observer.validate()
    },
    async loginForm() {
      try {
        const userData = {
          email: this.email,
          password: this.password,
        }
        await this.$store.dispatch('LOGIN', userData)
        this.$router.push('/')
      } catch (error) {
        console.log(error)
        alert("로그인에 실패하였습니다.")
      } finally {
        this.initForm()
      } 
    },
    initForm() {
      this.email = ''
      this.password = ''
    }
  },
}


</script>

<style>

</style>