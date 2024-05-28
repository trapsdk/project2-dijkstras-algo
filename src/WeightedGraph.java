import java.util.*;

public class WeightedGraph {
    int v;

    // HOLDS VERTEX
    HashMap<Integer,
            // HOLDS LIST OF DEST VERTEX AND WEIGHTED PATH
            ArrayList<HashMap<Integer, Integer>>>
                // HASHMAP NAME
                graphList;

    WeightedGraph(){
        this.graphList = new HashMap<>();
    }
    private void printVertex(){
        for ( int vertex : this.graphList.keySet() ){
            System.out.println(vertex + " ");
        }
    }
    public void printAdjWithDistance(){
        for ( int vertex : this.graphList.keySet()){
            System.out.print("Vertex " + vertex + ": ");
            for ( int j = 0; j < this.graphList.get(vertex).size(); j++){
                System.out.print(this.graphList.get(vertex).get(j).entrySet() + " ");
            }
            System.out.println();
        }
    }
    public void addEdge(int s, int e, int w){
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(e, w);
        HashMap<Integer, Integer> tempTwo = new HashMap<>();
        tempTwo.put(s, w);
        if(!this.graphList.containsKey(s) ){
            addVertex(s);
            this.graphList.get(s).add(temp);
        } else if (this.graphList.containsKey(s)){
            this.graphList.get(s).add(temp);
        }
        // ADD BIDIRECTIONAL METHOD
        if( !this.graphList.containsKey(e) ){
            addVertex(e);
            this.graphList.get(e).add(tempTwo);
        }else {
            this.graphList.get(e).add(tempTwo);
        }
    }
    private void addVertex(int s){
        this.graphList.put(s, new ArrayList<>());
    }

    public void Dijkstra(int startVertex, int endVertex) {
        int path = 0;
        while( startVertex != endVertex ){
            int minWeight = Integer.MAX_VALUE;

            for ( Integer key: this.graphList.keySet() ){
                if ( key == startVertex){

                    for ( int i = 0; i < this.graphList.get(key).size(); i++){
                        if ( (int) this.graphList.get(key).get(i).values().toArray()[0] < minWeight ){
                            minWeight = (int) this.graphList.get(key).get(i).values().toArray()[0];
                        }
                    }
                    path += minWeight;
                    System.out.println(minWeight);
                }
            }




            System.out.println(path);
            startVertex = 2;
        }
    }
}



