<#macro layout title>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="/layui/css/layui.css">
        <link rel="stylesheet" href="/css/global.css">
        <script src="/layui/layui.js"></script>
        <script src="/js/jquery.min.js"></script>
    </head>
    <body>

    <#include "/public/common.ftl"/>
    <#include "/public/header.ftl"/>

    <#--将模板插入到此处-->
    <#nested >

    <#include "/public/footer.ftl"/>

    <script>
        // layui.cache.page = '';
        layui.cache.user = {
            username: '${profile.username!"游客"}'
            ,uid: ${profile.id!"-1"}
            ,avatar: '${profile.avatar!"/images/avatar/00.jpg"}'
            ,experience: 83
            ,sex: '${profile.sex!"男"}'
        };

        layui.config({
            version: "3.0.0"
            ,base: '/mods/' //这里实际使用时，建议改成绝对路径
        }).extend({
            fly: 'index'
        }).use('fly');
    </script>

    </body>
    </html>

</#macro>
