<template>
  <div class="login-container">
    <el-form :model="form" class="login-form" @submit.native.prevent="login">
      <h2>家庭物品管理系统</h2>
      <el-form-item label="用户名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password"></el-input>
      </el-form-item>
      <el-button type="primary" native-type="submit">登录</el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    async login() {
      // 调用登录接口
      localStorage.setItem('token', 'demo-token')
      this.$router.push('/home')
    }
  }
}
</script>