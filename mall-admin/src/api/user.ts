import axios from '@/utils/axios.ts'

export function login(username:string,password: string) {
    return axios({
        url:'/admin/login',
        method:'post',
        data:{
            username,
            password
        }
    })
}
