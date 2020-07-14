package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.entity.UserMessage;
import cn.edu.gues.mjzblog.mapper.UserMessageMapper;
import cn.edu.gues.mjzblog.service.UserMessageService;
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
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {

}
