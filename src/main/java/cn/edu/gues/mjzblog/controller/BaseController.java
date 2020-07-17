package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.config.shiro.AccountProfile;
import cn.edu.gues.mjzblog.service.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

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
    UserService userService;

    @Autowired
    UserMessageService messageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SearchService searchService;

    @Autowired
    UserCollectionService collectionService;

    @Autowired
    CommentService commentService;

    @Autowired
    AmqpTemplate amqpTemplate;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(request, "size", 10);
        return new Page(pn, size);
    }

    protected AccountProfile getProfile() {
        return (AccountProfile)SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getProfileId() {
        return getProfile().getId();
    }

}
