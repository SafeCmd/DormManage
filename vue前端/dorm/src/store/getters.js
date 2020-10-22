const getters = {
  thtypes: state => state.basedic.thtype,
  areas: state => state.basedic.areas,
  qussources: state => state.basedic.qussource,
  qusTypes: state => state.basedic.qusType,
  partyCommittees: state => state.basedic.partyCommittee,
  test: state => state.basedic.test,
  whistle: state => state.whistleStore.whistle,
  token: state => state.user.token,
  user: state => state.user.user
};

export default getters;
