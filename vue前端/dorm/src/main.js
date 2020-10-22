import Vue from "vue";
import App from "./App.vue";
import VueStorage from "vue-ls";
import router from "./router";
import store from "./store";
import Antd from 'ant-design-vue';
import { VueAxios } from '@/utils/request' // axios 不建议引入到 Vue 原型链上
import 'ant-design-vue/dist/antd.css';
import { ACCESS_TOKEN } from "@/store/mutation-types";
Vue.config.productionTip = false;
Vue.use(Antd);

//设置本地化存储vue ls
Vue.use(VueStorage, {
  namespace: "pro__", // key prefix
  name: "ls", // name variable Vue.[ls] or this.[$ls],
  storage: "local" // storage name session, local, memory
});
//路由守卫
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    // 判断该路由是否需要登录权限
    var token = Vue.ls.get(ACCESS_TOKEN, null);
    if (token) {
      //判断本地是否存在access_token
      next();
    } else {
      next({
        path: "/login"
      });
    }
  } else {
    next();
  }
  /*如果本地 存在 token 则 不允许直接跳转到 登录页面*/
  if (to.fullPath == "/login") {
    if (Vue.ls.get(ACCESS_TOKEN, null)) {
      next({
        path: from.fullPath
      });
    } else {
      next();
    }
  }
});
new Vue({
  VueAxios,
  router,
  store,
  render: h => h(App)
}).$mount("#app");
