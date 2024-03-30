package cn.wlk.keepcoding.niuke.Y2020.meituan;

import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 2020/3/19 10:48
 * author:WLK
 *
 * https://www.nowcoder.com/question/next?pid=21910764&qid=894465&tid=31670628
 *
 *
 *
 美团点评2020校招后台开发方向笔试题
 企业提供原题
 00:10:45
 5/9
 [编程题]表达式求值

 时间限制：C/C++ 1秒，其他语言2秒

 空间限制：C/C++ 256M，其他语言512M

 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。

 输入描述:

 输入第一行包含布尔表达式字符串s，s只包含true、false、and、or几个单词（不会出现其它的任何单词），且单词之间用空格分隔。 (1 ≤ |s| ≤ 103).


 输出描述:

 输出true、false或error，true表示布尔表达式计算为真，false表示布尔表达式计算为假，error表示一个不合法的表达式。


 输入例子1:

 and


 输出例子1:

 error


 输入例子2:

 true and false


 输出例子2:

 false


 输入例子3:

 true or false and false


 输出例子3:

 true


 */

/**
 * 解法：用栈，
 * 但是
 * 您的代码已保存
 * 请检查是否存在数组越界等非法访问情况
 * case通过率为94.12%
 */


public class Meituan1 {

    @Test
    public void test() {
        Meituan1 t = new Meituan1();

//        System.out.println(t.func("true and false"));
        System.out.println(t.func("true or false and false"));
        System.out.println(t.func("true true"));

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        boolean r = func(line);
//        System.out.println(r);
//    }


    public String func(String str){


        String[] words = str.split(" ");
        Stack<String> wordStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();

        for(int i = 0;i<words.length;){
            if(words[i].equals("true") || words[i].equals("false")){
                wordStack.push(words[i]);
                i++;
            }else if(words[i].equals("or")){
                opsStack.push(words[i]);
                i++;
            }else{
                String currWord = wordStack.pop();
                String nextWord;
                if(i+1<words.length) {
                    nextWord = words[i + 1];
                }else{
                    return "error";
                }
                if(currWord.equals("true") && nextWord.equals("true")){
                    wordStack.push("true");
                }else{
                    wordStack.push("false");
                }
                i+=2;
            }
        }
        while (!opsStack.empty()){
            String w1;
            String w2;
            if(wordStack.size()>=2) {
                 w1 = wordStack.pop();
                 w2 = wordStack.pop();
            }else{
                return "error";
            }
            String op = opsStack.pop();
            if(w1.equals("true") || w2.equals("true")){
                wordStack.push("true");
            }else{
                wordStack.push("false");
            }
        }

        if(wordStack.size()==1){
            return wordStack.pop().equals("true")?"true":"false";
        }else{
            return "error";
        }
    }

}
