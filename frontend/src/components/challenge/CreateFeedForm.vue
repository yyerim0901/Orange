<template>
  <v-container class="fill-height">
    <v-row class="justify-content-center my-5">
      <v-col cols="auto">
        <v-card
          width="720"
        >
          <v-card-text class="text-center px-12 py-16">
            <validation-observer
              ref="observer"
              v-slot="{ invalid }"
            >
              <v-form
                ref="form"
                @submit.prevent="createPost"
              >
                <div class="text-h4 font-weight-black mb-3">
                  인증하기
                </div>
                <span class="mb-10">당신의 오늘을 인증해주세요</span>
                
                <validation-provider
                  v-slot="{ errors }"
                  name="제목"
                  :rules="{
                    required: true,
                    FeedTitle: true,
                  }"
                >
                  <v-text-field
                    v-model="feedname"
                    label="제목"
                    clearable
                    prepend-icon="mdi-email"
                    :error-messages="errors"
                  />
                </validation-provider>

                <validation-provider
                  v-slot="{ errors }"
                  name="챌린지 내용"
                  :rules="{
                    required: true,
                  }"
                >
                  <v-textarea
                    v-model="feedtext"
                    label="내용"
                    clearable
                    hint="내용을 성의있게 입력해주세요."
                    prepend-icon="mdi-lock-outline"
                    :error-messages="errors"
                  />
                </validation-provider>

                <v-file-input
                  label="인증 사진"
                  hint="인증 사진을 넣어주세요."
                  prepend-icon="mdi-camera"
                ></v-file-input>

                <v-btn
                  class="mt-6"
                  type="submit"
                  block
                  x-large
                  rounded
                  color="primary"
                  :disabled="invalid"
                >
                  글 작성
                </v-btn>
              </v-form>
            </validation-observer>
            <div class="mt-10">
              <v-btn text @click="goBack">
                뒤로 가기
              </v-btn>
              <v-btn text @click="goHome">
                홈
              </v-btn>
            </div>
            
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'CreateFeedForm',
    data: () => ({
      feedname: null,
      feedtext: null,
  }),
  methods: {
    async createPost () {
      const result = await this.$refs.observer.validate()
      if (result) {
        alert('작성 완료')
      }
    },
    goBack() {
      window.history.back()
    },
    goHome() {
      this.$router.push({path:'/'}).catch(()=> {});
    }
  },
}
</script>

<style>

</style>