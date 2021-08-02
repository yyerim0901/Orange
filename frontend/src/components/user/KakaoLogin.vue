<template>
  <div>
    <a id="custom-login-btn" href="javascript:loginWithKakao()">
      <img
        src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
        width="222"
      />
    </a>
  </div>
</template>

<script>
export default {
  name: 'KakaoLogin',
  data: function () {
    return {
      accessToken: window.Kakao.Auth.getAccessToken(),
    };
  },
  methods: {
    logout(type) { // 카카오 로그아웃
      window.Kakao.Auth.logout(function () {
        if (type) { // "unlink"
          alert("Unlinked Kakao Account!");
        } else {
          alert("Logout Account!");
        }
        router.push("login");
      });
    },
    unlink() {  // 카카오 계정 연결끊기
      let logout = this.logout;
      window.Kakao.API.request({
        url: "/v1/user/unlink",
        success: function (response) {
          console.log(response);
          logout("unlink");
        },
        fail: function (error) {
          console.log(error);
          alert(error);
          return;
        },
      });
    },
  },
  watch: {
    accessToken: function () { // 토큰이 변경 확인
      console.log(this.accessToken);
    },
    $route(to) { // 라우트 변경 될때 마다 확인하여 (로그인체크)
      this.accessToken = window.Kakao.Auth.getAccessToken();
      if (to.name != "Login" && to.name != "AuthKakaoCallback") {
        if (!this.accessToken) {
          console.log("Not logged in.");
          location.href = "/login";
        }
      }
    },
  },
  beforeMount() { // 최초 한번만 호출
    console.log(router.currentRoute);
  },
};
</script>

<style>

</style>