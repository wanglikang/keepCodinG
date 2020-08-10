package cn.wlk.keepcoding.niuke.Y2020.WangYi.SHIXI2021;

import org.junit.Test;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/4/7 20:37
 * author:WLK
 */

public class WS3 {

    @Test
    public void test() {
        WS3 t = new WS3();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] map = new int[n][m];
        for(int i = 0;i<n;i++){
            String line = scanner.nextLine();
            for(int j = 0;j<m;j++){
                map[i][j]=Integer.parseInt(line.substring(j,j+1));
            }
        }

        int[][] re = func(map);;
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<m-1;j++){
                System.out.print(re[i][j]+" ");
            }
            System.out.println(re[i][m-1]);
        }
        for(int j = 0;j<m-1;j++){
            System.out.print(re[n-1][j]+" ");
        }
        System.out.print(re[n-1][m-1]);
    }
    public  static int[][] func(int[][] map){
        if(map==null){
            return map;
        }

        int n = map.length;
        if(n == 0 ){
                //
        }
        int m = map[0].length;
        int[][] result = new int[n][m];
        int[][] hasVisited = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j]==1){
                    result[i][j] = findDistance(map,hasVisited,i,j,i,j);
                    for(int ii = 0;ii<n;ii++){
                        for(int jj = 0;jj<n;jj++){
                            hasVisited[ii][jj]=0;
                        }
                    }
                }else{
                    result[i][j]=0;
                }
            }
        }

        return result;
    }

    private static int findDistance(int[][] map, int[][] hasVisited,int x1,int y1, int i, int j) {
        int n = map.length;
        int m = map[0].length;
        Queue<int[]> queue = new LinkedBlockingQueue<>();
        queue.add(new int[]{i,j});
        int mindistance=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] xys = queue.poll();
            int x = xys[0];
            int y = xys[1];
            hasVisited[x][y]=1;
            if(map[x][y]==0){
                //找到了怪兽
                return Math.abs(x1-x)+Math.abs(y1-y);
            }else{
                if(x>0 && hasVisited[x-1][y]==0){
                    queue.add(new int[]{x-1,y});
                }
                if(x<n-1 && hasVisited[x+1][y]==0){
                    queue.add(new int[]{x+1,y});
                }
                if(y>0 && hasVisited[x][y-1]==0){
                    queue.add(new int[]{x,y-1});
                }
                if(y<m-1 && hasVisited[x][y+1]==0){
                    queue.add(new int[]{x,y+1});
                }
            }
        }

        return -1;
    }

}
