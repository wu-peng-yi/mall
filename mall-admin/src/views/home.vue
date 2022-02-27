<template>
  <div>
    <el-input v-model="username"></el-input>
  </div>
</template>

<script>
import {defineComponent, reactive} from "vue";

export default {
  name: "home",
  setup() {
    let data = reactive({
      username:'',
      pass:''
    })

    return data
  }
}
</script>

<style scoped>

</style>
