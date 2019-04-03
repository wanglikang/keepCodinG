package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/3 11:18
 * author:WLK
 * 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * <p>
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * <p>
 * 对于%50的数据,size<=10^4
 * <p>
 * 对于%75的数据,size<=10^5
 * <p>
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 1,2,3,4,5,6,7,0
 * <p>
 * 输出
 * 复制
 * <p>
 * 7
 *
 * 解法：使用归并排序，每次在归并排序之后，
 *      排好序的两个子数组自然拥有逆序的关系，
 *      然后从两个数组尾部逆序遍历，对比，即可求出全部的逆序对数
 */
public class Solution35 {
    @Test
    public void test() {
        Solution35 t = new Solution35();
        int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr2 = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219,
                993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460,
                505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181,
                486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474,
                162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569,
                256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697,
                478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655,
                446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266,
                235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(t.InversePairs(arr));
    }

    /**
     * 剑指offer的解法；使用归并排序，但是没有通过全部测试用例
     * @param array
     * @return
     */
    public int InversePairs(int[] array){
        int len = array.length;
        int[] newarr = new int[len];
        for(int i  = 0;i<len;i++)newarr[i] = array[i];

        return MergeAndCount(array,newarr, 0,len-1);
    }

    public int MergeAndCount(int[] arr,int[] newarr,int left,int right){

        if(left==right) {
            newarr[left]=arr[left];
            return 0;
        }
        int leftlen = (right-left)/2;
        int mid = left+leftlen;
        //left-mid--------mid+1-right
        int result = 0;
        result+=MergeAndCount(arr, newarr,left, mid);
        result+=MergeAndCount(arr,newarr, mid+1,right);
        int resultindex=right;
        int index1=mid,index2=right;
        while(index1>=left &&index2>mid){
            if(arr[index1]>arr[index2]){
                result+=index2-mid;
                newarr[resultindex--]=arr[index1--];
            }else
                if(arr[index1]<arr[index2]){
                newarr[resultindex--]=arr[index2--];
            }else
                {
                newarr[resultindex--]=arr[index2--];
                newarr[resultindex--]=arr[index1--];
            }
        }

        while(index1>=left){
            newarr[resultindex--]=arr[index1--];
        }
        while (index2>mid){
            newarr[resultindex--]=arr[index2--];
        }
        for(int i = left;i<=right;i++){
            arr[i] = newarr[i];
        }
        return result;

    }


}
