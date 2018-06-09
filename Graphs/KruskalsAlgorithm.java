// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph
// 주어진 연결된, 방향이 없고 가중치가 있는 그래프의 최소 스패닝 트리를 찾기 위한 
// Kruskal의 알고리즘을 위한 자바 프로그램
import java.utiwl.*;
import java.lang.*;
import java.io.*;
 
class Graph
{
    // A class to represent a graph edge
    // 그래프 간선 표현을 위한 클래스
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
 
        // Comparator function used for sorting edges based on
        // their weight
	// 가중치를 기준으로 간선을 정렬하는데 사용되는 비교 함수
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };
 
    // A class to represent a subset for union-find
    // union-find에 대한 하위 집합을 나타내는 클래스.
    class subset
    {
        int parent, rank;
    };
 
    int V, E;    // V-> no. of vertices & E->no.of edges
		 // V-> 정점의 수 & E->간선의 수
    Edge edge[]; // collection of all edges
		 // 모든 간선들의 집합
 
    // Creates a graph with V vertices and E edges
    // V개의 정점들과 E개의 간선들로 구성된 그래프 생성
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find set of an element i
    // (uses path compression technique)
    // i 원소의 세트를 찾기 위한 기능 메소드
    // (path compression 기술 사용)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
	// 루트를 찾고 루트를 i의 부모로 만든다.
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    // 두 세트의 x와 y의 결합을 수행하는 함수.
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
	// 높은 등급의 트리의 루트 밑에 작은 랭크의 트리를 붙인다.
	// (등급에 따른 결합)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
	// 만약 등급이 같다면, 하나를 루트로 만들고 그 랭크를 하나 증가시킨다.
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's algorithm
    // Kruskal의 알고리즘을 사용하여 MST(최소 스패닝 트리)를 만드는 메인 메소드.
    void KruskalMST()
    {
        Edge result[] = new Edge[V];  // 결과 MST를 저장한다.
        int e = 0;  // result[]에 쓰이는 주소 변수.
        int i = 0;  // 저장된 간선들에 쓰이는 주소 변수.
        for (i=0; i<V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
	//
	// 1단계: 모든 간선들을 그들의 가중치에 따라 줄어들지 않는 순서로 정렬한다.
	// 만약 우리가 주어진 그래프를 바꾸는 것이 허용되지 않는다면 
	// 간선들의 배열의 복사를 만든다.
        Arrays.sort(edge);
 
        // Allocate memory for creating V ssubsets
	// V 하위 집합을 위한 메모리 할당
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
 
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  //다음 간선 선택을 위한 주소 

        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
	    // 2단계: 가장 작은 간선 선택. 그리고 다음 반복문에서 주소를 증가시킨다.
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle, include it
	    // 만약 이 간선을 포함하는 것이 원형을 만들지 않는다면 포함하라.
            // in result and increment the index of result for next edge
	    //그리고 다음 간선을 위해 결과의 주소를 증가하라.
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                               result[i].weight);
    }
 
    // Driver Program
    public static void main (String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
 
        graph.KruskalMST();
    }
}
