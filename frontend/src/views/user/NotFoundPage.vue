<template>
  <center>
    <div class="notFound-margin">
      <img :src="notfoundImage">
    </div>
    <p class="notFound-fontSize">해당 페이지는</p>
    <p class="notFound-fontSize">존재하지 않는 페이지입니다.</p><br>
    <b-button variant="outline-danger">
      <a href="/" class="notFound-text">홈으로 이동</a>
    </b-button>
  </center>
</template>

<script>
import notfoundImage from "../../assets/images/not-found.png";

export default {
  name: 'NotFoundPage',
  data: () => {
    return { notfoundImage };
  },
}
</script>

<style>
.notFound-margin {
    margin: 2vw;
}
.notFound-fontSize {
    font-size: 30px;
}
.notFound-text {
  text-decoration: none;
  color: black
}
</style>