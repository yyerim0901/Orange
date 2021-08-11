import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://i5b102.p.ssafy.io:8181'
})

function registerUser(userData) {
  return instance.post('/api/user/signup', userData)
}

function loginUser() {
  return instance.post('')
}



export { registerUser }