package algorithms;

import java.util.Scanner;
/**
 * 回文序列
 * 
 *@author wqz
 *
 * @date 2017年3月26日
 */
public class Main {
  public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    while(scanner.hasNext()){
		    	int times =0;
		    	int n = scanner.nextInt();
		    	int[] inputArr = new int[n];
		    	for(int i=0;i<n;i++){
		    		inputArr[i] = scanner.nextInt();
		    	}
		    	int head =0;
		    	int tail =n-1;
		    	while(head<tail){
		    		if(inputArr[head]>inputArr[tail]){
		    			inputArr[--tail]+=inputArr[tail+1];
		    			times++;
		    		}else if(inputArr[head]<inputArr[tail]){
		    			inputArr[++head]+=inputArr[head-1];
		    			times++;
		    		}else{
		    			head++;
		    			tail--;
		    		}
		    	}
		    	System.out.println(times);
		    }
		    scanner.close();
	}
}
