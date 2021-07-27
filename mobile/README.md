# 프로젝트 오렌지 안드로이드 개발



## 2021 07 26

- 안드로이드 멀티 모듈 구조 셋팅
- 안드로이드 의존성 정리
- 안드로이드 플러그인 정리

- ui-noti 작성 fragment -notification  작성 (state pattern)

## 2021 07 27

- 안드로이드 필수 ui-module 구성
- 카카오 SDK Login 도입

```kotlin
    private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "로그인 실패", error)
            requireContext().toast("이런")
            requireActivity().finish()
        } else if (token != null) {
            Log.i(TAG, "로그인 성공 ${token.accessToken}")
            loginViewModel.sendTokenToServer(token)
        }
    }

private fun auth() {
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
        UserApiClient.instance.loginWithKakaoTalk(requireContext(), callback = callback)
    } else {
        UserApiClient.instance.loginWithKakaoAccount(requireContext(), callback = callback)
    }
}
```

- 흐름 작성을 할 것, 안드로이드 DI Hilt 도입
