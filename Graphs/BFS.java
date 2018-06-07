import java.util.*;

/**
 * Implementation of a Breadth First Search
 * 너비우선탐색 
 * @author Unknown
 *
 */
public class BFS{

	/**
	 * 사용을 위해 코드로 구현된 BFS.
	 *
	 * @param a Structure to perform the search on a graph, adjacency matrix etc.
	 * @param vertices The vertices to use
	 * @param source The Source
	 */
	public static void bfsImplement(byte [][] a,int vertices,int source){ 
	 // 인접 행렬 및 정점의 수를 전달합니다.
		byte []b=new byte[vertices];   
	 //각 정점의 상태가 포함된 플래그 컨테이너.
		Arrays.fill(b,(byte)-1);   //상태 초기화
		/*       code   status
				 -1  =  준비
				  0  =  대기
				  1  =  진행       */

		Stack st = new Stack(vertices);     //운영 스택
		st.push(source);                                                 //소스 할당
		while(!st.isEmpty()){
			b[st.peek()]=(byte)0;                                   //대기 할당 
			System.out.println(st.peek());
			int pop=st.peek();
			b[pop]=(byte)1;               //진행 상황 할당
			st.pop();                  //큐의 헤드 제거
			for(int i=0;i<vertices;i++){
				if(a[pop][i]!=0 && b[i]!=(byte)0 && b[i]!=(byte)1 ){
					st.push(i);
					b[i]=(byte)0;                        //대기 상황 할당
				}}}
	}


	/**
	 * The main method
	 *주 메소드
	 * @param args Command line arguments
	 */
		public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int vertices=in.nextInt(),source=in.nextInt();
		byte [][]a=new byte [vertices][vertices];
		//initially all elements of a are initialized with value zero
		//초기에 'a'의 모든 요소는 값 0으로 초기화됩니다.

		for(int i=0;i<vertices;i++){
			int size =in.nextInt();
			for(int j=0;j<size;j++){
				a[i][in.nextInt()]=1;      //taking adjacency entries by assigning 1
							   //1을 할당하여 인접 항목을 가져옴.
			}
		}
		bfsImplement(a,vertices,source);         //function call 함수 호출
		in.close();
	}
}
