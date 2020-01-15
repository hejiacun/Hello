package Utils.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 签名算法类
 *
 * @author xusheng
 */
public final class SignGenerate {

    private static Logger logger = LoggerFactory.getLogger(SignGenerate.class);
    private static Pattern pattern = Pattern.compile("\\{.*\\}|\\[.*\\]");

    /**
     * 签名生成算法
     *
     * @return sign
     * @param请求的所有参数必须已转换为字符串类型
     */
    public static String getSign(Map<String,String> params, String appSecret) {
        //Map<String, String> params = toHashMap(json);

        // 第一步：检查参数是否已经排序
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        for (Object key : keys) {
            query.append(key);
            if (!key.equals("file")) {//如果文件不计算在签名内
                String value = params.get(key.toString());
                //参数值如果是json数组、json类型、空值，都将不计算在签名内
                if (valueTypeQualified(value)) {
                    query.append(value);
                }
            }
        }

        String str = appSecret + query.toString() + appSecret;
        try {
            str = new String(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return StringEncrypt.encrypt(str, "MD5");

    }

    /**
     * 如果某个参数值类型为数组，将不计算在签名算法内
     * Author：xusheng
     * Date：2016.06.20
     *
     * @param str
     * @return
     */
    private static boolean valueTypeQualified(String str) {
        if (StringUtil.isEmpty(str) || str.equals("null")) {
            return false;
        }
        Matcher matcher = pattern.matcher(str);
        return !matcher.matches();
    }
}
