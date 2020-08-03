package users.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


public  class HystrixService {
    @HystrixCommand(fallbackMethod = "HystrixServiceImpl",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            }
    )
    Object hystrixtest(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix成功";
    }
}
