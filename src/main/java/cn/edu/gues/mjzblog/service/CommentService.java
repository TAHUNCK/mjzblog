package cn.edu.gues.mjzblog.service;

import cn.edu.gues.mjzblog.entity.Comment;
import cn.edu.gues.mjzblog.vo.CommentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CK
 * @since 2020-07-15
 */
public interface CommentService extends IService<Comment> {

    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
