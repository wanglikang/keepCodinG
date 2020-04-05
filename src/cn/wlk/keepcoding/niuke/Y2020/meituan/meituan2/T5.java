package cn.wlk.keepcoding.niuke.Y2020.meituan.meituan2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/19 20:32
 * author:WLK
 *
 * 特殊的序列
 * 时间限制：C/C++语言 2000MS；其他语言 4000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 某个序列的最长不下降子序列的定义为将这个序列去除最少的数，使得剩下的每一个数都大于等于他自身前面的数。比如，1,0,0,1,1的最长不下降子序列为0,0,1,1，其中去除了第一个1，剩下的数0,0,1,1后面的数都大于等于前面的数。
 *
 * 现在有一个特殊的序列，这个序列中所有的数都是0或者1。你需要按照题目所给的顺序完成两种任务：
 *
 * 1.将某段区间的0变为1,1变为0
 *
 * 2.询问整段序列的最长不下降子序列长度。
 *
 * 每一个操作进行后都会对序列造成改变，这意味着整个序列会不停的发生变化。
 *
 * 输入
 * 第一行2个数n,m，代表序列长度和询问次数
 *
 * 第二行n个数字，中间没有空格。每个数字为0或者1，第 i 个数代表序列中第i个数的大小
 *
 * 接下来m行，每行一个询问。其中，两个操作的询问方式如下：
 *
 * 1.c x y将区间[x,y]的0变为1,1变为0。
 *
 * 2.q 询问整段序列的最长不下降子序列长度。
 *
 * 注意，序列的第一个位置从开始标号，意思为整个序列的下标为1,2...n
 *
 * 1≤n≤100000 , 1≤m≤100000 , 1≤x≤y≤n
 *
 * 输出
 * 对于第二种操作：q类型询问，输出整段序列的最长不下降子序列长度。
 *
 *
 * 样例输入
 * 5 5
 * 10011
 * q
 * c 1 5
 * q
 * c 1 3
 * q
 * 样例输出
 * 4
 * 3
 * 4
 *
 * 提示
 * 样例解释
 * 1.第一次询问，原序列为10011，答案为0011
 * 2.第二次修改，原序列为10011，修改后为01100
 * 3.第三次询问，原序列为01100，答案为011或者000
 * 4.第四次修改，原序列为01100，修改后为10000
 * 5.第五次询问，原序列为10000，答案为0000
 *
 */

public class T5 {

    @Test
    public void test() {
        T5 t = new T5();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        scanner.nextLine();
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        for(int i= 0;i<chars.length;i++){
            arr[i] = chars[i]=='0'?0:1;
        }
        for(int i = 0;i<m;i++){
            line = scanner.nextLine();
            if(line.length()==1){//q
                System.out.println(query(arr));

            }else{//change

                String[] nums = line.split(" ");
                funcChange(arr,Integer.parseInt(nums[1])-1,Integer.parseInt(nums[2])-1);
            }

        }
    }
    public static void funcChange(int[] arr,int x,int y){
        for(int i = x;i<=y;i++){
            arr[i] = arr[i]==1?0:1;
        }
    }
    public static int query(int[] arr){
        return findLongestSub(arr);
    }

    public static int findLongestSub(int[] arr){
        int n = arr.length;
        int count0 = (int) Arrays.stream(arr).filter(v->{return v==0;}).count();
        int count1 = 0;

        int pre1=0,pre0 = 0;
        int end1=0,end0 = 0;
        for(int i = 0;i<n;i++){
            if(arr[i]==1){
                pre1++;
            }else{
                break;
            }
        }
        for(int i = 0;i<n;i++){
            if(arr[i]==0){
                pre0++;
            }else{
                break;
            }
        }

        for(int i = n-1;i>=0;i--){
            if(arr[i]==1){
                end1++;
            }else{
                break;
            }
        }
        for(int i = n-1;i>=0;i--){
            if(arr[i]==0){
                end0++;
            }else{
                break;
            }
        }


        if(pre0!=0){
            return count0+end1;
        }else{
            return Math.max(pre1,count0+end1);
        }

    }

}
