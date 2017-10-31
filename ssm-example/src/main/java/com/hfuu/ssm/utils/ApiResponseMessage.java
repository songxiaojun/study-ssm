package com.hfuu.ssm.utils;


public class ApiResponseMessage {
	// 返回状态码   (默认1:成功,0:失败)
	private int code = 1;

	// 返回的中文消息
	private String message;

	// 成功时携带的数据
	private Object data;

	public int getCode() {
		return code;
	}

	public ApiResponseMessage setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}
	
	public ApiResponseMessage setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ApiResponseMessage setData(Object data) {
		this.data = data;
		return this;
	}

	public ApiResponseMessage addSuccess(String message) {
		this.message = message;
		this.code = 0;
		this.data = null;
		return this;
	}

	public ApiResponseMessage addError(String message) {
		this.message = message;
		this.code = 0;
		this.data = null;
		return this;
	}

	public ApiResponseMessage addFail(String message) {
		this.message = message;
		this.code = 999;
		this.data = null;
		return this;
	}

	public ApiResponseMessage addWarn(String message) {
		this.message = message;
		this.code = 2;
		this.data = null;
		return this;
	}

	public ApiResponseMessage success(Object data) {
		this.message = "success";
		this.data = data;
		this.code = 1;
		return this;
	}

	public boolean isSuccess() {
		return getCode() == 1;
	}

	
}
