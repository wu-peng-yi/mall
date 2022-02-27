<template>
  <div>
    <el-card class="login-form-layout">
      <el-form autoComplete="on"
               :model="loginForm"
               :rules="loginRules"
               ref="loginForm"
               label-position="left">
        <h2 class="login-title color-main">mall-admin-web</h2>

        <el-form-item prop="username">
          <el-input name="username"
                    type="text"
                    v-model="loginForm.username"
                    autoComplete="on"
                    placeholder="请输入用户名">
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input name="password"
                    :type="pwdType"
                    @keyup.enter.native="handleLogin"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入密码">
          </el-input>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'login',
}
</script>

<script setup>
import {ref, reactive, computed, onMounted, nextTick} from "vue";
import {isValidUsername} from "../../utils/validate";

const validateUsername = (rule, value, callback) => {
  if (!isValidUsername(value)) {
    callback(new Error('请输入正确的用户名'))
  } else {
    callback()
  }
};
const validatePass = (rule, value, callback) => {
  if (value.length < 3) {
    callback(new Error('密码不能小于3位'))
  } else {
    callback()
  }
};

let loginForm = reactive(
    {
      username: '',
      password: '',
    }
)


const showPwd = () => {
  console.log("sada")
}

const loginRules = {
  username: [{required: true, trigger: 'blur', validator: validateUsername}],
  password: [{required: true, trigger: 'blur', validator: validatePass}]
}

const pwdType = ref('password')

const handleLogin = () => {
  console.log("login")
}
</script>

<style scoped>

</style>
