import { instance } from './index'

// 챌린지를 생성하는 API
function createChallenge(challengeData) {
  return instance.post('/api/challellge/register/new-challenge', challengeData)
}

// 특정 챌린지 1개를 조회하는 API
function challengeDetail(challengeId) {
  return instance.get(`/api/challenge/${challengeId}`)
}

// 뱃지를 조회하는 API
function badgeList(badgeData) {
  return instance.get('/api/badge/list', badgeData)
}

// 유저 챌린지 정보를 불러오는 API
function userChallenge(myData) {
  return instance.get('/api/challenge/search/user', myData)
}

export { 
  createChallenge,
  badgeList,
  challengeDetail,
  userChallenge,
}