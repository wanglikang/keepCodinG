package cn.wlk.keepcoding.leetcode;

/**
 * 840. 矩阵中的幻方
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *
 *
 * 示例：
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 *
 * 提示:
 *
 *     1 <= grid.length <= 10
 *     1 <= grid[0].length <= 10
 *     0 <= grid[i][j] <= 15
 *
 */
public class Solution840 {
	public static void main(String[] args) {
		Solution840 s = new Solution840();
//		int[] ma1 = {4,3,8,4};
//		int[] ma2 = {9,5,1,9};
//		int[] ma3 = {2,7,6,2};

		int[] ma1 = {5,5,5};
		int[] ma2 = {5,5,5};
		int[] ma3 = {5,5,5};
		int[][] matrix = new  int[3][3];
		matrix[0] = ma1;
		matrix[1] = ma2;
		matrix[2] = ma3;

		int result = s.numMagicSquaresInside(matrix);
		System.out.println(result);

	}
	public int numMagicSquaresInside(int[][] grid) {
		int xlength = grid.length;
		int ylength = grid[0].length;
		int result =0;
		for(int i =0;i<xlength-2;i++){
			for(int j = 0;j<ylength-2;j++){
				if(isMagic(grid,i,j )){
					result++;
				}
			}
		}
		return result;
	}

	public boolean isMagic(int[][] grid,int x,int y){
		boolean result = true;
		int sum  = grid[x][y]+grid[x+1][y]+grid[x+2][y];
		int[] numbers = new int[10];

		for(int i = 0;i<3;i++){
			int temp = 0;
			int temp2 = 0;
			for(int  j = 0;j<3;j++){
				if(grid[x+i][y+j]>9 || grid[x+i][y+j]<1)
					return false;
				numbers[grid[x+i][y+j]]++;
				temp  += grid[x+i][y+j];
				temp2  += grid[x+j][y+i];
			}
			if(temp!=sum || temp2!=sum){
				result = false;
			}
		}
		for(int i = 1;i<10;i++){
			if(numbers[i]>1){
				return false;
			}
		}
		int tmp1 = grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2];
		int tmp2 = grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y];
		if(tmp1!=sum  || tmp2!=sum)
			result = false;

		return result;

	}

}
