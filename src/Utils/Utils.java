package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	public static boolean testIsPrime3(int n){
	       if (n <= 3) {
	            return n > 1;
	        }
	        
	       for(int i=2;i<=Math.sqrt(n);i++){
	           if(n%i == 0)
	               return false;
	       }
	       return true;
	   }
	
	public static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferedList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferedList.add(arr));
        return transferedList;
    }
}
