package cn.wlk.keepcoding.niuke.Y2020.Tencent.tongyibishi;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/26 21:41
 * author:WLK
 */

public class T11 {
    static int[] queue = new int[100000];
    static int front = 0;
    static int tail = 0;

    @Test
    public void test() {
        T11 t = new T11();
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
        queue[tail++]=x;
//        queue.add(x);
    }
    public static int top(){
        if(tail-front>0){
            return queue[front];
        }else{
            return -1;
        }
    }

    public static int pop(){
        if(tail-front>0) {
            return    queue[front++];
        }else{
            return -1;
        }
    }
    public static int size(){
        return tail-front;

    }

    public static void clear(){
        front = 0;
        tail = 0;
    }

}
