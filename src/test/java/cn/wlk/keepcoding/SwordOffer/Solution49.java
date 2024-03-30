package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 14:44
 * author:WLK
 * 把字符串转换成整数
 * <p>
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * <p>
 * 输入一个字符串,包括数字字母符号,可以为空
 * <p>
 * 输出描述:
 * <p>
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * +2147483647
 * 1a33
 * <p>
 * 输出
 * 复制
 * <p>
 * 2147483647
 * 0
 *
 * 解法：一步一步的计算即可
 */
public class Solution49 {
    @Test
    public void test() {
        Solution49 t = new Solution49();
        System.out.println(t.StrToInt("123456"));
        System.out.println(t.StrToInt("-123456"));
        System.out.println(t.StrToInt("+120456"));
        System.out.println(t.StrToInt("-001345600"));
        System.out.println(t.StrToInt("123f456"));
        System.out.println(t.StrToInt(""));

    }
    public int StrToInt(String str) {

        if(str.length()==0){
            return 0;
        } else {
            char[] chars = str.toCharArray();
            int result = 0;
            int flag = 1;
            int len = chars.length;
            for(int i = 0;i<len;i++){
                if(Character.isDigit(chars[i])){
                    result=result*10+chars[i]-'0';
                }else if(i==0 && chars[i]=='+'||chars[i]=='-'){
                    flag=chars[i]=='+'?1:-1;
                }else return 0;
            }
            return result*flag;
        }
    }

}
