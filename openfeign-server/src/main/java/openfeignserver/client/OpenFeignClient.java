package openfeignserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import users.entity.User;

import java.util.List;

@FeignClient(value = "USER-SERVER",fallback = FeignCallBack.class)//指定调用user-server的接口
public interface OpenFeignClient {

    // user-server controller的方法
    @GetMapping("/test")
    public User getUsers();
}
