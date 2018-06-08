import java.util.ArrayList;
import java.lang.StringBuilder;

class AdjacencyListGraph<E extends Comparable<E>> {
	
    ArrayList<Vertex> verticies;

    public AdjacencyListGraph() {
        verticies = new ArrayList<>();
    }

    private class Vertex {
        E data;
        ArrayList<Vertex> adjacentVerticies;

        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            this.data = data;
        }

        public boolean addAdjacentVertex(Vertex to) {
            for (Vertex v: adjacentVerticies) {
                if (v.data.compareTo(to.data) == 0) {
                    return false; // the edge already exists    간선이 이미 존재한다.
                }
            }
            return adjacentVerticies.add(to); // this will return true; true 반환
        }

        public boolean removeAdjacentVertex(E to) {
            // use indexes here so it is possible to 
            // remove easily without implementing 
            // equals method that ArrayList.remove(Object o) uses
		
	   // 여기에서 인덱스를 사용하므로
	   // ArrayList.remove(Object o)가 쓰는 equals 메소드를 구현하지 않고도
	   // 쉽게 제거할 수 있습니다.
            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(to) == 0) {
                    adjacentVerticies.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * this method removes an edge from the graph between two specified
     * verticies
     * 이 메소드는 그래프에서 두 특정 정점 사이의 간선을 제거합니다.
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns false if the edge doesn't exist, returns true if the edge exists and is removed
     */
    public boolean removeEdge(E from, E to) {
        Vertex fromV = null;
        for (Vertex v: verticies) {
            if (from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if (fromV == null) return false;
        return fromV.removeAdjacentVertex(to);
    }
    /**
     * this method adds an edge to the graph between two specified
     * verticies 
     * 이 메소드는 그래프에서 두 특정 정점 사이의 간선을 추가합니다.
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns true if the edge did not exist, return false if it already did
     */
    public boolean addEdge(E from, E to) {
        Vertex fromV = null, toV = null;
        for (Vertex v: verticies) {
            if (from.compareTo(v.data) == 0) { // see if from vertex already exists
					       // from vertex가 이미 존재하는지 확인
                fromV = v;
            } else if (to.compareTo(v.data) == 0) { // see if to vertex already exists
						    // to vertex가 이미 존재하는지 확인
                toV = v;
            }
            if (fromV != null && toV != null) break; // both nodes exist so stop searching
						     // 두 노드 모두 존재하므로 탐색 중지
        }
        if (fromV == null) {
            fromV = new Vertex(from);
            verticies.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            verticies.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }

    /**
     * this gives a list of verticies in the graph and their adjacencies
     * 그래프에 있는 정점과 그 인접들의 리스트를 준다.
     * @return returns a string describing this graph
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v: verticies) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2: v.adjacentVerticies) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Graphs {
	
	public static void main(String args[]) {
		AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1, 2);
        assert graph.addEdge(1, 5);
        assert graph.addEdge(2, 5);
	    assert !graph.addEdge(1, 2);
        assert graph.addEdge(2, 3);
        assert graph.addEdge(3, 4);
        assert graph.addEdge(4, 1);
        assert !graph.addEdge(2, 3);
        System.out.println(graph);
    }
	
}
