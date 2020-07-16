package cn.edu.gues.mjzblog.template;

import cn.edu.gues.mjzblog.common.templates.DirectiveHandler;
import cn.edu.gues.mjzblog.common.templates.TemplateDirective;
import cn.edu.gues.mjzblog.service.PostService;
import cn.edu.gues.mjzblog.vo.PostVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostsTemplate extends TemplateDirective {

    @Autowired
    PostService postService;

    @Override
    public String getName() {
        return "posts";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {

        Integer level = handler.getInteger("level");
        Integer pn = handler.getInteger("pn", 1);
        Integer size = handler.getInteger("size", 2);
        Long categoryId = handler.getLong("categoryId");

        IPage<PostVo> page = postService.paging(new Page<>(pn, size), categoryId, null, level, null, "created");

        handler.put(RESULTS, page).render();
    }
}
