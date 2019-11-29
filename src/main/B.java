package main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class B {

	public static void main(String[] args) {
		System.out.println("========================开始");
		System.out.println("========================1");
		try {
			if (1==1) {
				throw new Exception();
			}
			System.out.println("成功");
		} catch (Exception e) {
			System.out.println("==========异常");
		}
		System.out.println("========================结束");
		System.out.println(idEncrypt("654321"));
		System.out.println(idEncrypt("987654321"));
		System.out.println(emailEncrypt("sfddf654321@sddff"));
		System.out.println(emailEncrypt("4321@sddff"));
		List<String> list = new ArrayList<>();
		list.add("dd");
		System.out.println(list);
		System.out.println(list.toString());
//		String email = "sfddf654321@sddff";
//		System.out.println(email.substring(0, email.indexOf("@")));
//		System.out.println(email.substring(email.indexOf("@")));
//		System.out.println(email.substring(0,email.length()-4));
//		System.out.println(email.substring(email.length()-4,email.length()));
	}

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

	public static String emailEncrypt(String email) {
		String id = email.substring(0, email.indexOf("@"));
		return idEncrypt(id, 2) + email.substring(email.indexOf("@"));
	}
}
