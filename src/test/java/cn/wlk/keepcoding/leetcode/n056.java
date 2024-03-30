package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
//done
public class n056 {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start == o2.start)
                    return 0;
                else return 1;
            }
        };

        Collections.sort(intervals, comp);


        int len = intervals.size();
//        System.out.println(len);
        for (int i = 0; i < intervals.size() - 1; ) {
//            System.out.println(intervals.get(i).start + ":" + intervals.get(i).end);
            if (intervals.get(i).end >= intervals.get(i + 1).end) {
                intervals.remove(i + 1);

            } else if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = intervals.get(i + 1).end;
                intervals.remove(i + 1);

            } else if (intervals.get(i).end < intervals.get(i + 1).start) {
                i++;
            }
        }
        return intervals;

    }

    @Test
    public void test() {
        n056 t = new n056();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(16, 292));
        intervals.add(new Interval(4, 9));
        intervals.add(new Interval(2, 3));
        List<Interval> result = t.merge(intervals);

        for (Interval in : intervals) {
            System.out.println(in.start + ":" + in.end);
        }

        System.out.println();
    }

}
