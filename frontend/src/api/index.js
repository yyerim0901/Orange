import axios from 'axios';
import { setInterceptors } from './common/interceptors';

// 엑시오스 초기화 함수
function createInstance() {
  const instance = axios.create({
    baseURL: 'http://i5b102.p.ssafy.io:8181',
  })
  return setInterceptors(instance);
}
const instance = createInstance();

// 회원가입 API
function registerUser(userData) {
  return instance.post('/api/user/signup', userData)
}

// 로그인 API
function loginUser(userData) {
  return instance.post('/api/user/login', userData)
}

// 챌린지를 생성하는 API
function createChallenge(challengeData) {
  return instance.post('/api/challellge/register/new-challenge', challengeData)
}


// 메인 피드 인기 탭 API, 랭킹 조회 API
function popularMain(challengeData) {
  return instance.get('/api/challenge/ranking/point', challengeData)
}

// 메인 피드 신규 탭 API
function newMain(challengeData) {
  return instance.get('/api/challenge/ranking/startdate', challengeData)
}

export { registerUser, loginUser, createChallenge, popularMain, newMain };