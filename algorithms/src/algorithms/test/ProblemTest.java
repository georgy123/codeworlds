package algorithms.test;

public class ProblemTest {
     public static void main(String[] args) {
    	 String str1 = "hello";
    	 String str2 = "he" + new String("llo");
    	 System.err.println(str1 == str2);
    	 Thread t = new Thread() {
             public void run() {
                 pong();
             }
         };
         t.run();
         System.out.print("ping");
         
         
    
         double d1=-0.5;
         System.out.println("Ceil d1="+Math.ceil(d1));
         System.out.println("floor d1="+Math.floor(d1));
         boolean b=true?false:true==true?false:true;
         System.out.println(b);
     }
     static void pong() {
         System.out.print("pong");
	}
     
}
