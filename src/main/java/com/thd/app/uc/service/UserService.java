package com.thd.app.uc.service;

import com.thd.app.uc.model.User;
import com.thd.base.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户管理持久化操作
 */
@Service
public class UserService {
    @Resource
    private BaseService baseService;

    public String save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null!");
        }

        String userId = user.getUserId();
        if (StringUtils.isEmpty(userId)) {
            return baseService.save(user);
        }

        User oldUser = baseService.load(User.class, userId);
        if (oldUser == null || StringUtils.isEmpty(oldUser.getUserId())) {
            return userId;
        }

        baseService.update(user);
        return userId;
    }
}
