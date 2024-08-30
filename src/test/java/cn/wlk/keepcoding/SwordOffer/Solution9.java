package cn.wlk.keepcoding.SwordOffer;
/***变态跳台阶 
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author WLK
 *
 */
public class Solution9 {
	static int[] arr = new int[1000];
    static{
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int q = 3;q<1000;q++){
            for(int z = 1;z<q;z++){
                arr[q] +=arr[z];
            }
            arr[q]+=1;
        }

        //通过数学推理后，可得知：
        // f(n) =  2* f(n-1);
        // 参考：https://zhuanlan.zhihu.com/p/155926448
    }
    public int JumpFloorII(int target) {
        return arr[target];
    }

}
