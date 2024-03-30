package cn.wlk.keepcoding.niuke.Y2021.WangYi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 2020/8/8 15:10
 * author:WLK
 */

public class T2 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n= scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> sbs = new ArrayList<>(m+1);
        Map<Integer,Integer> indexMaps =new HashMap<>();
        int t;
        sbs.add(new ArrayList<>());
        for(int i = 0;i<m;i++){
            t =scanner.nextInt();
            final ArrayList<Integer> subArr = new ArrayList<>();
            subArr.add(t);
            sbs.add(subArr);
            indexMaps.put(t,i+1);
        }
        indexMaps.put(0,0);

        int sbIndex =0;
        for(int i = 1;i<=n;i++){
            if(indexMaps.containsKey(i)){
                if(sbIndex<indexMaps.get(i)) {
                    sbIndex = indexMaps.get(i);
                }
            }else {
                sbs.get(sbIndex).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=m;i++){
            if(sbs.get(i).size()!=0){
                sbs.get(i).forEach(v->{
                    sb.append(v).append(" ");
                });
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
}
