<template>
    <img
        class="kakao_btn"
        src="@/assets/images/kakao_login_medium_wide.png"
        @click="loginWithKakao"
    />
</template>

<script>
export default {
    name: "LoginKakao",
    methods: {
        loginWithKakao() {
            const params = {
                redirectUri: "http://localhost:8080/auth/kakao/callback",
            };
            window.Kakao.Auth.authorize(params);
        },
    },
};
</script>