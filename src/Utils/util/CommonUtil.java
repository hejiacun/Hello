package Utils.util;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by djb
 * on 2014/11/17.
 */
public class CommonUtil {
    //sha256 加密
    public static String bytes2Hex(String msg) {
        byte[] bt = msg.getBytes();
        MessageDigest md = null;
        String des = "";
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(bt);
            byte[] bts = md.digest();
            String tmp = null;
            for (int i = 0; i < bts.length; i++) {
                tmp = (Integer.toHexString(bts[i] & 0xFF));
                if (tmp.length() == 1) {
                    des += "0";
                }
                des += tmp;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return des;
    }

    /**
     * 时间分割
     */
    public static List<String> getTimeRange(Long timeLong) {
        List<String> list = new ArrayList<>();
        if (timeLong > 0) {
            for (int i = 0; i < 96; i++) {
                Long newTime = timeLong + i * 15 * 60 * 1000;
                String str = DateUtil.formatLong2String(newTime, DateUtil.DATEPATTERN_HHMM);
                list.add(str);
            }
            list.add("24:00");
        }
        return list;
    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断为金额
     *
     * @param str
     * @return
     */
    public static boolean isPrice(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断为金额
     *
     * @param str
     * @return
     */
    public static boolean isPrice4DecimalPlaces(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,4})?$"); // 判断小数点后4位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches()) {
            return true;
        }
        return false;
    }


