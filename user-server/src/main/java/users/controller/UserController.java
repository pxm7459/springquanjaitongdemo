package users.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import users.entity.User;
import users.hystrix.StoreIntegration;
import users.service.IUserService;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-08-01
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    StoreIntegration storeIntegration;

    @RequestMapping("/test")
    @Cacheable("user")
    public User test() {

        return userService.getById(1);
    }

    @CacheEvict(value = "user")
    public void update() {

    }

    @RequestMapping("/testhystrix/{time}")
    public Object testhystrix(@PathVariable("time") Long time) {


        return storeIntegration.getStores(time);
    }

}


