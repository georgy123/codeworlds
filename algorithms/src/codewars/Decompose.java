package codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * Task

Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².

If there are multiple solutions (and there will be), return the result with the largest possible values:
Examples

decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.
For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.

Note

Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null, Nothing, None (depending on the language) or "" (Java, C#) or {} (C++).

The function "decompose" will take a positive integer n and return the decomposition of N = n² as:

"x1 ... xk"

 * @author Wqz
 *
 *
 *2017年5月25日下午9:11:45
 */
public class Decompose {
     //1到n的平方和1^2+2^2+3^2+...+n^2=n(n+1)(2n+1)/6
	public String decompose(long n) {
       List<Long> decomposeArray = Decomposer(n, n * n);
		// no valid solution exists
		if(decomposeArray == null) return "";
	    // remove the last element
		decomposeArray.remove(decomposeArray.size() - 1);
		List<String> result = new ArrayList<>();
		for(Long ele : decomposeArray){
			result.add(String.valueOf(ele.longValue()));
		}
		return String.join(" ", result);
	}
	
	/**
	 * Recursion to get the list of decompose
	 * @param n
	 * @param remain
	 * @return
	 */
	public List<Long> Decomposer(long n, long remain){
		// basic case
		if(remain == 0){
			List<Long> r = new ArrayList<Long>();
			r.add(n);
			return r;
		}
		// iterate all element less than n
		for(long i = n - 1 ; i > 0; i--){
			if((remain - i * i) >= 0){
				List<Long> r = Decomposer(i, (remain - i * i));
				// only get the answer
				if(r != null){
					r.add(n);
					return r;
				}
			}
		}
		// no answer
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new Decompose().decompose(1));
	}
}
