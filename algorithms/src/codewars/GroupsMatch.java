package codewars;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 括号匹配
 * @author Wqz
 *
 *
 *2017年5月3日下午10:23:31
 */

public class GroupsMatch {

	 public static boolean groupCheck(String s){
		 Stack<Character> stack = new Stack<Character>();
		    if(s.length()%2==1){
		    	return false;
		    }else{
		    	for (int i = 0; i < s.length(); i++) {
					switch (s.charAt(i)) {
					case '(':
					case '[': 
					case '{': 
						stack.push(s.charAt(i));
					break;
					case ')': 
					case ']':
					case '}':
						if(stack.isEmpty()){
							return false;
						}else if(!GroupsMatch.matchS(stack.pop(), s.charAt(i)))
							return false;
					break;
					}
				}
		    	
		    }
		    return stack.isEmpty();
		  }
	 public static boolean matchS(char sLeft,char sRight){
		 switch (sLeft) {
			case '(':
				if(sRight==')') return true;
			break;
			case '[': 
				if(sRight==']') return true;
			break;
			case '{': 
				if(sRight=='}') return true;
			break;
			default:
			break;
	 }
		 return false;
  }
	 /**
	  * others 
	  * @param s
	  * @return boolean
	  */
public static boolean groupCheck2(String s) {
		    int len;
		    do {
		      len = s.length();
		      s = s.replace("()", "");
		      s = s.replace("{}", "");
		      s = s.replace("[]", "");
		    } while (len != s.length());
		    return s.length() == 0;
		  }
/**
 * 正则表达式	 
 * @param s
 * @return
 */
public static boolean groupCheck3(String s) {
		    long len;
		    do {
		      len = s.length();
		      s = s.replaceAll("\\(\\)|\\{\\}|\\[\\]", "");
		    } while (len > s.length());

		    return s.isEmpty();
//		    Matcher m = Pattern.compile("(\\(\\)|\\{\\}|\\[\\])").matcher(s);
//		    while(m.find())
//		      m.reset((s = m.replaceAll("")));
//		    return s.length()==0 ? true : false;
		  }
	 public static void main(String[] args) {
		System.out.println(GroupsMatch.groupCheck("())("));
	}
}
