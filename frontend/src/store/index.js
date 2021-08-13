import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // token
    data1: '',
    // userid
    data2: '',
    
  },
  getters: {
    isLogin(state) {
      return state.data2 !== '';
    }
  },
  mutations: {
    setToken(state, data1) {
      state.data1 = data1
    },
    setUserId(state, data2) {
      state.data2 = data2
    },
    clearUserId(state) {
      state.data2 = '';
    }
  },
})