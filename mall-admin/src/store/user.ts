import {createStore} from "vuex";



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
            console.log("dasdasd")
            const username = userInfo.username.trim()
            return new Promise((resolve, reject) => {
            })
        }
    },


})


interface userInfo {
    username:string,
    password:string
}


