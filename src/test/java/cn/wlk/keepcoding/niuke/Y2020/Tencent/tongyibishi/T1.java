package cn.wlk.keepcoding.niuke.Y2020.Tencent.tongyibishi;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2020/4/26 20:03
 * author:WLK
 */

public class T1 {
    private static Queue<Integer> queue =new LinkedList<>();

    @Test
    public void test() {
        /*
2
7
PUSH 1
PUSH 2
TOP
POP
TOP
POP
POP
5
PUSH 1
PUSH 2
SIZE
POP
SIZE

         */
        T1 t = new T1();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while(k-->0){
            int n = scanner.nextInt();
            scanner.nextLine();
            clear();
            while(n-->0){
                String  str = scanner.nextLine();
                String[] command = str.split(" ");

                switch (command[0]){
                    case "PUSH":
                        push(Integer.parseInt(command[1]));
                        break;
                    case "TOP":
                        System.out.println(top());
                        break;
                    case "POP":
                        int popreuslt = pop();
                        if(popreuslt==-1) {
                            System.out.println(-1);
                        }else{
                            //System.out.println(popreuslt);
                        }
                        break;
                    case "SIZE":
                        System.out.println(size());
                        break;
                    case "CLEAR":
                        clear();
                }

            }

        }
    }

    public static void push(int x){
        queue.add(x);
    }
    public static int top(){
        if(queue.size()>0){
            return queue.peek();
        }else{
            return -1;
        }
    }

    public static int pop(){
        if(queue.size()>0) {
            return    queue.poll();
        }else{
            return -1;
        }
    }
    public static int size(){
        return queue.size();
    }

    public static void clear(){
        queue.clear();;


    }

}
