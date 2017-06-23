package codewars;

/**
 * 
 * What might not be so trivial is instead to get a decent breadcrumb from your
 * current url. For this kata, your purpose is to create a function that takes a
 * url, strips the first part (labelling it always HOME) and then builds it
 * making each element but the last a <a> element linking to the relevant path;
 * last has to be a <span> element getting the active class. All elements need
 * to be turned to uppercase and separated by a separator, given as the second
 * parameter of the function; the last element can terminate in some common
 * extension like .html, .htm, .php or .asp; if the name of the last element is
 * index.something, you treat it as if it wasn't there, sending users
 * automatically to the upper level folder. Well, probably not so much, but we
 * have one last extra rule: if one element (other than the root/home) is longer
 * than 30 characters, you have to shorten it, acronymizing it (i.e.: taking
 * just the initials of every word); url will be always given in the format
 * this-is-an-element-of-the-url and you should ignore words in this array while
 * acronymizing: ["the","of","in","from","by","with","and", "or", "for", "to",
 * "at", "a"]; a url composed of more words separated by - and equal or less
 * than 30 characters long needs to be just uppercased with hyphens replaced by spaces.
 * 
 * Ignore anchors (www.url.com#lameAnchorExample) and parameters(www.url.com?codewars=rocks&pippi=rocksToo) when present. 
 * Example:
 * solution.generate_bc("mysite.com/pictures/holidays.html", " : ").equals( '<a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> :<span class="active">HOLIDAYS</span>' );
 * Solution.generate_bc("www.codewars.com/users/GiacomoSorbi", " / ").equals( '<a href="/">HOME</a> / <a href="/users/">USERS</a> /<span class="active">GIACOMOSORBI</span>' );
 * Solution.generate_bc("www.microsoft.com/docs/index.htm", " * ").equals( '<a href="/">HOME</a> * <span class="active">DOCS</span>' );
 * Solution.generate_bc("mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.htm"," > ").equals( '<a href="/">HOME</a> >
 * <a href="/very-long-url-to-make-a-silly-yet-meaningful-example/">VLUMSYME</a>> <span class="active">EXAMPLE</span>' ); 
 * Solution.generate_bc("www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi"," + ").equals( '<a href="/">HOME</a> + <a href="/users/">USERS</a> +<span class="active">GIACOMO SORBI</span>' )
 * 
 *  
 *  
 *  {
 * "<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>"
 * ,"<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>"
 * , "<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
 * "<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>"
 * ,"<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>"
 * };
 * 
 * @author Wqz
 *
 *         面包屑导航生成，在童话里，面包屑是汉赛尔在进入森林的路中偷偷撒下的，这是一种“历史记录”的应用方式，目的是帮助你追溯来路，
 *         因而它应该是一种线性的导航方式。
 *         不过在网页的应用中，“追溯来路”这件事浏览器已经做得足够好了，所以“面包屑”慢慢地就变成用来表达内容归属关系的界面元素，
 *         也就是我们经常看到的“主分类>一级分类>二级分类>三级分类>……>最终内容页面”这样的方式。
 *         但是一般正常的来讲目录结构由3层结构组成。分别是首页>栏目页>内容页。
 *         
 *        error： (1)开始出错未考虑最后一个元素“linkedin.it/surfer-bladder-bioengineering-a-or-research/login.php#offers”既有“.”又有“#”
 *                     解决方式：把if(".")的判断放在“#” “？”前面
 *               (2)https://www.linkedin.com/in/giacomosorbi,把“//”其中一个“/”当成了一个分隔符
 *                       一开始替换"//"
 *               (3) pippi.pi/the-from-by-surfer-with-the-biotechnology/#offers  去掉#后就没有了
 *               (4)www.agcpartners.co.uk/只有一元素情况
 *               (5)Test with : https://www.agcpartners.co.uk/index.html 解决len==0情况
 *               (6)https://linkedin.it/of-the-a-kamehameha-immunity-diplomatic-bladder/#offers?rank=recent_first&hide=sold
 *     linkedin.it/skin-biotechnology-transmutation/#info github.com/wanted/skin-with-a-skin-kamehameha-with-bladder/
 *          2017年6月14日下午8:59:09
 */
public class BreadcrumbGenerator {
	public static String[] ignoreWords = { "the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at","a" };

