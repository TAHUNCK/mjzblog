package cn.edu.gues.mjzblog.vo;

import cn.edu.gues.mjzblog.entity.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/15 9:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostVo extends Post {

    private Long authorId;
    private String authorName;
    private String authorAvatar;
    private String categoryName;

}
