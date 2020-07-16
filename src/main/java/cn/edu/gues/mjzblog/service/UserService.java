package cn.edu.gues.mjzblog.service;

import cn.edu.gues.mjzblog.common.Result;
import cn.edu.gues.mjzblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CK
 * @since 2020-07-15
 */
public interface UserService extends IService<User> {

    Result register(User user);
}
