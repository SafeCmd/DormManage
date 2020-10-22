import Vue from "vue";
import axios from "axios";
// import store from "@/store";
import notification from "ant-design-vue/es/notification";
import { VueAxios } from "./axios";
import { ACCESS_TOKEN } from "@/store/mutation-types";

// 创建 axios 实例
const service = axios.create({
  baseURL: process.env.VUE_APP_API_BASE_URL, // api base_url
  timeout: 6000 // 请求超时时间
});

const err = error => {
  if (error.response) {
    const data = error.response.data;
    // const token = Vue.ls.get(ACCESS_TOKEN);
    if (error.response.status === 403) {
      notification.error({
        message: "Forbidden",
        description: data.message
      });
    }
    if (error.response.status === 401 && !data.result) {
      notification.error({
        message: "Unauthorized",
        description: "Authorization verification failed"
      });
      //清空TOKEN并到登录页
      Vue.ls.set(ACCESS_TOKEN, null);
      const token = Vue.ls.get(ACCESS_TOKEN, null);
      if (!token) {
        window.location.reload();
      }
    }
  }
  return Promise.reject(error);
};

//request interceptor
service.interceptors.request.use(config => {
  const token = Vue.ls.get(ACCESS_TOKEN, null);
  if (token) {
    config.headers["Authorization"] = token; // 让每个请求携带自定义 token 请根据实际情况自行修改
  }
  return config;
}, err);

// response interceptor
service.interceptors.response.use(response => {
  console.log(response.headers.authorization);
  if (response.headers.authorization) {
    // sessionStorage.setItem("SET_TOKEN", response.headers.authorization);
    Vue.ls.set(
      ACCESS_TOKEN,
      response.headers.authorization,
      7 * 24 * 60 * 60 * 1000
    );
  }
  return response.data;
}, err);

const installer = {
  vm: {},
  install(Vue) {
    Vue.use(VueAxios, service);
  }
};

export { installer as VueAxios, service as axios };
