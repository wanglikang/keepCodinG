package cn.wlk.keepcoding.niuke.Y2020.meituan.meituan2;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/3/19 19:38
 * author:WLK
 *
 * 最长上升子串构造
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给出一个长度为n的由正整数构成的序列，你需要从中删除一个正整数，很显然你有很多种删除方式，你需要对删除这个正整数以后的序列求其最长上升子串，请问在所有删除方案中，最长的上升子串长度是多少。
 *
 * 这里给出最长上升子串的定义：即对于序列中连续的若干个正整数，满足a_{i+1}>a_i，则称这连续的若干个整数构成的子串为上升子串，在所有的上升子串中，长度最长的称为最长上升子串。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示给出的序列的长度。(1<=n<=100000)
 *
 * 接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=100000)
 *
 * 输出
 *   输出仅包含一个正整数，即删除一个数字之后的最长上升子串长度。
 *
 *
 * 样例输入
 * 5
 * 2 1 3 2 5
 * 样例输出
 * 3
 *
 * 超时了
 *
 */

public class T2 {

    @Test
    public void test() {
        T2 t = new T2();

        int[] arr = new int[]{2,1,3,2,5};
        int result = func(arr);
        System.out.println("result:"+result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        System.out.println(func(arr));
    }

    public static int func(int[] arr){
        int n  = arr.length;
        int longest = -1;
        for(int i = 0;i<n;i++){
            int re = findLongestSubStr(arr, i);
//            System.out.println(re);
            if(re>longest){
                longest = re;
            }
        }

        return longest;

    }
    public static int findLongestSubStr(int[] arr,int k){

        int n = arr.length;
        int longest = 1;
        int currDp = 1;


        int i = 0;
        if(k==0){
            i = 2;
        }else{
            i = 1;
        }
        for(;i<n;i++){
            if(i!=k) {
                if (arr[i - 1] < arr[i]) {
                    currDp = currDp + 1;
                    if (longest < currDp) {
                        longest = currDp;
                    }
                } else {
                    currDp = 1;
                }
            }
        }
        return longest;
    }
}







