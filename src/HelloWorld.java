import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.Entry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import javax.sql.ConnectionPoolDataSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import annotation.HelloAnnotation;

@HelloAnnotation(say = "do it")
public class HelloWorld {
	private static String getKey(String pattern, Object... arguments) {
		return MessageFormat.format(pattern, arguments);
	}

	public static void main(String[] args) throws ParseException, IOException {
		System.out.println(9 & (8 - 1));// 按位与
		Integer sInteger = 100000;
		int in = 100000;
		System.out.println(in);
		System.out.println(sInteger);
		System.out.println(sInteger.toString());
		System.out.println(String.valueOf(in));
		System.out.println(Double.MAX_VALUE);
		System.out.println("=============================================");
		String teamId = "1111";
		String key = getKey("TEAM_QUEUE", teamId);
		System.out.println(key);
		long n = 200;
		float f = 1.39e-43f;
		System.out.println(f);
		double max = java.lang.Double.MAX_VALUE;
		System.out.println("Max double = " + max);
		double min = java.lang.Double.MIN_VALUE;
		System.out.println("Min double = " + min);
		float maxf = java.lang.Float.MAX_VALUE;
		System.out.println("Max float = " + maxf);
		float minf = java.lang.Float.MIN_VALUE;
		System.out.println("Min float = " + minf);
		System.out.println(Math.pow(n, 3));
		System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
		System.out.println("0度的余弦值：" + Math.cos(0));
		System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
		System.out.println("1的反正切值： " + Math.atan(1));
		System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Math.floor(3.1542));
		System.out.println(0x10);
		// 8进制输出
		Integer integer = 20;
		System.out.println(Integer.toOctalString(integer));
		System.out.println("=============================================");
		// 注解
		HelloAnnotation annotation = HelloWorld.class.getAnnotation(HelloAnnotation.class);
		System.out.println(annotation.say());
		System.out.println("=============================================");
		String str = "douhao,";
		int indx = str.lastIndexOf(",");
		String str1 = null;
		String str2 = null;
		if (indx != -1) {
			str1 = str.substring(0, indx);
			str2 = str.substring(indx + 1, str.length());
		}
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("=============================================");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		System.out.println(list1.toString());
		for (Integer i : list1) {
			// System.out.println(i.byteValue());
			System.out.println(i + "");
		}
		System.out.println(Collections.max(list1));
		// // int page = 2;
		// // int count = 5;
		// // int start = (page-1)*count;
		// // List<Integer> list1=new ArrayList<Integer>();
		// // for (int i = start; i < start+count && i < list.size(); i++) {
		// // list1.add(list.get(i));
		// // }
		// // System.out.println(list1);
		System.out.println("=============================================");
		// Map的打印
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 8);
		map.put("name", "jay");
		ObjectMapper oMapper = new ObjectMapper();
		System.out.println(oMapper.writeValueAsString(map));
		System.out.println(map.toString());
		System.out.println(map.hashCode());
		//map的遍历
		Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iter.next();
			String k = entry.getKey();
			Object v = entry.getValue();
			System.out.println(k+":"+v);
		}
		System.out.println("=============================================");
		//// //String的比较
		//// String s1 = "hello";
		//// String s2 = new String("hello");
		//// String s3 = "hello";
		//// String s4 = s2.intern();
		//// int h1=s1.hashCode();
		//// int h2=s2.hashCode();
		//// int h3=s3.hashCode();
		//// int h4=s4.hashCode();
		//// if (s1.intern() == s2.intern()) {
		//// System.out.println("hello");
		//// } else {
		//// System.out.println("world");
		//// }
		//// System.out.println("=============================================");
		// //常量池-128,127
		//// Integer i1=10;
		//// Integer i2=10;
		//// System.out.println(i1==i2);
		//// Long i3=-129l;
		//// Long i4=-129l;
		//// System.out.println(i3==i4);
		//// System.out.println("=============================================");
		// // Integer id=(Integer) map.get("id");
		// // System.out.println(id);
		// //时间戳
		// // Timestamp d = new Timestamp(System.currentTimeMillis());
		// // Timestamp loginTime1=new Timestamp(75, 01, 01, 00, 00, 0, 0);
		// // Long loginTime=loginTime1.getTime();
		// // System.out.println(loginTime1);
		// // System.out.println(loginTime);
		// // System.out.println(d);
		//// System.out.println("=============================================");
		// //子字符串
		// // String test = "This is test for string";
		// // System.out.println(test.indexOf("This")); //0
		// // System.out.println(test.indexOf("s")); //2
		// // System.out.println(test.indexOf("test")); //8
		// // System.out.println(test.indexOf("for")); //13
		// // System.out.println(test.indexOf("for string "));//-1
		// //
		// // if (test.indexOf("this")!=-1){
		// // //"只要test.indexOf('this')返回的值不是-1说明test字符串中包含字符串'this',相反如果包含返回的值必定是-1"
		// // System.out.println("存在包含关系，因为返回的值不等于-1");
		// //
		// // }else{
		// //
		// // System.out.println("不存在包含关系，因为返回的值等于-1");
		// // }
		// // System.out.println("=============================================");
		//
		// Date date = new Date(0);
		// System.out.println(date);
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd
		//// HH:mm:ss");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		// System.out.println(simpleDateFormat.format(date));
		// System.out.println(sdf.format(date));
		// Timestamp time = Timestamp.valueOf("2010-10-07 14:30:30");
		// Long long1 = time.getTime();
		// System.out.println(time);
		// System.out.println(long1);
		// System.out.println("=============================================");
		// // String string="abctygf";
		// // String string2="Ct";
		// // System.out.println(string.contains(string2));
		//
		// // Jedis jedis=new Jedis("localhost");
		// // System.out.println("连接成功");
		// // //Redis Java String(字符串) 实例
		// // jedis.set("runoobkey", "www.runoob.com");
		// // System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
		// // //Redis Java List(列表) 实例
		// // jedis.rpush("list", "Hello");
		// // jedis.rpush("list", "world");
		// // jedis.rpush("list", "!");
		// // List<String> lStrings=jedis.lrange("list", 0, 2);
		// // System.out.println(lStrings);
		// // //Redis Java Keys 实例
		// //// Set<String> keys=jedis.keys("*");
		// //// Iterator<String> iterator=keys.iterator();
		// //// while (iterator.hasNext()) {
		// //// String key = (String) iterator.next();
		// //// System.out.println(key);
		// //// }
		// // //Redis Java set 实例
		// // jedis.hset("myhash", "jay", "hjc");
		// // System.out.println(jedis.hget("myhash", "jay"));
		// //// System.out.println("服务器正在运行"+jedis.ping());
		// // jedis.zadd("myzet", 10, "a");
		// // System.out.println(jedis.zrange("myzet", 0, -1));
		// // jedis.close();
		//// System.out.println("=============================================");
		//
		//
		// // User user = new User();
		// // user.setName("小民");
		// // user.setEmail("xiaomin@sina.com");
		// // user.setAge(20);
		// //
		// // SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		// // user.setBirthday(dateformat.parse("1996-10-01"));
		// //
		// // /**
		// // * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
		// // * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
		// // * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
		// // * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
		// // * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
		// // * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
		// // */
		// // ObjectMapper mapper = new ObjectMapper();
		// //
		// // //User类转JSON
		// //
		//// //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
		// // String json = mapper.writeValueAsString(user);
		// // System.out.println(json);
		// //
		// // String json1 =
		// //
		//// "{\"name\":\"小明\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
		// //
		// // /**
		// // * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
		// // */
		// //// ObjectMapper mapper = new ObjectMapper();
		// // User user1 = mapper.readValue(json1, User.class);
		// // System.out.println(user1.toString());
		//// int h = 0x10000000;
		//// System.out.println((Integer.toBinaryString(h)));
		//// for(int i = 0; i < 28; i++) {
		//// h >>>= 1;
		//// System.out.println((Integer.toBinaryString(h)));
		//// }
		//// int h = -1;
		//// System.out.println(Integer.toBinaryString(h));
		//// h <<= 10;
		//// System.out.println(Integer.toBinaryString(h));
		//// for(int i = 0; i < 32; i++) {
		//// h >>>= 1;
		//// System.out.println(Integer.toBinaryString(h));
		//// }
		//// System.out.println(Integer.toBinaryString('b'));
		//// System.out.println(Integer.parseInt("11", 16));
		//// System.out.println(Math.cos(3.1415926));
		//// List<Integer> Id = new ArrayList<Integer>();
		//// Id.add(3);
		//// Id.add(7);
		//// Id.add(2);
		//// Id.add(8);
		//// map.put("childrenId", Id);
		//// List<Integer> childrenId = (List<Integer>) map.get("childrenId");
		//// StringBuffer stringBuffer = new StringBuffer();
		//// for (Integer integer2 : childrenId) {
		//// stringBuffer.append(integer2.toString()+",");
		//// }
		//// stringBuffer.deleteCharAt(stringBuffer.length()-1);
		//// System.out.println(stringBuffer.toString());
		//// String filename = System.currentTimeMillis() + ".xlsx";
		//// System.out.println(filename);
		// char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		//// 'n', 'o', 'p', 'q', 'r', 's', 't',
		// 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
		//// '9'};
		// int length = ch.length;
		// Random r = new Random();
		// String hjc = new String(new char[] {ch[r.nextInt(length)],
		// ch[r.nextInt(length)],
		// ch[r.nextInt(length)],
		// ch[r.nextInt(length)],
		// ch[r.nextInt(length)],
		// ch[r.nextInt(length)]});
		// System.out.println(hjc);
		// System.out.println(System.currentTimeMillis());
		//// Timestamp d = new Timestamp(System.currentTimeMillis());
		//// Long loginTime = d.getTime();
		//// System.out.println(loginTime);
		//// String string = "{1}";
		//// System.out.println(string.length() > 2 ? 1 : 0);
		// Map<Integer, String> map1 = new HashMap<>();
		// for (int i = 0; i < 10; i++) {
		// // putIfAbsent使得我们不用写是否为null值的检测语句；
		// map1.putIfAbsent(i, "val_" + i);
		// }
		//
		// // -------1------maps不支持流。然而现在maps包括了许多新的非常有用的方法用于执行通用任务:
		// // forEach使用consumer来对map中的每个元素进行操作,执行通用任务。
		// Set<Integer> set = map1.keySet();
		// for (Integer integer : set) {
		// System.out.println(map1.get(integer));
		// }
		// long ms = 30 * 1000;// 毫秒数
		// SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//
		// 初始化Formatter的转换格式。
		// formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		// String hms = formatter.format(ms);
		// // String hString= formatter.forma
		// System.out.println(hms);
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd
		// HH-mm-ss");
		// long time3 = System.currentTimeMillis() + 5000 * 1000;
		// Date date2 = new Date(time3);
		// date2.setTime(time3);
		// System.out.println(simpleDateFormat.format(date2));
		//
		// System.out.println(converLongTimeToStr(ms));
		//
		// NumberFormat percentFormat = NumberFormat.getPercentInstance();
		// percentFormat.setMaximumFractionDigits(2); // 最大小数位数
		// // percentFormat.setMaximumIntegerDigits(2);//最大整数位
		// // percentFormat.setMinimumFractionDigits(2); //最小小数位数
		// // percentFormat.setMinimumIntegerDigits(1);//最小整数位数
		// String string111 = percentFormat.format(1.2455d);// 自动转换成百分比显示..
		// System.out.println(string111);

		// List<String> header = new ArrayList<>();
		// // String[] headers = new String[] {};
		// String[] headers = new String[] { "Agent", "Total Login Time", "AVG Respond
		// Time", "Total Chat Time",
		// "AVG Chat Time", "Chats", "Evaluated", "Evaluated Rate", "Very Satisfied",
		// "Very Satisfied Rate",
		// "Satisfied", "Satisfied Rate", "General", "General Rate", "Dissatisfied",
		// "Dissatisfied Rate",
		// "Very Dissatisfied", "Very Dissatisfied Rate" };
		// header.addAll(Arrays.asList(headers));
		// System.out.println(header);
		// List<String> header = new ArrayList<>();
		//// List<String> headers = new ArrayList<>();
		// Set<String> headers = new HashSet<>();
		// for (String string : headers) {
		// if ("".equals(string)) {
		// System.out.println("head");
		// }
		// }
		// headers.add("Agent");
		// headers.add("Evaluated");
		// headers.add("General");
		// headers.forEach(System.out::println);
		// Map<String, Object> param =new HashMap<>();
		// param.put("field", headers);
		// ObjectMapper objectMapper = new ObjectMapper();
		// header =
		// objectMapper.readValue(objectMapper.writeValueAsString(param.get("field")),
		// new TypeReference<List<String>>() {
		// });
		// Comparator<String> comparator = (h1, h2) -> h1.compareTo(h2);
		// header.sort(comparator.reversed());
		// System.out.println(header);
		// 反向迭代
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("score", 32l);
		map1.put("name", "vfghd");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("score", 53l);
		map2.put("name", "gtgds");
		Map<String, Object> map3 = new HashMap<>();
		map3.put("score", 34l);
		map3.put("name", "tgrsd");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		int j = list.size() - 1;
		while (j >= 0) {
			System.out.println(list.get(j));
			j--;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
		ListIterator<Map<String, Object>> iListIterator = list.listIterator(list.size());
		while (iListIterator.hasPrevious()) {
			Map<String, Object> map4 = iListIterator.previous();
			System.out.println(map4);

		}
		// 排序
		// Comparator<Map<String, Object>> comparator = new Comparator<Map<String,
		// Object>>() {
		// @Override
		// public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		//// return (int) (Long.valueOf(o1.get("score").toString()) -
		// Long.valueOf(o2.get("score").toString()));
		// return
		// Long.valueOf(o1.get("score").toString()).compareTo(Long.valueOf(o2.get("score").toString()));
		// }
		// };
		// getComparator("score");
		Collections.sort(list, getComparator("score").reversed());// 倒序
		System.out.println(list);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("fd");
		if (stringBuilder.length() > 0)
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		System.out.println(stringBuilder);
		// Collections.reverse(list);
		// Iterator<Map<String, Object>> iterator = list.iterator();
		//// Comparator cmp = Collections.reverseOrder();
		//// Comparator<Map<String, Object>> comparator2 = (h1,h2) -> ((Long)
		// h1.get("score")).compareTo((Long) h1.get("score"));
		//// Collections.sort(list,comparator2);
		////// list.sort(comparator2.reversed());
		// System.out.println(list);
		// param.put("9", "h");
		// param.merge("9", "ello", (value,newValue)->((String) value).concat((String)
		// newValue));
		// System.out.println(param);
		// Map<Integer, String> map = new HashMap<>();
		// map.put(1, "h");
		// map.put(2, "e");
		// map.put(3, "l");
		// map.put(4, "l");
		// map.put(5, "o");
		//// map.getOrDefault(44, "world");
		// map.compute(3, (num, val) -> val + num*10);
		//// map.forEach((key,value) -> value.concat("a"));
		// map.forEach((key,value) -> System.err.println(key +" : "+value));
		// Long waitedTime = (long) ((Double.valueOf("100.3"))*1000);
		// int count = 5;
		// long g = waitedTime / count;
		// System.out.println(g);
		// System.out.println(waitedTime);

		// List<String> list = new ArrayList<>();
		// list.add("abc");
		// list.add("hello");
		// list.add("world");
		// list.add("test");
		// Iterator<String> iterator2 = list.iterator();
		// ListIterator<String> iterator1 = list.listIterator();
		// ListIterator<String> iterator = list.listIterator(list.size());
		// while(iterator.hasPrevious()){
		// System.out.println(iterator.previous());
		// }
		System.out.println(md5("lhp"));

		// //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
		// ServerSocket serverSocket = new ServerSocket(12345);
		// InetAddress address = InetAddress.getLocalHost();
		// String ip = address.getHostAddress();
		// Socket socket = null;
		// //2.调用accept()等待客户端连接
		// System.out.println("~~~服务端已就绪，等待客户端接入~，服务端ip地址: " + ip);
		// socket = serverSocket.accept();
		// //3.连接后获取输入流，读取客户端信息
		// InputStream is=null;
		// InputStreamReader isr=null;
		// BufferedReader br=null;
		// OutputStream os=null;
		// PrintWriter pw=null;
		// is = socket.getInputStream(); //获取输入流
		// isr = new InputStreamReader(is,"UTF-8");
		// br = new BufferedReader(isr);
		// String info = null;
		// while((info=br.readLine())!=null){//循环读取客户端的信息
		// System.out.println("客户端发送过来的信息" + info);
		// }
		// socket.shutdownInput();//关闭输入流
		// socket.close();
		test1(-3);
		System.out.println("=============================================");
		List<Integer> integers = new ArrayList<>();
		integers.add(3);
		for (Integer integer2 : integers) {
			System.out.println(integer2);
		}
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			Integer integer2 = (Integer) iterator.next();
			if (integer2 > 2) {
				iterator.remove();
			}
		}
		System.out.println("list:"+integers);
	}

	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字 // 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code += "0";
		}
		return md5code;
	}

	public static String converLongTimeToStr(long time) {
		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;

		long hour = (time) / hh;
		long minute = (time - hour * hh) / mi;
		long second = (time - hour * hh - minute * mi) / ss;

		String strHour = hour < 10 ? "0" + hour : "" + hour;
		String strMinute = minute < 10 ? "0" + minute : "" + minute;
		String strSecond = second < 10 ? "0" + second : "" + second;
		if (hour > 0) {
			return strHour + ":" + strMinute + ":" + strSecond;
		} else {
			return "00:" + strMinute + ":" + strSecond;
		}
	}

	public static Comparator<Map<String, Object>> getComparator(String property) {
		Comparator<Map<String, Object>> comparator = new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				// return (int) (Long.valueOf(o1.get(property).toString()) -
				// Long.valueOf(o2.get(property).toString()));
				return Long.valueOf(o1.get(property).toString()).compareTo(Long.valueOf(o2.get(property).toString()));
			}
		};
		return comparator;
	}
	private static void test1(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}
