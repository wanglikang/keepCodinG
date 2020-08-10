package cn.wlk.keepcoding.niuke.Campus.tencent2020;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/4/11 10:42
 * author:WLK
 */

public class T1 {

    @Test
    public void test() {
        T1 t = new T1();

        int[] arr1 = new int[]{1,3,5,7,9,0,0,0,0,0,0,0};
        int[] arr2 = new int[]{2,3,4,5,6};
        t.merge(arr1,5,arr2,5);
        Utils.showArray(arr1);


    }


    @Test
    public void test2() {
        T1 t = new T1();

        int[] arr1 = new int[]{1,3,5,7,9,0,0,0,0,0,0,0};
        int[] arr2 = null;
        t.merge(arr1,5,arr2,0);
        Utils.showArray(arr1);
    }
    @Test
    public void test3() {
        T1 t = new T1();

        int[] arr1 = null;
        int[] arr2 = new int[]{1,3,5,7,9};
        t.merge(arr1,5,arr2,0);
        if(arr1!=null) {
            Utils.showArray(arr1);
        }
    }


    public void merge(int[] arr1,int n1,int[] arr2,int n2){
        if(arr1== null || arr2==null){
            return;
        }
        int n = arr1.length;

        if(n<n1+n2){
            return;//arr1的空间不足以容纳两个数组merge后的结果
        }
        int i1 = n1-1;
        int i2 = n2-1;

        int i = n1+n2-1;

        while(i1>=0 && i2>=0){
            int a1 = arr1[i1];
            int a2 = arr2[i2];
            if(a2>a1){
                arr1[i]=a2;
                i2--;
            }else{
                arr1[i]=a1;
                i1--;
            }
            i--;
        }

        while(i1>=0){
            arr1[i--]=arr1[i1--];
        }
        while(i2>=0){
            arr1[i--]=arr2[i2--];
        }
    }


}
