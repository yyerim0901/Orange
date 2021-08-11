import axios from 'axios'

function registerUser(userData) {
  const url = 'http://i5b102.p.ssafy.io:8181/api/user/signup'
  return axios.post(url, userData)
}

export { registerUser }