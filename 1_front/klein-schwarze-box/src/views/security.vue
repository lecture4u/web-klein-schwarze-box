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
                  <h4>{{encryptionMode}} Key Encryption</h4>
                </li>
                <li>
                  <span>
                    <input type="radio" id="encrypt_public" name="encryptionType" value="public" v-model="encryptionMode">
                    <label for="encrypt_public">Public Key</label>
                  </span>
                  <span>
                    <input type="radio" id="encrypt_private" name="encryptionType" value="private" v-model="encryptionMode">
                    <label for="encrypt_private">Private Key</label>
                  </span>
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
                      <button type="submit" class="btn full submit content-format" @click.prevent="cryptoControl('encrypt')">Encryption Button</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="cipherText" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>{{decryptionMode}} Decryption</h4>
                </li>
                <li>
                  <span>
                    <input type="radio" id="decrypt_public" name="decryptionType" value="public" v-model="decryptionMode">
                    <label for="decrypt_public">Public Key</label>
                  </span>
                  <span>
                    <input type="radio" id="decrypt_private" name="decryptionType" value="private" v-model="decryptionMode">
                    <label for="decrypt_private">Private Key</label>
                  </span>
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
                      <button type="submit" class="btn full submit content-format" @click.prevent="cryptoControl('decrypt')">Decryption Button</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="decrypted" size="80" required>
                    </div>
                  </label>
                </li>
              </ul>
            </fieldset>
          </div>
          <div v-show="step === 3">
            <fieldset>
              <legend>Asymmetric Key Generation</legend>
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
              <legend>DITIGAL SIGNATURE</legend>
              <ul class="fields">
                <li>
                  <h4>Sender</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="plainText" size="80" required>
                      <span class="lbl">상대방에게 전송할 데이터를 입력하세요</span>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll left">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="Hashed" size="80" required>
                      <span class="lbl">전송할 데이터의 Hash값입니다</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="">Generate Signature</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="cipherText" size="80" required>
                      <span class="lbl">생성된 Digital Signature</span>
                    </div>
                  </label>
                </li>
              </ul>
              <ul class="fields">
                <li>
                  <h4>Receiver</h4>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="plainText" size="80" required>
                      <span class="lbl">Received Data</span>
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
                      <span class="lbl">Hash of received data</span>
                    </div>                    
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="cipherText" size="80" required>
                      <span class="lbl">Received Digital Signature</span>
                    </div>
                    <div class="coll right">
                      <button type="submit" class="btn full submit content-format" @click.prevent="cryptoControl('decrypt')">Check Signature</button>
                    </div>
                  </label>
                </li>
                <li>
                  <label class="input-label linear">
                    <div class="coll">
                      <span class="pre">
                        <i class="fas fa-pen"></i>
                      </span>
                      <input type="text" class="full-width" ref="title" v-model="decrypted" size="80" required>
                      <span class="lbl">Decrypted Digital Signature</span>
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
      text: "",
      toHash: "",
      step: 3,
      hashed: "",
      privateKey: "",
      publicKey: "",
      plainText: "",
      cipherText: "",
      decrypted: "",
      encryptionMode: "public",
      decryptionMode: "private",
      test: ""
    }
  },
  methods: {
    async testSubmit() {
      this.hashed = (await Api.getHash(this.toHash)).data
    },
    async getKeyPair() {
      const obj = await Api.getKey()
      const priKey = obj.prikey
      const pubKey = obj.pubkey
      this.privateKey = priKey
      this.publicKey = pubKey
    },
    async getPubEncryption() {
      const obj = (await(Api.postPubEncryption({
        data: this.plainText,
        pubKey: this.publicKey,
        priKey: this.privateKey
      })))
      this.cipherText = obj.cipherText
    },
    async getPriDecryption() {
      const obj = (await(Api.postPriDecryption({
        data: this.cipherText,
        pubKey: this.publicKey,
        priKey: this.privateKey
      })))
      this.decrypted = obj.decrypted
    },
    async getPriEncryption() {
      const obj = (await(Api.postPriEncryption({
        data: this.plainText,
        pubKey: this.publicKey,
        priKey: this.privateKey
      })))
      this.cipherText = obj.cipherText
    },
    async getPubDecryption() {
      const obj = (await(Api.postPubDecryption({
        data: this.cipherText,
        pubKey: this.publicKey,
        priKey: this.privateKey
      })))
      this.decrypted = obj.decrypted
    },
    async cryptoControl(params) {
      //controls encryption and decryption
      if (params === "encrypt") {
        if (this.encryptionMode === "public") {
          //do public encryption
          await this.getPubEncryption()
        } else if (this.encryptionMode === "private") {
          //do private encryption
          await this.getPriEncryption()
        }  
      } else if (params === "decrypt") {
        if (this.decryptionMode === "public") {
          //do public decryption
          await this.getPubDecryption()
        } else if (this.decryptionMode === "private") {
          //do private decryption
          await this.getPriDecryption()
        }
      }
    },
    goToStep(num) {
      if(num == 2 | num == 3) this.getKeyPair()
      this.step = num;
    }
  }
};
</script>

