/**
 * Created by zxk175 on 16/12/2.
 */

//使用墨绿皮肤
laydate.skin('molv');

laydate({
    //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，
    //因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
    elem: '#date',
    //响应事件。如果没有传入event，则按照默认的click
    event: 'focus',
    //分隔符可以任意定义，该例子表示只显示年月
    format: 'YYYY-MM-DD hh:mm:ss',
    //显示节日
    festival: true,
    //回调函数
    choose: function (datas) {
        console.log(datas);
    }
});