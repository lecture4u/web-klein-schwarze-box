import axios from 'axios'

const baseURL = '/api'
const RestApi = class {
  constructor () { }

  async result (promise) {
    // 결과값 가져오기
    const response = await promise
    const data = response.data

    // 에러처리
    if (!data.success) throw data.err

    // 에러가 없으면 data 반환
    return data
  }
  //get hash from server
  async getHash (hash) { return await this.result(axios.get(`${baseURL}/hash?data=${hash}`)) }

  //for test
  async getTest () { return await this.result(axios.get(`${baseURL}/test`)) }

  // membmer part
  async postMember (params) { return await this.result(axios.post(`${baseURL}/member`, params)) }

  // consensus part
  async postConsensus (params) { return await this.result(axios.post(`${baseURL}/consensus`, params)) }
  async getConsensusList (params) { return await this.result(axios.get(`${baseURL}/consensus`, { params })) }
  async getConsensus (idx) { return await this.result(axios.get(`${baseURL}/consensus/${idx}`)) }

  // item part
  async postItem (params) { return await this.result(axios.post(`${baseURL}/item`, params)) }
  async getItems (idx) { return await this.result(axios.post(`${baseURL}/item/list/${idx}`)) }

  // consensus member part
  async postConsensusMember (params) { return await this.result(axios.post(`${baseURL}/consensus_member`, params)) }

  // test Data
  

}

export default new RestApi();