package cn.wlk.keepcoding.niuke.Y2020.meituan.meituan2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/19 20:06
 * author:WLK
 *
 * 任务最大得分
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 现在一共有n个任务可以完成。对于每个任务，都有k个子任务可以做。并且第 i 个子任务需要花费的时间是 ti 。我们可以认为一个子任务需要的时间只和这个子任务是第几个子任务有关，而不和这是属于哪个任务有关。也就是说n个任务的第 i 个子任务需要的时间都是一样的。
 *
 * 每个任务都只可以完成一次，同时每个子任务也只能完成一次，任何任务都不能重复完成。
 *
 * 每当你完成一个子任务你会获得p分，而当你完成一个任务的k个子任务后，你会获得额外的q分，也就是说你会获得pk+q分。
 *
 * 现在你一共有m的时间，你需要求出最大的得分。
 *
 * 输入
 * 第一行三个整数n，k，m。(1≤n≤100),(1≤k≤100),(0≤m≤2e9)
 *
 * 第二行两个整数p，q。(1≤p,q≤100)
 *
 * 第三行k个整数表示每个子任务需要的时间。(1≤ ti≤1e6)
 *
 * 输出
 * 输出在m的时间内能获得的最大得分。
 *
 *
 * 样例输入
 * 3 2 8
 * 3 1
 * 9 5
 * 样例输出
 * 3
 *
 * 提示
 * 输入样例
 * 2 2 3
 * 1 2
 * 1 1
 *
 * 输出样例
 * 5
 */

public class T3 {

    @Test
    public void test() {
        T3 t = new T3();
        System.out.println(func(3,2, 8, 3, 1, new int[]{9, 5}));
//        System.out.println(func(2,2,3,1,2, new int[]{1,1}));


        int tt = Integer.MAX_VALUE;
        long ttt = Long.MAX_VALUE;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr =new int[k];
        for(int i = 0;i<k;i++){
            arr[i] = scanner.nextInt();
        }

        int re = func(n, k, m, p, q, arr);
        System.out.println(re);
    }



    public static int func(int n,int k,int m,int p,int q,int[] arr){
        System.out.println(n+"\t"+k+"\t"+m+"\t"+p+"\t"+q);
        int sum = Arrays.stream(arr).sum();
        int flag = 0;
        if((p*k+q)/sum <p){
            flag = 1;//单个单个的子任务填
        }else{
            flag = 0;//紧着任务填
        }
        Arrays.sort(arr);
        int result = 0;
        if(flag==0){
            int count = Math.min(m/sum,k);

            //能填满count个任务
            result = count*(p*k+q);
            m  = m - count*sum;


            if(count<k) {
                for (int i = 0; i < arr.length; i++) {
                    if (m > 0 && arr[i] <= m) {
                        result += p;
                        m = m - arr[i];
                    } else {
                        break;
                    }
                }
            }
        }else{
            for(int i= 0;i<n;i++){
                int c = Math.min(m / arr[i], k);
                if(c>0){
                    result+=c*p;
                    m = m-arr[i]*c;
                }else{
                    break;
                }
            }
        }

        return result;
    }
}
