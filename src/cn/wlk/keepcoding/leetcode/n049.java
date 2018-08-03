package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
//done
public class n049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<Integer,List<String>> re = new HashMap<>();
        int hashval=0;
        for(int i = 0;i<len;i++){
            hashval = countHashAnagram(strs[i]);
            if(re.containsKey(hashval)){
                re.get(hashval).add(strs[i]);
            }else {
                List<String> set = new ArrayList<>();
                set.add(strs[i]);
                re.put(hashval,set);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry:re.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public int countHashAnagram(String s){
        int len  =s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        String hashstr ="";
        for(int i = 0;i<len;i++){
            count[chars[i]-'a']++;
        }
        for(int i = 0;i<26;i++){
            hashstr+=(count[i]);
        }
        return hashstr.hashCode();

    }

    @Test
    public void test() {
        n049 t = new n049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for(List<String> str:t.groupAnagrams(strs)){
            for(String s:str){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }

}
