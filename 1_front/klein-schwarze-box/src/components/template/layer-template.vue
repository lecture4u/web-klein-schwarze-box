<template>
  <div class="layer">
    <span class="middle"></span><div class="box">
      <a class="close" href="#" @click.prevent="$store.commit('closeLayer')">
        <i class="fas fa-times"></i>
      </a>
      <component :is="layerContent"></component>
    </div>
  </div>
</template>

<script>
  import loginBox from '@/components/member/login.vue'
  export default {
    components: { loginBox },
    props: ['layerContent']
  }
</script>