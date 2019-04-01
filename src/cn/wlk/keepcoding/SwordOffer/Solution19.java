package cn.wlk.keepcoding.SwordOffer;

import java.util.ArrayList;

/*****
 * 顺时针打印矩阵
 * 
 * 
 * 题目描述 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author WLK
 *
 */
public class Solution19 {
	public static void main(String[] args) {
		Solution19 s = new Solution19();
//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrix= {{1,11},{2,12},{3,13},{4,14},{5,15}};
		ArrayList<Integer> result = s.printMatrix(matrix);
		for (int i : result)
			System.out.println(i);
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		showArr(matrix, 0, 0, row, col, result);
		return result;

	}

	public void showArr(int[][] matrix, int ax, int ay, int xlength, int ylength, ArrayList<Integer> result) {
		if (xlength <= 0 || ylength <= 0)
			return;
		int x = ax, y = ay;
		if(xlength==1) {
			for(int i = 0;i<ylength;i++)
				result.add(matrix[x][y++]);
			return ;
		}
		else if(ylength==1) {
			for(int i = 0;i<xlength;i++)
				result.add(matrix[x++][y]);
			return ;
		}

		for (int i = 0; i < ylength && x >= 0 && y >= 0; i++) 
			result.add(matrix[x][y++]);
		x++;
		y--;
		for (int i = 1; i < xlength && x >= 0 && y >= 0; i++) 
			result.add(matrix[x++][y]);
		y--;
		x--;
		for (int i = 1; i < ylength && x >= 0 && y >= 0; i++) 
			result.add(matrix[x][y--]);
		y++;
		x--;
		for (int i = 2; i < xlength && x >= 0 && y >= 0; i++) 
			result.add(matrix[x--][y]);
		
		showArr(matrix, ax + 1, ay + 1, xlength - 2, ylength - 2, result);
	}

}
