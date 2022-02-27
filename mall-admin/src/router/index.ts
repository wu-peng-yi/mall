import {
    createRouter,
    createWebHistory,
    RouteRecordRaw
} from "vue-router";

import Home from '@/views/home.vue'
import Vuex from '@/views/vuex.vue'
import Login from '@/views/Login/index.vue'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/vuex',
        name: 'Vuex',
        component: Vuex
    },
    {
        path: '/axios',
        name: 'Axios',
        component: () => import('@/views/axios.vue')
    }
]

const router = createRouter({
    // history: createWebHashHistory('/'),
    history: createWebHistory("/"),
    routes
})

export default router


