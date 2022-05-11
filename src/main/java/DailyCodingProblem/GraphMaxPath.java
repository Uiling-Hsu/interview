package DailyCodingProblem;

import java.util.*;

public class GraphMaxPath {
    int max = 0;

    public int maxPath(String nodes, int[][] edges) {
        max = 0;
        int nodeNum = nodes.length();
        List<Integer>[] adjMetrix = new ArrayList[nodeNum];
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            if (adjMetrix[from] == null) {
                adjMetrix[from] = new ArrayList();
            }
            adjMetrix[from].add(to);
        }

        for (int i = 0; i < adjMetrix.length; i++) {
            Set<Integer> seen = new HashSet();
            Map<Character, Integer> record = new HashMap();
            seen.add(i);
            record.put(nodes.charAt(i),1);
            findMax(nodes, adjMetrix, i, seen, record);
            if (max == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return max;

    }

    public void findMax(String nodes, List[] adjMetrix, int index, Set<Integer> seen, Map<Character, Integer> record) {
        List<Integer> adj = adjMetrix[index];
        if (adj == null) {
            int m = 0;
            for(Integer v :record.values()){
                if(v > m){
                    m = v;
                }
            }
            max = Math.max(max, m);
            return;
        }

        for (int i : adj) {
            if (seen.contains(i)) {
                max = Integer.MAX_VALUE;
                return;
            }
            seen.add(index);
            char n = nodes.charAt(index);
            int v = record.getOrDefault(n, 0);
            record.put(n, v + 1);
            findMax(nodes, adjMetrix, i, seen, record);
            seen.remove(index);
            v = record.get(n);
            if (v - 1 == 0) {
                record.remove(n);
            }
            record.put(n, v - 1);
            if (max == Integer.MAX_VALUE) {
                return;
            }
        }
    }

    public static void main(String[] args){
        GraphMaxPath graphMaxPath = new GraphMaxPath();
        String nodes = "ABACA";
//        String nodes = "A";
//        int[][] edges = new int[][]{{0,1},{0,2},{2,3},{3,4},{1,2}};
        int[][] edges = new int[][]{{0,1},{1,2},{3,4},{2,3},{0,2}};
//        int[][] edges = new int[][]{{0,1},{0,2},{2,3},{3,4},{1,2},{4,1}}; // cycle
//        int[][] edges = new int[][]{{0,0}};
        System.out.println(graphMaxPath.maxPath(nodes,edges));
    }


}
