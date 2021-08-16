import { instance } from './index'

// 챌린지를 생성하는 API
function createChallenge(challengeData) {
  return instance.post('/api/challellge/register/new-challenge', challengeData)
}

// 뱃지를 조회하는 API
function badgeList(badgeData) {
  return instance.get('/api/badge/list', badgeData)
}

export { 
  createChallenge,
  badgeList,
}