<template>
  <div>
    <AppHeader></AppHeader>
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
    <header>
      <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link>
    </header>
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