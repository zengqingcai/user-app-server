package com.user.app.remote;


import com.user.common.model.CodeMsg;
import com.user.common.model.CodeMsgEnum;
import com.user.app.model.user.UserBase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value = "appFall")
public class UserAppFallback implements UserAppFeignService{


	@Override
	public CodeMsg saveUserBase(UserBase userBase) throws Exception {
		return new CodeMsg(CodeMsgEnum.OTHER_FAST);
	}
}
