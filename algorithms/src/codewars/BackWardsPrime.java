package codewars;

/**
 * 回文素数
 * 
 * @author Wqz
 *
 *
 *         2017年5月5日下午9:49:23
 */
public class BackWardsPrime {

	public static String backwardsPrime(long start, long end) {
		String backwardsPrimes = "";
		for (long i = start; i <= end; i++) {
			if (i % 2 != 0 && i>10) {
				if (isPrime(i)) {
//					String str = String.valueOf(i);
//					String newStr = "";
//					for (int j = str.length() - 1; j >= 0; j--) {
//						newStr += str.charAt(j);
//					}
//					if (isPrime(Long.valueOf(newStr)) && Long.valueOf(newStr)!=i) {
//						backwardsPrimes += i + " ";
//					}
					String newStr =new StringBuilder(String.valueOf(i)).reverse().toString();
					if (isPrime(Long.valueOf(newStr)) && Long.valueOf(newStr)!=i) {
						backwardsPrimes += i + " ";
					}
				}

			}

		}
		return backwardsPrimes.trim();
	}
/**
 * 判断是否为质数
 * @param n
 * @return
 */
public static boolean isPrime(long n) {
		boolean flag = true;
		for (int j = 2; j <=Math.sqrt(n); j++) {
			if (n % j == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
/**
 * others 
 * @param start
 * @param end
 * @return  backwardsPrime
 */
public static String backwardsPrime2(long start, long end) {
    StringBuilder sb = new StringBuilder();
     while(start <= end){
      int rev = Integer.parseInt(new StringBuilder(
        String.valueOf(start)).reverse().toString());
      if(start > 12 && isPrime(rev) && isPrime(start) && start != rev) 
        sb.append(start + " ");  
      start++;
    }
    return sb.toString().trim();
  }
 //others
  static boolean isPrime2(long n) {
    if(n % 2 == 0) return false;                 
    for(int i = 3; i * i  <= n  ; i += 2) {
      if(n % i == 0)                                    
        return false;                            //differnet from me 
    }
    return true;
  }
	public static void main(String[] args) {
		System.out.println(BackWardsPrime.backwardsPrime(9900, 10000));
	}
}
