package cn.wlk.keepcoding.niuke.Y2020.Ali;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2020/4/10 9:08
 * author:WLK
 */

public class A2 {

    @Test
    public void test() {
        A2 t = new A2();

        int[][] nmc = new int[][]{
                {1,5,2},
                {3,3,4},
                {2,3,3},
                {3,2,3}
        };
        int[][] cc = new int[][]{
                {4,1},
                {1,2,2,4},
                {2,2,2},
                {2,2,2}
        };

        for(int i = 0;i<4;i++){
            System.out.println(A2.func(nmc[i][0],nmc[i][1],nmc[i][2],cc[i]));
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){

            int n=  scanner.nextInt();
            int m= scanner.nextInt();
            int C = scanner.nextInt();
            int[] c = new int[C];
            for(int i = 0;i<C;i++){
                c[i] = scanner.nextInt();
            }
            System.out.println(func(n,m,C,c));
        }
    }
    public static String func(int n,int m,int C,int[] c){
        long sum = 0;
        for(int i = 0;i<C;i++){
            sum+=c[i];
        }
        if(sum<n*m){
            return "NO";
        }
        int[][] map = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                map[i][j]=-1;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(draw(map,i,j,c,1)){
                    return "YES";
                }
            }
        }

        return "NO";

    }


    /**
     * 在当前染料c的情况下，是否可以有解
     * @param map 已经染成的颜色,默认为为染色，-1
     * @param x
     * @param y
     * @param c
     * @return
     */
    public static boolean draw(int[][] map,int x,int y,int[] c,int drawCount){
        int C = c.length;

        int n = map.length;
        int m = map[0].length;
        boolean left,right,up,down;
        for(int i = 0;i<C;i++){
            left = right = up = down = true;

            //还有剩余染料可用
            if(c[i]>0){
                //当前x,y能着色
                if(canDraw(map,x,y,c,i)) {
                    c[i]--;
                    map[x][y] = i;
                    if(drawCount==n*m){
                        return true;
                    }

                    if (x > 0 && map[x - 1][y] == -1) {
                        left = draw(map, x - 1, y, c,drawCount++);
                    }
                    if (x < n - 1 && map[x + 1][y] == -1) {
                        right = draw(map, x + 1, y, c,drawCount++);
                    }
                    if (y > 0 && map[x][y - 1] == -1) {
                        up = draw(map, x, y - 1, c,drawCount++);
                    }
                    if (y < m - 1 && map[x][y + 1] == -1) {
                        down = draw(map, x, y + 1, c,drawCount++);
                    }

                    if(left&&right&&up&&down){
                        return true;
                    }
                    //恢复未着色状态
                    map[x][y]=-1;
                    c[i]++;
                }
            }
        }
        return false;
    }

    public static boolean canDraw(int[][] map,int x,int y,int[] c,int cIndex){
            int n = map.length;
            int m= map[0].length;
            int color = cIndex;//此处写成了c[cIndex];/////////////////////////////////////////////////////
            boolean left,right,up,down ;
            left = right = up = down = true;//默认都可以
            if(x>0 &&map[x-1][y]!=-1){
                left = map[x-1][y]!=color;
            }
            if(x<n-1 && map[x+1][y]!=-1){
                right = map[x+1][y]!=color;
            }
            if(y>0 && map[x][y-1]!=-1){
                up = map[x][y-1]!=color;
            }

            if(y<m-1 && map[x][y+1]!=-1){
                down = map[x][y+1]!=color;
            }
        ConcurrentHashMap<String,String> hhh = new ConcurrentHashMap<>();
            hhh.get("aaa");
            return left&& right&&up&& down;
        }

}
