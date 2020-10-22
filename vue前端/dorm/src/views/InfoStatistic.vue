<template>
  <div style="background-color:#f9fef8;height:800px">
    <a-row>
      <a-col :span="8">
        <div class="box" style="background-color:#d4ad52;">
          <span style="color:#beddce;">可住总人数100人</span>
        </div>
      </a-col>
      <a-col :span="8">
        <div class="box" style="background-color:#f89463;">
          <span style="color:#f9fef8;">已住人数100人</span>
        </div>
      </a-col>
      <a-col :span="8">
        <div class="box" style="background-color:#85ad32;">
          <span style="color:#fef79d;">剩余床位99人</span>
        </div>
      </a-col>
    </a-row>
    <a-row style="margin-top:20px;">
      <a-col :span="24">
        <div style="background-color: #ececec; padding: 20px;">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card title="待处理事项" :bordered="false">
              <a-list item-layout="horizontal" :data-source="data">
    <a-list-item slot="renderItem" slot-scope="item">
      <a-list-item-meta
        description="302宿舍今日门窗未关，床上因下雨长满野生菌"
      >
        <a slot="title" href="https://www.antdv.com/">{{ item.title }}</a>
        <a-avatar
          slot="avatar"
          src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        />
      </a-list-item-meta>
    </a-list-item>
  </a-list>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="通知公告" :bordered="false">
                <p>宿舍从今日起，禁止使用大功率用电器。尤其不得在宿舍煮火锅</p>
                 <p>宿舍从今日起，禁止使用大功率用电器。尤其不得在宿舍煮火锅</p>
                  <p>宿舍从今日起，禁止使用大功率用电器。尤其不得在宿舍煮火锅</p>
                   <p>宿舍从今日起，禁止使用大功率用电器。尤其不得在宿舍煮火锅</p>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="寻物启事" :bordered="false">
                <p>技术野生菌同学在经过166宿舍时捡到不知哪位同学不小心丢失的节操请速来宿管处认领</p>
              </a-card>
            </a-col>
          </a-row>
        </div>
      </a-col>
    </a-row>
  </div>
</template>
<script>
const data = [
  {
    title: '302宿舍今天门窗未关',
  },
  {
    title: '302宿舍今天门窗未关',
  },
  {
    title: '302宿舍今天门窗未关',
  },
  {
    title: '302宿舍今天门窗未关',
  },
];
export default {
  data() {
    return {
      data,
    };
  },
};
</script>
 <style>
.box {
  height: 100px;
  width: 400px;
  border: 1px solid #ccc;
  border-radius: 6px;
  line-height: 100px;
}
.box span {
  font-size: 20px;
  width: 160px;
  color: red;
  display: block;
  margin: 0 auto;
}
</style>