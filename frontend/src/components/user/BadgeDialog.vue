<template>
  <v-container>
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
       
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
            <p class="text-center text-h6 font-weight-bold">나의 배지</p>
          </v-card-text>
          <v-divider class="mx-4"></v-divider>
          <div class="d-flex justify-space-between">
            <div class="row">
              <v-card v-for="(badge, index) in badges" :key="index" cols="4">
                  <v-card-text class="text-center">{{ badge.badgeTitle }}</v-card-text>
                  <v-card-text class="text-center">{{ badge.badgeDescribe }}</v-card-text>
              </v-card>
            </div>
          </div>
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
import { badgeList } from '@/api/challenge'

export default {
  name: 'BadgeDialog',
  data () {
    return {
      dialog: false,
      badges: [],
    }
  },
  methods: {
    async myBadge() {
      const { data } = await badgeList()
      this.badges = data
      // console.log(data)
    }
  },
  created() {
    this.myBadge()
  }
}
</script>