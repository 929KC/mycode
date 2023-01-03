import axios from "axios";
import nprogress from "nprogress";
import "nprogress/nprogress.css";
const requests = axios.create({
    baseURL: "/api",
    timeout: 50000
});
//请求拦截器
requests.interceptors.request.use((config) => {
    nprogress.start();
    return config;
});
// 相应拦截拦截器
requests.interceptors.response.use((res) => {
    nprogress.done();
    return res.data;
}, (error) => {
    return Promise.reject(new Error('failure'));
});
export default requests;