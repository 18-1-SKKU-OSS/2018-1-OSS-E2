import java.util.*;

/**
 * Implementation of a Depth First Search
 * 깊이 우선 탐색의 구현
 * @author Unknown
 *
 */

public class DFS{
	
	/**
	 * Implementation in code of a DFS
	 * 깊이 우선 탐색 코드의 구현
	 * @param a structure to be DFS'ed
	 * @param vertices The vertices
	 * @param source The source
	 */
	public static void dfsImplement(byte [][] a,int vertices,int source){ 
        //passing adjacency matrix and no of vertices
	//인접한 행렬과 정점의 수를 전달 
		byte []b=new byte[vertices];               
		//flag container containing status of each vertices
		//각 꼭지점의 상태가 포함된 플래그 컨테이너
		Arrays.fill(b,(byte)-1);                  //status initialization
							  //상태 초기화
		/*       code   status 
		          -1  =  준비
		           0  =  대기
		           1  =  진행       */
		
		
		Stack st=new Stack(vertices);         //운영 스택
		st.push(source);                          //소스 할당
		while(!st.isEmpty()){
			b[st.peek()]=(byte)0;                 //대기 상태 할당
			System.out.println(st.peek());
			int pop=st.pop();
			b[pop]=(byte)1;                       //진행 상황 할당
			for(int i=0;i<vertices;i++){
				if(a[pop][i]!=0 && b[i]!=(byte)0 && b[i]!=(byte)1 ){
					st.push(i);
					b[i]=(byte)0;                  //대기 상황 할당
				}}}
		
	}
	
	/**
	 * The main method
	 * 주 메소드
	 * @param args Command line arguments
	 */
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int vertices=in.nextInt(),source=in.nextInt();
		byte [][]a=new byte [vertices][vertices];
		//initially all elements of a are initialized with value zero
		//초기의 'a'의 모든 원소는 0으로 초기화된다.
		for(int i=0;i<vertices;i++){
			int size =in.nextInt(); 
			for(int j=0;j<size;j++){
				a[i][in.nextInt()]=1;      //taking adjacency entries by assigning 1
							   //1을 지정하여 인접 항목을 가져옴. 
			}
		}
		dfsImplement(a,vertices,source);         //function call
		in.close();
	}
}
