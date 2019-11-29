package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import Utils.ObjectUtils;
import Utils.Utils;
import entity.Student;

public class Main {
	private static final String qwe = "fgh";
	public static void main(String[] args) throws Exception {
		String qwe = "sf";
		System.out.println(qwe);
		System.out.println(Main.qwe);
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(StringUtils.join(list.toArray(), ","));
		Table<String, String, Integer> tables = HashBasedTable.create();// 双键map
		tables.put("a", "javase", 80);
		tables.put("b", "javaee", 90);
		tables.put("c", "javame", 100);
		tables.put("d", "guava", 70);
		//得到所有行数据 tables.cellSet()
		System.out.println("得到所有行数据 tables.cellSet()");
		Set<Cell<String, String, Integer>> cells = tables.cellSet();
		for (Cell<String, String, Integer> temp : cells) {
			System.out.println(temp.getRowKey() + " " + temp.getColumnKey() + " " + temp.getValue());
		}
		// 得到所有学生 rowKeySet()
		System.out.println("得到所有学生 rowKeySet()");
		Set<String> students = tables.rowKeySet();
		for (String str : students) {
			System.out.print(str + "\t");
		}
		System.out.println();
		// 得到所有课程 columnKeySet()
		System.out.println("得到所有课程 columnKeySet()");
		Set<String> courses = tables.columnKeySet();
		for (String str : courses) {
			System.out.print(str + "\t");
		}
		System.out.println();
		// 得到所有成绩：values
		System.out.println("得到所有成绩：values");
		Collection<Integer> scores = tables.values();
		for (Integer in : scores) {
			System.out.print(in + "\t");
		}
		System.out.println();
		// 得到学生的课程成绩表 rowMap+get(stu)/row(stu)
		System.out.println("得到学生的课程成绩表 rowMap+get(stu)/row(stu)");
		for (String str : students) {
			Map<String, Integer> rowMap = tables.row(str);
			Set<Entry<String, Integer>> setEntry = rowMap.entrySet();
			for (Entry<String, Integer> entry : setEntry) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
		// 得到学生的姓名成绩表 columnMap+get(course)/column(course)
		System.out.println("得到学生的姓名成绩表 columnMap+get(course)/column(course)");
		for (String str : courses) {
			Map<String, Integer> rowMap2 = tables.column(str);
			Set<Entry<String, Integer>> setEntry2 = rowMap2.entrySet();
			for (Entry<String, Integer> entry : setEntry2) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
		
//		Student student = new Student();
//		student.setIds(null);
//		List<Integer> ids = student.getIds();
//		if (ids != null) {
//			
//		}
		List<Integer> list2 = Collections.singletonList(3);
//		list2.remove(Integer.valueOf(3));
//		list2.add(4);
		System.out.println(list2);
		String string = "{\"s\":\"dgfd\"}";
		try {
			Map<String, Object> map = ObjectUtils.json2Map(string);
			System.out.println(map.get("s"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student student = new Student();
		student.setAddress("asdd");
		student.setHelloWorld("hello");
		student.setWorld_hello("world");
		Map<String, Object> map = ObjectUtils.Object2Map(student);
		System.out.println(ObjectUtils.object2Json(student));
		System.out.println(map);
		
//		String key = "=RsTM6z1GZyGb9UKdD1t3tw==";
//		String s = AesUtils.encrypt(key, "hjc");
//		System.out.println(s);
//		System.out.println(AesUtils.decrypt(key, s));
		
		Integer[] REASONS = new Integer[] {22,40,41,42,43,44,45,46,47,48,49,99};
		List<Integer> list3 = Utils.transferArrayToList(REASONS);
		System.out.println(list3);
		list3.remove(2);
		System.out.println(list3);
		String lString = "[1,2,3]";
		List<String> list4 = ObjectUtils.json2List(lString, String.class);
		List<Integer > lIntegers = ObjectUtils.json2List(lString, Integer.class);
		System.out.println(lIntegers.get(1) + lIntegers.get(2));
		System.out.println(list4.get(2));
		System.out.println(Utils.testIsPrime3(5));
	}
}
