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
      <form action="" method="post" @submit.prevent="insertWallet1">
        <fieldset><legend>Wallet1</legend>
          <ul class="fields">
            <li>
              <h4>Wallet #1</h4>
            </li>
            <li>
              <label class="input-label">
                <span class="pre"><i class="fas fa-pen"></i></span>
                <input type="text" class="full-width" ref="title" v-model="wallet1_title" size="80" required />
                <span class="lbl">트랜잭션 값을 입력하세요</span>
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
                      <th v-for="(lbl, k) in ['트랜잭션 번호', '값', 'Hash']" :key="k" v-html="lbl" />
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(v, k) in wallet1_list" :key="k" @click.prevent="selectItem(k)" :class="{active: selectedItem === k}">
                      <td v-html="k + 1" />
                      <td>
                        {{v.wallet1_title}}
                      </td>
                      <td v-html="contentPreview(v.description, 40)" />
                      <td v-html="contentPreview(v.hashed, 40)" />
                    </tr>
                  </tbody>
                </table>
              </li>
            </ul>
          </section>
        </fieldset>
      </form>
      <form action="" method="post" @submit.prevent="insertWallet2">
        <fieldset><legend>Wallet2</legend>
          <ul class="fields">
            <li>
              <h4>Wallet #2</h4>
            </li>
            <li>
              <label class="input-label">
                <span class="pre"><i class="fas fa-pen"></i></span>
                <input type="text" class="full-width" ref="title" v-model="wallet2_title" size="80" required />
                <span class="lbl">트랜잭션 값을 입력하세요</span>
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
                      <th v-for="(lbl, k) in ['트랜잭션 번호', '값', 'Hash']" :key="k" v-html="lbl" />
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(v, k) in wallet2_list" :key="k" @click.prevent="selectItem(k)" :class="{active: selectedItem === k}">
                      <td v-html="k + 1" />
                      <td>
                        {{v.wallet2_title}}
                      </td>
                      <td v-html="contentPreview(v.description, 40)" />
                      <td v-html="contentPreview(v.hashed, 40)" />
                    </tr>
                  </tbody>
                </table>
              </li>
            </ul>
          </section>
        </fieldset>
      </form>
      <form action="" method="post" @submit.prevent="insertWallet3">
        <fieldset><legend>Wallet3</legend>
          <ul class="fields">
            <li>
              <h4>Wallet #3</h4>
            </li>
            <li>
              <label class="input-label">
                <span class="pre"><i class="fas fa-pen"></i></span>
                <input type="text" class="full-width" ref="title" v-model="wallet3_title" size="80" required />
                <span class="lbl">트랜잭션 값을 입력하세요</span>
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
                      <th v-for="(lbl, k) in ['트랜잭션 번호', '값', 'Hash']" :key="k" v-html="lbl" />
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(v, k) in wallet3_list" :key="k" @click.prevent="selectItem(k)" :class="{active: selectedItem === k}">
                      <td v-html="k + 1" />
                      <td>
                        {{v.wallet3_title}}
                      </td>
                      <td v-html="contentPreview(v.description, 40)" />
                      <td v-html="contentPreview(v.hashed, 40)" />
                    </tr>
                  </tbody>
                </table>
              </li>
            </ul>
          </section>
        </fieldset>
      </form>
        <ul class="fields">
          <li>
            <button type="submit" class="btn full submit" @click.prevent="postTransaction()">Block추가하기</button>
          </li>
        </ul>
    </div>
  </section>
</template>

<script>
import Api from '@/middleware/Api'
export default {
    created (){ 
    },
    data () {
      return {
        wallet1_title: '',
        wallet2_title: '',
        wallet3_title: '',
        list: [],
        wallet1_list: [],
        wallet2_list: [],
        wallet3_list: [],
        description: '',
        selectedItem: null,
        hashed: '',
        merkletree: [],
        nonce: '',
        prevBlockHash: '',
        merkleTreeRoot: '',
        blockHeader: []
      }
    },
    methods: {
      async insertWallet1 () {
        await this.getHash(this.wallet1_title)
        const {wallet1_title, description, hashed} = this.$data
        this.wallet1_list.push({wallet1_title, description, hashed})
        this.wallet1_title = this.description = this.hashed = ''
        this.$refs.wallet1_title.focus()
      },
      async insertWallet2 () {
        await this.getHash(this.wallet2_title)
        const {wallet2_title, description, hashed} = this.$data
        this.wallet2_list.push({wallet2_title, description, hashed})
        this.wallet2_title = this.description = this.hashed = ''
        this.$refs.wallet2_title.focus()
      },
      async insertWallet3 () {
        await this.getHash(this.wallet3_title)
        const {wallet3_title, description, hashed} = this.$data
        this.wallet3_list.push({wallet3_title, description, hashed})
        this.wallet3_title = this.description = this.hashed = ''
        this.$refs.wallet3_title.focus()
      },
      selectItem (key) { this.selectedItem = this.selectedItem === key ? null  : key },
      deleteItem () {
        this.list.splice(this.selectedItem, 1)
        this.selectedItem = null
        this.setColor()
      },
      async getHash(params) {
        this.hashed = (await Api.getHash(params)).data
        return this.hashed
      },
      makeMerkleTree() {
        let obj = []
        obj.push(0)
      },
      async postTransaction() {
        const obj = (await(Api.postTransaction({
          data: this.list
        })))
        this.blockHeader = obj;
      },
      getNonce() {
        this.nonce = this.blockHeader.nonce
      },
      async getPreviousBlockHash() {
        // const buffer = this.blockHeader.previousBlockHash
        // this.prevBlockHash = await this.getHash(buffer)
        this.prevBlockHash = this.blockHeader.previousBlockHash
      },
      getMerkleRoot() {
        this.merkleTreeRoot = this.blockHeader.merkleTreeRoot
      }
    }
  }
</script>

