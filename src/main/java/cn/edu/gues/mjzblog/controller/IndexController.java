package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.entity.vo.PostVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 21:08
 */
@Controller
public class IndexController extends BaseController{

    @RequestMapping({"", "/", "index"})
    public String index() {
        IPage<PostVo> results=postService.paging(getPage(),null,null,null,null,"created");
        request.setAttribute("pageData",results);
        request.setAttribute("currentCategoryId",0);
        return "index";
    }

    @RequestMapping("/search")
    public String search(String q) {

        IPage pageData = searchService.search(getPage(), q);

        request.setAttribute("q", q);
        request.setAttribute("pageData", pageData);
        return "search";
    }


}
