import java.util.*;

public class FindItinerary {
    Map<String,List<Ticket>> graph;
    class Ticket implements Comparable<Ticket>{
        public String from,to;
        public Ticket(String from, String to ){
            this.from = from;
            this.to = to;
        }
        public int compareTo(Ticket o){
            return this.to.compareTo(o.to);
        }
        public String toString(){
            return to;
        }

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new TreeMap<>();
        for(List<String> ticket: tickets){
            List<Ticket> adj = graph.getOrDefault(ticket.get(0),new ArrayList());
            adj.add(new Ticket(ticket.get(0),ticket.get(1)));
            graph.put(ticket.get(0), adj);
        }
        for(String k:graph.keySet()){
            Collections.sort(graph.get(k));
        }
        for(String k:graph.keySet()){
            List<String> result = find(k,new HashSet<>(),new ArrayList());
            if(result.size() == tickets.size()+1){
                return result;
            }
        }
        return new ArrayList();

    }

    public List<String> find(String from, HashSet<Object> used, List<String> result){
        result.add(from);
        System.out.println(used.toString());
        for(Ticket t:graph.get(from)!=null?graph.get(from):new ArrayList<Ticket>()){
            if(!used.contains(t)){
                used.add(t);
                find(t.to,used,result);
            }
        }
        return result;
    }

    public static void main(String[] args){

        List<List<String>> tickets = new ArrayList();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        FindItinerary f = new FindItinerary();
        f.findItinerary(tickets);

    }
}
