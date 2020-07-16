package cn.edu.gues.mjzblog.service.impl;

import cn.edu.gues.mjzblog.common.Result;
import cn.edu.gues.mjzblog.entity.User;
import cn.edu.gues.mjzblog.mapper.UserMapper;
import cn.edu.gues.mjzblog.service.UserService;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public Result register(User user) {
        int count=this.count(new QueryWrapper<User>()
        .eq("email",user.getEmail())
        .or()
        .eq("username",user.getUsername())
        );
        if(count>0){
            return Result.fail("用户名或邮箱已被占用！");
        }
        User userTmp=new User();
        userTmp.setUsername(user.getUsername());
        userTmp.setPassword(SecureUtil.md5(user.getPassword()));
        userTmp.setEmail(user.getEmail());
        userTmp.setAvatar("/images/avatar/default.png");
        userTmp.setCreated(new Date());
        userTmp.setPoint(0);
        userTmp.setVipLevel(0);
        userTmp.setCommentCount(0);
        userTmp.setPostCount(0);
        this.save(userTmp);
        return Result.success();
    }
}
