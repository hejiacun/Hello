package Utils.util;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	public static Map<String, Object> response(int code, String message) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", code);
		returnMap.put("msg", message);
		return returnMap;
	}
	
	public static Map<String, Object> response(int code, Object data, String message) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", code);
		returnMap.put("msg", message);
		returnMap.put("data", data);
		return returnMap;
	}
	
	public static Map<String, Object> response(ApiCodeEnum.BaseEnum baseEnum) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", baseEnum.getCode());
		returnMap.put("msg", baseEnum.getDesc());
		return returnMap;
	}

	public static Map<String, Object> response(ApiCodeEnum.BaseEnum baseEnum, Object data) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", baseEnum.getCode());
		returnMap.put("msg", baseEnum.getDesc());
		returnMap.put("data", data);
		return returnMap;
	}

	public static Map<String, Object> response(ApiCodeEnum.BaseEnum baseEnum, Object data,String msg) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", baseEnum.getCode());
		returnMap.put("data", data);
		if(StringUtil.hasBlank(msg)){
			returnMap.put("msg", baseEnum.getDesc());
		}else {
			returnMap.put("msg", msg);
		}
		return returnMap;
	}
	
	public static Map<String, Object> success() {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code", ApiCodeEnum.CommonCode.SUCCESS.getCode());
		returnMap.put("msg", ApiCodeEnum.CommonCode.SUCCESS.getDesc());
		return returnMap;
	}
}
