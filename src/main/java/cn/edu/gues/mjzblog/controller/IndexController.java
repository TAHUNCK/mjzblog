package cn.edu.gues.mjzblog.controller;

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
        return "index";
    }

}
