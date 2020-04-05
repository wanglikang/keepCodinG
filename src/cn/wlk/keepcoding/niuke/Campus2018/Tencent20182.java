package cn.wlk.keepcoding.niuke.Campus2018;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/3/8 9:56
 * author:WLK
 * https://www.nowcoder.com/question/next?pid=10611931&qid=161631&tid=31187355
 *
 *
 * 腾讯2018春招技术类编程题汇总
 * 企业提供原题
 * 00:26:11
 * 2/6
 * [编程题]纸牌游戏
 *
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 *
 * 输入描述:
 *
 * 输入包括两行。
 * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 *
 *
 * 输出描述:
 *
 * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 *
 *
 * 输入例子1:
 *
 * 3
 * 2 7 4
 *
 *
 * 输出例子1:
 *
 * 5
 *
 */

public class Tencent20182 {

    @Test
    public void test() {
        Tencent20182 t = new Tencent20182();
    }

    public static void main(String[] argc){
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//
//        for(int i  = 0;i<n;i++){
//            nums[i]=scanner.nextInt();
//        }

        int[] nums = new int[]{2,7,4};

        int result = func(nums);
        System.out.println(result);



    }

    public static int func(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        int diff = 0;
        for(int i = n-1;i>=0;i=i-2){
            if(i!=0){
                diff+=nums[i]-nums[i-1];
            }else{
                diff += nums[0];
            }
        }

        return diff;
    }

}
