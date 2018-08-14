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
