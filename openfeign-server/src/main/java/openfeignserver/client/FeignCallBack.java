package openfeignserver.client;

import org.springframework.stereotype.Component;
import users.entity.User;

@Component
public class FeignCallBack implements OpenFeignClient{
    @Override
    public User getUsers() {
        System.out.println("feigen 获取user出错了");
        return null;
    }
}
