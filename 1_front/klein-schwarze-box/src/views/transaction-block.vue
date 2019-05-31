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
              <h4>트랜잭션 생성 #{{Object.keys(list).length + 1}}</h4>
            </li>
            <li>
              <label class="input-label">
                <span class="pre"><i class="fas fa-pen"></i></span>
                <input type="text" class="full-width" ref="title" v-model="title" size="80" required />
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
                    <tr v-for="(v, k) in list" :key="k" @click.prevent="selectItem(k)" :class="{active: selectedItem === k}">
                      <td v-html="k + 1" />
                      <td>
                        {{v.title}}
                      </td>
                      <td v-html="contentPreview(v.description, 40)" />
                      <td v-html="contentPreview(v.hashed, 40)" />
                    </tr>
                  </tbody>
                </table>
              </li>
              <li>
              <button type="submit" class="btn full submit" @click.prevent="postTransaction()">Merkle Tree 생성하기</button>
            </li>
            </ul>
            <div class="btn-group center btm" v-if="selectedItem !== null">
              <button type="button" class="btn delete" @click.prevent="deleteItem">삭제하기</button>
            </div>
          </section>
        </fieldset>
        <div class="btn-group">
          <button type="button" class="btn default" @click.prevent="getNonce()">getNonce</button>
          <button type="button" class="btn default" @click.prevent="getPreviousBlockHash()">Get Previous Hash</button>
          <button type="button" class="btn default" @click.prevent="getMerkleRoot()">Add to block</button>
        </div>
      </form>
      <ul class="fields">
          <li>
            <h4>Block Hash - hash</h4>
          </li>
          <li>
            <label class="input-label">
              <span class="pre"><i class="fas fa-pen"></i></span>
              <input type="text" class="full-width" v-model="nonce" size="80" required />
              <span class="lbl">Nonce(with consensus)</span>
            </label>
          </li>
          <li>
            <label class="input-label">
              <span class="pre"><i class="fas fa-pen"></i></span>
              <input type="text" class="full-width" v-model="prevBlockHash" size="80" required />
              <span class="lbl">Previous Block Hash</span>
            </label>
          </li>
          <li>
            <label class="input-label">
              <span class="pre"><i class="fas fa-pen"></i></span>
              <input type="text" class="full-width" v-model="merkleTreeRoot" size="80" required />
              <span class="lbl">Merkle Tree Root</span>
            </label>
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
        title: '',
        list: [],
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
      async insertItem () {
        await this.getHash(this.title)
        const {title, description, hashed} = this.$data
        this.list.push({title, description, hashed})
        this.title = this.description = this.hashed = ''
        this.$refs.title.focus()
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

