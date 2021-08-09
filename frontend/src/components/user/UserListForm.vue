<template>
  <v-container>
    <v-flex justify="space-around">
      <div class="d-flex">{{ username }}</div>
      <v-btn class="d-flex" outlined text color='red'>삭제</v-btn> 
    </v-flex>
  </v-container>
</template>

<script>
export default {
  name: 'UserListForm',
  data() {
    return {
      username: 'username',
    }
  }
}
</script>

<style>

</style>