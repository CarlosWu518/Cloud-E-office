<template>
  <div>
    <el-form
      v-loading="loading"
      element-loading-text="正在登录. . ."
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.7)"
      :rules="rules"
      :model="loginForm"
      ref="loginForm"
      class="loginContainer"
    >
      <h3 class="logintitle">系统登录</h3>
      <el-form-item prop="username">
        <el-input
          type="text"
          auto-complete="false"
          v-model="loginForm.username"
          placeholder="请输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          auto-complete="false"
          v-model="loginForm.password"
          placeholder="请输入密码"
        ></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <div id="el-code">
          <el-input
            type="text"
            auto-complete="false"
            v-model="loginForm.code"
            placeholder="点击图片更换验证码"
            class="logincode"
          ></el-input>
          <img :src="captchaUrl" @click="updateCaptcha" />
        </div>
      </el-form-item>
      <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
      <el-button type="primary" class="loginbtn" @click="loginSubmit"
        >登录
      </el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      captchaUrl: "/captcha?time=" + new Date(),
      loginForm: {
        username: "admin",
        password: "1123",
        code: "",
      },
      loading: false,
      checked: true,
      rules: {
        username: [
          { required: true, message: "用户名不能为空", trigger: "blur" },
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" },
        ],
        code: [{ required: true, message: "验证码不能为空", trigger: "blur" }],
      },
    };
  },
  methods: {
    updateCaptcha() {
      this.captchaUrl = "/captcha?time=" + new Date();
    },
    loginSubmit() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          this.postRequest("/login", this.loginForm).then((response) => {
            if (response) {
              this.loading = false;
              //存储用户token
              const tokenStr = response.obj.tokenHead + response.obj.token;
              window.sessionStorage.setItem("tokenStr", tokenStr);
              //跳转首页
              this.$router.replace("/home");
            } else {
              this.loading = false;
            }
          });
        } else {
          this.$message.error("请输入所有字段");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.loginContainer {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cacaca;
}

.logintitle {
  margin: 0px auto 40px auto;
  text-align: center;
}

.logincode {
  width: 250px;
  margin-right: 5px;
}

.loginRemember {
  text-align: left;
  margin: 0px 0px 15px 0px;
}

.loginbtn {
  width: 100%;
}
#el-code {
  display: flex;
}
</style>