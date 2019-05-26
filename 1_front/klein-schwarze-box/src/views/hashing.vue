<template>
  <section class="content">
    <aside class="left-guide">
      <ul class="fields">
        <li>
          <a href="#" @click.prevent="goToStep(1)">
            <h4>1. Hash</h4>
          </a>
          <div v-show="step === 1">
            <div class="description">
              <h4>About Hash Function</h4>
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
        <li>
          <a href="#" @click.prevent="goToStep(2)">
            <h4>2. Nonce Hashing</h4>
          </a>
          <div v-show="step===2">
            <div class="description">
              <h4>About Nonce Hashing</h4>
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
        <li>
          <a href="#" @click.prevent="goToStep(3)">
            <h4>3. Hash+Hash Hashing</h4>
          </a>
          <div v-show="step===3">
            <div class="description">
              <h4>About Hash of hash</h4>
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
      <form action method="post" @submit.prevent="test">
        <div class="program-wrapper">
          <div v-show="step === 1">
            <fieldset>
              <legend>SECURITY</legend>
              <ul class="fields">
                <li>
                  <h4>Data</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="toHash" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="getHash(toHash)">Generate Hash</button>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Hash</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashed" size="80" required>
                      <span class="lbl">Hash된 결과(Digested)</span>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
          </div>
          <div v-show="step === 2">
            <fieldset>
              <legend>SECURITY</legend>
              <ul class="fields">
                <li>
                  <h4>Data</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="data" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                  </label>
                </li>
                <li>
                  <h4>Nonce</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="nonce" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                  </label>
                </li>
                <li>
                  <h4>Nonce + Data</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="noncedata" size="80">
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="getHash(noncedata)">Generate Hash</button>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Hash</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashed" size="80" required>
                      <span class="lbl">Hash된 결과(Digested)</span>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
          </div>
          <div v-show="step === 3">
            <fieldset>
              <legend>SECURITY</legend>
              <ul class="fields">
                <li>
                  <h4>Data</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="toHash" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="getHash(toHash)">Generate Hash</button>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Hash</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashed" size="80" required>
                      <span class="lbl">Hash된 결과(Digested)</span>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
            <fieldset>
              <legend>SECURITY</legend>
              <ul class="fields">
                <li>
                  <h4>Hash1</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="data" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                  </label>
                </li>
                <li>
                  <h4>Hash2</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="data2" size="80" required>
                      <span class="lbl">값을 입력하세요</span>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Result Hash(Hash of Hashes)</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashofhash" size="80" required>
                      <span class="lbl">Hash된 결과(Digested)</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="getHashofhash(concat(data, data2))">Generate Hash</button>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
          </div>
        </div>
      </form>
    </div>
  </section>
</template>

<script>
import Api from '@/middleware/Api'
export default {
  created() {},
  data() {
    return {
      data: "",
      data2: "",
      nonce: 0,
      toHash: "",
      hashed: "",
      hashofhash: "",
      step: 3
    }
  },
  methods: {
    async getHash(params) {
      this.hashed = (await Api.getHash(params)).data
    },
    async getHashofhash(params) {
      this.hashofhash = (await Api.getHash(params)).data
    },
    concat(str1, str2) {
      return str1+''+str2
    },
    goToStep(num) {
      this.step = num;
    }
  },
  computed: {
    noncedata: function() {
      return this.nonce + this.data
    }
  }
};
</script>

