package cn.edu.gues.mjzblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 23:47
 */
@Configuration
@MapperScan("cn.edu.gues.mjzblog.mapper")
public class MybatisPlusConfig {

}
