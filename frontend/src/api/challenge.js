import { instance } from './index'

// 챌린지를 생성하는 API
function createChallenge(challengeData) {
  return instance.post('/api/challellge/register/new-challenge', challengeData)
}

export { createChallenge };