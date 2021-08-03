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
          이름
        </v-card> 
        </v-col>
        <v-col>
          <v-row justify="space-between">
            <v-col cols="auto">
              <v-card
                outlined>
                뱃지
              </v-card>
            </v-col>
            <v-col cols="auto">
              <v-card
                outlined>
                뱃지
              </v-card>
            </v-col>
          </v-row>
        </v-col>
        <v-col>
          <v-row justify="space-between">
            <v-col cols="auto">
              Join  | 
            </v-col>
            <v-col cols="auto">
              Followers  |
            </v-col>
            <v-col cols="auto">
              Following 
            </v-col>
          </v-row>
        </v-col>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'ProfileForm',
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