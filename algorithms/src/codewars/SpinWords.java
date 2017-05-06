package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，把其中单词长度大于5的反转
 * example：
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
  spinWords( "This is a test") => returns "This is a test"
 ( "This is another test" )=> returns "This is rehtona test"
 * @author Wqz
 *
 *
 *2017年5月5日下午9:06:22
 */
public class SpinWords {

	public String spinWords(String sentence) {
		 String[] letters = sentence.split(" ");
		 String newStr = "";
		 for (int i = 0; i < letters.length; i++) {
			if(letters[i].length()>=5){
				String reveStr = "";
				for (int j = letters[i].length()-1; j >=0; j--) {
					reveStr+=String.valueOf(letters[i].charAt(j));      //反转，StringBuffer和StringBuilder有reverse()函数
				}
				letters[i]=reveStr;
			}
		}
		 for (int i=0; i<letters.length;i++) {
			if(i!=letters.length-1) newStr+=letters[i]+" ";
			else newStr+=letters[i];
		}
         return newStr;
	}
	/**
	 * others
	 * @param sentence
	 * @return after reversing words 
	 */
	public String spinWords2(String sentence) {
	    String[] words = sentence.split(" ");
	    for (int i=0; i<words.length; i++) {
	      if (words[i].length() >= 5) {
	        words[i] = new StringBuilder(words[i]).reverse().toString();
	      }
	    }
	    return String.join(" ",words);
	  }
	/**
	 * others 2 lamada表达式
	 * @param sentence
	 * @return
	 */
	public String spinWords3(String sentence) {
	    return Arrays.stream(sentence.split(" "))
	                 .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
	                 .collect(Collectors.joining(" "));
	  }
	public static void main(String[] args) {
		System.out.println(new SpinWords().spinWords("Welcome"));
	}
}
