package cn.wlk.keepcoding.leetcode.tencent;

import org.junit.Test;

import java.util.HashMap;

/**
 * 2020/3/8 16:44
 * author:WLK
 */

public class T2 {

    @Test
    public void test() {
        T2 t = new T2();
        String[] fileContent = new String[]{
                "10.0.0.1,10.0.0.3,beijing",
                "10.0.0.3,10.0.0.6,beijing1",
                "10.0.0.8,10.0.0.10,beijing2",
                "10.0.0.10,10.0.0.200,beijing3"
        };

        String targetIp = "10.0.0.9";
        t.func(fileContent,targetIp);

    }



    public void func(String[] lines,String targetIp){

        long[] nums = new long[lines.length*2];
        HashMap<Integer,String> cityNameIndexMap = new HashMap<>();
        for(int i = 0;i<lines.length;i++){
            String[] vars = lines[i].split(",");
            String ipStart = vars[0];
            String ipEnd = vars[1];
            String city = vars[2];
            nums[2*i] = ipToLong(ipStart);
            nums[2*i+1] = ipToLong(ipEnd);
            cityNameIndexMap.put(i,city);
        }
        long targetIpNum = ipToLong(targetIp);
        int index = -1;

        int l = 0;
        int r = nums.length/2-1;
        int mid;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[2*mid] <= targetIpNum && nums[2*mid + 1] > targetIpNum ){
                index = mid;
                break;
            }
            if(nums[2*mid] > targetIpNum ){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
//        System.out.println(l+"-"+r);
//        System.out.println("index="+index);
//此时的nums[mid]应该为对应的ip段


        //先用简单的搜索
//        for(int i = 0;i<nums.length/2;i++){
//            if(nums[2*i] <= targetIpNum && nums[2*i+1] > targetIpNum){
//                index = i;
//                break;
//            }
//        }

        if(index!=-1) {
            System.out.println(cityNameIndexMap.get(index));
        }
    }

    private long ipToLong(String ipStart) {
        String[] ipFields = ipStart.split("\\.");
        int p1 = Integer.parseInt(ipFields[0]);
        int p2 = Integer.parseInt(ipFields[1]);
        int p3 = Integer.parseInt(ipFields[2]);
        int p4 = Integer.parseInt(ipFields[3]);

        return p1*255*255*255+p2*255*255+p3*255+p4;
   }


}
