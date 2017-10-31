package com.hfuu.ssm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfuu.ssm.entity.User;
import com.hfuu.ssm.service.UserService;
import com.hfuu.ssm.utils.ApiResponseMessage;
import com.hfuu.ssm.utils.CodeConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("api/user")
@Api(value="api/user",description="用户接口")
public class UserController extends APIBaseAction{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "用户列表", notes = "用户列表", httpMethod = "GET")
	public ApiResponseMessage list(HttpServletRequest request) {
		try {
			List<User> list = userService.list();
			return json(list, "查询成功", CodeConstant.SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return json(null, "系统正忙", CodeConstant.FAIL);
		}
	}
}
