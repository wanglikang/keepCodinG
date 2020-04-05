package cn.wlk.keepcoding.niuke.Y2020.meituan;

import org.junit.Test;

import java.util.*;

/**
 * 2020/3/19 10:48
 * author:WLK
 *
 * https://www.nowcoder.com/question/next?pid=21910764&qid=894514&tid=31670628
 *
 美团点评2020校招后台开发方向笔试题
 企业提供原题
 01:49:57
 9/9
 [编程题]火星文字典

 时间限制：C/C++ 1秒，其他语言2秒

 空间限制：C/C++ 256M，其他语言512M

 已知一种新的火星文的单词由英文字母（仅小写字母）组成，但是此火星文中的字母先后顺序未知。给出一组非空的火星文单词，且此组单词已经按火星文字典序进行好了排序（从小到大），请推断出此火星文中的字母先后顺序。

 输入描述:

 一行文本，为一组按火星文字典序排序好的单词(单词两端无引号)，单词之间通过空格隔开


 输出描述:

 按火星文字母顺序输出出现过的字母，字母之间无其他字符，如果无法确定顺序或者无合理的字母排序可能，请输出"invalid"(无需引号)




 输入例子1:

 z x


 输出例子1:

 zx


 输入例子2:

 wrt wrf er ett rftt


 输出例子2:

 wertf


 输入例子3:

 z x z


 输出例子3:

 invalid


 */

/**
 * 解法：类似求是否有环的方法，但是只通过了70%
 */


public class Meituan5 {

    @Test
    public void test() {
        Meituan5 t = new Meituan5();
//        String str = "wrt wrf er ett rftt";
        String str = "b j";
        System.out.println(func(str.split(" ")));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String aline = scanner.nextLine();
        System.out.println(func(aline.split(" ")));

    }


    public static String func(String[] words){

        int[] next = new int[256];
        int[] pre = new int[256];

        List<char[]> pair = new ArrayList<>();
        HashSet<Integer> charsSet = new HashSet<>();

        for(int i = 0;i<words.length-1;i++){
            for(int j = 0;j<words[i].length();j++){
                charsSet.add((int)words[i].charAt(j));
            }
            pair.add(findDiff(words[i],words[i+1]));
        }
        for(int j = 0;j<words[words.length-1].length();j++){
            charsSet.add((int)words[words.length-1].charAt(j));
        }

        for(int i = 0;i<pair.size();i++){
            int start = pair.get(i)[0];
            int end = pair.get(i)[1];
            if(next[start]!=0 && next[start]!=end){
                return "invalid";
            }else{
                next[start]=end;
                pre[end]=start;
            }
            if(hasClose(next,start)){
//                System.out.println("hasclose\t"+start+"\t"+(char)start);
                return "invalid";
            }
        }

        int startIndex = -1;
        for(int i = 0;i<256;i++){
            if(next[i]!=0 && pre[i]==0){
                startIndex= i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(startIndex!=0){
            sb.append((char)startIndex);
            startIndex = next[startIndex];
        }

        return sb.length()==charsSet.size()?sb.toString():"invalid";
    }
    public static  boolean hasClose(int[] next,int key){
        int t = key;
        while(next[t]!=0){
            t = next[t];
            if(t==key){
                return true;
            }
        }
        return false;
    }

    public static  char[] findDiff(String s1,String s2){
        for(int i = 0;i<s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return new char[]{s1.charAt(i), s2.charAt(i)};
            }
        }
        return new char[]{};

    }

}
