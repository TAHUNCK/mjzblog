package cn.edu.gues.mjzblog.mapper;

import cn.edu.gues.mjzblog.entity.Comment;
import cn.edu.gues.mjzblog.vo.CommentVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CK
 * @since 2020-07-15
 */
@Component
public interface CommentMapper extends BaseMapper<Comment> {
    IPage<CommentVo> selectComments(Page page, @Param(Constants.WRAPPER) QueryWrapper<Comment> wrapper);
}
