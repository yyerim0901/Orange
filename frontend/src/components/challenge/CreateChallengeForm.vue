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
                @submit.prevent="submitForm"
              >
                <div class="text-h4 font-weight-black mb-10">
                  챌린지 생성
                </div>
                <span>챌린지는 여러분들이 만들어 나가는 것입니다.</span><br>
                <span class="mb-10">성의있는 제목, 내용을 작성해주세요.</span>
                <validation-provider
                  v-slot="{ errors }"
                  name="챌린지 제목"
                  :rules="{
                    required: true,
                    ChallengeTitle: true,
                  }"
                >
                  <v-text-field
                    v-model="challengeTitle"
                    label="챌린지 제목"
                    clearable
                    prepend-icon="mdi-email"
                    :error-messages="errors"
                  />
                </validation-provider>

                <validation-provider
                  v-slot="{ errors }"
                  name="카테고리"
                  :rules="{
                    required: true,
                  }"
                >
                  <v-select
                    v-model="select"
                    :items="category"
                    label="카테고리"
                    data-vv-name="select"
                    prepend-icon="mdi-account"
                    :error-messages="errors"
                  />
                </validation-provider>

                <v-slider
                  v-model="slider"
                  class="align-center"
                  :max="50"
                  :min="2"
                  :rules="rules"
                  prepend-icon="mdi-account"
                  label="인원"
                  hide-details
                >
                  <template v-slot:append>
                    <v-text-field
                      v-model="slider"
                      class="mt-0 pt-0"
                      hide-details
                      single-line
                      :rules="rules"
                      type="number"
                      style="width: 60px"
                    ></v-text-field>
                  </template>
                </v-slider>
                <DateForm />
                <validation-provider
                  v-slot="{ errors }"
                  name="챌린지 내용"
                  :rules="{
                  }"
                >
                  <v-textarea
                    v-model="challengeDescribe"
                    label="챌린지 내용"
                    clearable
                    hint="챌린지 내용을 성의있게 입력해주세요."
                    prepend-icon="mdi-lock-outline"
                    :error-messages="errors"
                  />
                </validation-provider>

                <v-file-input
                  label="대표 사진"
                  hint="챌린지 배경사진을 넣어주세요."
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
                  @click="createForm"
                >
                  챌린지 생성
                </v-btn>
              </v-form>
            </validation-observer>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import DateForm from '@/components/challenge/DateForm.vue'
import { createChallenge } from '@/api/challenge'

export default {
  name: 'CreateChallengeForm',
  components: {
    DateForm,
  },
  data: () => ({
    challengeTitle: null,
    challengeDescribe: null,
    slider: null,
    select: null,
    category: [
      "운동",
      "음식",
      "영양제",
    ],
    rules: [
      v => v <= 50 || '50명 제한',
    ],
  }),
  methods: {
    async submitForm () {
      await this.$refs.observer.validate()
    },
    async createForm () {
      const response = await createChallenge({
        challengeTitle: this.challengeTitle,
        challengeDescribe: this.challengeDescribe,
      })
      console.log(response)
    }
  }
}
// 카테고리 ID
// 챌린지 내용 (유저가 공란으로 받아도댐)
// 챌린지 제목
// 최소멤버, 최대멤버
// 히든으로 manaerID를 넣어줘야함
// 기간id
// 스타트데이트를 나우로
</script>

<style>

</style>