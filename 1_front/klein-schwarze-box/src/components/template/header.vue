<template>
  <header class="site-header">
    <div class="container">
      <h3 class="logo"><router-link to="/"><img src="@/assets/abc-logo.png" alt="abc"></router-link></h3>
      <nav class="gnb">
        <router-link to="/#">Security</router-link>
        <router-link to="/#">Hashing</router-link>
        <router-link to="/#">Transaction & Block</router-link>
        <router-link to="/#">Wallet</router-link>
        <router-link to="/#">Blockchain</router-link>
        <router-link to="/#">Contributor</router-link>
      </nav>
    </div>
  </header>
</template>

<script>
  import Api from '@/middleware/Api.js'
  export default {
    methods: {
      async signInByGoogle () {
        // google 에서 user 정보 가져오기 
        const user = await this.$gAuth.signIn()
        const member = {
          access_token: user.Zi.access_token,
          id: user.El,
          name: user.w3.ig,
          email: user.w3.U3,
          photo_url: user.w3.Paa
        }

        // DB에 회원 정보 등록 및 가져오기
        const memberData = await Api.postMember(member)

        // store에 저장 및 layer 닫기
        this.$store.commit('loggedIn', memberData.member)
      },
      logout () {
        this.$store.commit('logout')
        this.$router.push('/')
      }
    }
  }
</script>
