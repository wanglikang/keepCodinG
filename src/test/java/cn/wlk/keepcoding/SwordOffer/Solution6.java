package cn.wlk.keepcoding.SwordOffer;

/****
 * 旋转数组的最小数字
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author WLK
 *
 */
public class Solution6 {
	public static void main(String[] args) {
		Solution6 s6 = new Solution6();
		int[] array= {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
		System.out.println(s6.minNumberInRotateArray(array));
				
	}
    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<array.length;i++){
            if(array[i]<min)
                min = array[i];
        }        
        return min;
    }
    
    
    /**
     * 比较优的解
     * 题目是两个有序非递减（也就是递增数列）的数组拼接而成的，用二分法就可以很好的解决
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        return dealwith(array,0,array.length-1);
    }
    public int dealwith(int[] array,int start,int end){
        int leftv,rightv,midv;
        int midindex = (end+start)/2;
        leftv = array[start];
        rightv = array[end];
        midv = array[midindex];
        if(leftv<rightv)
            return leftv;
        if(midv>leftv){
            return dealwith(array,midindex,end);
        }else if(midv<rightv){
            return dealwith(array,start,midindex);
        }else return Math.min(midv, Math.min(rightv, leftv));
    }
}


