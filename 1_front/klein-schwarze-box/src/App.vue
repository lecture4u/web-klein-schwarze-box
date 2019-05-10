<template>
  <div id="app">
    <siteHeader />
    <section class="site-content">
      <div>
        <router-view/>
      </div>
    </section>
    <siteFooter />
    <layerTemplate v-if="$store.state.layerState" :layerContent="$store.state.layerState" />
  </div>
</template>

<script>
  import siteHeader from '@/components/template/header.vue'
  import siteFooter from '@/components/template/footer.vue'
  import layerTemplate from '@/components/template/layer-template.vue'
  export default {
    components: { siteHeader, siteFooter, layerTemplate },
    created () {
    }
  }
</script>

<style lang="scss" src="@/assets/scss/common.scss"></style>