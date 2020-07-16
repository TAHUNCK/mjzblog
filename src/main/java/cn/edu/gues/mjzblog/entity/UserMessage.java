package cn.edu.gues.mjzblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.Date;

import cn.edu.gues.mjzblog.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author CK
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_message")
public class UserMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发送消息的用户ID
     */
    private Long fromUserId;

    /**
     * 接收消息的用户ID
     */
    private Long toUserId;

    /**
     * 消息可能关联的帖子
     */
    private Long postId;

    /**
     * 消息可能关联的评论
     */
    private Long commentId;

    private String content;

    /**
     * 消息类型
     */
    private Integer type;

    private Date created;

    private Date modified;

    private Integer status;


}
