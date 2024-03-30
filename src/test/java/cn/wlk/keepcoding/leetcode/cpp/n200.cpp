class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
            if(grid==null)
                return 0;

            int i = sizeof(grid)/sizeof(char[])
            if(i==0)
                return 0;
            int j = grid[0].length;
            int[][] flag   = new int[i][j];

            int sum = 0;
            int count = 0;
            for(int a=0;a<i;a++)
                for(int b=0;b<j;b++)
                    flag[a][b]=0;


            for(int a=0;a<i;a++){
                for(int b=0;b<j;b++) {
                    sum+=look(grid,flag,a,b);
                }
            }
            //  System.out.println(sum);



            return sum;

        }
        int look(char[][] grid,int[][] flag,int a,int b){
            int i = grid.length;
            int j = grid[0].length;
            if(a<0 || a>=i)
                return 0;
            if(b<0 || b>=j)
                return 0;

            if(grid[a][b]=='0')
                return 0;

            if(grid[a][b]=='1'){
                if(flag[a][b]==0) {
                    flag[a][b] = 1;
                    look(grid, flag, a -1, b );
                    look(grid, flag, a + 1, b );
                    look(grid, flag, a , b -1);
                    look(grid, flag, a , b + 1);
                }else return 0;
            }
            return 1;
        }

};