package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Mixing {
	public static String mix(String s1, String s2) {
         String[] str1 = s1.split(" ");
         String[] str2 = s2.split(" ");
         int[] a = new int[128];  // lowercase letters ->ascll
         int[] b = new int[128]; 
         Map<String,Integer> map1 = new HashMap<String,Integer>();
         Map<String,Integer> map2 = new HashMap<String,Integer>();
         for (String let1: str1) {
			for (int i = 0; i < let1.length(); i++) {
				a[let1.charAt(i)]++;
			}
		}
         for (String let2: str2) {
 			for (int i = 0; i < let2.length(); i++) {
 				b[let2.charAt(i)]++;
 			}
 		}
         for(int j =97; j<=122; j++){
        	 if(a[j]!=0) map1.put(String.valueOf((char)j), a[j]);
        	 if(b[j]!=0) map2.put(String.valueOf((char)j), b[j]);
         }
         List<Map.Entry<String, Integer>> amaps = new ArrayList<Map.Entry<String,Integer>>(map1.entrySet());
         List<Map.Entry<String, Integer>> bmaps = new ArrayList<Map.Entry<String,Integer>>(map2.entrySet());
         Collections.sort(amaps,(o1,o2)->{return o2.getValue().compareTo(o1.getValue());});
         Collections.sort(bmaps,(o1,o2)->{return o2.getValue().compareTo(o1.getValue());});
         for(Entry<String, Integer> mapping:amaps){
             System.out.println(mapping.getKey()+" "+mapping.getValue());
        } 
     	return null;
	}
	  public static void main(String[] args) {
		Mixing.mix("In many languages", "there's a pair of functions");
	}
}
