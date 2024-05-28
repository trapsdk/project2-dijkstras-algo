import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class Graph {
    private Map<Integer, List<Edge>> adjacencyMap;
    final String filePath = "DijkstraOutput.txt";
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public Graph() {
        adjacencyMap = new HashMap<>();
        try {
            fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addVertex(int vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(int source, int destination, int weight) {
        adjacencyMap.putIfAbsent(source, new ArrayList<>());
        adjacencyMap.putIfAbsent(destination, new ArrayList<>());
        adjacencyMap.get(source).add(new Edge(destination, weight));
        // UNDIRECTED GRAPH LINE OF CODE
        adjacencyMap.get(destination).add(new Edge(source, weight));
    }

    public void dijkstra(int startVertex, int targetVertex) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> predecessors = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Set<Integer> visited = new HashSet<>();
        for (Integer vertex : adjacencyMap.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);
        pq.add(new Edge(startVertex, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int vertex = currentEdge.vertex;

            // If we have reached the target vertex, we can stop
            if (vertex == targetVertex) {
                break;
            }

            if (!visited.add(vertex)) continue;
            for (Edge edge : adjacencyMap.get(vertex)) {
                if (!visited.contains(edge.vertex)) {
                    int newDist = distances.get(vertex) + edge.weight;
                    if (newDist < distances.get(edge.vertex)) {
                        distances.put(edge.vertex, newDist);
                        pq.add(new Edge(edge.vertex, newDist));
                        predecessors.put(edge.vertex, vertex);
                    }
                }
            }
        }

        printDijkstra(startVertex, targetVertex, distances, predecessors);
    }

    private void printDijkstra(int startVertex, int targetVertex, Map<Integer, Integer> distances, Map<Integer, Integer> predecessors) {

        bufferedWriter = new BufferedWriter(fileWriter);

        System.out.println("Dijkstra Algorithm: (Starting from vertex " + startVertex + ")");
        try {
            bufferedWriter.write("Dijkstra Algorithm: (Starting from vertex " + startVertex + ")\n");
            bufferedWriter.write("Vertex " + targetVertex + " is at distance " + distances.get(targetVertex) + "\n");
            bufferedWriter.write("Path: " + startVertex);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (distances.get(targetVertex) == Integer.MAX_VALUE) {
            System.out.println("No path from " + startVertex + " to " + targetVertex);
            return;
        }

        System.out.println("Vertex " + targetVertex + " is at distance " + distances.get(targetVertex));
        System.out.print("Path: ");
        printPath(targetVertex, predecessors);
        System.out.println();
        System.out.println();
        try {
            bufferedWriter.write("\n\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void printPath(int currentVertex, Map<Integer, Integer> predecessors) {
        if (!predecessors.containsKey(currentVertex)) {

            System.out.print(currentVertex);
            return;
        }
        printPath(predecessors.get(currentVertex), predecessors);

        try {
            bufferedWriter.write(" -> " + currentVertex);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print(" -> " + currentVertex);
    }
}


