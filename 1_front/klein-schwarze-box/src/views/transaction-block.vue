<template>
  <section class="content">
    <aside class="left-guide">
      <ul class="fields">
        <li>
          <a href="#">
            <h4>Transactions</h4>
          </a>
          <div>
            <div class="description">
              <h4>About Transacntion</h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sem ex, maximus at consectetur a, ornare ut
                mauris. Nam iaculis aliquam sem. Vivamus id lacus maximus, semper purus posuere, sagittis tellus. Morbi
                dapibus a ex eu ornare. Aliquam vestibulum dapibus purus scelerisque tincidunt. Ut lobortis, ligula sit amet
                ornare dapibus, enim purus venenatis urna, at laoreet nisl turpis a dui. Vestibulum imperdiet augue quis
                vestibulum tincidunt.
              </p>
            </div>
            <div class="description">
              <h4>Instruction</h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sem ex, maximus at consectetur a, ornare ut
                mauris. Nam iaculis aliquam sem. Vivamus id lacus maximus, semper purus posuere, sagittis tellus. Morbi
                dapibus a ex eu ornare. Aliquam vestibulum dapibus purus scelerisque tincidunt. Ut lobortis, ligula sit amet
                ornare dapibus, enim purus venenatis urna, at laoreet nisl turpis a dui. Vestibulum imperdiet augue quis
                vestibulum tincidunt.
              </p>
            </div>
          </div>
        </li>
      </ul>
    </aside>
    <div class="program">
      <form action="" method="post" @submit.prevent="insertItem">
        <fieldset><legend>트랜잭션 생성</legend>
          <ul class="fields">
            <li>
              <h4>트랜잭션 생성</h4>
            </li>
            <li>
              <label class="input-label">
                <span class="pre"><i class="fas fa-pen"></i></span>
                <input type="text" class="full-width" ref="title" v-model="title" size="80" required />
                <span class="lbl">아이템 이름</span>
              </label>
            </li>
            <li>
              <button type="submit" class="btn full submit">트랜잭션 추가하기</button>
            </li>
          </ul>
          <section class="item-list">
            <ul class="fields">
              <li>
                <h4>등록된 아이템</h4>
              </li>
              <li>
                <table>
                  <colgroup>
                    <col v-for="(n, k) in [50, 50]" :key="k" :width="`${n}%`" />
                  </colgroup>
                  <thead>
                    <tr>
                      <th v-for="(lbl, k) in ['트랜잭션 번호', '값']" :key="k" v-html="lbl" />
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(v, k) in list" :key="k" @click.prevent="selectItem(k)" :class="{active: selectedItem === k}">
                      <td v-html="k + 1" />
                      <td>
                        <span class="color-label" :style="`background:${v.color}`"></span>
                        {{v.title}}
                      </td>
                      <td v-html="contentPreview(v.description, 40)" />
                    </tr>
                  </tbody>
                </table>
              </li>
            </ul>
            <div class="btn-group center btm" v-if="selectedItem !== null">
              <button type="button" class="btn delete" @click.prevent="deleteItem">삭제하기</button>
            </div>
          </section>
        </fieldset>
      </form>
    </div>
  </section>
</template>

<script>
// import Api from '@/middleware/Api'
export default {
    created (){ 
      this.setColor()
    },
    data () {
      return {
        title: '',
        list: [],
        description: '',
        selectedItem: null,
      }
    },
    methods: {
      insertItem () {
        const {title, description, reg_date = this.getNow()} = this.$data
        this.list.push({title, description, reg_date})
        this.title = this.description = ''
        this.$refs.title.focus()
      },
      selectItem (key) { this.selectedItem = this.selectedItem === key ? null  : key },
      deleteItem () {
        this.list.splice(this.selectedItem, 1)
        this.selectedItem = null
        this.setColor()
      }
    }
  }
</script>

