package com.gzbeishan.config;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;


public class BasicResult implements Serializable {

	private String code;
	private String msg;
	private JSONObject response = new JSONObject();

	@JsonIgnore
	public boolean isSuccess() {
		if (!StringUtils.isEmpty(code) && code.trim().equals("0")) {
			return true;
		}
		return false;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JSONObject getResponse() {
		return response;
	}

	private void setResponse(JSONObject response) {
		this.response = response;
	}

	public void setResponse(Object obj) {
		setResponse(JSONObject.parseObject(JSONObject.toJSON(obj).toString()));
	}

	@JsonIgnore
	public JSONArray getResponseDatas() {
		if (response == null) {
			return new JSONArray();
		}
		return (JSONArray) response.get("datas");
	}

	public <T> void setResponseDatas(List<T> datas) {
		if (response == null) {
			response = new JSONObject();
		}
		if (datas == null) {
			JSONArray jsonArray = new JSONArray();
			response.put("datas", jsonArray);
		} else {
			response.put("datas", datas);
		}
	}

	public static BasicResult createSuccessResult(String msg, JSONObject response) {
		BasicResult basicResult = createSuccessResult();
		basicResult.setMsg(msg);
		basicResult.setResponse(response);
		return basicResult;
	}

	public static <T> BasicResult createSuccessResultWithDatas(String msg, List<T> datas) {
		BasicResult basicResult = createSuccessResult();
		basicResult.setMsg(msg);
		basicResult.setResponseDatas(datas);
		return basicResult;
	}

	public static BasicResult createSuccessResult(String msg) {
		BasicResult basicResult = createSuccessResult();
		basicResult.setMsg(msg);
		return basicResult;
	}

	public static BasicResult createFailResult(String msg) {
		BasicResult basicResult = createFailResult();
		basicResult.setMsg(msg);
		return basicResult;
	}

	public static BasicResult createSuccessResult() {
		BasicResult basicResult = new BasicResult();
		basicResult.setCode("0");
		basicResult.setMsg("请求成功！");
		return basicResult;
	}

	public static BasicResult createFailResult() {
		BasicResult basicResult = new BasicResult();
		basicResult.setCode("1");
		basicResult.setMsg("请求失败！");
		return basicResult;
	}
}
