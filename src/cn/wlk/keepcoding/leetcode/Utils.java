package cn.wlk.keepcoding.leetcode;

public class Utils {
    public static void showArray(int[] arr){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            System.out.print(arr[i]+" ");
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
}
