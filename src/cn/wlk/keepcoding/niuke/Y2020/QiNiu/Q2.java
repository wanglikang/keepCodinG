package cn.wlk.keepcoding.niuke.Y2020.QiNiu;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2020/4/28 20:20
 * author:WLK
 * 消消乐
 *
 */

public class Q2 {

    @Test
    public void test() {
        Q2 t = new Q2();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-->0) {
            String s = scanner.nextLine();
            System.out.println(func(s));
        }
    }
    public static  String func(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(stack.size()==0){
                stack.add(c);
            }else{
                char top = stack.peek();
                if(top==c){
                    stack.pop();
                }else{
                    stack.add(c);
                }

            }
        }

        if(stack.size()==0){
            return "Yes";
        }else{
            return "No";
        }


    }


}
