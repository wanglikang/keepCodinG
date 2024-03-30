package cn.wlk.keepcoding.leetcode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static void showArray(int[] arr){
        showArray(arr,"%3d");

    }
    public static void showArray(int[] arr,String format){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            System.out.print(String.format(format+" ",arr[i]));
        }
    }
    public static void showArray(long[] arr){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void showBinary(int arr){
        int i =0;
        for(i =31;i>=0;i--){
            System.out.print(((arr>>i)&0x00000001)==1?1:0);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void showBinary(long arr){
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
                if(num.length()>0) {
                    li[c] = Integer.parseInt(num.trim());
                    c++;
                }
            }
            if(c==0){
                result[countX]=new int[0];
            }else {
                result[countX] = li;
            }
            countX++;
        }

        return result;
    }

    public static Object createListByArray(Class parentClass,Object o,Class<?> listNodeClass, int[] arr) {


        try {

            /**
             * class.getConstructor ：获取public的constructor
             * class.getDeclaredConstructor :获取declared 的constructor
             */
            Constructor<?> constructor = listNodeClass.getDeclaredConstructor(parentClass,int.class);
            Field nextField = listNodeClass.getDeclaredField("next");
            nextField.setAccessible(true);
            constructor.setAccessible(true);
            Object node = constructor.newInstance(o,-1);
            Object head = node;
            Object last = head;
            for(int i = 0;i<arr.length;i++) {
                node = constructor.newInstance(o,arr[i]);
                nextField.set(last,node);
                last = node;
            }
            return head;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void showArray(int[][] re) {
        showArray(re,"%3d");
    }
    public static void showArray(int[][] re,String format) {
        int n = re.length;
        for(int i = 0;i<n;i++){
            showArray(re[i],format);
            System.out.println();
        }
    }

    public static int[] createIntArrayFromString(String str) {

        String[] nums =  str.substring(1,str.length()-1).split(",");

        int[] li = new int[nums.length];
        int c = 0;
        for(String num:nums){
            if(num.length()>0) {
                li[c] = Integer.parseInt(num);
                c++;
            }
        }

        return li;
    }
}