    /**
     * 随机
     *
     * @param digit :位数
     * @param scope :范围
     * @return
     */
    public static String getRandomNum(int digit, int scope) {

        StringBuffer randomnum = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            randomnum.append(random.nextInt(scope));
        }
        return randomnum.toString();
    }

    /**
     * 将传入的数据，转化为BigDecimal
     * 如果为空，返回BigDecimal.ZERO
     *
     * @param str
     * @return BigDecimal类型数据
     */
    public static BigDecimal parseAmt(Object str) {
        if (str != null && !"".equals(String.valueOf(str).trim())) {
            return new BigDecimal(String.valueOf(str).trim());
        } else {
            return BigDecimal.ZERO;
        }
    }

    /**
     * 将list转化为string,之间用英文半角逗号分割
     *
     * @param list 传入集合
     * @return 返回拼接后的字符串
     */
    public static String transListToString(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (String str : list) {
            strBuilder.append(str).append(",");
        }
        strBuilder.deleteCharAt(strBuilder.length() - 1);
        return strBuilder.toString();
    }

    /**
     * 将list转化为string,之间用英文半角逗号分割
     *
     * @param list 传入集合
     * @return 返回拼接后的字符串
     */
    public static String transIntegerListToString(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (Integer str : list) {
            strBuilder.append(str).append(",");
        }
        strBuilder.deleteCharAt(strBuilder.length() - 1);
        return strBuilder.toString();
    }

    /**
     * 将英文半角逗号分割的字符串，转化为数组
     *
     * @param srcStr 前端传入字符串
     * @return 返回数组集合
     */
    public static List<String> transStringToList(String srcStr) {
        if (StringUtils.isBlank(srcStr)) {
            return null;
        }
        String[] descStr = srcStr.split(",");
        List<String> descs = new ArrayList<>();
        for (int i = 0, size = descStr.length; i < size; i++) {
            descs.add(descStr[i]);
        }
        return descs;
    }

    /**
     * 将英文半角逗号分割的字符串 转化为map，每个子串作为key
     *
     * @param srcStr 前端传入字符串
     * @return 返回map
     */
    public static Map<String, String> transStringToMap(String srcStr) {
        if (StringUtils.isBlank(srcStr)) {
            return null;
        }
        String[] descStr = srcStr.split(",");
        Map<String, String> descs = new HashMap<String, String>();
        for (int i = 0, size = descStr.length; i < size; i++) {
            descs.put(descStr[i], "");
        }
        return descs;
    }


    /**
     * 获取length位的数字串
     *
     * @param length
     * @return
     */
    public static String randomNumStr(int length) {
        String num = "0123456789";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(num.charAt(random.nextInt(num.length())));
        }
        return sb.toString();
    }


    /**
     * 将字符数组，放在map中
     *
     * @param arrayStr 需要传入的字符串 形如：["ar","fr","pl","en","tw"]
     * @return
     */
    public static Map<String, String> transArrayStrToMap(String arrayStr) {
        //这里比较特殊，需要考虑字符串null的情况
        if (StringUtils.isBlank(arrayStr) || StringUtils.equals(arrayStr, "null")) {
            return null;
        }
        List<String> list = JSONArray.parseArray(arrayStr, String.class);
        Map<String, String> transMap = new HashMap<>();
        for (String str : list) {
            transMap.put(str, str);
        }
        return transMap;
    }


    /**
     * 将String转换为Integer类型，如果不为数字的话，返回0
     *
     * @param orgParam 传入字符串
     * @return 转换后的Integer类型数据
     */
    public static Integer transStringToInteger(String orgParam) {
        if (isNumber(orgParam)) {
            return Integer.parseInt(orgParam);
        }
        return 0;
    }


    /**
     * 将String转换为Integer类型
     *
     * @param destinationCountryStr 传入字符串
     * @return 转换后的Integer类型数据
     */
    public static String generateWaybillNo(int tmsOrderId, String destinationCountryStr) {
        if (StringUtils.isEmpty(destinationCountryStr)) {
            return "";
        }
        //String fixLenthString = getFixLenthString(10);
        String fixLenthString = String.valueOf(1000000000 + tmsOrderId);
        return "JCL" + fixLenthString + destinationCountryStr;
    }

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     */
    private static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        int pross = (int) ((1 + rm.nextDouble()) * Math.pow(10, strLength));
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(0, strLength);
    }

    /**
     * 两个数相除得到double的数据
     */
    public static Double getDoubleData(Long a, Long b, int num) {

        if (a == null || b == null||a == 0 || b == 0) {
            return 0.00;
        }
        double f1 = new BigDecimal((float) a / b).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
    /**
     * 两个数相除得到long的数据
     */
    public static Long getLongData(Long a, Long b) {

        if (a == 0 || b == 0 || a == null || b == null) {
            return 0L;
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(getDoubleData(38l,367624l,2));
    }

    /**
     * 两个数相除得到String的数据
     */
    public static String getStringDoubleData2(Long a, Long b, int num) {

        if (a == null || b == null||a == 0 || b == 0) {
            return "0";
        }
        double f1 = new BigDecimal((float) a / b).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        //return String.valueOf(f1 * 100) + "%"; 偶尔出现精度丢失,如getStringDoubleData(4L,8L,4)
        return new BigDecimal(Double.toString(f1)).multiply(new BigDecimal(100)).doubleValue()+"";
    }

    /**
     * 两个数相除得到String的数据
     */
    public static String getStringDoubleData(Long a, Long b, int num) {

        if (a == null || b == null||a == 0 || b == 0) {
            return "0%";
        }
        double f1 = new BigDecimal((float) a / b).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        //return String.valueOf(f1 * 100) + "%"; 偶尔出现精度丢失,如getStringDoubleData(4L,8L,4)
        double result = new BigDecimal(Double.toString(f1)).multiply(new BigDecimal(100)).doubleValue();
        if(result > 100d){
            result = 100d;
        }
        return result+"%";
    }

    /**
     * 对map进行排序
     */
    public static void comparator(List<Map<String, Object>> data, final String key) {
        Collections.sort(data, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                if (o1.get(key) == null || o2.get(key) == null) {
                    return -1;
                }
                Double d1 = Double.valueOf(o1.get(key).toString());
                Double d2 = Double.valueOf(o2.get(key).toString());
                return d1.compareTo(d2);
            }
        });
    }


    private static Object getValue(Object ob, final String strField) {
        try {
            Field field = ob.getClass().getDeclaredField(strField);
            field.setAccessible(true);
            return field.get(ob);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    /**
     * 获取0-(lenth-1)范围随机整数
     * @param lenth
     * @return
     */
    public static int getRandom(int lenth) {
        Random r = new Random();
        return r.nextInt(lenth);
    }

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
