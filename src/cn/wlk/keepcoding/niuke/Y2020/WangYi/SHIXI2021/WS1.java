package cn.wlk.keepcoding.niuke.Y2020.WangYi.SHIXI2021;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2020/4/7 20:02
 * author:WLK
 */

public class WS1 {

    @Test
    public void test() {
        WS1 t = new WS1();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int[][] matrix = new int[n+1][n+1];
        int[][] xys = new int[m][2];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                matrix[i][j] = 1;
            }
        }
        for(int i = 0;i<m;i++){
            xys[i][0] = scanner.nextInt();
            xys[i][1] = scanner.nextInt();
        }
        System.out.println(func(matrix,xys,s,n));

    }
    public  static int func(int[][] matrix,int[][] xys,int s,int n){
        int i = 1;
        for(;i<=xys.length;i++){
            int x = xys[i-1][0];
            int y = xys[i-1][1];
            if(x==0){
                //y城封城市
                if(y==s){
                    return i;
                }
                for(int j = 1;j<=n;j++){
                    matrix[y][j]=0;
                    matrix[j][y]=0;
                }
                matrix[y][y]=0;
            }else{
                matrix[x][x]=0;
                matrix[y][y]=0;
                matrix[x][y]=0;
                matrix[y][x]=0;
            }
            ReentrantLock lock = new ReentrantLock();
            Condition c1 = lock.newCondition();
            lock.lock();

            LinkedList<Integer> l = new LinkedList<>();
            l.add(1);
            ConcurrentHashMap<Integer,Integer> mmap = new ConcurrentHashMap<>();
            mmap.put(1,1);

            //检查s是否封城了
            int t = 0;
            for(int k = 1;k<=n;k++){
                t+=matrix[s][k];
            }
            if(t==0){
                return i;
            }
        }

        return 0;
    }


}
