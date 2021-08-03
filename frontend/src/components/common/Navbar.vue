<template>
  <div>
    <b-navbar variant="navbar-light bg-light justify-content-between" type="light">
      <b-navbar-brand tag="h1">
        <router-link to="/" class="nav-brand-text">Orange</router-link>
      </b-navbar-brand>
      <b-navbar-nav class="d-flex">
        <b-nav-item>About</b-nav-item>
        <b-nav-item><b-icon icon="bell"></b-icon></b-nav-item>
        <b-nav-item><b-icon icon="person"></b-icon></b-nav-item>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import AppHeader from '@/components/common/AppHeader.vue'

export default {
  name: 'Navbar',
  components: {
    AppHeader,
  }
}
</script>

<style>
.nav-brand-text {
  text-decoration: none;
  color: black;
}
</style>