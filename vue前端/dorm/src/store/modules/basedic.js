// import {
//   getThType,
//   getAreas,
//   getQussource,
//   getQusType,
//   getPartyCommittee
// } from "@/api/basedic";
// const basedic = {
//   state: {
//     thtype: [],
//     areas: [],
//     qussource: [],
//     qusType: [],
//     partyCommittee: [],
//     test: []
//   },

//   mutations: {
//     SET_THTYPE: (state, thtype) => {
//       state.thtype = thtype;
//     },
//     SET_AREAS: (state, areas) => {
//       state.areas = areas;
//     },
//     SET_QUSSOURCE: (state, qussource) => {
//       state.qussource = qussource;
//     },
//     SET_QUSTYPE: (state, qustype) => {
//       state.qusType = qustype;
//     },
//     SET_PARTYCOMMITTE: (state, partyCommittee) => {
//       state.partyCommittee = partyCommittee;
//     },
//     SET_TEST: (state, test) => {
//       state.test = test;
//     }
//   },

//   actions: {
//     // 获取基础信息
//     GetBaseDic({ commit }) {
//       getThType().then(res => {
//         commit("SET_THTYPE", res.data);
//       });
//       getAreas({ commit }).then(res => {
//         commit("SET_AREAS", res.data);
//       });
//       getQussource({ commit }).then(res => {
//         commit("SET_QUSSOURCE", res.data);
//       });
//       getQusType({ commit }).then(res => {
//         commit("SET_QUSTYPE", res.data);
//       });
//       getPartyCommittee({ commit }).then(res => {
//         commit("SET_PARTYCOMMITTE", res.data);
//       });
//     },
//     GetTest({ commit }) {
//       commit("SET_TEST", [
//         { title: "常规哨1", value: "0", key: "0" },
//         { title: "协调哨1", value: "1", key: "1" },
//         { title: "重点哨", value: "2", key: "2" }
//       ]);
//     }
//   }
// };

// export default basedic;
