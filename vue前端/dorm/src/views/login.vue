<template>
  <div class="loginBg" v-bind:style="{ height: curHeight + 'px' }">
    <div class="loginBox">
      <div class="tit">
        <span class="h2">技术野生菌宿舍管理系统</span>
      </div>
      <div class="wlogin">
        <a-row>
          <a-col :span="2"></a-col>
          <a-col :span="20" class="res">
            <a-input v-model="account" class="ipt pdl40"></a-input>
            <span class="icon iconfont">&#xe868;</span>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="2"></a-col>
          <a-col :span="20" class="res">
            <!-- <a-input-password v-model="pwd" @pressEnter="Login()" class="ipt mrb24"></a-input-password> -->
            <a-input
              v-model="pwd"
              type="password"
              class="ipt pdl48"
              @pressEnter="Login()"
            ></a-input>
            <span class="icon iconfont">&#xe605;</span>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="2"></a-col>
          <a-col :span="2"></a-col>
          <a-col :span="13"></a-col>
          <a-col :span="7">
            <a-checkbox class="pdt12 mrb22">记住密码</a-checkbox>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="2"></a-col>
          <a-col :span="20" style="text-align:center;">
            <a-button type="submit" @click="Login()" class="loginbtn"
              >登录</a-button
            >
          </a-col>
        </a-row>
      </div>
    </div>
  </div>
</template>
<style scoped>
.ant-input:focus {
  box-shadow: none !important;
}
/* a,
input {
  border: none;
  outline: none !important;
}
input.ant-input[type="password"] {
  border: none !important;
} */
.pdt12 {
  padding-top: 22px;
}
.pdl48 {
  padding-left: 48px;
  background: #fff;
  border: none;
}
.pdl38 {
  padding-left: 38px;
}

.pdl40 {
  padding-left: 40px;
}
.iconfont {
  position: absolute;
  top: 43px;
  left: 18px;
}
.res {
  position: relative;
}
.mrb22 {
  margin-bottom: 22px;
}

.loginbtn {
  width: 100%;
  height: 48px;
  text-align: center;
  color: #fff;
  background: #00bcd4;
  border-radius: 4px;
  font-size: 18px;
}
.ipt {
  width: 414px;
  height: 46px;
  border: 1px solid #adadad;
  border-radius: 2px;
  outline: none;
  margin-top: 32px;
}
.mrb24 {
  margin-bottom: 24px;
}

.wlogin {
  background: #d5faf0;
  width: 496px;
  height: 320px;
  border-radius: 4px;
  display: block;
  box-shadow: 0 0 6px rgba(0, 0, 0, 0.3);
  padding-top: 10px;
}
.loginBg {
    background: url("../assets/bg.png");
  height: 100%;
  width: 100%;
  background-size: 100% 100%;
}
.loginBox {
  /* width: 260px; */
  height: 420px;
  position: absolute;
  top: 30%;
  margin-top: -210px;
  right: 15%;
}
.tit {
  position: relative;
}
h2 {
  text-align: center;
  font-weight: bold;
  font-size: 32px;
  position: relative;
  padding-bottom: 20px;
  text-shadow: 2px 2px 2px #fff;
}
span.h2 {
  width: 100%;
  text-align: center;
  font-weight: bold;
  font-size: 32px;
  position: absolute;
  top: 0;
  padding-bottom: 20px;
  display: inline-block;
  background-image: -webkit-linear-gradient(
    top,
    #CDDC39, #00BCD4
  );
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
</style>
<script>
import { login } from "@/api/login";
import store from "@/store";
export default {
  data() {
    return {
      account: "",
      pwd: "",
      curHeight: null
    };
  },
  created() {
    this.beforeMount(0);
  },
  methods: {
    Login() {
      login({
        username: this.account,
        password: this.pwd,
        rememberMe: false
      }).then(res => {
        console.log(res);
        this.$router.push({
          name: "Home"
        });
        store.dispatch("GetUser");
      });
    },
    beforeMount(height) {
      var h =
        window.innerHeight ||
        document.documentElement.clientHeight ||
        document.body.clientHeight;

      this.curHeight = h - height; //减去页面上固定高度height
    }
  }
};
</script>
