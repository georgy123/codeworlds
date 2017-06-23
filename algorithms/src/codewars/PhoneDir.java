package codewars;

/**
 * John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number 
 * (formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.
Unfortunately everything is mixed, things are not always in the same order, lines are cluttered with non-alpha-numeric characters.

Examples of John's phone book lines:
"/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
" 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
"<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
Could you help John with a program that, given the lines of his phone book and a phone number returns a string for this number : "Phone => num, Name => name, Address => adress"
 *   
 * Example:
 *   s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
     phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
     It can happen that, for a few phone numbers, there are many people for a phone number -say nb- , then

return : "Error => Too many people: nb"

or it can happen that the number nb is not in the phone book, in that case

return: "Error => Not found: nb"

You can see other examples in the test cases.

JavaScript random tests completed by @matt c
 * @author Wqz
 *
 *
 *2017年6月6日下午7:36:59
 */
public class PhoneDir {
	private static final String REPLACE = "*+!/+:,<>;$";
	public static  String phone(String strng, String num) {
          if((strng.length()-strng.replace("+"+num, "").length())/num.length()>1) return "Error => Too many people: "+num;
          if(!strng.contains(num)) return "Error => Not found: "+num;
          String[] inf = strng.split("\n");
          String phoneInf ="";
          for (String str : inf) {
			if(str.contains(num)){
				phoneInf="Phone => "+num+", ";
				phoneInf+="Nmae => "+str.substring(str.indexOf("<")+1, str.indexOf(">"))+", ";
				str=str.replace(num, "");
                str=str.replace(str.substring(str.indexOf("<")+1, str.indexOf(">")), "");
                for(char ch : REPLACE.toCharArray()){
                	str=str.replace(String.valueOf(ch), "");
                }
                System.out.println(str);
                str = str.replace("  ", " ");
                str = str.replace("_", " ");
                phoneInf+="Address => "+str;
                str = str.trim();
                break;
			}
		}
	      return phoneInf;
	}
	
	public static void main(String[] args) {
		String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
			    + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
			    + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
			    + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
			    + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
			    + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
			    + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
			    + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
			    + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
			    + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
			    + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";
               
		
		System.out.println(PhoneDir.phone(dr, "1-541-754-3010"));
		System.out.println("ddddd\\n");
	}
}
