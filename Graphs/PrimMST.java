// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
//adjacency matrix representation of the graph

// Prim's Minimum Spanning Tree 알고리즘의 자바 프로그램
// 인접 행렬이 그래프를 표현

import java.lang.*;
 
class PrimMST
{
    // Number of vertices in the graph
    // 그래프의 정점 개수
    private static final int V=5;
 
    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST

    // 아직 MST에 포함되지 않은 정점 세트에서 최소 키값을 가지는
    // 정점을 찾는 유틸리티 메소드
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
	// 최솟값 초기화
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed MST stored in
    // parent[]

    // parent[]에 저장된 생성된 MST를 출력하는 유틸리티 메소드
    void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
 
    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation

    // 인접 행렬 표현을 사용한 그래프의 MST를 생성하고 출력하는 메소드
    void primMST(int graph[][])
    {
        // Array to store constructed MST
	// 생성된 MST 저장하는 배열
        int parent[] = new int[V];
 
        // Key values used to pick minimum weight edge in cut
	// 최소 가중치 간선을 고르기 위한 키 값
        int key[] = new int [V];
 
        // To represent set of vertices not yet included in MST
	// 아직 MST에 포함되지 않은 정점 세트를 표시
        Boolean mstSet[] = new Boolean[V];
 
        // Initialize all keys as INFINITE
	// 모든 키들을 무한으로 초기화
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first 1st vertex in MST.
	// 항상 MST의 첫 정점을 포함
        key[0] = 0;     // Make key 0 so that this vertex is
                        // picked as first vertex
        parent[0] = -1; // First node is always root of MST
 			// 이 정점이 첫번째 정점으로 골라지게 하기 위해
			// 키를 0으로 만듦
			// 첫번째 노드는 항상 MST의 루트다.			
        // The MST will have V vertices	
	// MST는 V 정점들을 가질 것이다.

        for (int count = 0; count < V-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
	    // 아직 MST에 포함되지 않은 정점 세트에서 최소 키 정점을 선택

            int u = minKey(key, mstSet);
 
            // Add the picked vertex to the MST Set
	    // 선택된 정점을 MST 세트에 추가
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST

	    // 선택된 정점의 인근 정점의 부모 주소와 키 값을 업데이트
	    // 아직 MST에 포함되지 않은 정점들만 고려한다.
            for (int v = 0; v < V; v++)
 
                if (graph[u][v]!=0 && mstSet[v] == false &&
                    graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }
 
        // print the constructed MST
	// 생성된 MST 출력
        printMST(parent, V, graph);
    }
 
    public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        PrimMST t = new PrimMST();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        // Print the solution
        t.primMST(graph);
    }
}
