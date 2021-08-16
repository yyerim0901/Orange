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

export { 
  createChallenge,
  badgeList,
  challengeDetail
}