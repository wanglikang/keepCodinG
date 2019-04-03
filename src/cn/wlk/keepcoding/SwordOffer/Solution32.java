package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 2019/4/3 9:29
 * author:WLK
 *
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 解法：自定义排序规则：从高位开始比较，a,b，
 *                  若某位上a数字大，则此数较“大”；
 *                  若某位上a数字较小，则此数字较”小“；
 *                  若a,b位数不一样，则用多出来的各个位和最高位相比
 *
 */
public class Solution32 {
    @Test
    public void test() {
        Solution32 t = new Solution32();
        int[] numbers = {3,5,1,4,2};
//        int[] numbers = {3334,3,3333332};
//        int[] numbers={3,32,321};

        System.out.println(t.PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<numbers.length;i++){
            arr.add(numbers[i]);
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int[] arr1 = getLenOfN(o1);
                int[] arr2 = getLenOfN(o2);

//                for (int i : arr1) {
//                    System.out.print(i+" ");
//                }
//                System.out.println();
//                for (int i : arr2) {
//                    System.out.print(i+" ");
//                }
//                System.out.println();
//                System.out.println("***************");
                int index1 = 0, index2 = 0;
                int first = arr1[0];
                while (index1 < arr1.length && index2 < arr2.length) {
                    if (arr1[index1] < arr2[index2]) {
                        return -1;
                    } else if (arr1[index1] > arr2[index2]) {
                        return 1;
                    }
                    index1++;
                    index2++;
                }
               while(index1<arr1.length){
                   if(arr1[index1]>first){
                       return 1;
                   }else if(arr1[index1]<first){
                       return -1;
                   }
                   index1++;
               }
               while(index2<arr2.length){
                   if(arr2[index2]>first){
                       return -1;
                   }else if(arr2[index2]>first){
                       return 1;
                   }
                   index2++;
               }
                return 0;
            }

            public int[] getLenOfN(int n) {
                int len = 0;
                int t = n;
                while (n > 0) {
                    len++;
                    n = n / 10;
                }
                int[] arr = new int[len];
                for (int i = len - 1; i >= 0; i--) {
                    arr[i] = t % 10;
                    t = t / 10;
                }
                return arr;
            }
        });

        for (Integer e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<numbers.length;i++){
            sb.append(arr.get(i));
        }

        return sb.toString();
    }

}
