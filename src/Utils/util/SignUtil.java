package Utils.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author: hejiacun
 * @create: 2019-07-31
 **/
public class SignUtil {
    /**
     * 签名生成算法
     *
     * @return sign
     * @param请求的所有参数必须已转换为字符串类型
     */
    public static String getSign(Map<String, Object> params, String appSecret) {

        // 第一步：检查参数是否已经排序
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        for (Object key : keys) {
            if (!key.equals("file")) {//如果文件不计算在签名内
                query.append(key).append(":");
                String value = params.get(key.toString()).toString();
                query.append(value).append("&");
            }
        }

        String str = query.append("chat_training").append(":").append(appSecret).toString();
        try {
            str = new String(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Utils.md5(str);

    }
}
