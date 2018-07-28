kadane算法的youbute介绍

https://www.youtube.com/watch?v=86CQq3pKSUw

Kadane算法，它是由美国卡耐基梅隆大学的教授Kadane发明的一种用于求解最大连续子序列和问题的最优算法。

对于一个长度为n的数组A而言，从A[0] 到 A[j] 是一个子数组（j<n），

那么以A[j]结尾的子数组之最大和，要么是 A[j]， 要么是 max(A[i]~A[j-1])+A[j] ，

其中0 ≤ i ≤ j-1。这就是该算法设计的出发点。

c++代码如下：
```
int maxSubArray(vector<int>& nums) {
    vector<int>::iterator it  = nums.begin();
    int maxSum = *it;
    int theSum = *it;
            
    for(it = it+1 ; it != nums.end(); it++){
      theSum = max(theSum + *it, *it);
                
    if(theSum > maxSum)
      maxSum = theSum;
    }
            
    return maxSum;
}
```