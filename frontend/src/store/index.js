import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    data: '',
  },
  getters: {

  },
  mutations: {
    setToken(state, data) {
      state.data = data
    }
  },
})