	public static String generate_bc(String url, String separator) {
		url = url.replace("//", "-");
		String[] elements = url.split("/");
		if(elements.length==1) return "<span class=\"active\">HOME</span>";  //只有一个元素情况
		StringBuilder builder = new StringBuilder();
		builder.append("<a href=\"/\">HOME</a>");
		builder.append(separator);
		int len = elements.length - 1; // 最后一个元素
		if (url.contains("index.")) len = len - 1;
		if (elements[len].contains(".")) {
			String temp = elements[len].substring(0, elements[len].indexOf(".")); 
			if("".equals(temp)) len=len-1;
		} else if (elements[len].contains("#")) {
			String temp = elements[len].substring(0, elements[len].indexOf("#")); 
			if("".equals(temp)) len=len-1;
		} else if (elements[len].contains("?")) {
			String temp = elements[len].substring(0, elements[len].indexOf("?"));
			if("".equals(temp)) len=len-1;
		}
		if(len==0)  return "<span class=\"active\">HOME</span>";
		System.out.println("len:"+len);
		for (int i = 1; i < len; i++) {
			if (elements[i].contains("-") && elements[i].length() <= 30) {
				String tempStr = elements[i].replace("-", " ").toUpperCase();
				if(i>1) {
					builder.append("<a href=\"/" + elements[i-1] + "/" + elements[i] + "/\">" + tempStr + "</a>");
					builder.append(separator);
					continue;
				}
				builder.append("<a href=\"/" + elements[i] + "/\">" + tempStr + "</a>");
				builder.append(separator);
			} else if (elements[i].contains("-") && elements[i].length() > 30) {
				String str = "";
				String[] t = elements[i].split("-");
				for (int j = 0; j < t.length; j++) {
					boolean flag = true;
					for (int k = 0; k < ignoreWords.length; k++) {
						if (t[j].equals(ignoreWords[k])) {
							flag = false;
							break;
						}
					}
					if (flag)
						str += t[j].charAt(0);
				}
				if(i>1) {
					builder.append("<a href=\"/" + elements[i-1] + "/" + elements[i] + "/\">" +  str.toUpperCase() + "</a>");
					builder.append(separator);
					continue;
				}
				builder.append("<a href=\"/" + elements[i] + "/\">" + str.toUpperCase() + "</a>");
				builder.append(separator);
			} else if(i>1){ 
				builder.append("<a href=\"/" + elements[i-1] + "/" + elements[i] + "/\">" +  elements[i].toUpperCase() + "</a>");
				builder.append(separator);
			}else{
				builder.append("<a href=\"/" + elements[i] + "/\">" + elements[i].toUpperCase() + "</a>");
				builder.append(separator);
			}
		}
		if (elements[len].contains(".")) {
			elements[len] = elements[len].substring(0, elements[len].indexOf(".")); // 处理？，#的情况
		} else if (elements[len].contains("#")) {
			elements[len] = elements[len].substring(0, elements[len].indexOf("#")); // 处理？，#的情况
		} else if (elements[len].contains("?")) {
			elements[len] = elements[len].substring(0, elements[len].indexOf("?"));
		}
		if (elements[len].contains("-") && elements[len].length() <= 30) {
			String tempStr = elements[len].replace("-", " ").toUpperCase();
			builder.append("<span class=\"active\">" + tempStr + "</span>");
		} else if (elements[len].contains("-") && elements[len].length() > 30) {
			String str = "";
			String[] t = elements[len].split("-");
			for (int j = 0; j < t.length; j++) {
				boolean flag = true;
				for (int k = 0; k < ignoreWords.length; k++) {
					if (t[j].equals(ignoreWords[k])) {
						flag = false;
						break;
					}
				}
				if (flag)
					str += t[j].charAt(0);
			}
			builder.append("<span class=\"active\">" + str.toUpperCase() + "</span>");
		} else {
			builder.append("<span class=\"active\">" + elements[len].toUpperCase() + "</span>");
		}
		return builder.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(BreadcrumbGenerator.generate_bc("http://pippi.pi/users/bioengineering-biotechnology/secret-page.asp?rank=recent_first&hide=sold"," > "));
		System.out.println("//");
		System.out.println("#long".substring(0, "#long".indexOf("#")).equals(null));
//		String a = "mysite.com/pictures/holidays.html";
//		String[] s = a.split("/");
//		int len = s.length;
//		for (int i = 0; i < len; i++) {
//			if (s[2].contains("html"))
//				len = s.length - 1;
//			System.out.println(s[i]);
//		}
//		System.out.println(a.replace("/", "-"));
//		char c = 'a';
//		String d = "";
//		d += c;
//		System.out.println(d);
		// System.out.println("<a href=\"/\">HOME</a>"+" / ");
		// System.out.println(Arrays.toString(s));
		// System.out.println(s[2].substring(0, s[2].lastIndexOf(".")));
	}
}
