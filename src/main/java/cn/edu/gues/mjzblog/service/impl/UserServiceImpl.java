package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.entity.User;
import cn.edu.gues.mjzblog.mapper.UserMapper;
import cn.edu.gues.mjzblog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
