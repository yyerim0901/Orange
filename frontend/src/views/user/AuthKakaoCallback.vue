<template>
  <div>
  </div>
</template>
<script>
export default {
  methods: {
    getParameterByName: function (name) {
      name = name.replace(/[[]/, "\\[").replace(/[\]]/, "\\]");
      var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
      return results == null
        ? ""
        : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
  },
  beforeMount() {
    const code = this.getParameterByName("code");
    alert(code);
    var details = {
      grant_type: "authorization_code",
      client_id: "7366b5af072a0f66a3be9fa5278e3bfe",
      redirect_uri: "http://localhost:8080/auth/kakao/callback",
      code: code,
    };
    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    fetch("https://kauth.kakao.com/oauth/token", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
      },
      body: formBody,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(JSON.stringify(data));
        alert(JSON.stringify(data));
        window.Kakao.Auth.setAccessToken(data.access_token);
        // test : Token
        alert(window.Kakao.Auth.getAccessToken());
        location.href = "/"
      });
  },
};
</script>