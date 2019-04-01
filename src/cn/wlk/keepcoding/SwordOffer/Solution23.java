package cn.wlk.keepcoding.SwordOffer;
/****************二叉搜索树的后序遍历序列 
 * 
 * 
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 * @author WLK
 *
 */
public class Solution23 {
public static void main(String[] args) {
	Solution23 s = new Solution23();
	int[] sequence = {4,8,6,12,16,14,10};
	System.out.println(s.VerifySquenceOfBST(sequence));
			
}
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        
        return checkSub(sequence,0,sequence.length-1);
    }
    public boolean checkSub(int[] arr,int from ,int to){
//    	System.out.println(from+":"+to);
        if(to<=from)
            return true;
        if(from>arr.length||to>arr.length)
        	return true;
        int mid ;
        int key = arr[to];
        int i = to-1;
        while(i>=0&&arr[i]>key)
            i--;
        mid = i;
        i--;
        while(i>=0&&arr[i]<key)
            i--;
        if(i>=0)
            return false;
        return checkSub(arr,from,mid)&&checkSub(arr,mid+1,to-1);
    }

}
