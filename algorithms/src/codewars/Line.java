package codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Wqz
 *The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. 
 *Each of them has a single 100, 50 or 25 dollars bill. A "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to each person and give the change if he initially has no money and 
sells the tickets strictly in the order people follow in the line?
Return YES, if Vasya can sell a ticket to each person and give the change. Otherwise return NO.
// 
Example:
Line.Tickets(new int[] {25, 25, 50}) // => YES 
Line.Tickets(new int []{25, 100}) 
         // => NO. Vasya will not have enough money to give change to 100 dollars
             在售货员一开始没有零钱的情况下，能否通过卖票给买票人找零钱
 *
 *2017年4月24日下午9:10:13
 */
public class Line {
	/**
	 * 统计25和50的个数来找零钱
	 * @param peopleInLine
	 * @return
	 */
	public static String Tickets(int[] peopleInLine)
	  {
//		   for (int i = 0; i < peopleInLine.length; i++) {
//			System.out.print(peopleInLine[i]+"");          //可以通过打印的方式知道测试用例
//		}
		int count25 =0;  //统计25的个数
		int count50 =0;  //统计50的个数
		int leftM =0; //售货员手里的零钱,all time leftM compare to sell
		   for (int i = 0; i < peopleInLine.length; i++) {
			if(peopleInLine[i]==25){
				//leftM+=peopleInLine[i];
				count25++;
			}else if(peopleInLine[i]==50){
				//leftM+=-peopleInLine[i]+25; //没有考虑这种情况25,50,25,50；不能单纯的考虑剩余钱的问题，还有考虑手里25,50的个数如：25,25,25,25,50,100,50
				if(count25==0) return "NO";
				else count25--;
				count50++;
			}else{
				if(count25!=0 && count50!=0){
					count25--;
					count50--;
				}else if(count25>=3){
					count25-=3;
				}else{
					return "NO";
				}
			}
			//if(leftM<0) return "NO";
		}
		   return "YES";
	  }
	/**
	 * others better 每次+25的票钱，和sum减去要找的零钱change，比较sum和change的大小
	 * @param peopleInLine
	 * @return
	 */
	public static String Tickets2(int[] peopleInLine)
	  {
	      int i, sum=0, change = 0;
	      String a = "";
	      for(i=0; i<peopleInLine.length; i++) {
	          
	          sum += 25;
	          change = (peopleInLine[i] - 25);
	          sum -= change;
	          
	          if(sum < change) {
	            a = "NO";
	          }
	          else a = "YES";
	      }
	      return a;
	  }
	@Test
	   public void test2() {
	      assertEquals("NO", Line.Tickets(new int []{25, 100}));
	    }
	public static void main(String[] args) {
		System.out.println(Tickets(new int[] {25,25,25,25,50,100,50}));
	}
}
