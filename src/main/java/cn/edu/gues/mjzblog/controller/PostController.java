package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.vo.CommentVo;
import cn.edu.gues.mjzblog.vo.PostVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 22:44
 */
@Controller
public class PostController extends BaseController{

    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name = "id") Long id) {
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        request.setAttribute("currentCategoryId",id);
        request.setAttribute("pn", pn);
        return "post/category";
    }

    @GetMapping("/post/{id:\\d*}")
    public String detail(@PathVariable(name = "id") Long id) {
        PostVo vo=postService.selectOnePost(new QueryWrapper<PostVo>().eq("p.id",id));
        Assert.notNull(vo,"文章已被删除");
        postService.putViewCount(vo);
        IPage<CommentVo> results = commentService.paing(getPage(), vo.getId(), null, "created");
        request.setAttribute("currentCategoryId",vo.getCategoryId());
        request.setAttribute("post",vo);
        request.setAttribute("pageData", results);
        return "post/detail";
    }

}
