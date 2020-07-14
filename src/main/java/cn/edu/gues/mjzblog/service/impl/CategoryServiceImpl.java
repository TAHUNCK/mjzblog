package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.entity.Category;
import cn.edu.gues.mjzblog.mapper.CategoryMapper;
import cn.edu.gues.mjzblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-07-15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
