package com.user.app.remote;

import com.user.common.model.CodeMsg;
import com.user.app.model.user.UserBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Profile("!mock")
@FeignClient(name = "user-general",fallback = UserAppFallback.class)
@RequestMapping(value = "/userBase")
public interface UserAppFeignService {


    @RequestMapping(value = "/saveUserBase",method = RequestMethod.POST)
    @ResponseBody
    CodeMsg saveUserBase(@RequestBody UserBase userBase)throws Exception;

}
