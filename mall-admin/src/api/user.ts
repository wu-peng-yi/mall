import axios from "../utils/axios";


export function login(username:string,password: string) {
    return axios({
        url:'/admin/login',
        method:'POST',
        data:{
            username,
            password
        }
    })
}
