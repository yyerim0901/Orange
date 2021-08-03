<template>
  <v-app>
      <AuthenticationView />
  </v-app>
</template>

<script>
import AuthenticationView from './View'
export default {
  name: 'AuthenticationLayout',
  components: {
    AuthenticationView,
  }
}
</script>

<style>

</style>