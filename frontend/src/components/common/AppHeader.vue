<template>
  <div>
    <b-navbar variant="warning" type="light">
      <b-navbar-brand tag="h1" class="mb-0 "><router-link to="/" class="nav-brand-text">Orange</router-link></b-navbar-brand>
    </b-navbar>
    <header>
      <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link>
    </header>
  </div>
</template>

<script>
export default {
  name: 'AppHeader',
}
</script>

<style>
.nav-brand-text {
  text-decoration: none;
  color: black;
}
</style>