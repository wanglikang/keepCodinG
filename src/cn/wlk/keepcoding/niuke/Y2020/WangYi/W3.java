package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import org.junit.Test;

import java.util.*;

/**
 * 2020/4/5 20:44
 * author:WLK
 *
 * 网易2020校招笔试- Java 开发工程师（提前批）
 * 企业提供原题
 * 00:28:53
 * 16/16
 * [编程题]序列维护
 *
 * 时间限制：C/C++ 3秒，其他语言6秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易在维护数据的时候遇到一个需求，具体来说小易有一系列数据，这些数据了构成一个长度为n的数字序列，接下来小易会在这个序列上进行q次操作。
 * 每次操作有一个查询的数字x，小易需要将序列数据中所有大于等于x的数字都减一，并输出在本次操作中有多少个数字被减一了。
 * 小易犯了难，希望你能帮帮他。
 *
 * 输入描述:
 *
 * 第一行n,q，表示数字个数和操作个数。
 * 接下来一行n个数表示初始的数字。
 * 接下来q行，每行一个数，表示指定的数字x。
 * ，
 *
 *
 * 输出描述:
 *
 * 对于每个询问，输出一个数字表示答案
 *
 *
 * 输入例子1:
 *
 * 4 3
 * 1 2 3 4
 * 4
 * 3
 * 1
 *
 *
 * 输出例子1:
 *
 * 1
 * 2
 * 4
 *
 *
 * 输入例子2:
 *
 * 3 2
 * 1 2 3
 * 3
 * 3
 *
 *
 * 输出例子2:
 *
 * 1
 * 0
 *
 *
 */

public class W3 {

    @Test
    public void test() {
        W3 t = new W3();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        long[] nums = new long[n];
        TreeMap<Long,Long> map = new TreeMap<>();
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextLong();
            map.put(nums[i], map.getOrDefault(nums[i], 0L)+1);
        }
        long x=0;
        for(int i = 0;i<p;i++){
            x = scanner.nextLong();
            System.out.println(doOnce(map,n,x));
        }
    }

    public static long doOnce(TreeMap<Long,Long> map, long n, long x){

        Map.Entry<Long, Long> bigX = map.ceilingEntry(x);
        long rightKey = map.lastKey();

        if(bigX==null ||bigX.getKey()>rightKey){
            return 0;
        }
        SortedMap<Long, Long> subMap = map.subMap(bigX.getKey(), true,map.lastKey(),true);
        long result = 0;
        for(Map.Entry<Long,Long> entry:subMap.entrySet()){
            result+=entry.getValue();
        }

        Set<Long> s = new HashSet<>();
        for(Map.Entry<Long,Long> entry:subMap.entrySet()){
            s.add(entry.getKey());
        }
        Iterator<Long> it = s.iterator();
        while(it.hasNext()) {
            long k = it.next();
            map.put(k - 1, map.get(k)+map.getOrDefault(k-1,0L));

        }
        map.remove(map.lastKey());
        return  result;

    }


}
