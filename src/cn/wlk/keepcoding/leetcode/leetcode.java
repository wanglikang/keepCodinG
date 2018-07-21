package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

public class leetcode {
    public int n_771_numJewelsInStones(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        int count = 0;
        for (char j : js) {
            for (char s : ss) {
                if (j == s)
                    count++;
            }
        }
        return count;

    }

    public int n_200_numIslands(char[][] grid) {
        if (grid == null)
            return 0;

        int i = grid.length;
        if (i == 0)
            return 0;
        int j = grid[0].length;
        int[][] flag = new int[i][j];

        int sum = 0;
        int count = 0;
        for (int a = 0; a < i; a++)
            for (int b = 0; b < j; b++)
                flag[a][b] = 0;


        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                sum += n_200look(grid, flag, a, b);
            }
        }
        //  System.out.println(sum);


        return sum;
    }

    public int n_200look(char[][] grid, int[][] flag, int a, int b) {
        int i = grid.length;
        int j = grid[0].length;
        if (a < 0 || a >= i)
            return 0;
        if (b < 0 || b >= j)
            return 0;

        if (grid[a][b] == '0')
            return 0;

        if (grid[a][b] == '1') {
            if (flag[a][b] == 0) {
                flag[a][b] = 1;
                n_200look(grid, flag, a - 1, b);
                n_200look(grid, flag, a + 1, b);
                n_200look(grid, flag, a, b - 1);
                n_200look(grid, flag, a, b + 1);
            } else return 0;
        }
        return 1;
    }


    public void n_130_solve(char[][] board) {
        int i = board.length;
        if (i < 1)
            return;
        int j = board[0].length;
        int[][] isSolve = new int[i][j];
        for (int a = 0; a < i; a++)
            for (int b = 0; b < j; b++)
                isSolve[a][b] = 0;

        for (int a = 1; a < i; a++) {
            for (int b = 1; b < j; b++) {
                if (isSolve[a][b] == 0)
                    if (board[a][b] == 'o')
                        n_130look(board, isSolve, a, b);
            }
        }

    }

    public int n_130look(char[][] board, int[][] isSolve, int a, int b) {
        int i = board.length;
        int j = board[0].length;

        if (a == 0 || b == 0 || a == i - 1 || b == j - 1) {//判断此点若是边界上的点，，则异常，返回
            isSolve[a][b] = 1;
            if (board[a][b] == 'o')
                return -1;
            else return 0;
        }

        if (a <= 0 || b <= 0 || a >= i || b >= j) {//判断此点若是边界外面的点，，也异常，返回
            return -1;
        }
        if (board[a][b] != 'o')
            return 0;

        board[a][b] = 'x';/////////
        isSolve[a][b] = 1;
        int s = 0;
        s += n_130look(board, isSolve, a + 1, b);
        s += n_130look(board, isSolve, a - 1, b);
        s += n_130look(board, isSolve, a, b + 1);
        s += n_130look(board, isSolve, a, b - 1);
        if (s != 0) {
            board[a][b] = 'o';
            return -1;
        }
        return 0;
    }


    public int n_171_titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        char ch;
        int len = s.length();
//        System.out.println(s.length());
        for (int i = 0; i < len; i++) {
            ch = chars[i];
            result = result * 26 + (ch - 'A') + 1;
        }
        return result;
    }

    public String n_168_convertToTitle_my(int n) {
        int a, b;
        a = n;
        String result = "";
        char c = 'A';
        char newchar;
        b = a % 26;
        while (a > 26) {
            b = a % 26;
            if (b == 0)
                newchar = 'Z';
            else newchar = (char) (c + b - 1);
            result = (newchar) + result;
            a = (a - b) / 26;
        }
        newchar = (char) (c + a - 1);
        result = (newchar) + result;
        return result;
    }


    /**
     * 就是把A-Z当做0-25，，是一个26进制的表示，
     * 不用考虑从Z到AA的感觉上的奇怪，只用类比从9到10的变化即可
     * 同时A作为0考虑，Z作为25考虑，那么需要在每一轮将n-1，即可将A-Z映射到0-25上
     */
    public String n_168_convertToTitle(int n) {
        String temp = "";
        while (n > 0) {
            char s = (char) ((n - 1) % 26 + 'A');
            temp = s + temp;
            n = (n - 1) / 26;
        }
        return temp;
    }

    public int n_172_trailingZeroesmy(int n) {
        int result = 0;

        int n5 = 0,n2 = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 10 == 0)
                result++;
            else if(i%5==0)
                n5++;
            else if(i%2==0)
                n2++;

        }
        result+=(Math.min(n2,n5)+1)/2;
        return result;
    }

    public int n_172_trailingZeroes(int n){//求N的阶乘中的各个因式中因式5的个数
        int sum=0;
        while(n>0){
            sum+=n/5;
            n/=5;
        }
        return sum;
    }

    @Test
    public void t172(){
        leetcode l = new leetcode();
        System.out.println(l.n_172_trailingZeroes(30));
        // 30: 5:       26525285981219105863630848   0000000:7
          }

    @Test
    public void t168() {
        leetcode l = new leetcode();

//        System.out.println(l.n_168_convertToTitle(1));
        System.out.println(l.n_168_convertToTitle(1));
        System.out.println(l.n_168_convertToTitle(26));
        System.out.println(l.n_168_convertToTitle(27));
        System.out.println(l.n_168_convertToTitle(28));
        System.out.println(l.n_168_convertToTitle(701));
        System.out.println(l.n_168_convertToTitle(702));
        System.out.println(l.n_168_convertToTitle(703));
    }


    @Test
    public void t171() {
        leetcode l = new leetcode();
        System.out.println(l.n_171_titleToNumber("ZY"));
    }

    @Test
    public void t130() {
        char[][] board = {
                {'x', 'x', 'x', 'x'},
                {'x', 'o', 'o', 'x'},
                {'x', 'x', 'o', 'x'},
                {'x', 'o', 'x', 'x'}};
        leetcode l = new leetcode();
        l.n_130_solve(board);
        for (char[] line : board)
            System.out.println(new String(line));
    }

    @Test
    public void t22() {
        leetcode l = new leetcode();
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        char[][] grid = {
        };

        int i = l.n_200_numIslands(grid);
        System.out.println(i);

    }

}
