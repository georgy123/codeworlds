package codewars;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Write function scramble(str1,str2) that returns true if a portion of str1
 * characters can be rearranged to match str2, otherwise returns false.
 * 
 * For example: str1 is 'rkqodlw' and str2 is 'world' the output should return
 * true. str1 is 'cedewaraaossoqqyt' and str2 is 'codewars' should return true.
 * str1 is 'katas' and str2 is 'steak' should return false.
 * 
 * @author Wqz
 *
 *
 *         2017年5月8日上午9:23:43
 */
public class Scramblies {

	public static boolean scramble(String str1, String str2) {
		// int count =0;
		// for (int i = 0; i < str2.length(); i++) {
		// if(str1.contains(String.valueOf(str2.charAt(i))))
		// //少考虑情况javscripts，javascript因该是false
		// count++;
		// }
		// return str2.length()==count?true:false;
		if (str1.length() < str2.length())
			return false;
		else {
			int[] a = new int[256];
			int[] b = new int[256];
			for (int i = 0; i < str1.length(); i++) {
				a[str1.charAt(i)]++;
			}
			for (int j = 0; j < str2.length(); j++) {
				b[str2.charAt(j)]++;
			}
			for (int i = 0; i < 256; i++) {
				if (a[i] < b[i])
					return false;
			}

		}
          return true;
	}
	/**
	 * other 
	 * @param str1
	 * @param str2
	 * @return
	 */
	  public static boolean scramble2(String str1, String str2) {
	        LinkedList<Character> linkedList = new LinkedList<Character>();
	        for(char a: str1.toCharArray()){
	            linkedList.add(a);               //对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
	        }
	        for(char a: str2.toCharArray()) {
	            if(!linkedList.remove((Character)a)) {
	                return false;
	            }
	        }
	        return true;
	    }
	  /**
	   * other 2
	   * @param str1
	   * @param str2
	   * @return
	   */
	  public static boolean scramble3(String str1, String str2) {
	        if (str2.length() > str1.length()) return false;
	        for (String s: str2.split("")) {
	          if (!str1.contains(s))  return false;
	          str1 = str1.replaceFirst(s,"");              //每匹配一个就用去掉
	        }        
	        return true;
	    }
	  /**
	   * other 3
	   * @param str1
	   * @param str2
	   * @return 
	   */
	  public static boolean scramble4(String str1, String str2) {
	        Map<Integer, Integer> cnt = new HashMap<>();
	        str2.chars().forEach(i -> cnt.put(i, cnt.getOrDefault(i, 0) + 1));
	        str1.chars().filter(i -> cnt.containsKey(i)).forEach(i -> cnt.put(i, cnt.get(i) - 1));   //lamda表达式形式
	        return cnt.values().stream().filter(i -> i>0).count() == 0;
	    }
	public static void main(String[] args) {
		System.out.println(Scramblies.scramble("javscripts", "javascript"));
	}
}
