package com.ruoyi.framework.sso;

/***
 * author: Jiang Hua
 */
public enum HttpResponseEnum {
	SUCCESS(200, "Success"), FAILED(9999, "Failed"),
	AUTH_STATUS_INCONSISTENT(9016, "请求状态不一致"),
	AUTH_CIAM_TOKEN_EXPIRED(9017, "BoschID会话过期,请重新点击登录"),
	AUTH_CIAM_TOKEN_REQUEST_FAILED(9018, "CIAM token api 请求失败"),
	ERROR_REQUEST(1400, "错误的请求"),
	UNAUTHORIZED(1401, "没有授权"),
	FORBIDDEN(1403, "没有权限访问"),
	NOT_FOND(1404, "页面不存在"),
	SERVER_ERROR(1500, "服务器错误"),
	ERROR_USERNAME(16001, "用户名错误"),
	ERROR_PASSWORD(16002, "密码错误"),
	TOKEN_EXPIRED(16003, "TOKEN过期"),
	USER_NOT_FOUND(16004, "用户不存在"),
	USER_TELEPHONE_HAS_BINDING(16005, "用户手机已经被绑定"),
	USER_WECHAT_HAS_BINDING(16005, "用户微信已经被绑定"),
	VERIFY_CODE_EXPIRED(16006, "验证码过期"),
	TELEPHONE_NOT_FOUND(16007, "手机号码不存在"),
	USER_EXISTS(16008, "用户已存在");
	private int responseCode;
	private String responseMSG;

	HttpResponseEnum(int responseCode, String responseMSG) {
		this.responseCode = responseCode;
		this.responseMSG = responseMSG;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseMSG() {
		return responseMSG;
	}
}
