package cn.wlk.keepcoding.niuke.Y2020.WangYi.xitongkaifa;

/**
 * 2020/8/8 11:03
 * author:WLK
 */

import java.util.*;

/**
 * 网易2020校招笔试- 系统开发/研发工程师（提前批）
 * 企业提供原题
 15/16
 [编程题]序列维护

 时间限制：C/C++ 3秒，其他语言6秒

 空间限制：C/C++ 256M，其他语言512M
 小易在维护数据的时候遇到一个需求，具体来说小易有一系列数据，这些数据了构成一个长度为n的数字序列，接下来小易会在这个序列上进行q次操作。
 每次操作有一个查询的数字x，小易需要将序列数据中所有大于等于x的数字都减一，并输出在本次操作中有多少个数字被减一了。
 小易犯了难，希望你能帮帮他。

 输入描述:

 第一行n,q，表示数字个数和操作个数。
 接下来一行n个数表示初始的数字。
 接下来q行，每行一个数，表示指定的数字x。
 ，


 输出描述:

 对于每个询问，输出一个数字表示答案


 输入例子1:

 4 3
 1 2 3 4
 4
 3
 1


 输出例子1:

 1
 2
 4


 输入例子2:

 3 2
 1 2 3
 3
 3


 输出例子2:

 1
 0


 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(int i = 0;i<n;i++){
            int a = scanner.nextInt();
            if(maps.containsKey(a)){
                maps.put(a,maps.get(a)+1);
            }else{
                maps.put(a,1);
            }
        }
        for(int i = 0;i<q;i++){
            int k = scanner.nextInt();
            int count = 0;
            for(int qqq = k;qqq<=n;qqq++){
                if(maps.containsKey(qqq)){
                    int v = maps.get(qqq);
                    count+=v;
                    if(maps.containsKey(qqq-1)){
                        maps.put(qqq-1,maps.get(qqq-1)+v);
                    }else{
                        maps.put(qqq-1,v);
                    }
                    maps.remove(qqq);
                }
            }
            System.out.println(count);
        }

    }
}
