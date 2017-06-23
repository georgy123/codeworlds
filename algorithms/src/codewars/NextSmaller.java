package codewars;

import java.util.Arrays;

/**
 * 
 * Next smaller number with the same digits 
 * 
 * Write a function that takes a positive integer and returns the next smaller positive integer containing the
 * same digits. For example:
 * 
 * nextSmaller(21) == 12 nextSmaller(531) == 513 nextSmaller(2071) == 2017
 * 
 * Return -1, when there is no smaller number that contains the same digits.
 * Also return -1 when the next smaller number with the same digits would
 * require the leading digit to be zero.
 * 
 * nextSmaller(9) == -1 nextSmaller(111) == -1 nextSmaller(135) == -1
 * nextSmaller(1027) == -1 // 0721 is out since we don't write numbers
 * 
 * @author Wqz
 *
 *         写一个取正整数函数返回仅次于它的正整数 2017年6月7日下午9:01:12
 */
public class NextSmaller {

	/**
	 * 从前往后
	 * 
	 * @param n
	 * @return
	 */
	public static long nextSmaller(long n) {
		String[] splitNum = String.valueOf(n).split("");
		int division = 0;
		boolean flag = false;
		for (int i = 0; i < splitNum.length - 1; i++) {
			if (Integer.valueOf(splitNum[i]) > Integer.valueOf(splitNum[i + 1])) {
				division = i;                                                      
				flag = true;
			}
		}
//		for (int i = splitNum.length-1; i > 0; i--) {
//			if (Integer.valueOf(splitNum[i]) < Integer.valueOf(splitNum[i-1])) {
//				division = i-1;  
//				break;                 //从后向前判断i<i+1 记录i的位置第一次
//			}
//		}
		if (!flag)
			return -1;         //该数包含的数字不存在次小值
		for (int i = splitNum.length - 1; i > 0; i--) {
			String temp = "";
			if (division == i)
				i--;                           //这句可以去掉，不会出现这种情况
			if (Integer.valueOf(splitNum[i]) < Integer.valueOf(splitNum[division])) {
				temp = splitNum[i];
				splitNum[i] = splitNum[division];
				splitNum[division] = temp;
				break;
			}
		}
		if ("0".equals(splitNum[0]))
			return -1;
		String str = "";
		for (int i = 0; i <= division; i++) {
			str += splitNum[i];
		}
		String[] needSort = Arrays.copyOfRange(splitNum, division + 1, splitNum.length);
		Arrays.sort(needSort);
		for (int i = needSort.length - 1; i >= 0; i--) {
			str += needSort[i];
		}
		return Long.valueOf(str);
		
	}
	public static void main(String[] args) {
		int[] a = { 12, 3, 4, 5, 6, 7, 90 };
		int[] copyOfRange = Arrays.copyOfRange(a, 3, 4); // 5,6,7
		System.out.println(NextSmaller.nextSmaller(123456798));
	}
}
