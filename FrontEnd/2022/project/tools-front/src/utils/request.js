import axios from 'axios'
import { getToken } from '@/utils/auth'
import {Message} from 'element-ui'

const service = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 20000
})
service.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
service.defaults.withCredentials = true

service.interceptors.request.use(
  config => {
    if (getToken()) {
      config.headers['X-Token'] = getToken()
    }
    return config
  },
  error => {
    console.log(error)
    Promise.reject(error)
  }
)

service.interceptors.response.use(
  response => response,
  response => {},
  error => {
    console.log('error:' + error)
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
