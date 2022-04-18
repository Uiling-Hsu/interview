package DailyCodingProblem;

import java.util.*;

public class Itinerary {
    public static List<String> schedule(List<String[]> flights, String start){
        Map<String, List<String[]>> graph  = new HashMap(); // [destination, used]
        // build graph
        for(String[] f: flights){
            List adjs = graph.getOrDefault(f[0],new ArrayList());
            adjs.add(new String[]{f[1],"F"});
            graph.put(f[0],adjs);
        }
        for(String k: graph.keySet()){
            Collections.sort(graph.get(k),(a,b)->a[0].compareTo(b[0]));
        }
        List<String> result = new ArrayList();
        result.add(start);
        return dfs(graph, start, 0, result, flights.size())? result: null;
    }

    // result .add(start)
    public static boolean dfs(Map<String, List<String[]>> graph, String start, int count, List<String> result, int flightsCount){
        if(count == flightsCount) return true;
        List<String[]> adjs = graph.get(start);
        if(adjs == null) return false;
        for(String[] f: adjs){
            if(f[1] != "T"){
                result.add(f[0]);
                f[1] = "T";
                if(dfs(graph, f[0],count+1,result,flightsCount)){
                    return true;
                }
                f[1] = "F";
                result.remove(result.size()-1);
            }
        }
        return false;
    }


    public static void main(String[] args){
        List<String[]> flights = new ArrayList();
        flights.add(new String[]{"A","B"});
        flights.add(new String[]{"A","C"});
        flights.add(new String[]{"B","C"});
        flights.add(new String[]{"C","A"});
        List result = Itinerary.schedule(flights, "A");
        System.out.println(result.toString());

    }
}
