package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.entity.Comment;
import cn.edu.gues.mjzblog.mapper.CommentMapper;
import cn.edu.gues.mjzblog.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
