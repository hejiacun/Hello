import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JWR {

	public static void main(String[] args) {
//		try {
//			FileWriter fileWriter=new FileWriter("text.txt");
//			fileWriter.write("123S");
//			fileWriter.close();
//			
//			FileReader fileReader=new FileReader("text.txt");
//			for (int c=fileReader.read(); c!=-1; c=fileReader.read()) {
//				System.out.print((char)c);
//			}
//			fileReader.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
