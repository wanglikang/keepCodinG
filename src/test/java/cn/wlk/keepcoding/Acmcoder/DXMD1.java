package cn.wlk.keepcoding.Acmcoder;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/20 16:34
 * author:WLK
 *
 * 度小满金融 2020春招 Java研发试卷在线考试
 * 编程题|20.0分1/2
 * 滑动窗口
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 在机器学习中有一种流行的池化操作，而在池化操作中，3*3极大值池化应用十分广泛。什么是3*3极大值池化呢？设原矩阵是n*m的，则3*3极大值池化就是枚举矩阵中的所有3*3的子矩阵,分别求最大值并顺次拼接而成，处理过后的矩阵是(n-2)*(m-2)。
 *
 * 例如，原矩阵是[[1,2,3,4],[5,6,7,8],[9,10,11,12]],经过池化之后就变成[[11,12]]。
 *
 * 为了提高难度，选择的滑动窗口并不是3*3的，而是a*b的，由于输入可能是非常大的，原n*m的矩阵权值由以下公式计算得到，h(i,j)=i*j mod 10。(1<=i<=n,1<=j<=m)
 *
 * 由于输出矩阵也是一个很麻烦的事情，因此你只需输出经过a*b池化处理后的矩阵的元素之和即可。
 *
 * 输入
 * 输入第一行包含四个正整数，n,m,a,b，分别表示原矩阵的行列数量和滑动窗口的行列数量。(1<=n,m,a,b<=1000)
 *
 * 输出
 * 输出仅包含一个整数，即新矩阵的元素之和。
 *
 *
 * 样例输入
 * 4 5 3 3
 * 样例输出
 * 54
 *
 *
 */

public class DXMD1 {

    @Test
    public void test() {
        DXMD1 t = new DXMD1();
        int[][] m = t.createMatrix(4,5);
        Utils.showArray(m);
        System.out.println(findMaxMatrix(m,3,3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m,a,b;
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();

        int[][] matrix = createMatrix(n, m);

        System.out.println(findMaxMatrix(matrix,a,b));
    }

    public static long findMaxMatrix(int[][] matrix,int a,int b){
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        for(int i = 0;i+a<=n;i++){
            for(int j = 0;j+b<=m;j++){
                int max = -1;
                for(int ii = i;ii<i+a;ii++){
                    for(int jj = j;jj<j+b;jj++){
                        if(matrix[ii][jj]>max){
                            max = matrix[ii][jj];
                        }
                    }
                }
                sum+=max;
             //   System.out.println("max:"+max);
            }
        }

        return sum;

    }



    public static int[][] createMatrix(int n,int m){
        int[][] matrix = new int[n][m];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                matrix[i-1][j-1]=(i*j)%10;
            }
        }
        return matrix;
    }
}
