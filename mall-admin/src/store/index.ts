import { createStore } from 'vuex'
import {login} from "../api/user";



const defaultState = {
    count: 0
}

const user = {
    token: 'getToken()',
    name: '',
    avatar: '',
    roles: []
}

export default createStore({
    state() {
        return user
    },
    mutations: {
        SET_TOKEN: (state:typeof user, token:string) => {
            state.token = token
        },
        SET_NAME: (state:typeof user, name:string) => {
            state.name = name
        },
        SET_AVATAR: (state:typeof user, avatar:string) => {
            state.avatar = avatar
        },
        SET_ROLES: (state:typeof user, roles) => {
            state.roles = roles
        }
    },

    actions: {
        Login({commit},userInfo: userInfo) {
            const username = userInfo.username.trim()
            return new Promise((resolve, reject) => {
                login(username, userInfo.password).then((response) => {
                    console.log(response)
                    const data = response.data
                    const tokenStr = data.tokenHead+data.token
                    // setToken(tokenStr)
                    commit('SET_TOKEN', tokenStr)
                    // resolve()
                }).catch((error:Error) => {
                    reject(error)
                })
            })
        }
    },


})


interface userInfo {
    username:string,
    password:string
}

