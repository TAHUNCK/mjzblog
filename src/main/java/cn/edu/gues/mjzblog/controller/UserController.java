package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.entity.Post;
import cn.edu.gues.mjzblog.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/16 14:04
 */
@Controller
public class UserController extends BaseController{

    @GetMapping("/user/home")
    public String home() {

        User user = userService.getById(getProfileId());

        List<Post> posts = postService.list(new QueryWrapper<Post>()
                .eq("user_id", getProfileId())
                // 30天内
                //.gt("created", DateUtil.offsetDay(new Date(), -30))
                .orderByDesc("created")
        );

        request.setAttribute("user", user);
        request.setAttribute("posts", posts);
        return "/user/home";
    }

}
