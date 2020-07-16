package cn.edu.gues.mjzblog.entity.vo;

import cn.edu.gues.mjzblog.entity.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommentVo extends Comment {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

}
