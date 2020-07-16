package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.common.Result;
import cn.edu.gues.mjzblog.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    /**
     *
     * @param id 帖子主键
     * @param rank 0表示取消，1表示操作
     * @param field 操作种类
     * @return Result
     */
    @ResponseBody
    @PostMapping("/jie-set")
    public Result jetSet(Long id, Integer rank, String field) {

        Post post = postService.getById(id);
        Assert.notNull(post, "该帖子已被删除");

        if("delete".equals(field)) {
            postService.removeById(id);
            return Result.success().action("/");

        } else if("status".equals(field)) {
            post.setRecommend(rank == 1);

        }  else if("stick".equals(field)) {
            post.setLevel(rank);
        }
        postService.updateById(post);
        return Result.success();
    }

}
