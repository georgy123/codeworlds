package codewars;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Longest Common Subsequence
 * 
 * LCS examples

Solution.lcs("abcdef", "abc") => returns "abc"
Solution.lcs("abcdef", "acf") => returns "acf"
Solution.lcs("132535365", "123456789") => returns "12356"

 * 
 * 
 * @author Wqz
 *
 *最长公共子序列
 *2017年6月10日下午8:53:40
 */
public class Lcs {
    
	 public static String lcs(String x, String y) {
	        int[][] c = new int[x.length()+1][y.length()+1];  //一张二维表记录子问题
	        for (int i = 1; i <=x.length(); i++) {
				for (int j = 1; j <=y.length(); j++) {
					if(x.charAt(i-1)==y.charAt(j-1)){
						c[i][j]=c[i-1][j-1]+1;
					}else if(c[i-1][j]>=c[i][j-1]){
						   c[i][j]=c[i-1][j];
					}else{
						c[i][j]=c[i][j-1];
					}
				}
			}
	 //The longest common subsequence is obtained by backtracking
	    	StringBuilder lcs = new StringBuilder();
	        int i=x.length();
	        int j=y.length();
	    	while(i>0 && j>0){
	    		if(x.charAt(i-1)==y.charAt(j-1)){
	    			//System.out.print(x[i-1]);
	    			lcs.append(String.valueOf(x.charAt(i-1)));   //from back to front  输出出来是倒序的
	    			i--;
	    			j--;
	    		}else if(c[i-1][j]>=c[i][j-1]){
	    			i--;
	    		}else{
	    			j--;
	    		}
	    	}
	        
	        return lcs.reverse().toString();    // need reverse 需要反转
	    }
	 @Test
	    public void exampleTests() {
	        assertEquals("nottest", Lcs.lcs("anothertest", "notatesta"));
	        //assertEquals("abc", Lcs.lcs("abcdef", "abc"));
	    }
}
