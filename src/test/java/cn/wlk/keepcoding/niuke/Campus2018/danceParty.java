package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 2019/3/27 11:06
 * author:WLK
 */

/**
 * 题目描述 舞会
 * <p>
 * <p>
 * <p>
 * 今天，在冬木市举行了一场盛大的舞会。参加舞会的有n 位男士，从 1 到 n 编号；有 m 位女士，从 1 到 m 编号。对于每一位男士，他们心中都有各自心仪的一些女士，在这次舞会中，他们希望能与每一位自己心仪的女士跳一次舞。同样的，对于每一位女士，她们心中也有各自心仪的一些男士，她们也希望能与每一位自己心仪的男士跳一次舞。在舞会中，对于每一首舞曲，你可以选择一些男士和女士出来跳舞。但是显然的，一首舞曲中一位男士只能和一位女士跳舞，一位女士也只能和一位男士跳舞。由于舞会的时间有限，现在你想知道你最少需要准备多少首舞曲，才能使所有人的心愿都得到满足？
 * 输入描述:
 * <p>
 * 第一行包含两个整数n,m，表示男士和女士的人数。1≤n,m≤ 1000
 * 接下来n行，
 * 第i行表示编号为i的男士有ki个心仪的女生
 * 然后包含ki个不同的整数分别表示他心仪的女士的编号。
 * 接下来m行，以相同的格式描述每一位女士心仪的男士。
 * <p>
 * 输出描述:
 * <p>
 * 一个整数，表示最少需要准备的舞曲数目。
 * <p>
 * 示例1
 * 输入
 * <p>
 * 2 3
 * 1 1
 * 2 2 3
 * 0
 * 0
 * 0
 * <p>
 * 输出
 * <p>
 * 2
 * <p>
 * 说明
 * <p>
 * 示例2
 * 输入
 * <p>
 * 3 3
 * 2 1 2
 * 2 1 3
 * 2 2 3
 * 1 1
 * 2 1 3
 * 2 2 3
 * <p>
 * 输出
 * <p>
 * 2
 * <p>
 * 说明
 * <p>
 * 对于样例2，我们只需要两首舞曲，第一首舞曲安排（1,1），（2,3），（3,2）；第二首舞曲安排（1,2），(2,1)，（3,3）。
 *
 * 解法：建一个二维表，存放互相心仪的对应关系，，然后找出每个人（男人和女人）的最大的需要跳舞的次数即可（即对每行每列，找出最大值）
 */
public class danceParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        for (int t = 1; t <= n; t++) {
            int nu = scanner.nextInt();
            int temp;
            for (int i = 0; i < nu; i++) {
                temp = scanner.nextInt();
                arr[t][temp] = 1;
            }
        }
        for (int t = 1; t <= m; t++) {
            int nu = scanner.nextInt();
            int temp;
            for (int i = 0; i < nu; i++) {
                temp = scanner.nextInt();
                arr[temp][t] = 1;
            }
        }

//        for(int i = 1;i<=n;i++){
//            for(int j = 1;j<=m;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        int result = -1;
        for (int i = 1; i <= n; i++) {
            int tempsum = 0;
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1)
                    tempsum++;
            }
            result = Math.max(result, tempsum);
        }
        for (int i = 1; i <= m; i++) {
            int tempsum = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[j][i] == 1)
                    tempsum++;
            }
            result = Math.max(result, tempsum);
        }
        System.out.println(result);
    }

}
