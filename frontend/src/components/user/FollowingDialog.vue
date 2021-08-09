<template>
  <div>
    <v-dialog
      v-model="dialog"
      width="500"
    >
    
      <template v-slot:activator="{ on, attrs }">
        <div
          v-bind="attrs"
          v-on="on"
          class="subtitle-2">{{ followings }}</div>
        <div class="caption grey--text">FOLLWERS</div>
      </template>

      <v-card>
        <v-card-text class="text-h5 text-center font-weight-bold p-2 lighten-2">
          Followings
        </v-card-text><hr>

        <v-card-text>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="red"
            text
            @click="dialog = false"
          >
            Close
          </v-btn>
        </v-card-actions>
      </v-card>
      
    </v-dialog>
  </div>
</template>

<script>
export default {
  name: 'FollowingDialog',
  data() {
    return {
      followings: '784',
      dialog: false,
    }
  }
}
</script>

<style>

</style>