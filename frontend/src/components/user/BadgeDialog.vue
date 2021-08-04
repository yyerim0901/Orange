<template>
  <v-container>
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
        class="my-3"
        width="600px"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            outlined
            small
            v-bind="attrs"
            v-on="on"
          >
            Badge
          </v-btn>
        </template>
        <v-spacer></v-spacer>
        <v-card>
          <v-card-text>
            <p class="text-center text-h6 font-weight-bold">나의 대표 배지</p>
            <p class="text-center">나를 대표할 수 있는 배지를 선택해 주세요.</p>
            <p class="text-center">배지 사진</p>
          </v-card-text>
          <v-divider class="mx-4"></v-divider>
          <v-row class="mx-3">
            <v-col>
              <p>나의 대표 배지</p>
            </v-col>
            <v-col>
              <p>나의 대표 배지</p>
            </v-col>
            <v-col>
              <p>나의 대표 배지</p>
            </v-col>
            <v-col>
              <p>나의 대표 배지</p>
            </v-col>
          </v-row>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="red darken-1"
              text
              @click="dialog = false"
            >
              close
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'BadgeDialog',
    data () {
      return {
        dialog: false,
      }
    },
  }
</script>