import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [{
    path: "/login",
    name: "login",
    meta: {
      title: "登录"
    },
    component: () => import("@/views/login")
  },
  {
    path: "/",
    name: "Home",
    redirect: "/statistics",
    meta: {
      requireAuth: true,
      title: "首页"
    },
    component: Home,
    children: [{
        path: "/statistics",
        name: "statistics",
        meta: {
          requireAuth: true,
          title: "综合信息"
        },
        component: () => import("@/views/InfoStatistic.vue")
      }, {
        path: '/eqpmanage',
        name: "eqpmanage",
        component: () => import("@/views/Eqpmanage.vue")
      }, {
        path: "/stdmanage",
        name: "stdmanage",
        component: () => import("@/views/Stdmanage.vue")
      },
      {
        path: "/baseinfo",
        name: "baseinfo",
        component: () => import("@/views/BaseInfo.vue"),
        children: [{
            path: "/student",
            name: "student",
            component: () => import("@/views/Student.vue")
          },
          {
            path: "/building",
            name: "building",
            component: () => import("@/views/Building.vue")
          }, {
            path: "/visitor",
            name: "visitor",
            component: () => import("@/views/Visitor.vue")
          }, {
            path: "/eqpment",
            name: "eqpment",
            component: () => import("@/views/Eqpment.vue")
          }, {
            path: "/worker",
            name: "worker",
            component: () => import("@/views/Worker.vue")
          }
        ]
      }
    ]
  },
  {
    path: "/about",
    name: "About",
    component: () =>
      import( /* webpackChunkName: "about" */ "../views/About.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;