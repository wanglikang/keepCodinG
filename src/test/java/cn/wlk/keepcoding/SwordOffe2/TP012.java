package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/2 16:53
 * author:WLK
 *
 * 面试题12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 *
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 *
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 解法：DFS
 */

public class TP012 {

    @Test
    public void test() {
        TP012 t = new TP012();
//        char[][] board = new char[][]{{'a'},{'b'},{'c'}};
        char[][] board = new char[][]{{'a'}};
        System.out.println(t.exist(board,"ab"));
    }


    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();
        int M = board.length;
        if(M==0){
            return false;
        }
        int N = board[0].length;
        int[][] visited = new int[M][N];
        boolean isfound = false;
        for(int i = 0;i<M && !isfound;i++){
            for(int j = 0;j<N && !isfound;j++) {
                isfound = dfs(board,visited,i,j,chars,0);
            }
        }
        return isfound;
    }

    public boolean dfs(char[][] board,int[][] visitd,int x,int y,char[] chars,int index) {
        System.out.println("in:" + board[x][y]);
        if (board[x][y] == chars[index] ) {
            visitd[x][y]=1;
            boolean isFound = false;
            if(index == chars.length - 1) {
                return true;
            }else{
                int M = board.length;
                int N = board[0].length;

                    //当前字符匹配上了
                if (x > 0 && visitd[x - 1][y] != 1) {
                    isFound = dfs(board, visitd, x - 1, y, chars, index + 1);
                }
                if (!isFound && x < M - 1 && visitd[x + 1][y] != 1) {
                    isFound = dfs(board, visitd, x + 1, y, chars, index + 1);
                }

                if(!isFound && y>0 && visitd[x][y-1]!=1){
                    isFound = dfs(board,visitd,x,y-1,chars,index+1);
                }

                if(!isFound && y <N-1 && visitd[x][y+1] !=1){
                    isFound = dfs(board, visitd,x,y+1,chars,index+1);
                }

            }

            visitd[x][y]=0;
            return isFound;
        }else {
            return false;
        }

    }



}
