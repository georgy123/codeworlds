package codewars;

/**
 * In this kata you get the start number and the end number of a region and should return 
 * the count of all numbers except numbers with a 5 in it. The start and the end number are both inclusive!
Examples:
1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
The result may contain fives. 
The start number will always be smaller than the end number. Both numbers can be also negative!
 *
 *@author wqz
 *
 * @date 2017年4月14日 下午9:07:00
 */
public class DontGiveMeFive {
 
	
	/**
	 * 返回不包含5的数
	 * @param start
	 * @param end
	 * @return 中间的个数
	 */
	public static int dontGiveMeFive(int start, int end)
	  {
	    int scount =end-start;
	    int count5 =0;
		return 0;
	  }
	public static void main(String[] args) {
		int count =0;
		int number = 12;
		while(number>0){
			number/=10;
			count++;
		}
		System.out.println(count);
	}
}
