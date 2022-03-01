<template>
  <div>
    <el-card class="login-form-layout">

      <el-form
          :model="loginForm"
          :rules="loginRules"
          ref="loginFormRef"
          label-position="left">
        <h2 class="login-title color-main">mall-admin-web</h2>

        <el-form-item prop="username">
          <el-input
              type="text"
              v-model="loginForm.username"
              placeholder="请输入用户名">
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input name="password"
                    :type="pwdType"
                    @keyup.enter.native="handleLogin(loginFormRef)"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入密码">
          </el-input>
        </el-form-item>

        <el-form-item style="margin-bottom: 60px;text-align: center">
          <el-button style="width: 45%" type="primary" :loading="loading"
                     @click.native.prevent="handleLogin(loginFormRef)">
            登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import {isValidUsername} from "../../utils/validate";
import type {ElForm} from 'element-plus'

import { useStore } from "vuex";
const store = useStore();


type FormInstance = InstanceType<typeof ElForm>
const loginFormRef = ref<FormInstance>()

const loading = false

const validateUsername = (rule: any, value: string, callback: any) => {
  if (!isValidUsername(value)) {
    callback(new Error('请输入正确的用户名'))
  } else {
    callback()
  }
}
const validatePass = (rule: any, value: string, callback: any) => {
  if (value.length < 3) {
    callback(new Error('密码不能小于3位'))
  } else {
    callback()
  }
}
const loginForm = reactive(
    {
      username: '',
      password: '',
    }
)

const showPwd = () => {
  console.log("sada")
}

const loginRules = reactive({
  username: [{required: true, trigger: 'blur', validator: validateUsername}],
  password: [{required: true, trigger: 'blur', validator: validatePass}]
})

const pwdType = ref('password')

const handleLogin = (formEl: FormInstance ) => {
  console.log(formEl)
  formEl.validate((valid) => {
    if (valid) {
      store.dispatch('Login',loginForm).then(() =>{
        console.log("999")
      })
     // router.push({path: '/'})
    } else {
      console.log('参数验证不合法！');
      return false
    }
  })
}


</script>

<style scoped>

</style>
