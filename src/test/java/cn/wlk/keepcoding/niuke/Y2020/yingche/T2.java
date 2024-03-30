package cn.wlk.keepcoding.niuke.Y2020.yingche;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2020/8/4 23:04
 * author:WLK
 */

public class T2 {
    public static void main(String[] args) {
        T2 t =new T2();
        String[][] arr = {{"d1", "d0", "IT"}, {"d2", "d0", "RD"}, {"d0", "", "The Company"}, {"d3", "d0", "HR"}};

        String[] re = t.listToTree(arr);
        for (String s : re) {
            System.out.println(s);
        }



    }

    public String[] listToTree (String[][] departments) {
        Map<String, Set<String>> subSet = new HashMap<>();
        Map<String,String> id2Node= new HashMap<>();

        String prefix = "a_";
        for(int i = 0;i<departments.length;i++){
            String id = departments[i][0];
            String parentId = departments[i][1];
            String departmentName = departments[i][2];
            if(!subSet.containsKey(parentId)){
                subSet.put(prefix+parentId,new HashSet<>());
            }
            subSet.get(prefix+parentId).add(id);
            id2Node.put(id,departmentName);
        }


        String root = prefix;
        List<String> results = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root=queue.getLast();
            final Set<String> subIds = subSet.get(root);
            final String s = id2Node.get(root);
            results.add(s);
            queue.removeLast();

            if(subIds!=null) {
                final List<String> collect = subIds.stream().map(id2Node::get).collect(Collectors.toList());
                collect.sort(String::compareTo);
                collect.forEach(v -> {
                    queue.addFirst(v);
                });
                results.addAll(collect);
            }
        }
        return results.toArray(new String[0]);
    }
}
