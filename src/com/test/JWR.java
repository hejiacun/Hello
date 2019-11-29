package com.test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 */
public class JWR {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("hello");
		list.add("world");
		list.add("test"); 
		ListIterator<String>  iterator = list.listIterator(list.size());
		while(iterator.hasPrevious()){
			System.out.println(iterator.previous());
		}
	}

}
