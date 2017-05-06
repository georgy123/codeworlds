package codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764.
 *  The sum of the squared divisors is 2500 which is 50 * 50, a square!Given two integers m, n (1 <= m <= n) 
 *  we want to find all integers between m and n whose sum of squared divisors is itself a square. 42 is such a number.
The result will be an array of arrays(in C an array of Pair), each subarray having two elements, 
first the number whose squared divisors is a square and then the sum of the squared divisors.
#Examples:
list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]

 * @author Wqz
 *
 *  找出一个数的所有的因子的平方和能开方
 *2017年5月5日下午8:57:10
 */
public class SumSquaredDivisors {
    
	public static String listSquared(long m, long n) {
		List<String> listSqu = new ArrayList<String>();
		for (long i = m; i <= n; i++) {
			int sum =0;
			for (int j = 1; j <=i; j++) {
				if(i%j==0){
					sum+=Math.pow(j, 2);
				}
			}
			if((int)Math.sqrt(sum)==Math.sqrt(sum)){
				List a = new ArrayList();
				a.add(i);
				a.add(sum);
				listSqu.add(a.toString());
			}
		}
		return listSqu.toString();
	}
	/**
	 * others 
	 * @param m
	 * @param n
	 * @return
	 */
	public static String listSquared2(long m, long n) {
        // your code
        String result = "[";
        for(long i=m; i<=n; i++) {
            if(Math.round(Math.sqrt(sumOfSquareDivisors(i))) == Math.sqrt(sumOfSquareDivisors(i))) {
                result+= "["+i +", "+sumOfSquareDivisors(i)+"], ";
            }
        }
        return result.length()>1 ? result.substring(0, result.length()-2)+"]" : "[]";
    }
    
    
    public static long sumOfSquareDivisors(long n) {
        return LongStream.range(1, n + 1)
                .filter(i -> n % i == 0)
                .map(i -> i * i)                        //java8的新特性
                .sum();
    }
	public static void main(String[] args) {
		System.out.println(SumSquaredDivisors.listSquared(42, 250).toString());
	}
}
