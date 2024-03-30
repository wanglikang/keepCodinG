package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 2020/4/6 10:11
 * author:WLK
 * 网易2020校招笔试- 大数据开发工程师（正式批）
 * 企业提供原题
 * 00:43:54
 * 16/16
 * [编程题]积木
 *
 * 时间限制：C/C++ 2秒，其他语言4秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易有堆积木，第堆积木有块。小易还拥有一个容量无限的背包。
 * 一开始小易站在第一堆积木旁边。每次小易可以选择进行下列三种操作中的一种：
 * 1、从背包里掏出一块积木（如果有的话）放到当前这一堆里
 * 2、从当前这一堆积木里掏出一块塞到背包里(如果当前积木堆不为空的话)
 * 3、从当前这一堆走到下一堆。
 * 一开始小易的背包里有块积木。小易希望把这些个积木变成严格递增的（即。小易希望知道这是否有可能能完成。（所有操作结束后不需要保证背包里没有积木了，可以有积木堆为空）。
 *
 * 输入描述:
 *
 * 第一行数据组数T
 * 对于每组数据，第一行数字，接下来一行个数字表示.
 *
 *
 * 输出描述:
 *
 * 对于每组数据输出一行，输出结果YES或NO
 *
 *
 * 输入例子1:
 *
 * 1
 * 5 3
 * 2 2 3 3 1
 *
 *
 * 输出例子1:
 *
 * YES
 *
 *
 * 输入例子2:
 *
 * 1
 * 5 2
 * 0 0 1 2 1
 *
 *
 * 输出例子2:
 *
 * NO
 */

public class W6 {

    @Test
    public void test() {
        W6 t = new W6();
//        int n  = 5;
//        int m = 3;
        int[] arr = new int[]{2,2,3,3,1};
//        System.out.println(func(arr,m)!=Integer.MAX_VALUE?"YES":"NO");
//        int[] arr = new int[]{0,0,1,2,1};
        int res = func(arr,3);
        System.out.println(res);
        System.out.println(res!=Integer.MAX_VALUE?"YES":"NO");
    }


    public int func(int[] arr,int m){
        return dfs(arr,m,0,0);
    }

    public static int getLastNotZero(int[] arr,int endIndex){
        for(int i = endIndex;i>=0;i--){
            if(arr[i]!=0){
                return i;
            }
        }
        return endIndex;
    }

    public  static int dfs(int[] arr,int m ,int index,int count){
        if(index>=arr.length){
            return count;
        }
//        System.out.println(m+":"+index+":"+depth);

        int mm = m;
        int value = arr[index];
        int tcount = count;
        int t=0;

        int lastNotZero = getLastNotZero(arr,index);
        if(lastNotZero<index){


        }else{
            //index是第一个堆

        }


        return t==Integer.MAX_VALUE?Integer.MAX_VALUE:t+1;
    }
}
