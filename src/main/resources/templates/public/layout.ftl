<#macro layout title>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="keywords" content="fly,layui,前端社区">
        <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
        <link rel="stylesheet" href="../static/layui/css/layui.css">
        <link rel="stylesheet" href="../static/css/global.css">
        <script src="../static/layui/layui.js"></script>
        <script src="../static/js/jquery.min.js"></script>
    </head>
    <body>

    <#include "/public/common.ftl"/>
    <#include "/public/header.ftl"/>

    <#--将模板插入到此处-->
    <#nested >

    <#include "/public/footer.ftl"/>

    <script>
        //layui.cache.page = '';
        layui.cache.user = {
            username: '游客'
            , uid: -1
            , avatar: 'static/images/avatar/00.jpg'
            , experience: 83
            , sex: '男'
        };
        layui.config({
            version: "3.0.0"
            , base: '../static/mods/' //这里实际使用时，建议改成绝对路径
        }).extend({
            fly: 'index'
        }).use('fly');
    </script>

    </body>
    </html>

</#macro>
