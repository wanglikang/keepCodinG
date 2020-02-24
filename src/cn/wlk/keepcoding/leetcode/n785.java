package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 * <p>
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：
 *  根据题目中对于二分图的定义，
 *  *    若为二分图，则将所有点分成两组，则一组标注为1，另一组标注为-1，
 *  *    则一定可以找到一个由所有边组成的序列，，且这个序列中的每个边所对应的两个端点所对应的组一定是  1/-1  交替出现的。
 *    若能找到任意一个端点序列不符合1/-1 交替出现，，则一定不是二分图。
 *    否则，则是二分图。
 *
 */
public class n785 {

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] visited = new int[N];
        int lastGroup = 1;//标注组别，默认为1
        boolean result = true;
        for(int i =0;i<N;i++) {//对每一个点的邻接表进行判断：因为测试用例中会有空数组的情况
            result &= dfs(graph, i, visited, visited[i]==0?1:visited[i]);
            if(!result){
                return false;
            }
        }
        return result;
    }

    public boolean dfs(int[][] graph, int i, int[] visited, int group) {
        if (visited[i] == 0) {
            //未访问过
            visited[i] = group;
            boolean result = visited[i] == group;
            for (int jindex = 0; jindex < graph[i].length; jindex++) {
                int j = graph[i][jindex];
                if (visited[j] != group) {
                    result &= dfs(graph, j, visited, -1 * group);//-1*group：设置下一个为opposite组别
                } else {
                    return  false;//提前监测到不是二分图
                }
            }
            return result;
        } else {
            return visited[i] == group;//是同一个组别内，不符合1/-1交替的要求，则一定不是二分图
        }
    }
    @Test
    public void t() {

//        String instr = "[[1,2,3], [0,2], [0,1,3], [0,2]]";
//        String instr = "[[1,3], [0,2], [1,3], [0,2]]";
        String instr = "[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]";
        int[][] in = Utils.createintInintFromString(instr);

        n785 n = new n785();
        System.out.println(n.isBipartite(in));
    }
}
