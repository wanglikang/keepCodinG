package cn.wlk.keepcoding.niuke.Y2020.yingche;

import java.util.Scanner;

/**
 *
 * 2020/8/4 22:17
 * author:WLK
 */

/**
 *
 1/2
 [编程题]String literal validation

 时间限制：C/C++ 1秒，其他语言2秒

 空间限制：C/C++ 256M，其他语言512M
 Check if the given string is a valid string literal.

 输入描述:

 A double quoted string


 输出描述:

 true or false


 输入例子1:

 "abc"


 输出例子1:

 true


 输入例子2:

 "abc


 输出例子2:

 false


 */
public class T1 {
    public static boolean judge(String str){
        if(str.length() <2 || !str.startsWith("\"") || !str.endsWith("\"")){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();



        if(!judge(input)){
            System.out.println("false");
        }else {
            input = input.substring(1,input.length()-1);

            char[] chars = input.toCharArray();
            boolean isTrue = true;
            for(int i = 0;i<chars.length;i++){
                if(chars[i]=='\\'){
                    if(i+1>=chars.length){
                        isTrue = false;
                        break;
                    }else{
                        i++;
                    }
                }else if(!(Character.isDigit(chars[i]) || Character.isLetter(chars[i]))){
                    isTrue = false;
                }
            }


            if(isTrue){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
