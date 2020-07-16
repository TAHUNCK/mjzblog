package cn.edu.gues.mjzblog.controller;

import cn.edu.gues.mjzblog.common.Result;
import cn.edu.gues.mjzblog.common.utils.ValidationUtil;
import cn.edu.gues.mjzblog.entity.User;
import cn.edu.gues.mjzblog.service.UserService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/15 23:58
 */
@Controller
public class AuthController extends BaseController{

    private static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";

    @Autowired
    Producer producer;

    @Autowired
    UserService userService;

    @GetMapping("/kaptcha.jpg")
    public void kaptcha(HttpServletResponse resp) throws IOException {

        // 验证码
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        request.getSession().setAttribute(KAPTCHA_SESSION_KEY, text);
        resp.setHeader("Cache-Control", "no-store, no-cache");
        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
    }

    @GetMapping("/login")
    public String login(){
        return "/auth/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String doLogin(){

        return "/auth/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/auth/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public Result doRegister(User user,String repass,String vercode){

        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(user);
        if(validResult.hasErrors()) {
            return Result.fail(validResult.getErrors());
        }

        if(!user.getPassword().equals(repass)) {
            return Result.fail("两次输入密码不相同");
        }

        String kaptcha = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(kaptcha);
        if(vercode == null || !vercode.equalsIgnoreCase(kaptcha)) {
            return Result.fail("验证码输入不正确");
        }

        // 完成注册
        Result result = userService.register(user);
        return result.action("/login");
    }

}