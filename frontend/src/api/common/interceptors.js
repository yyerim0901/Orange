import store from "@/store/index";

export function setInterceptors(instance) {
  // 요청 인터셉터 추가
  instance.interceptors.request.use(
    function (config) {
      config.headers.Authrozation = store.state.data;
      return config;
    },
    function (error) {
      return Promise.reject(error);
    }
  );
    
    // 응답 인터셉터 추가
  instance.interceptors.response.use(
    function (response) {
      return response;
    },
    function (error) {
      return Promise.reject(error);
    }
  );
  return instance;
}