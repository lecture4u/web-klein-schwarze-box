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
                Hash 함수는 한 입력에 대해 n자리의 수학적으로 거의 유일한 값을 출력하는 함수이다. <br>
                출력된 값으로 본래 입력 값을 유추할 수 없다는 제2 역상 저항성과 유일한 값, 즉 다른 값일 때 그 결과가 모두 다르다는 점에서 충돌 저항성이라는 특징이 있다.<br>
                Hash 함수를 이용하여 암호화 등에 활발하게 사용되고 있기 때문에 보안 분야의 핵심 개념 중 하나이다. <br>
                더불어 이러한 Hash 함수는 블록체인의 논리에 가장 기초적인 요소이며 블록들의 체인 형성에 사용되어 데이터 무결성 확보에 핵심이 된다.<br>
              </p>
            </div>
            <div class="description">
              <h4>Instruction</h4>
              <p>
                Hash 함수를 직접 실행하여 개념을 파악한다.<br><br>
                [기본 조작]<br>
                1. Data에 텍스트를 입력한다.<br>
                2. 오른편 'Generate Hash' 버튼을 클릭한다.<br>
                3. Hash 부분에 결과값(Digested)를 확인한다.<br>
                <br>
                [역상 저항성 테스트]<br>
                역상 저항성이란 그 결과값으로 입력 값을 역산할 수 없다는 특징이다.<br><br>
                1. Hash된 결과를 Data에 입력한다.<br>
                2. 오른편 'Generate Hash' 버튼을 클릭한다.<br>
                3. 결과를 확인한다.<br>
                <br>
                [충돌 저항성 테스트]<br>
                충돌 저항성이란 한 입력에 대해서 그 결과가 유일하다는 특징이다.<br>
                즉 어떠한 입력을 넣어 Hash 하더라도 그 결과는 모두 다르다. 즉 충돌되지 않는다.<br><br>
                1. Data에 텍스트를 입력한다. <br>
                2. 오른편 'Generate Hash' 버튼을 클릭한다.<br>
                3. 결과를 확인하고 메모한다.<br>
                4. 1~2를 반복하며 3의 결과와 동일한 결과가 나오는지 확인한다.<br>
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
            <h4>Sorry! We are work in progress</h4>
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
      step: 1,
      hashed: ""
    }
  },
  methods: {
    async testSubmit() {
      this.hashed = (await Api.getHash(this.toHash)).data
    },
    goToStep(num) {
      this.step = num;
    }
  }
};
</script>

