package cn.edu.gues.mjzblog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/14 23:47
 */
@EnableTransactionManagement
@Configuration
@MapperScan("cn.edu.gues.mjzblog.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

}
