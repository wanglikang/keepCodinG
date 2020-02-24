package cn.wlk.keepcoding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void showArray(int[] arr){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void showBinary(int arr){
        int i =0;
        for(i =31;i>=0;i--){
            System.out.print(((arr>>i)&0x00000001)==1?1:0);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void showArray(char[] arr){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void showArray(char[] arr,int start,int end){
        int len = arr.length;
        for(int i = start;i<end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void showListInList(List<List<Integer>> list){
        for(List<Integer> li:list){
            for(int i :li){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    public static void ListAddEle(List<Integer> special, int ...nums) {
        for(int i  =0;i<nums.length;i++){
            special.add(nums[i]);
        }
    }

    public static void showList(List<Integer> needs) {
        for(int i :needs)
            System.out.print(i+" ");
        System.out.println();
    }

    public static List<List<Integer>> createListInListFromString(String str) {
        List<List<Integer>> result = new ArrayList<>();
        String[] strs = str.substring(1,str.length()-1).split("\\[");
        for(String s:strs){
            if(s.length()==0)
                continue;

            String []nums =  s.split("\\]")[0].split(",");
            List<Integer> li = new ArrayList<>();
            for(String num:nums){
                li.add(Integer.parseInt(num));
            }
            result.add(li);
        }

        return result;
    }

    /**
     *
     * @param str
     * 应该是如下形式
     * [[0,0],[0,1],[0,4],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2],[2,3],[2,4],[3,0],[4,0],[4,1],[4,3],[4,4]]
     * @return
     */
    public static int[][] createintInintFromString(String str) {
        String[] strs = str.substring(1,str.length()-1).split("\\[");
        int[][] result = new int[strs.length-1][];
        int countX = 0;
        for(String s:strs){
            if(s.length()==0)
                continue;

            String []nums =  s.split("\\]")[0].split(",");
            int[] li = new int[nums.length];
            int c = 0;
            for(String num:nums){
                li[c]=Integer.parseInt(num);
                c++;
            }
            result[countX]=li;

            countX++;
        }

        return result;
    }

    public static void createListByArray(Class<?> listNodeClass, int[] arr) {
//        Object aclass = listNodeClass.newInstance();

    }
}
