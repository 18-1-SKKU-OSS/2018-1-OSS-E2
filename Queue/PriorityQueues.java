/**
 * This class implements a PriorityQueue.
 * 이 클래스는 우선순위 큐를 구현합니다. 
 * 
 * A priority queue adds elements into positions based on their priority.
 * So the most important elements are placed at the front/on the top.
 * In this example I give numbers that are bigger, a higher priority.
 * Queues in theory have no fixed size but when using an array
 * implementation it does.
 * 
 * 우선순위 큐는 원소들을 우선순위에 기초한 위치에 삽입합니다.
 * 그래서 가장 중요한 원소들은 가장 앞에 위치합니다. 
 * 이 예시에서는 숫자가 높을수록 우선 순위도 높습니다.
 * 큐는 이론상으로는 정해진 크기가 없지만, 배열을 통해 구현하게 되면
 * 정해진 크기가 존재하게 됩니다.  
 * 
 * 
 * @author Unknown
 *
 */
class PriorityQueue{
	/** The max size of the queue 
	 *  큐의 최대 크기
	 * */
	private int maxSize;
	/** The array for the queue 
	 *  큐를 구현할 배열
	 * */
	private int[] queueArray;
	/** How many items are in the queue 
	 *  큐에 들어가 있는 원소의 수
	 * */
	private int nItems;

	/**
	 * Constructor
	 * 생성자
	 * 
	 * @param size Size of the queue
	 * size라는 변수는 큐의 크기를 의미합니다. 
	 */
	public PriorityQueue(int size){
		maxSize = size;
		queueArray = new int[size];
		nItems = 0;
	}

	/**
	 * Inserts an element in it's appropriate place
	 * 원소를 적절한 위치에 삽입합니다. 
	 * 
	 * @param value Value to be inserted
	 * value라는 변수는 삽입할 값을 위미합니다. 
	 * 
	 */
	public void insert(int value){
		if(nItems == 0){
			queueArray[0] = value;
		}
		else{
			int j = nItems;
			while(j > 0 && queueArray[j-1] > value){
				queueArray[j] = queueArray[j-1]; 
				//Shifts every element up to make room for insertion 
				//삽입할 공간을 만들기 위해 모든 원소들을 움직입니다. 
				j--;
			}
			queueArray[j] = value; 
			//Once the correct position is found the value is inserted
			//맞는 위치가 찾아지면 값이 삽입됩니다. 
		}
		nItems++;
	}

	/**
	 * Remove the element from the front of the queue
	 * 큐의 가장 앞부분에서 원소를 삭제합니다. 
	 * 
	 * 
	 * @return The element removed
	 * 지워진 원소의 값을 리턴합니다. 
	 */
	public int remove(){
		return queueArray[--nItems];
	}

	/**
	 * Checks what's at the front of the queue
	 * 큐의 가장 앞에 무엇이 있는지 확인합니다. 
	 * 
	 * @return element at the front of the queue
	 * 큐의 가장 앞에 있는 원소를 리턴합니다. 
	 */
	public int peek(){
		return queueArray[nItems-1];
	}

	/**
	 * Returns true if the queue is empty
	 * 큐가 비어있으면 true를 리턴합니다. 
	 * 
	 * @return true if the queue is empty
	 * 큐가 비어있으면 true를 리턴합니다. 
	 */
	public boolean isEmpty(){
		return(nItems == 0);
	}

	/**
	 * Returns true if the queue is full
	 * 큐가 꽉 차있으면 true를 리턴합니다. 
	 * 
	 * @return true if the queue is full
	 * 큐가 꽉 차있으면 true를 리턴합니다. 
	 */
	public boolean isFull(){
		return(nItems == maxSize);
	}

	/**
	 * Returns the number of elements in the queue
	 * 큐에 들어있는 원소의 수를 리턴합니다. 
	 * 
	 * @return number of elements in the queue
	 * 큐에 들어있는 원소의 수를 리턴합니다. 
	 */
	public int getSize(){
		return nItems;
	}
}

/**
 * This class implements the PriorityQueue class above.
 * 이 클래스는 우선순위 큐를 구현합니다. 
 * 
 * @author Unknown
 *
 */
public class PriorityQueues{
	/**
	 * Main method
	 * 메인 메서드
	 * @param args Command Line Arguments
	 */
	public static void main(String args[]){
		PriorityQueue myQueue = new PriorityQueue(4);
		myQueue.insert(10);
		myQueue.insert(2);
		myQueue.insert(5);
		myQueue.insert(3);
		//[2, 3, 5, 10] Here higher numbers have higher priority, so they are on the top
		//              여기서 더 큰 숫자는 더 큰 우선순위를 가지므로 더 위에 위치합니다. 
		for(int i = 3; i>=0; i--)
			System.out.print(myQueue.remove() + " "); //will print the queue in reverse order [10, 5, 3, 2]
													  //큐를 역순으로 출력합니다. 
		//As you can see, a Priority Queue can be used as a sorting algorithm
		//보는 것과 같이, 우선순위 큐는 정렬 알고리즘에 이용될 수 있습니다. 
	}
}