package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 2019/3/31 12:39
 * author:WLK
 */

/**题目描述 题目列表
 *
 * 解法：自定义排序
 *
 */
import java.util.Scanner;
public class ProblemList{
    static class Prob implements Comparable<Prob> {
        public String name;
        public int level;

        public Prob(String name, int x, int y) {
            this.name = name;
            double dif = y * 100.0 / x;
            if (dif <= 30)
                this.level = 5;
            else if (dif <= 60)
                this.level = 4;
            else this.level = 3;
        }

        @Override
        public int compareTo(Prob b) {
            return this.name.compareTo(b.name);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String tname;
        int x,y;
        ArrayList<Prob> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            tname = scanner.next();
            x = scanner.nextInt();
            y = scanner.nextInt();
            Prob p = new Prob(tname,x,y);
            arr.add(p);
        }
        Collections.sort(arr);
        for(int i = 0;i<n;i++){
            System.out.println(arr.get(i).name+" "+arr.get(i).level);
        }

    }

}