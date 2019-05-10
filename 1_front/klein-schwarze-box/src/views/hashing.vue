<template>
  <section class="consensus create">
      <form action="" method="post" @submit.prevent="test">
        <fieldset><legend>DEV PAGE</legend>
        <ul class="fields">
            <li>
              <label class="input-label">
                  <span class="pre"><i class="fas fa-pen"></i></span>
                  <input type="text" class="full-width" ref="title" v-model="testInput" size="80" required />
                  <span class="lbl">값을 입력하세요</span>
              </label>
            </li>
            <li>
              <button type="submit" class="btn full submit" @click.prevent="testSubmit">테스트확인 {{text}}</button>
            </li>
        </ul>
        </fieldset>
      </form>
  </section>
</template>

<script>
  // import Api from '@/middleware/Api'
  export default {
    created() {
    },
    data () {
      return {
        text: '',
        testInput: ''
      }
    },
    methods: {
      testSubmit() {
        this.text = this.testInput
      }
    }
  }
</script>

