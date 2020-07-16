package cn.edu.gues.mjzblog.vo;

import cn.edu.gues.mjzblog.entity.Comment;
import lombok.Data;

@Data
public class CommentVo extends Comment {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

}
