<template>
    <div id="myCharts3" style="width:600px;height:300px;" ref="myCharts3"></div>
</template>
<script>
import echarts from 'echarts'
export default {
  mounted(){
     //以下三步即可完成echarts的初始化使用,代码注释的详解别忘了看看
     const  myCharts = echarts.init(this.$refs.myCharts3);
    
 var options = {
    angleAxis: {
        max: 2,
        startAngle: 30,
        splitLine: {
            show: false
        }
    },
    radiusAxis: {
        type: 'category',
        data: ['v', 'w', 'x', 'y', 'z'],
        z: 10
    },
    polar: {
    },
    series: [{
        type: 'bar',
        data: [4, 3, 2, 1, 0],
        coordinateSystem: 'polar',
        name: 'Without Round Cap',
        color: 'rgba(200, 0, 0, 0.5)',
        itemStyle: {
            borderColor: 'red',
            borderWidth: 1
        }
    }, {
        type: 'bar',
        data: [4, 3, 2, 1, 0],
        coordinateSystem: 'polar',
        name: 'With Round Cap',
        roundCap: true,
        color: 'rgba(0, 200, 0, 0.5)',
        itemStyle: {
            borderColor: 'green',
            borderWidth: 1
        }
    }],
    legend: {
        show: true,
        data: ['Without Round Cap', 'With Round Cap']
    }
}


      myCharts.setOption(options);
}
}
</script>