package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.vo.PostVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 21:08
 */
@Controller
public class IndexController extends BaseController{

    @Override
    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(request, "size", 10);
        return new Page(pn, size);
    }

    @RequestMapping({"", "/", "index"})
    public String index() {

        IPage<PostVo> results=postService.paging(getPage(),null,null,null,null,"created");
        request.setAttribute("pageData",results);
        request.setAttribute("currentCategoryId",0);
        return "index";
    }

}
