package cn.wlk.keepcoding.niuke.Y2020.QiNiu;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/28 19:29
 * author:WLK
 *
 * 给一个无向图，判断是否联通
 * 联通输出YES
 * 否则输出NO
 */

public class Q1 {

    static int visitedNode = 0;

    @Test
    public void test() {
        Q1 t = new Q1();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] map = new int[N+1][N+1];
        int[] visited = new int[N+1];
//        int[][] edges = new int[M][2];
        int u ,v;
        for(int i = 0;i<M;i++){
            u = scanner.nextInt();
            v = scanner.nextInt();
            map[u][v]=1;
            map[v][u]=1;
        }
        System.out.println(func(N,visited,map));
    }
    public static String func(int N,int[] visited,int[][] map){

        visitedNode++;
        visited[1]=1;
        dfs(map,visited,1,N);
        if(visitedNode!=N){
            return "NO";
        }

        return "YES";
    }

    public static void dfs(int[][] map,int[] visited,int u,int N){
        for(int v = 1;v<=N;v++){
            //v点尚未访问过
            if(v!=u && visited[v]!=1 && map[u][v]==1){
                visited[v]=1;
                visitedNode++;
                dfs(map,visited,v,N);
            }
        }
    }


}
