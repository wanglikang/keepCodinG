package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/3/3 12:05
 * author:WLK
 * 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * 解法：回溯法，设置visited数组，这是x,y坐标到原数组的映射
 */
public class Solution65 {
    @Test
    public void test() {
        Solution65 t = new Solution65();
//        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] matrix =     "AAAAAAAAAAAA".toCharArray();
        char[] chars =      "AAAAAAAAAAAA".toCharArray();
        System.out.println(t.hasPath(matrix,3,4,chars));

    }

    public int  getIndex(int rows,int cols,int x,int y){
        return x*cols+y;


    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        int len = matrix.length;
        if(str.length>len){
            return false;
        }
        int[] visited = new int[len];
        boolean result = false;
        for(int i  = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                result = result||isAvailable(matrix,rows,cols,i,j,str,0,visited);
                if(result){
                    return true;
                }
                System.out.println("------------------");
            }
        }
        return false;
    }
    public boolean isAvailable(char[] matric,
                               int rows,int cols,
                               int x,int y,
                               char[] str,
                               int chindex,int[] visited){
        visited[getIndex(rows,cols,x,y)]=1;
        //待匹配的下标已经越界或是最后一个且刚好匹配
        if(chindex==str.length
                || (chindex==str.length-1 && matric[getIndex(rows,cols,x,y)]==str[chindex])){
            visited[getIndex(cols,cols,x,y)]=0;
            return true;
        }
        if(str[chindex]!=matric[getIndex(rows,cols,x,y)]){
            visited[getIndex(rows,cols,x,y)]=0;
            return false;
        }

        boolean result = false;

        if(x-1>=0 && visited[getIndex(rows,cols,x-1,y)]!=1){
            result=result||isAvailable(matric, rows,cols,x-1, y,str,chindex+1,visited);
        }
        if(x+1<rows&& visited[getIndex(rows,cols,x+1,y)]!=1){
            result=result||isAvailable(matric, rows,cols,x+1, y,str,chindex+1,visited);
        }

        if(y-1>=0&& visited[getIndex(rows,cols,x,y-1)]!=1){
            result=result||isAvailable(matric, rows,cols,x, y-1,str,chindex+1,visited);
        }
        if(y+1<cols&& visited[getIndex(rows,cols,x,y+1)]!=1){
            result=result||isAvailable(matric, rows,cols,x, y+1,str,chindex+1,visited);
        }
        visited[getIndex(rows,cols,x,y)]=0;
        return result;
    }


}

