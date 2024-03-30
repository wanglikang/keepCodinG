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
 *
 *
 * 使用邻接链表的方式
 *
 * 通过88.89%
 * 有数组越界的情况
 */

public class Q1_2 {
    static class Node {
        int v;
        Node next;
        Node(int v){
            this.v =v;
        }
    }

    static int visitedNode = 0;

    @Test
    public void test() {
        Q1_2 t = new Q1_2();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Node[] map = new Node[N+1];
        int[] visited = new int[N+1];
//        int[][] edges = new int[M][2];
        int u ,v;
        for(int i = 0;i<M;i++){
            u = scanner.nextInt();
            v = scanner.nextInt();
            if(map[u]==null){
                map[u] = new Node(v);
            }else{
                Node n = new Node(v);
                n.next = map[u];
                map[u] = n;
            }
            if(map[v]==null){
                map[v]=new Node(u);
            }else {
                Node n = new Node(u);
                n.next = map[v];
                map[v] = n;
            }

        }


        try {
      //      String    result = func(N, visited, map);
            System.out.println(func(N,visited,map));
        }catch (Exception e){
            System.out.println("NO");
        }

    }
    public static String func(int N,int[] visited,Node[] map){
        if(N==0){
            return "NO";
        }

        visitedNode++;
        visited[1]=1;
        dfs(map,visited,1,N);
        if(visitedNode!=N){
            return "NO";
        }

        return "YES";
    }

    public static void dfs(Node[] map,int[] visited,int u,int N){
        Node head = map[u];
        while (head!=null){
            int v  =head.v;
            //v点尚未访问过
            if(v!=u && visited[v]!=1){

                visited[v]=1;
                visitedNode++;
                dfs(map,visited,v,N);
            }
            head = head.next;
        }
    }


}
