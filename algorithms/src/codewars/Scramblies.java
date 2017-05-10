package codewars;

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

	public static void main(String[] args) {
		System.out.println(Scramblies.scramble("javscripts", "javascript"));
	}
}
