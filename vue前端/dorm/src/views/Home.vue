<template>

  <a-layout id="components-layout-demo-custom-trigger">
    <a-layout-sider v-model="collapsed" :trigger="null" collapsible>
      <div class="logo" style="color:#FFF;">技术野生菌</div>
      <span>注销</span>
      <a-menu
        :default-selected-keys="['1']"
        :default-open-keys="['sub1']"
        mode="inline"
        theme="dark"
        :inline-collapsed="collapsed"
      >
        <a-menu-item key="1">
          <router-link :to="{ name: 'statistics'}">
            <a-icon type="pie-chart" />
            <span>信息总览</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link :to="{ name: 'eqpmanage'}">
            <a-icon type="desktop" />
            <span>设备租赁与报修</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="3">
          <router-link :to="{ name: 'stdmanage'}">
            <a-icon type="inbox" />
            <span>学生管理</span>
          </router-link>
        </a-menu-item>
        <a-sub-menu key="sub1">
          <span slot="title">
            <a-icon type="mail" />
            <span>基础信息</span>
          </span>
          <a-menu-item key="11">
            <router-link :to="{ name: 'student'}">学生基础信息</router-link>
          </a-menu-item>
          <a-menu-item key="12">
            <router-link :to="{ name: 'building'}">楼栋信息</router-link>
          </a-menu-item>
          <a-menu-item key="13">
            <router-link :to="{ name: 'worker'}">工作人员</router-link>
          </a-menu-item>
          <a-menu-item key="14">
            <router-link :to="{ name: 'eqpment'}">设备信息</router-link>
          </a-menu-item>
          <a-menu-item key="15">
            <router-link :to="{ name: 'visitor'}">访客人员</router-link>
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
        <span style="float:right;margin-right:30px;" @click="logout()"><a style="cursor:pointer;">注销</a></span>
      </a-layout-header>
      <a-layout-content
        :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '600px' }"
      >
        <router-view></router-view>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
import Vue from "vue";
import { ACCESS_TOKEN } from "@/store/mutation-types";
export default {
  data() {
    return {
      collapsed: false,
      selectItem: 1
    };
  },
  mounted() {
    switch (this.$route.name) {
      case "Aboutme":
        this.selectItem = 1;
        break;
      case "opus":
        this.selectItem = 2;
        break;
      case "vlog":
        this.selectItem = 3;
        break;
    }
  },
  methods: {
    onClick(item) {
      this.selectItem = item.key;
    },
    logout(){
      Vue.ls.set(
      ACCESS_TOKEN,
      null
    );
    this.$router.push("login")
    }
  }
};
</script>
<style>
#components-layout-demo-custom-trigger .trigger {
  font-size: 18px;
  line-height: 64px;
  padding: 0 24px;
  cursor: pointer;
  transition: color 0.3s;
}

#components-layout-demo-custom-trigger .trigger:hover {
  color: #1890ff;
}
.logo {
  text-align: center;
  line-height: 20px;
}
#components-layout-demo-custom-trigger .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
</style>
