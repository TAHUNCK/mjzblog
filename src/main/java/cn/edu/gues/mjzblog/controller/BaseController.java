package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.service.CommentService;
import cn.edu.gues.mjzblog.service.PostService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 23:41
 */
public class BaseController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(request, "size", 2);
        return new Page(pn, size);
    }

}
