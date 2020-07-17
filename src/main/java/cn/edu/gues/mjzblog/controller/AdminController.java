package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.common.Result;
import cn.edu.gues.mjzblog.entity.Post;
import cn.edu.gues.mjzblog.entity.vo.PostVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @ResponseBody
    @PostMapping("/initEsData")
    public Result initEsData(){
        int size=10000;
        Page page=new Page();
        page.setSize(size);
        long total=0;
        for (int i = 1; i < 1000; i++) {
            total++;
            page.setCurrent(i);
            IPage<PostVo> paging = postService.paging(page, null, null, null, null, null);
            searchService.initEsData(paging.getRecords());
            //一页查不出10000条的时候，是最后一页
            if(paging.getRecords().size()<size){
                break;
            }
        }
        return Result.success("ES索引初始化成功，共："+total+"条。",null);
    }

}
