package algorithms;


/**
 * 背包问题
 * @author Administrator
 *
 * @date 2017年2月12日
 */
public class Knapsack {
   
	public static void knaPsack(int[]v,int[] w,int c,int n,int m[][]){
		for(int j=0;j<=c;j++){
			if(j>=w[n]){
				m[n][j]=v[n];
			}else{
				m[n][j] =0;
			}
		}
	}
}
