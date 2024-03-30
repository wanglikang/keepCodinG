package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/29 10:58
 * author:WLK
 *
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 解法：dfs即可，先在边界上dfs一遍，标记所有的可联通O为已经访问，然后在边界之外的点dfs遍历，把O标记为X
 */
public class n130 {
    @Test
    public void test() {
        n130 t = new n130();
//        char[][] board = new char[][]{
//                {'O','X','X','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'},
//                {'X','O','X','X'}};
        char[][] board = new char[][]{
                {'X','O','X','X'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'}};


        solve(board);


        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

        public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
            int[][] visited = new int[board.length][board[0].length];
            for(int i = 0;i<board[0].length;i++){
                dfsForMark(board,visited,0,i);
                dfsForMark(board,visited,board.length-1,i);
            }
            for(int i = 0;i<board.length;i++){
                dfsForMark(board,visited,i,0);
                dfsForMark(board,visited,i,board[0].length-1);
            }

    //        System.out.println("----------visited----------");
    //        for(int i = 0;i<board.length;i++){
    //            for(int j = 0;j<board[0].length;j++){
    //                System.out.print(visited[i][j]+" ");
    //            }
    //            System.out.println();
    //        }
    //        System.out.println("----------visited----------");
            for(int i = 1;i<board.length-1;i++){
                for(int j = 1;j<board[0].length-1;j++){
                    if(board[i][j]=='O' && visited[i][j]==0){
                        dfs(board,visited,i,j);
                    }
                }
            }

        }

        public void dfs(char[][] board,int[][] visited,int x,int y){
            visited[x][y] = 1;
            board[x][y] = 'X';
            if(x-1>=0 && visited[x-1][y]==0 && board[x-1][y]=='O'){
                dfs(board,visited,x-1,y);
            }

            if(x+1<board.length && visited[x+1][y]==0 && board[x+1][y]=='O'){
                dfs(board,visited,x+1,y);
            }

            if(y-1>=0 && visited[x][y-1]==0 && board[x][y-1]=='O'){
                dfs(board,visited,x,y-1);
            }

            if(y+1<board.length && visited[x][y+1]==0 && board[x][y+1]=='O'){
                dfs(board,visited,x,y+1);
            }
        }

        public void dfsForMark(char[][] board,int[][] visited,int x,int y){
            if(board[x][y]=='X'){
                return ;
            }
            visited[x][y] = 1;//标记上已经访问过
            if(x-1>=0 && visited[x-1][y]==0 && board[x-1][y]=='O'){
                dfsForMark(board,visited,x-1,y);
            }

            if(x+1<board.length && visited[x+1][y]==0 && board[x+1][y]=='O'){
                dfsForMark(board,visited,x+1,y);
            }

            if(y-1>=0 && visited[x][y-1]==0 && board[x][y-1]=='O'){
                dfsForMark(board,visited,x,y-1);
            }

            if(y+1<board[0].length && visited[x][y+1]==0 && board[x][y+1]=='O'){
                dfsForMark(board,visited,x,y+1);
            }

        }


}