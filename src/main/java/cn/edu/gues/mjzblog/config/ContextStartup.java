package cn.edu.gues.mjzblog.config;


import cn.edu.gues.mjzblog.entity.Category;
import cn.edu.gues.mjzblog.service.CategoryService;
import cn.edu.gues.mjzblog.service.PostService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 23:53
 */
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    @Autowired
    CategoryService categoryService;

    ServletContext servletContext;

    @Autowired
    PostService postService;

    @Override
    public void run(ApplicationArguments args) {
        List<Category> category = categoryService.list(new QueryWrapper<Category>()
                .eq("status", 0));
        servletContext.setAttribute("categoryS",category);

        postService.initWeekRank();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
