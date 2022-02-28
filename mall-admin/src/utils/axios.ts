import Axios from "axios";
import {ElMessage} from "element-plus";

const baseURL = 'http://localhost:9999'

const axios = Axios.create({
    baseURL,
    timeout: 20000
})

/**
 * 发起请求前拦截
 */
axios.interceptors.request.use(response => {
    return response
},(err) =>{
    return Promise.reject(err)
})

/**
 * 响应后拦截
 */
axios.interceptors.response.use((response) => {
    return response
},error => {
    if (error.response && error.response.data) {
        const code = error.response.status
        const msg = error.response.data.message
        ElMessage.error(`Code: ${code}, Message: ${msg}`)
        console.error(`[Axios Error]`, error.response)
    } else {
        ElMessage.error(`${error}`)
    }
    return Promise.reject(error)
})


export default axios
