// GABRIEL R CORTEZ
/// CS 244
//// 05/26/2024
///// DIJKSTRA ALGORITHIM WITH UNDIRECTED WEIGHTED GRAPH
public class Main {
    public static void main(String[] args) {
        // INITIALIZING OUR GRAPH
        Graph graph = new Graph();

// 0
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 7, 4);
        graph.addEdge(0, 14, 4);
        graph.addEdge(0, 20, 8);
// 1
        graph.addEdge(1, 5, 8);
// 2
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 6, 2);
// 3
        graph.addEdge(3, 17, 1);
// 4
        graph.addEdge(4, 5, 7);
        graph.addEdge(4, 7, 3);
        graph.addEdge(4, 8, 5);
// 5
        graph.addEdge(5, 6, 8);
        graph.addEdge(5, 8, 1);
        graph.addEdge(5, 25, 6);
// 6 All edges added
// 7
        graph.addEdge(7, 11, 1);
// 8
        graph.addEdge(8, 11, 8);
        graph.addEdge(8, 12, 7);
// 9
        graph.addEdge(9, 10, 6);
        graph.addEdge(9, 12, 9);
        graph.addEdge(9, 13, 3);
// 10
        graph.addEdge(10, 13, 5);
        graph.addEdge(10, 17, 2);
        graph.addEdge(10, 30, 4);
// 11
        graph.addEdge(11, 12, 2);
        graph.addEdge(11, 14, 6);
// 12
        graph.addEdge(12, 13, 2);
        graph.addEdge(12, 15, 8);
        graph.addEdge(12, 16, 6);
// 13
        graph.addEdge(13, 17, 9);
// 14 All edges added
// 15
        graph.addEdge(15, 35, 7);
// 16
        graph.addEdge(16, 17, 1);
// 17 All edges added
// 20
        graph.addEdge(20, 21, 1);
        graph.addEdge(20, 24, 3);
        graph.addEdge(20, 27, 5);
        graph.addEdge(20, 34, 1);
// 21
        graph.addEdge(21, 24, 1);
// 22
        graph.addEdge(22, 23, 8);
        graph.addEdge(22, 25, 1);
        graph.addEdge(22, 26, 8);
// 23
        graph.addEdge(23, 26, 2);
        graph.addEdge(23, 37, 2);
// 24
        graph.addEdge(24, 27, 2);
        graph.addEdge(24, 28, 6);
// 25
        graph.addEdge(25, 26, 7);
        graph.addEdge(25, 28, 1);
        graph.addEdge(25, 29, 6);
// 26
        graph.addEdge(26, 29, 9);
        graph.addEdge(26, 30, 5);
// 27
        graph.addEdge(27, 28, 5);
        graph.addEdge(27, 34, 7);
// 28
        graph.addEdge(28, 31, 5);
        graph.addEdge(28, 32, 1);
// 29
        graph.addEdge(29, 30, 1);
        graph.addEdge(29, 33, 5);
// 30
        graph.addEdge(30, 37, 4);
// 31
        graph.addEdge(31, 32, 4);
        graph.addEdge(31, 34, 3);
        graph.addEdge(31, 35, 9);
// 32
        graph.addEdge(32, 33, 4);
        graph.addEdge(32, 36, 1);
// 33
        graph.addEdge(33, 36, 7);
// 34 All edges added
// 35
        graph.addEdge(35, 36, 4);
        graph.addEdge(35, 37, 1);
// 36 All edges added
// 37 All edges added

        System.out.println("Starting from 1 to 37");
        graph.dijkstra(1, 37);
        System.out.println("Starting from 14 to 23");
        graph.dijkstra(14, 23);

    }
}