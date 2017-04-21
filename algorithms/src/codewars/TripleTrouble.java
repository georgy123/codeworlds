package codewars;

/**
 * which takes in numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place in num1 
 * and also a straight double of the same number in num2.
For example:
TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and  // num2 has straight double 99s
TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2
TripleDouble(12345, 12345) == 0
TripleDouble(666789, 12345667) == 1
 * 
 *
 *@author wqz
 *
 * @date 2017年4月10日
 */
public class TripleTrouble {
	public static int TripleDouble(long num1, long num2) 
	  {
	    String str1 = String.valueOf(num1);
	    String str2 = String.valueOf(num2);
        char[] a = str1.toCharArray();	    
        char[] b = str2.toCharArray();
        int[] temp1 = repeatTriple(a);
        int[] temp2 = repeatDouble(b);
        if(temp1[0]==0 || temp2[0]==0){
        	return 0;
        }
        for(int i =1;i<=temp1[0];i++){
        	for(int j=1; j<=temp2[0];j++){
        		if(temp1[i]==temp2[j]){
        			return 1;
        		}
        	}
        }
		return 0;
	    
	  }
	public static int[] repeatTriple(char[] a){
		int[] temp = new int[a.length]; 
        int j=0;
        for(int i=1;i<a.length;i++){
        	if(i+1!=a.length){
        		if(a[j]==a[i]){
        			if(a[j]==a[i+1]){
        				temp[temp[0]+1]=Integer.valueOf(String.valueOf(a[j]));
                		temp[0]++;
                		if(i+2!=a.length){
                			j=i+2;
                			i=j;
                		}
                		
        			}else{
        				j=i+1;
        				i=j;
        			}
            	}else{
            		j=i;
            	}
        	}
        }
        return temp;
	}
	public static int[] repeatDouble(char[] b){
		int[] temp = new int[b.length]; 
        int j=0;
        for(int i=1;i<b.length;i++){
        		if(b[j]==b[i]){
        				temp[temp[0]+1]=Integer.valueOf(String.valueOf(b[j]));
                		temp[0]++;
                			j=i+1;
                			i=j;
            	   }else{
            		    j=i;
            	  }
        	
        	
        }
        return temp;
	}
 public static int TripleDouble2(long num1, long num2){
	 String s = String.valueOf(num1) + " " + String.valueOf(num2);
	 return (s.matches(".*(\\d){3}.*\\s.*\\1{2}.*") ? 1 : 0);  
 }
	public static void main(String[] args) {
		System.out.println(TripleDouble2(45199977254666L, 41177722899L));
	}
}
