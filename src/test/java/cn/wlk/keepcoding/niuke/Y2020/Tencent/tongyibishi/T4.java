package cn.wlk.keepcoding.niuke.Y2020.Tencent.tongyibishi;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2020/4/26 20:24
 * author:WLK
 *
 * 用两个栈实现队列
 *
 * 超时了
 */

public class T4 {

//    static Stack<Integer> stack1 = new Stack<>();
//    static Stack<Integer> stack2 = new Stack<>();

    static String[] stack1 = new String[1000001];
    static String[] stack2 = new String[1000001];

    //放在下一个需要填充的位置
    static int size1 = 0;
    static int size2 = 0;

    @Test
    public void test() {
        T4 t = new T4();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-->0){
            String line  = scanner.nextLine();
            if(line.length()==4){
                if(line.equals("peek")){
                    System.out.println(peek());
                }else{
                    poll();
                }
            }else{
                //add
//                add(Integer.parseInt(line.substring(4)));
                add(line.substring(4));

            }
//            String[] command = line.split(" ");
//            switch (command[0]){
//                case "add":
//                    add(Integer.parseInt(command[1]));
//                    break;
//                case  "peek":
//                    System.out.println( peek());
//                    break;
//                case "poll":
//                    poll();
//                    break;
//                default:break;
//            }


        }
    }


    public static void add(String x){
        stack1[size1++]=x;
        if(size1>100){
            while(size1>0){
                stack2[size2++]=stack1[--size1];
            }
        }
//        if(stack1.size()>100){
//            while (stack1.size() > 0) {
//                stack2.add(stack1.pop());
//            }
//        }
    }

    public static String peek(){
        if(size2<1){
            while(size1>0){
                stack2[size2++]=stack1[--size1];
            }
        }
//
//        if(stack2.size()==0) {
//            while (stack1.size() > 0) {
//                stack2.add(stack1.pop());
//            }
//        }
        return stack2[size2-1];

    }

    public static void poll(){
        if(size2<1){
            while(size1>0){
                stack2[size2++]=stack1[--size1];
            }
        }
        size2--;
//
//        if(stack2.size()==0){
//            while (stack1.size()>0){
//                stack2.add(stack1.pop());
//            }
//        }
        //stack2.pop();
    }
}
