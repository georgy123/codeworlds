package codewars;

import java.util.Arrays;

/**
  * 
  * 统计字符串元音字母的个数(a,e,i,o,u为元音字母)
  *
  *@author wqz
  *
  * @date 2017年4月15日 下午8:40:53
  */
public class Vowels {
     
	public static int getCount(String str) {
	    int vowelsCount = 0;
	    char[] chars = str.toCharArray();
	    for(int i=0;i<chars.length;i++){
	    	if("aeiou".contains(String.valueOf(chars[i]))){
	    		vowelsCount++;
	    	}
	    }
	    return vowelsCount;
	  }
	public static int getCount2(String str) {
	     
		  return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();   //java的新特性lambda表达式
	  
	  }
	public static int check(String s) {  
	    if (s.equals("")) {  
	        throw new IllegalArgumentException();  
	    }  
	    return s.length();  
	}  
	public static void main(String[] args) {
		int count = getCount2("abracadabra");
		System.out.println(count);
		String[] datas = new String[]{""};  
		//Arrays.asList(datas).stream().forEach(name -> check(name));  
		int k;
		k=-3;
		if(k<=0){
			System.out.println("#####");
		}else{
			System.out.println("&&&");
		}
		System.out.println(153%100/10);
	}
	
}
