package cn.edu.gues.mjzblog.entity.vo;

import cn.edu.gues.mjzblog.entity.UserMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserMessageVo extends UserMessage {

    private String toUserName;
    private String fromUserName;
    private String postTitle;
    private String commentContent;

}
