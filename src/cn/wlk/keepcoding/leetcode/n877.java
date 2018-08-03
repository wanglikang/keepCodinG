package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 877. 石子游戏
 *
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *
 *
 * 示例：
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *
 *
 * 提示：
 *
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 */
public class n877 {
    public int choose(int[] piles,int i,int j,int sum[],int total){
        //choose i
        sum[0]+=piles[i];
        int sumi ;
        if(sum[0]>=total/2)
            return sum[0];
        else{
            //other choose i+1  OR //other choose j
            sumi =Math.max(choose(piles,i+2,j,sum,total),choose(piles,i+1,j-1,sum,total));
        }
        sum[0]-=piles[i];

        //choose j
        sum[0]+=piles[j];
        int sumj ;
        if(sum[0]>=total/2)
            return sum[0];
        else {
            //other choose j-1
            //other choose i
            sumj =Math.max(choose(piles,i+1,j-1,sum,total),choose(piles,i+1,j-2,sum,total));
        }
        sum[0]=Math.max(sumi,sumj);
        return sum[0];
    }
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int total = 0;
        for(int i = 0;i<len;i++){
            total+=piles[i];
        }

        int[] sum={0,0};
        if(choose(piles,0,len-1,sum,total)>=total/2)
            return true;
        else return false;


    }
    @Test
    public void test() {
        n877 t = new n877();
        int piles[] = {1,2,5,2,1};
        System.out.println(t.stoneGame(piles));
    }

}
