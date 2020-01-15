package Utils.util;

import org.springframework.util.DigestUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Utils {
    public static String generateToken(Integer id) {
        long time = System.currentTimeMillis();
        return time + getRandomStr() + id;
    }

    public static String getRandomStr() {
        char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int length = ch.length;
        Random r = new Random();
        return new String(new char[] {ch[r.nextInt(length)],
                ch[r.nextInt(length)],
                ch[r.nextInt(length)],
                ch[r.nextInt(length)],
                ch[r.nextInt(length)],
                ch[r.nextInt(length)]});
    }

    /**
     * 数组转list
     * @param array
     * @return
     */
    public static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferedList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferedList.add(arr));
        return transferedList;
    }

    /**
     * 电话脱敏
     * @param id
     * @return
     */
    public static  String idEncrypt(String id) {
        return idEncrypt(id, 4);
    }

    public static String idEncrypt(String id, int index) {
        if (id.isEmpty() || (id.length() <= index)) {
            return id;
        }
        if (id.length() <= index + 4) {
            String begin = id.substring(0, id.length() - index);
            String end = id.substring(id.length() - index, id.length());
            return begin.replaceAll("\\w", "*") + end;
        }
        return id.replaceAll("(\\w)(\\w{4})(\\w{" + index + "})$", "$1****$3");
    }

    /**
     * 邮箱脱敏
     * @param email
     * @return
     */
    public static String emailEncrypt(String email) {
        if (!email.contains("@")) {
            return email;
        }
        String id = email.substring(0, email.indexOf("@"));
        return idEncrypt(id, 2) + email.substring(email.indexOf("@"));
    }

    public static String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    public static Comparator<Map> getComparator(String property) {
        Comparator<Map> comparator = new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                return Double.valueOf(o1.get(property).toString()).compareTo(Double.valueOf(o2.get(property).toString()));
            }
        };
        return comparator;
    }

    public static String agentNameFilter(String str) throws PatternSyntaxException {
        // 只允许字母、数字、中文、空格、下划线 + - = .
        String regEx ="[^a-zA-Z0-9\\u4e00-\\u9fa5 _=.+\\-]";
        // 清除掉所有特殊字符
//		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static List<Integer> stringToIntegerLst(List<String> inList){
        List<Integer> iList =new ArrayList<Integer>(inList.size());
        try{
            for(int i=0,j=inList.size();i<j;i++){
                iList.add(Integer.parseInt(inList.get(i)));
            }
        }catch(Exception  e){
        }
        return iList;
    }
    
    public static String filterString(String str) {
        return str.replaceAll("\\s*", "")
                .replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "").toLowerCase();
    }
}
