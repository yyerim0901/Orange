import Vue from "vue";
import VueRouter from "vue-router";


Vue.use(VueRouter);

const routes = [
  {
    path: '/authentication',
    component: () => import('@/layouts/authentication/Index.vue'),
    children: [
      {
        path: 'login',
        name: 'Login',
        component: () => import('@/views/user/LoginPage.vue'),
      },
      {
        path: 'sign-up',
        name: 'Signup',
        component: () => import('@/views/user/SignupPage.vue'),
      },
    ]
  },
  {
    path: '/',
    component: () => import('@/layouts/main/Index.vue'),
    children: [
      {
        path: '',
        name: 'IndexFeed',
        component: () => import('@/views/feed/IndexFeed.vue'),
      },
      {
        path: 'profile',
        name: 'Profile',
        component: () => import('@/views/user/Profile.vue'),
      },
      {
        path: 'profile/introduce',
        name: 'Profile',
        component: () => import('@/views/feed/Introduce.vue'),
      },
      {
        path: 'create-challenge',
        name: 'CreateChallenge',
        component: () => import('@/views/feed/CreateChallenge.vue')
      },
      {
        path: 'challenge',
        name: 'ChallengeFeed',
        component: () => import('@/views/feed/ChallengeFeed.vue'),
      },
      {
        path: 'create-feed',
        name: 'CreateFeed',
        component: () => import('@/views/feed/CreateFeed.vue'),
      },
      {
        path: 'ranking',
        name: 'Ranking',
        component: () => import('@/views/feed/Ranking.vue'),
      },
    ]
  },
  {
    path: '*',
    redirect: '/NotFoundPage'
  },
  {
    path: '/NotFoundPage',
    component: () => import('@/views/user/NotFoundPage.vue'),
  },
  // kakao callback
  {
    path: '/auth/kakao/callback',
    name: 'AuthKakaoCallback',
    component: () => import('@/views/user/AuthKakaoCallback.vue')
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
