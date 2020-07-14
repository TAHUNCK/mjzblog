package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.entity.Post;
import cn.edu.gues.mjzblog.mapper.PostMapper;
import cn.edu.gues.mjzblog.service.PostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
