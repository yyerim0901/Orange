<template>
  <div>
    {{ searched }}
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Search',
  data() {
    return {
      query: '',
      searched: [],
    }
  },
  created() {
    this.query = this.$router.params.query
    axios.get(`http://i5b102.p.ssafy.io:8181/api/challenge/search/title/${query}`,)
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
      // 머지
  }
}
</script>

<style>

</style>