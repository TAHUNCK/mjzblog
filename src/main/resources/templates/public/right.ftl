<div class="layui-col-md4">

    <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">本周热议</dt>

        <@hots>
            <#list results as post>
                <dd>
                    <a href="/post/${post.id}">${post.title}</a>
                    <span><i class="iconfont icon-pinglun1"></i> ${post.commentCount}</span>
                </dd>
            </#list>
        </@hots>

    </dl>

    <div class="fly-panel">
        <div class="fly-panel-title">
            这里可作为广告区域
        </div>
        <div class="fly-panel-main">
            <a href="#" target="_blank" class="fly-zanzhu" time-limit="2017.09.25-2099.01.01" style="background-color: #5FB878;">待价而沽</a>
        </div>
    </div>

    <div class="fly-panel fly-link">
        <h3 class="fly-panel-title">友情链接</h3>
        <dl class="fly-panel-main">
            <dd><a href="http://chenkai.pro" target="_blank">CK</a><dd>
            <dd><a href="mailto:xianxin@layui-inc.com?subject=%E7%94%B3%E8%AF%B7Fly%E7%A4%BE%E5%8C%BA%E5%8F%8B%E9%93%BE" class="fly-link">申请友链</a><dd>
        </dl>
    </div>

</div>
