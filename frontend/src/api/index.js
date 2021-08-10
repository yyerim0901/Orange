import axios from 'axios'

function registerUser() {
  const url = 'http://i5b102.p.ssafy.io:8181/api/user/signup'
  axios.post(url)
}
