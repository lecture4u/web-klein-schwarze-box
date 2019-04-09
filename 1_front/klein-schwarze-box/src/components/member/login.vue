<template>
  <section class="login-box">
    <h3 class="layer-title">로그인</h3>
    <ul>
      <li v-for="(v, k) in members" :key="k" @click="login(v)">
        <span class="image" :style="{background: `url(${v.photo_url}) no-repeat center / cover`}" />
        <span class="name" v-html="v.name" />
        <span class="email" v-html="v.email" />
      </li>
    </ul>
  </section>
</template>

<script>
  import Api from '@/middleware/Api.js'
  export default {
    data () {
      return {
        members: [
          {idx: 1, id: 'test1', name: '이요셉', email: 'yoseplee@dankook.ac.kr', photo_url: require('@/assets/no-profile.jpg')},
          {idx: 2, id: 'test2', name: '이승민', email: 'dltmdals1119@gmail.com', photo_url: require('@/assets/no-profile.jpg')},
          {idx: 3, id: 'test3', name: '나성현', email: 'nasunguri@naver.com', photo_url: require('@/assets/no-profile.jpg')},
          {idx: 4, id: 'test4', name: '최동빈', email: 'dbchoi@gmail.com', photo_url: require('@/assets/no-profile.jpg')},
          {idx: 5, id: 'test5', name: '김강주', email: 'kangjukim14@naver.com', photo_url: require('@/assets/no-profile.jpg')}
        ]
      }
    },
    methods: {
      async login (member) {
        const data = await Api.postMember(member)
        this.$store.commit('loggedIn', data.member)
        this.$store.commit('closeLayer')
      }
    }
  }
</script>