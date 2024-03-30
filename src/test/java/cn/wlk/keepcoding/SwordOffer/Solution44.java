package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 10:18
 * author:WLK
 * 翻转单词顺序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 解法：两次翻转，，第一次将全部字符翻转，第二次对每个单词进行翻转
 *
 */
public class Solution44 {
    @Test
    public void test() {
        Solution44 t = new Solution44();
        System.out.println("["+t.ReverseSentence("student. a am I")+"]");
       System.out.println("["+t.ReverseSentence(" ")+"]");
        System.out.println("["+t.ReverseSentence("")+"]");
        System.out.println("["+t.ReverseSentence(" aaa bb c. cc   dd ee f")+"]");
    }

    /**
     * 剑指offer的方法，两次翻转
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length/2;i++){
            swap(chars,i,chars.length-i-1);
        }
//        System.out.println(String.valueOf(chars));
        int i = 0;
        int j = 0;
        while(i<chars.length){
            for(j = i;j<chars.length&&chars[j]!=' ';j++);
            if(j<=chars.length){
                int ii,pp;
                for(ii=i,pp = j-1;pp>ii;)swap(chars,ii++,pp--);
            }
            i = j+1;
        }
        return String.valueOf(chars);
    }
    public void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
