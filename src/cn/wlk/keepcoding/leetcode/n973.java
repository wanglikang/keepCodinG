package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2019/4/29 11:44
 * author:WLK
 *
 * 973. 最接近原点的 K 个点
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 解法：自定义类，PriorityQueue排序即可
 *      还有一个分治算法：
 *          就是topK 版本的快排：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/
 */
public class n973 {

    @Test
    public void test() {
        n973 t = new n973();
        int[][] points = new int[][]{{1,3},{-2,2}};
        int[][] result = t.kClosest(points, 1);
        for(int i = 0;i<result.length;i++){
            System.out.println(result[i][0]+":"+result[i][1]);
        }

    }

    class Point implements  Comparable<Point>{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            long dis1 = (this.x*this.x+this.y*this.y);
            long dis2 = (o.x*o.x+o.y*o.y);
            if(dis1==dis2)
                return 0;
            else return dis1>dis2?-1:1;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        List<Point> list = new ArrayList<>();
        PriorityQueue<Point> heap =new PriorityQueue<>(K);
        for(int i = 0;i<points.length;i++){
            Point p = new Point(points[i][0],points[i][1]);
            list.add(p);
            if(heap.size()<K) {
                heap.add(p);
            }else if(heap.peek().compareTo(p)<0){
                heap.poll();
                heap.add(p);
            }
        }

        Iterator<Point> it = heap.iterator();
        int[][] result = new int[heap.size()][2];
        int i = 0;
        while(it.hasNext()){
            Point pp = it.next();
            result[i] = new int[2];
            result[i][0] = pp.x;
            result[i][1] = pp.y;
            i++;
        }
        return result;
    }

}