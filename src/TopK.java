
import java.util.ArrayList;

public class TopK {
	void topK(int num[],int k){


	}

	public static void main(String[] args) {
//		int nums1[] = {4,8,4,4,5,6,4,2,7,6,5,4,3,2,10};
//		quickSort(nums1,0,nums1.length-1);
//		for (int e : nums1) {
//			System.out.print(e+" ");
//		}
		System.out.println();
		int nums2[] = {4,5,3,25,4534,2,4534,346,347,56,234,62,724,54,1231,34};
		int K = 7;
		ArrayList<Integer> result = quickSortTopK(nums2,0,nums2.length-1,K);
		for(int i = 0;i<nums2.length;i++){
			System.out.print(nums2[i]+" ");
			if(nums2.length-i-1==K)
				System.out.print(" | ");
		}
		System.out.println("\n-------------");
		for (Integer e : result) {
			System.out.print(e+" ");

		}

	}
	static void  swap(int nums[],int i,int j ){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	static void quickSort(int nums[],int start,int end){
		int i = start,j = end;
		if(end-start<1)
			return ;
		int mid = nums[start];
		while(start <end){
			while(start<end && nums[end]>=mid)end--;
			while(start<end && nums[start]<=mid)start++;
			swap(nums, start, end);
		}
		nums[i]=nums[start];
		nums[start]=mid;
		quickSort(nums, i,start-1);
		quickSort(nums,start+1, j);

	}

	static ArrayList<Integer> quickSortTopK(int nums[], int start, int end , int topK){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(end<start||start<0 || start >=nums.length || end<0||end>=nums.length)
			return result;
		if(end-start ==0){
			result.add(nums[start]);
			return result;
		}
		int i = start,j = end;
		int mid = nums[start];
		while(i<j){
			while(i<j &&nums[j]>=mid)j--;
			while(i<j &&nums[i]<=mid)i++;
			swap(nums, i, j);
		}

		nums[start]=nums[i];
		nums[i]=mid;
		int leftsize = i-start;
		int rightsize  = end-i;
		int subRightTopk=topK>=rightsize?rightsize:topK;
		int subLeftTopk =topK>rightsize?topK-rightsize:0;
		quickSortTopK(nums, i+1, end, subRightTopk);
		for(int a = 0;a<subRightTopk;a++) {
			result.add(result.size(),nums[end-a] );
		}
		if(subLeftTopk>0) {
			result.addAll(quickSortTopK(nums, start, i - 1, topK - (end - j + 1)));
//			for(int a = 0;a<topK;a++) {
//				result.add(result.size()-1,nums[end-a] );
//			}
		}

		return result;
	}
}
