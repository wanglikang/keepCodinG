package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2020/4/21 22:42
 * author:WLK
 */

public class TP08P02 {

    @Test
    public void test() {
        TP08P02 t = new TP08P02();
//        int[][] in = Utils.createintInintFromString("[[0,0,0],[0,1,0],[0,0,0]]");

//        int[][] in = Utils.createintInintFromString("[[1]]");
//        int[][] in = Utils.createintInintFromString("[[0]]");
//        int[][] in = Utils.createintInintFromString("[[1,0]]");
        int[][] in = Utils.createintInintFromString("[" +
                "[0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0]," +
                "[0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]," +
                "[0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0]," +
                "[1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1]," +
                "[0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0]," +
                "[0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0]," +
                "[1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0]," +
                "[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0]," +
                "[0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0]," +
                "[0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0]," +
                "[0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0]," +
                "[1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1]," +
                "[0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0]," +
                "[0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0]," +
                "[0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1]," +
                "[1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]," +
                "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0]," +
                "[0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1]," +
                "[0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1]," +
                "[1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0]," +
                "[0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1]," +
                "[0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0]]");

        /**
         * [[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[1,7],[1,8],[1,9],[1,10],[1,11],[2,11],[2,12],[2,13],[2,14],[2,15],[2,16],[2,17],[2,18],[3,18],[4,18],[4,19],[4,20],[4,21],[4,22],[5,22],[5,23],[5,24],[5,25],[6,25],[7,25],[8,25],[8,26],[9,26],[10,26],[10,27],[10,28],[11,28],[12,28],[13,28],[14,28],[15,28],[15,29],[16,29],[17,29],[18,29],[19,29],[19,30],[20,30],[21,30],[21,31],[21,32]]
         */
        List<List<Integer>> result = t.pathWithObstacles(in);
        result.stream().forEach(v->{
            v.stream().forEach(vv->{
                System.out.print(vv+" ");
            });
            System.out.println();
        });
    }
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        List<List<Integer>> result = new ArrayList<>();
        if(obstacleGrid[0][0]==1){
            return result;
        }
        dp[0][0]=1;
        for(int i = 1;i<n;i++){
            dp[i][0]=obstacleGrid[i][0]==1?0:dp[i-1][0]+1;
        }
        for(int j = 1;j<m;j++){
            dp[0][j]=obstacleGrid[0][j]==1?0:dp[0][j-1]+1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    if(obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]!=1){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+1;
                    }else if(obstacleGrid[i-1][j]!=1){
                        dp[i][j]=dp[i-1][j]+1;
                    }else if(obstacleGrid[i][j-1]!=1){
                        dp[i][j]=dp[i][j-1]+1;
                    }else{
                        dp[i][j]=0;
                    }
                }
            }
        }

        int k = dp[n-1][m-1];
        int i = n-1,j = m-1;

//        Utils.showArray(obstacleGrid);
//        System.out.println();
//        Utils.showArray(dp);
        if(dp[i][j]!=(n+m-1)){
            return result;
        }
        while(i>=1 && j>=1){
            if(dp[i][j]==dp[i-1][j]+1){
                List<Integer> xys = new ArrayList<>();
                xys.add(i);
                xys.add(j);
                result.add(xys);
                i--;
            }else{
                List<Integer> xys = new ArrayList<>();
                xys.add(i);
                xys.add(j);
                result.add(xys);
                j--;
            }
        }

        while (i>=0){
            List<Integer> xys = new ArrayList<>();
            xys.add(i);
            xys.add(j);
            result.add(xys);
            i--;
        }
        i++;
        j--;
        while (j>=0){
            List<Integer> xys = new ArrayList<>();
            xys.add(i);
            xys.add(j);
            result.add(xys);
            j--;
        }
        Collections.reverse(result);
//        Utils.showArray(dp);
        return result;
    }

}
