package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Given two strings s1 and s2, we want to visualize how different the two
 * strings are. We will only take into account the lowercase letters (a to z).
 * First let us count the frequency of each lowercase letters in s1 and s2.
 * 
 * s1 = "A aaaa bb c"
 * 
 * s2 = "& aaa bbb c d"
 * 
 * s1 has 4 'a', 2 'b', 1 'c'
 * 
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * 
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3
 * from s2. In the following we will not consider letters when the maximum of
 * their occurrences is less than or equal to 1. We can resume the differences
 * between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa
 * stands for string s1 and aaaa because the maximum for a is 4. In the same
 * manner 2:bbb stands for string s2 and bbb because the maximum for b is 3. The
 * task is to produce a string in which each lowercase letters of s1 or s2
 * appears as many times as its maximum if this maximum is strictly greater than
 * 1; these letters will be prefixed by the number of the string where they
 * appear with their maximum value and :. If the maximum is in s1 as well as in
 * s2 the prefix is =:.In the result, substrings (a substring is for example
 * 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of
 * their length and when they have the same length sorted in ascending
 * lexicographic order (letters and digits - more precisely sorted by
 * codepoint); the different groups will be separated by '/'. See examples and
 * "Example Tests".
 * 
 * Hopefully other examples can make this clearer.
 * 
 * s1 = "my&friend&Paul has heavy hats! &" s2 =
 * "my friend John has many many friends &" mix(s1, s2) -->
 * "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &" s2 =
 * "my frie n d Joh n has ma n y ma n y frie n ds n&" mix(s1, s2) -->
 * "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1="Are the kids at home? aaaaa fffff" s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 * 
 * Note for Swift
 * 
 * The prefix =: is replaced by E:
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &" s2 =
 * "my frie n d Joh n has ma n y ma n y frie n ds n&" mix(s1, s2) -->
 * "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/E:ee/E:ss"
 * 
 * @author Wqz
 *
 *
 *         2017年5月14日上午10:21:39
 */
public class Mixing {
	public static String mix(String s1, String s2) {
		String[] str1 = s1.split(" ");
		String[] str2 = s2.split(" ");
		int[] a = new int[128]; // lowercase letters ->ascll
		int[] b = new int[128];
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		Map<String, Integer> mapEqu = new HashMap<String, Integer>();
		for (String let1 : str1) {
			for (int i = 0; i < let1.length(); i++) {
				a[let1.charAt(i)]++;
			}
		}
		for (String let2 : str2) {
			for (int i = 0; i < let2.length(); i++) {
				b[let2.charAt(i)]++;
			}
		}
		for (int j = 97; j <= 122; j++) {
			if (a[j] > 1 && a[j] > b[j])
				map1.put(String.valueOf((char) j) + "," + "1", a[j]);
			// if(b[j]>1 && b[j]>a[j]) map2.put(String.valueOf((char)j), b[j]);
			// //b[j]>a[j]这样判断后可以把a[j]和b[j]的值放在一起，但无法分辨出来自哪一个数组；可以用','隔开即‘a,2’在split切割
			if (b[j] > 1 && b[j] > a[j])
				map1.put(String.valueOf((char) j) + "," + "2", b[j]);
			if (a[j] > 1 && b[j] > 1 && a[j] == b[j])
				mapEqu.put(String.valueOf((char) j), a[j]);
		}
		List<Map.Entry<String, Integer>> amaps = new ArrayList<Map.Entry<String, Integer>>(map1.entrySet());
		List<Map.Entry<String, Integer>> bmaps = new ArrayList<Map.Entry<String, Integer>>(map2.entrySet());
		List<Map.Entry<String, Integer>> Equmaps = new ArrayList<Map.Entry<String, Integer>>(mapEqu.entrySet());
		Collections.sort(amaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().split(",")[0].compareTo(o2.getKey().split(",")[0])
					: o2.getValue().compareTo(o1.getValue());
		});
		Collections.sort(bmaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey())
					: o2.getValue().compareTo(o1.getValue());
		});
		Collections.sort(Equmaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey())
					: o2.getValue().compareTo(o1.getValue());
		});
		for (Entry<String, Integer> mapping1 : amaps) {
			System.out.print(mapping1.getKey().split(",")[0] + ":" + mapping1.getValue() + " ");
		}
		System.out.println();
		for (Entry<String, Integer> mapping2 : bmaps) {
			System.out.print(mapping2.getKey() + ":" + mapping2.getValue() + " ");
		}
		System.out.println();
		for (Entry<String, Integer> mapping3 : Equmaps) {
			System.out.print(mapping3.getKey() + ":" + mapping3.getValue() + " ");
		}
		StringBuilder builder = new StringBuilder();
		int j = 0;
		int i = 0;
		// int isFrist =0; //判断两字符串字母相等，且值最大
		// int lengthMax =
		// amaps.get(0).getValue()>bmaps.get(0).getValue()?amaps.get(0).getValue():bmaps.get(0).getValue();
		// if(Equmaps.get(0).getValue()>lengthMax){
		// builder.append("=:"+repeatLetter(Equmaps.get(0).getKey(),
		// Equmaps.get(0).getValue()));
		// isFrist=1;
		// }
		while (i < amaps.size()) {
			if (j < bmaps.size()) {
				if (amaps.get(i).getValue() == bmaps.get(j).getValue()) {
					// if(amaps.get(i).getKey().equals(bmaps.get(j).getKey())){
					// String temps = i==0 && j==0?"=:":"/=:";
					// builder.append(temps);
					// builder.append(repeatLetter(amaps.get(i).getKey(),
					// amaps.get(i).getValue())); //一开始两字符串相等判断
					// i++;
					// j++;
					// }else{
					String temp1 = i == 0 && j == 0 ? "1:" : "/1:";
					builder.append(temp1 + repeatLetter(amaps.get(i).getKey(), amaps.get(i).getValue()));
					String temp2 = i == 0 && j == 0 ? "2:" : "/2:";
					builder.append(temp2 + repeatLetter(bmaps.get(j).getKey(), bmaps.get(j).getValue()));
					i++;
					j++;
					// }
				} else if (amaps.get(i).getValue() > bmaps.get(j).getValue()) {
					String temps = i == 0 && j == 0 ? "1:" : "/1:";
					builder.append(temps + repeatLetter(amaps.get(i).getKey(), amaps.get(i).getValue()));
					i++;
				} else {
					String temps = i == 0 && j == 0 ? "2:" : "/2:";
					builder.append(temps + repeatLetter(bmaps.get(j).getKey(), bmaps.get(j).getValue()));
					j++;
				}
			}
		}
		if (j < bmaps.size()) {
			for (int k = j; k < bmaps.size(); k++) {
				builder.append("/2:" + repeatLetter(bmaps.get(k).getKey(), bmaps.get(k).getValue()));
			}
		}
		return builder.toString();
	}

	public static String mix2(String s1, String s2) {
		String[] str1 = s1.split(" ");
		String[] str2 = s2.split(" ");
		int[] a = new int[128]; // lowercase letters ->ascll
		int[] b = new int[128];
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> mapEqu = new HashMap<String, Integer>();
		for (String let1 : str1) {
			for (int i = 0; i < let1.length(); i++) {
				a[let1.charAt(i)]++;
			}
		}
		for (String let2 : str2) {
			for (int i = 0; i < let2.length(); i++) {
				b[let2.charAt(i)]++;
			}
		}
		for (int j = 97; j <= 122; j++) {
			if (a[j] > 1 && a[j] > b[j])
				map1.put(String.valueOf((char) j) + "," + "1:", a[j]);
			if (b[j] > 1 && b[j] > a[j])
				map1.put(String.valueOf((char) j) + "," + "2:", b[j]);
			if (a[j] > 1 && b[j] > 1 && a[j] == b[j])
				mapEqu.put(String.valueOf((char) j) + "," + "=:", a[j]);
		}
		List<Map.Entry<String, Integer>> amaps = new ArrayList<Map.Entry<String, Integer>>(map1.entrySet());
		List<Map.Entry<String, Integer>> Equmaps = new ArrayList<Map.Entry<String, Integer>>(mapEqu.entrySet());
		Collections.sort(amaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().split(",")[0].compareTo(o2.getKey().split(",")[0])
					: o2.getValue().compareTo(o1.getValue());
		});
		Collections.sort(amaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().split(",")[1].split("")[0].compareTo(o2.getKey().split(",")[1].split("")[0])
					: o2.getValue().compareTo(o1.getValue());
		});
		Collections.sort(Equmaps, (o1, o2) -> {
			return o2.getValue() == o1.getValue() ? o1.getKey().split(",")[0].compareTo(o2.getKey().split(",")[0])
					: o2.getValue().compareTo(o1.getValue());
		});
		for (Entry<String, Integer> mapping3 : Equmaps) {
			int isbelong = 0;
			for (int i = 0; i < amaps.size(); i++) {
				if (mapping3.getValue() > amaps.get(i).getValue()) {
					amaps.add(i, mapping3);
					isbelong = 1;
					break;                                         //两个字符串中出现字母次数相等排在相同次数后面
				}
			}
			if (isbelong == 0)
				amaps.add(mapping3);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < amaps.size();i++) {
			String str1or2 = amaps.get(i).getKey().split(",")[1];
			String temp1 = i == 0 ? str1or2 : "/" + str1or2;
			builder.append(temp1 + repeatLetter(amaps.get(i).getKey().split(",")[0], amaps.get(i).getValue()));
		}
		return builder.toString();
	}

	public static String repeatLetter(String letter, int reCount) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < reCount; i++) {
			     builder.append(letter);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// Mixing.mix("In many languages", "there's a pair of functions");
		// //"1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt"
		// "2:eeeee/2:yy/=:hh/=:rr",
		// System.out.println(Mixing.mix2("Are they here", "yes, they are
		// here"));
		// 1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg
		Mixing.mix2("looping is fun but dangerous", "less dangerous than coding");
		System.out.println(Mixing.mix2("looping is fun but dangerous", "less dangerous than coding"));
		// System.out.println(Mixing.mix("my&friend&Paul has heavy hats! &", "my
		// friend John has many many friends &"));
		// System.out.println("a".charAt(0)>"b".charAt(0));

	}
}
