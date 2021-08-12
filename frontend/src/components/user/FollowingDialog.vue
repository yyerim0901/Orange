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
          <UserListForm />
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
import UserListForm from '@/components/user/UserListForm.vue'
export default {
  name: 'FollowingDialog',
  components: {
    UserListForm,
  },
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