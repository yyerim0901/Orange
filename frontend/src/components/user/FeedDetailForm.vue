<template>
  <v-container>
    <v-card outlined>
      <v-row d-flex>
        <v-col outlined>
          <v-img
            src='https://cdn.vuetifyjs.com/images/cards/house.jpg'
            height="500"
            max-width="600"
          >
          </v-img>
        </v-col>
        <v-col>
          <v-card-title>{{ feedItems.title }}</v-card-title>
          <v-card-subtitle class="mt-1">{{ feedItems.articleContent }}</v-card-subtitle>
          <v-divider></v-divider>
          <v-card-text
            v-for="(CommentItem, index) in CommentItems"
            :key="index"
            height="400"
            max-height="400"
          >
            🍊 : {{ CommentItem.commentContent }}
            <!-- <p class="text-end data-color">{{ CommentItem.commentWritetime| moment('YYYY-MM-DD')}}&nbsp;</p> -->
          </v-card-text>
          <v-text-field
            v-model="commentContent"
            label="comment"
          >
          </v-text-field>
          <v-btn text @click="newComment">작성</v-btn>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'
import { createComment } from '@/api/challenge'
export default {
  name: 'FeedDetailForm',
  data() {
    return {
      feedItems: [],
      CommentItems: [],
      commentContent: '',
      user: this.$store.state.data2,
      articleId: this.$route.params.id,
    }
  },
  methods: {
    async getFeed() {
      try {
        const articleId = this.$route.params.id
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/article/challenge/${articleId}`)
        console.log(data[0])
        this.feedItems = data[0]
      } catch (err) {
        console.log(err)
      }
    },
    async getComment() {
      try {
        const articleId = this.$route.params.id
        const { data } = await axios.get(`http://i5b102.p.ssafy.io:8181/api/comment/article/${articleId}`)
        console.log(data)
        this.CommentItems = data
      } catch (err) {
        console.log(err)
      }
    },
    newComment() {
      const commentData = {
        articleId: this.articleId,
        commentContent: this.commentContent,
        user: this.user,
      }
      axios.post('http://i5b102.p.ssafy.io:8181/api/comment/create', {commentData})
        .then(res =>{
          console.log(res)
        })
        .catch(err =>{
          console.error(err)
        })
      console.log(commentData)
    },

  },
  created() {
    this.getFeed()
    this.getComment()
  }
}
</script>

<style>
.data-color {
  color: gray;
}
</style>