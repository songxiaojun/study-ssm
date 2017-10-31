package com.hfuu.ssm.action;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hfuu.ssm.utils.ApiResponseMessage;

@Controller
public class APIBaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(APIBaseAction.class);
	
	@ExceptionHandler(Exception.class)  
	@ResponseBody
    public ApiResponseMessage exp(HttpServletRequest request, Exception ex) {  
        request.setAttribute("ex", ex);  
        // 根据不同错误转向不同页面  
        System.out.println("ccc:"+ex.getClass().getName());
        log.error("拦截错误:", ex);
        return json(null,"参数有误:" + ex,1);
    }  
	
/** ============================     ajax    =================================================  */
	
	/**   
	 * 返回ApiResponseMessage
	 * @param data
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage json(Object data) {
		return new ApiResponseMessage().success(data);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param data
	 * @param message
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage json(Object data, String message) {
		return json(data).setMessage(message);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param data
	 * @param message
	 * @param code
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage json(Object data, String message, int code) {
		return json(data, message).setCode(code);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param message
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage success(String message) {
		return new ApiResponseMessage().addSuccess(message);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param message
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage error(String message) {
		return new ApiResponseMessage().addError(message);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param message
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage warn(String message) {
		return new ApiResponseMessage().addWarn(message);
	}
	
	/**   
	 * 返回ApiResponseMessage
	 * @param message
	 * @return ApiResponseMessage
	*/
	public ApiResponseMessage fail(String message) {
		return new ApiResponseMessage().addFail(message);
	}
}
