<template>
  <v-container>
    <v-row>
      <v-col align-self="center">
        <v-img
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          class="profile_image"
        ></v-img> 
      </v-col>
      <v-col class="my-auto">
        <v-col>
        <v-card
          outlined>
          {{ username }}
        </v-card> 
        </v-col>
        <v-col>
          <v-row justify="space-between">
            <v-col cols="auto">
              <v-card
                outlined>
                {{ bestbadge }}
              </v-card>
            </v-col>
            <v-col cols="auto">
              <BadgeDialog />
            </v-col>
          </v-row>
        </v-col>
        <v-divider class="ma-4"></v-divider>
        <v-col>
        <v-container class="d-flex flex-row justify-space-between text-center">
          <v-flex>
            <div>
              <div class="subtitle-2">{{ join }}</div>
              <div class="caption grey--text">JOIN</div>
            </div>
          </v-flex>
          <v-flex>
            <FollowerDialog />
          </v-flex>
          <v-flex>
            <FollowingDialog />
          </v-flex>
        </v-container>
        </v-col>
        <v-divider class="ma-4"></v-divider>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import BadgeDialog from '@/components/user/BadgeDialog.vue'
import FollowerDialog from '@/components/user/FollowerDialog.vue'
import FollowingDialog from '@/components/user/FollowingDialog.vue'

export default {
  name: 'ProfileForm',
  components: {
    BadgeDialog,
    FollowerDialog,
    FollowingDialog,
  },
  data() {
    return {
      join: '784',
      username: 'username',
      bestbadge: 'bestbadge'
    }
  }
}
</script>

<style>
.profile_image {
  width: 200px;
  height: 200px; 
  border-radius: 70%;
  overflow: hidden;
  display: block;
  margin: auto;
}
</style>