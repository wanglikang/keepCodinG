package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/7/3 10:51
 * author:WLK
 * <p>
 * 93. 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：暴力查找即可，
 */
public class n093 {
    @Test
    public void test() {
        n093 t = new n093();
//        List<String> result = t.restoreIpAddresses("25525511135");
//        List<String> result = t.restoreIpAddresses("0000");
        List<String> result = t.restoreIpAddresses("010010");
//        List<String> result = t.restoreIpAddresses("");

        result.forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int[] dotIndex = new int[3];
        for (int i = 0; i < 3; i++) {
            dotIndex[0] = i;
            if(dotIndex[0]+1<s.length() && isOk(s.substring(0,dotIndex[0]+1))) {
                search(s, 0, dotIndex, result);
            }
        }
        return result;

    }

    public void search(String s, int level, int[] dotIndex, List<String> result) {
        int len = s.length();
        if (level == 2) {
            if (len - dotIndex[level] > 4) {
                return;//长度不符合，直接返回
            }
            if(isOk(s.substring(dotIndex[level]+1))){

                result.add(makeString(s,dotIndex));
            }
        }else {
            for(int i = 1;i<=3;i++){
                if(dotIndex[level]+1+i<s.length() && isOk(s.substring(dotIndex[level]+1,dotIndex[level]+1+i))){
                    dotIndex[level+1]=dotIndex[level]+1+i-1;
                    search(s,level+1, dotIndex, result);
                }
            }
        }
    }

    public boolean isOk(String s) {
//        System.out.println(s);
        if(s.length()==0)
            return false;

        if(s.startsWith("0") && s.length()>1){
            return false;
        }
        if (s.length() < 3) {
            return true;
        }
        if (s.length() == 3) {
//            System.out.println(Integer.parseInt(s.substring(0,3)));
//            System.out.println(Integer.parseInt(s.substring(0,3))<=255);
            return Integer.parseInt(s)<=255;
        } else return false;

    }

    public String makeString(String s,int[] dotIndex){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0            ,dotIndex[0]+1)).append(".");
        sb.append(s.substring(dotIndex[0]+1,dotIndex[1]+1)).append(".");
        sb.append(s.substring(dotIndex[1]+1,dotIndex[2]+1)).append(".");
        sb.append(s.substring(dotIndex[2]+1));
        return sb.toString();
    }


}