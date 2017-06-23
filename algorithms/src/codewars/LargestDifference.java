package codewars;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Summary: Write a function which takes an array data of numbers and returns the largest difference in indexes j - i such that data[i] <= data[j]

Long Description:

The largestDifference takes an array of numbers. That array is not sorted. Do not sort it or change the order of the elements in any way, or their values.

Consider all of the pairs of numbers in the array where the first one is less than or equal to the second one.

From these, find a pair where their positions in the array are farthest apart.

Return the difference between the indexes of the two array elements in this pair.

Example:

LargestDifference.largestDifference(new int[]{1,2,3}); //returns 2,
//because here j = 2 and i = 0 and 2 - 0 = 2


 * @author Wqz
 *     所在位置的最大差值
 *
 *2017年6月2日下午10:07:16
 */
public class LargestDifference {
     
	public static int largestDifference(int[] data) {
        if(data[0]<=data[data.length-1]) return data.length-1;
        if(data[0]<=data[data.length-2]) return data.length-2;
        int maxd=0;
        for(int i=1; i<data.length; i++){
        	for(int j =data.length-1; j>i; j--){
        		if(data[i]<=data[j] && (j-i)>maxd){
        		    maxd=j-i;
        		}
        	}
        }
		return maxd;

    }
	@Test
	public void test(){
		 //assertEquals(2, LargestDifference.largestDifference(new int[]{1,2,3}));
		 assertEquals(4, LargestDifference.largestDifference(new int[]{9,4,1,10,3,4,0,-1,-2}));
	}
}
