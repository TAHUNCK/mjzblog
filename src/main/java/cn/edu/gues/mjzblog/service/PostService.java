package cn.edu.gues.mjzblog.service;

import cn.edu.gues.mjzblog.entity.Post;
import cn.edu.gues.mjzblog.entity.vo.PostVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public interface PostService extends IService<Post> {
    IPage<PostVo> paging(Page<PostVo> page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<PostVo> wrapper);

    void initWeekRank();

    void incrCommentCountAndUnionForWeekRank(long postId, boolean isIncr);

    void putViewCount(PostVo vo);

}
