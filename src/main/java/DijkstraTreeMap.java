import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class DijkstraTreeMap {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }

        public void dijkstra_GetMinDistances(int sourceVertex) {

            boolean[] inSPT = new boolean[vertices];
            //distance used to store the distance of vertex from a source
            int[] distance = new int[vertices];

            //Initialize all the distances to infinity
            for (int i = 0; i < vertices; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            //Initialize priority queue
            //override the comparator to do the sorting based keys
            TreeMap<Integer, Integer> treeMap = new TreeMap(); // <minDist,vertex>
            //create the pair for the first index, 0 distance 0 index
            distance[0] = 0;
            //add it to tree set
            treeMap.put(distance[0], 0);

            //while priority queue is not empty
            while (!treeMap.isEmpty()) {
                //extract the min
                Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();

                //extracted vertex
                int source = entry.getValue();
                if (inSPT[source] == false) {
                    inSPT[source] = true;

                    //iterate through all the adjacent vertices and update the keys
                    LinkedList<Edge> list = adjacencylist[source];
                    for (int i = 0; i < list.size(); i++) {
                        Edge edge = list.get(i);
                        int destination = edge.destination;
                        //only if edge destination is not present in mst
                        if (inSPT[destination] == false) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey = distance[source] + edge.weight;
                            int currentKey = distance[destination];
                            if (currentKey > newKey) {
                                treeMap.put(newKey, destination);
                                distance[destination] = newKey;
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            printDijkstra(distance, sourceVertex);
        }

        public void printDijkstra(int[] distance, int sourceVertex) {
            System.out.println("Dijkstra Algorithm: (Adjacency List + TreeSet)");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " + +i +
                        " distance: " + distance[i]);
            }
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);
        }
    }
}