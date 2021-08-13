import axios from 'axios';
import { setInterceptors } from './common/interceptors';


function createInstance() {
  const instance = axios.create({
    baseURL: 'http://i5b102.p.ssafy.io:8181',
  })
  return setInterceptors(instance);
}


const instance = createInstance();

function registerUser(userData) {
  return instance.post('/api/user/signup', userData)
}

function loginUser(userData) {
  return instance.post('/api/user/login', userData)
}


export { registerUser, loginUser };