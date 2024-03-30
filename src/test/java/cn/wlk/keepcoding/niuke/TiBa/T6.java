package cn.wlk.keepcoding.niuke.TiBa;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 2020/4/3 19:09
 * author:WLK
 *
 * 牛妹打怪兽
 *
 * 题目描述
 * 众所周知，牛妹非常喜欢打游戏，在阳光明媚的一天，她在玩一个叫做打怪兽的游戏。
 * 也许您已经知道游戏“打怪物”。如果您不知道，没关系，让我现在告诉您，森林里有那么多怪物，您就是攻击怪物并保护村庄的英雄。
 * 为了简化问题，我们把怪物排成一行，怪物身上有很多攻击点，你有一把剑，只能切掉攻击点，当切掉一个攻击点时，怪物会分裂成两个在段中，您必须消耗与怪物一样多的能量。您的任务是将怪物切割成不包含任何攻击点。例如，您面对一个怪物，该怪物的长度为20，并且有四个攻击点在其主体上：2 5 10 18.您可以这样切割：
 * 1.切开第一点，您使用的能量为2 + 18 = 20；
 * 2.切第二点，您使用的能量为3 + 15 = 18；
 * 3.切第三点，您使用的能量为5 + 10 = 15；
 * 4.切第四点，您使用的能量是8 + 2 = 10；
 * 您使用的总能量为：20 + 18 + 15 + 10 = 63;
 * 但您可以采用另一种策略：
 * 1.切第二点，您使用的能量是5 + 15 = 20；
 * 2.切开第一点，您使用的能量为2 + 3 = 5；
 * 3.切第三点，您使用的能量是5 + 10 = 15；
 * 4.切第四个点，您使用的能量为8 + 2 = 10；
 * 您使用的能量为：20 + 5 + 15 + 10 = 50;
 * 因此您有最佳的策略来最小化需要消耗的能量。
 * 那么问题来了，牛妹面对给定攻击点和长度的怪兽，到底最后可以用最少多少的能量打倒怪兽呢？
 *
 * 示例1
 * 输入
 * 复制
 *
 * 20,[2,5,10,18]
 *
 * 输出
 * 复制
 *
 * 45
 *
 * 备注:
 *
 * 攻击点个数小于300
 * 怪兽长度小于1000000
 *
 *
 * 解法：用递归也行会超时，可以用dp数组进行记忆化子结果
 */

public class T6 {

    @Test
    public void test() {
        T6 t = new T6();

//        int length = 20;
//        int[] points = new int[]{2,5,10,18};//45
        int length = 90;
        int[] points = new int[]{16,84,52,1,22,75};//233
        System.out.println(t.attackMonster(length,points));
//        System.out.println();
//        System.out.println(t.attackMonster2(length,points));
    }

    /**
     *
     * @param length int整型 怪兽长度
     * @param points int整型一维数组 怪兽攻击点位置
     * @return int整型
     */
    public int attackMonster(int length, int[] points) {
        int n = points.length;
        int[] points2 = new int[n+2];
        points2[0] = 0;
        Arrays.sort(points);
        for(int i = 0;i<n;i++){
            points2[i+1]=points[i];
        }
        points2[n+1]=length;

        int[][] dp = new int[n+2][n+2];
        return func(points2,0,n+1,dp);
    }

    public int func(int[] points,int start,int end,int[][] dp){
        if(start>=end){
            return 0;
        }
        if(start+1==end){
            return 0;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        if(start+2==end){
            return points[end]-points[start];
        }

        int sum = 0;

        int t1,t2,t=Integer.MAX_VALUE;
        for(int i = start+1;i<end;i++){
            sum = points[i]-points[start];
            sum += points[end]-points[i];
            sum += func(points,start,i,dp);
            sum += func(points,i,end,dp);
            t=Math.min(t,sum);
        }
        System.out.println(start+":"+end+"=\t"+sum);
        dp[start][end]=t;
        return t;
    }

    public int attackMonster2(int monsterLength, int[] monsterPoint) {
        // write code here
        Arrays.sort(monsterPoint);
        int n =  monsterPoint.length;
        int[][] dp = new int[n+2][n+2];


        int [] len = new int[n+2];
        for(int i=1;i<n+1;i++){
            len[i] = monsterPoint[i-1];
        }
        len[0]=0;
        len[n+1] = monsterLength;
        for (int i = 2; i <= n+1; i++) { //步长
            for (int j = 0; j <= n+1-i; j++) { //子区间起始点
                int initialMin=Integer.MAX_VALUE;
                int t=-1;
                for (int k = j+1; k < i+j; k++) {    //子区间各个间隔点
                    int tempV=dp[j][k]+dp[k][j+i]+len[j+i]-len[j];
                    if(initialMin>tempV){
                        initialMin=tempV;
                        t = k;
                    }
                }
                System.out.println(t);
                dp[j][j+i]=initialMin;
            }
        }
        Utils.showArray(dp);
        return dp[0][n+1];
    }



}
