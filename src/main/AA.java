package main;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName ListUtilTest
  * @Description (List去重3种方式及性能比较)
  * @author ZHY
  * @date 2018年6月29日 下午9:18:20
  * @Copyright © 2018【www.zhy.com Inc. All rights reserved.】
  */
public class AA{
//	private static final Logger logger = LoggerFactory.getLogger(AA.class);
	private static List<String> list = new ArrayList<>();
	private static int num = 10000;

	@Before
	public void init() {
		list.add("1");
		list.add("1");
		list.add("3");
		list.add("4");
		list.add("4");
		list.add("2");
		list.add("2");
		list.add("5");
		for (int i = 0; i < num; i++) {
			list.add(i + "");
		}
	}

	@Test
	public void testDistinct() {
		System.out.println("测试{}条数据"+num);
		long startTime1 = System.currentTimeMillis();
// 原始代码去重
		List<String> distinctionList = new ArrayList<>();
		for (String string : list) {
			if (!distinctionList.contains(string)) {
				distinctionList.add(string);
			}
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("原始代码去重耗时：{}（ms）"+(endTime1-startTime1));
		assertThat(distinctionList, hasItems("1", "2", "3", "4", "5"));
// Set去重（元素是无序的）
		long startTime2 = System.currentTimeMillis();
		Set<String> distinctionSet = new HashSet<>();
		distinctionSet.addAll(list);
		long endTime2 = System.currentTimeMillis();
		System.out.println("Set去重（元素是无序的）耗时：{}（ms）"+(endTime2-startTime2));
		assertThat(distinctionList, hasItems("1", "2", "3", "4", "5"));
// Jdk1.8函数式，优雅实现数据去重
		long startTime3 = System.currentTimeMillis();
		list.stream().distinct().collect(Collectors.toList());
		long endTime3 = System.currentTimeMillis();
		System.out.println("Jdk1.8函数式，优雅实现数据去重耗时：{}（ms）"+(endTime3-startTime3));
		assertThat(distinctionList, hasItems("1", "2", "3", "4", "5"));
	}
}
