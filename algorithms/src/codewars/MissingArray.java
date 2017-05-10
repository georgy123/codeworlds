package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * You get an array of arrays.
If you sort the arrays by their length, you will see, that their length-values are consecutive.
But one array is missing!
You have to write a method, that return the length of the missing array.

Example:
[[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3
If the array of arrays is null/nil or empty, the method should return 0.
When an array in the array is null or empty, the method should return 0 too!
There will always be a missing element and its length will be always between the given arrays. 
有一个二维数组，把它们里面的数组长度排序，你会发现少一个长度
 * @author Wqz
 *
 *
 *2017年5月2日下午9:59:54
 */

public class MissingArray {
	/**
	 * mine
	 * @param arrayOfArrays
	 * @return 少的那个数组
	 */
	public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
	  {
		if(arrayOfArrays==null) return 0;
		int max =1;
		int min =Integer.MAX_VALUE;
		int[] n = new int[arrayOfArrays.length];
	    for(int i=0;i<arrayOfArrays.length; i++){
	    	if(arrayOfArrays[i]==null || arrayOfArrays[i].length==0 ) return 0;
	    	if(arrayOfArrays[i].length<min) min =arrayOfArrays[i].length;
	    	if(arrayOfArrays[i].length>max) max=arrayOfArrays[i].length;
	    	n[i]=arrayOfArrays[i].length;
	    }
	    for (int i = min; i <= max; i++) {
	    	int flag=0;
			for (int j = 0; j < n.length; j++) {
				if(i==n[j]){
					flag=1;
					break;
				}
			}
			if(flag==0) return i;
		}
		return 0;
	  }
	/**
	 * others 
	 * @param arrayOfArrays
	 * @return
	 */
	public static int getLengthOfMissingArray2(Object[][] arrayOfArrays)
	  {
	   if (arrayOfArrays == null || arrayOfArrays.length == 0)
	      return 0;
	    for (Object[] arr : arrayOfArrays) {
	      if (arr == null || arr.length == 0)  return 0;
	    }
	    Integer[] arr = Arrays.asList(arrayOfArrays).stream()
	        .map( el -> el.length)
	        .sorted()    
	        .toArray(Integer[]::new);
	    
	    int currentSum = Arrays.asList(arr).stream().reduce(0,(a,b) -> a+b);
	    int fullSum = IntStream.rangeClosed(arr[0], arr[arr.length-1]).sum();
	    

	    return fullSum - currentSum;

	  }
	public static void main(String[] args){
		System.out.println(MissingArray.getLengthOfMissingArray(new Object[][]{null,{1,1}}));
	}
}
