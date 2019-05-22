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
            <h4>2. Asymmetric Cryptography</h4>
          </a>
          <div v-show="step===2">
            <div class="description">
              <h4>About asymmetric Cryptography</h4>
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
            <h4>3. Digital Signature</h4>
          </a>
          <div v-show="step===3">
            <div class="description">
              <h4>About Digital Signature</h4>
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
                      <button type="submit" class="btn full submit content-format" @click.prevent="testSubmit">Generate Hash</button>
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
                  <h4>Public Key</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="publicKey" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Private Key</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="privateKey" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
            <fieldset>
              <legend>SECURITY</legend>
              <ul class="fields">
                <li>
                  <h4>Encryption</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="plainText" size="80" required>
                      <span class="lbl">암호화 할 값을 입력하세요(PlainText)</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="testSubmit">Encryption Button</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashed" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Decryption</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="cipherText" size="80" required>
                      <span class="lbl">암호화 된 데이터(CipherText)</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="testSubmit">Decryption Button</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="hashed" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
          </div>
          <div v-show="step === 3">
            <h4>Sorry! We are work in progress</h4>
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
      text: "",
      toHash: "",
      step: 2,
      hashed: "",
      privateKey: "",
      publicKey: "",
      plainText: "",
      cipherText: ""
    }
  },
  methods: {
    async testSubmit() {
      this.hashed = (await Api.getHash(this.toHash)).data
    },
    async getKeyPair() {
      const priKey = "abc";
      const pubKey = "def";
      this.privateKey = priKey;
      this.publicKey = pubKey;
    },
    goToStep(num) {
      if(num == 2 ) this.getKeyPair()
      this.step = num;
    }
  }
};
</script>

