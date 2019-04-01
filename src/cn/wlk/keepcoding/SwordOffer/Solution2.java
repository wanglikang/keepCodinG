package cn.wlk.keepcoding.SwordOffer;

/******
 * 替换空格
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author WLK
 * 
 *
 */
public class Solution2 {
	public String replaceSpace(StringBuffer str) {
		return str.toString().replace(" ", "%20");
	}
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		StringBuffer sb = new StringBuffer();
		sb.append("We Are Happy");
		System.out.println(s.replaceSpace(sb));
	}
}
