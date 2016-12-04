package org.xyz.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xyz.test.client.service.IUserService;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.web.constant.CommonUrl;
import org.xyz.test.web.constant.CommonUtils;
import org.xyz.test.web.execute.CommonExecute;
import org.xyz.test.web.execute.CommonExecutor;
import org.xyz.test.web.param.BaseParam;
import org.xyz.test.web.param.GetUserByAccountParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 2016/12/4.
 */
@Controller
public class UserController {

    @Resource(name = "userService")
    IUserService userService;

    @RequestMapping(value = CommonUrl.UrlConstant.GET_USER_BY_ACCOUNT, produces = CommonUtils.CONTENT_TYPE)
    @ResponseBody
    public String getUserByAccount(HttpServletRequest request, HttpServletResponse response, String account) {
        return CommonExecutor.execute(request, response, CommonUrl.GET_USER_BY_ACCOUNT.getParamClass(), new CommonExecute<GetUserByAccountParam>(){
            @Override
            public HttpResult execute(GetUserByAccountParam param) {
                HttpResult<UserDTO> result = userService.getUserByAccount(param.getAccount());
                return result;
            }
        });
    }
}
