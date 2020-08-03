package openfeignserver.controller;

import openfeignserver.client.OpenFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/openfeign")
@RestController
public class OpenFeignController {
    @Autowired
    private OpenFeignClient openFeignClient;

    @RequestMapping("/aaa")
    public Object aaa() {
            return openFeignClient.getUsers();
    }
}
