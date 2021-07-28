<template>
  <center class="notFound-margin">
    <img :src="notfoundImage">
    <h1 class="notFound-fontSize">Not Found</h1>
    <p>존재하지 않는 페이지입니다.</p><br>
    <b-button variant="outline-danger">
      <a href="/" class="notFound-text">홈으로 이동</a>
      </b-button>
  </center>
</template>

<script>
import notfoundImage from "../../assets/images/orange-removebg.png";

export default {
  name: 'NotFoundPage',
  data: () => {
    return { notfoundImage };
  },
}
</script>

<style>
.notFound-margin {
    margin: 1vw;
}
.notFound-fontSize {
    font-size: 7rem;
}
.notFound-text {
  text-decoration: none;
  color: black
}
</style>