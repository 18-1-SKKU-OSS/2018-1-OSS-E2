/**
 * This implements Queues by using the class Queue.
 * 이것은 큐 클래스를 사용하여 큐를 구현합니다. 
 * A queue data structure functions the same as a real world queue.
 * The elements that are added first are the first to be removed.
 * New elements are added to the back/rear of the queue.
 *
 * 큐는 실제 생활에서의 큐와 동일하게 작동하는 자료구조입니다. 
 * 가장 먼저 들어온 것이 가장 먼저 삭제됩니다. (FIFO)
 * 새로운 원소들은 큐의 가장 뒤에 삽입됩니다. 
 * 
 * 
 * @author Unknown
 *
 */
class Queue{
	/** Max size of the queue */
	/** 큐의 최대 크기 */
	private int maxSize;
	/** The array representing the queue */
	/** 큐를 나타내는 배열 */
	private int[] queueArray;
	/** Front of the queue */
	/** 큐의 앞부분*/
	private int front;
	/** Rear of the queue */
	/** 큐의 뒷부분*/
	private int rear;
	/** How many items are in the queue */
	/** 큐에 들어있는 원소의 수*/
	private int nItems;
	
	/**
	 * Constructor
	 * 생성자
	 * 
	 * @param size Size of the new queue
	 * size 변수는 새로운 큐의 최대 크기를 나타냅니다. 
	 */
	public Queue(int size){
		maxSize = size;
		queueArray = new int[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**
	 * Inserts an element at the rear of the queue
	 * 큐의 가장 뒷부분에 원소를 넣습니다. 
	 * 
	 * @param x element to be added
	 * @return True if the element was added successfully
	 * 
	 * x 변수는 큐에 더해질 원소입니다.
	 * 큐에 원소가 성공적으로 삽입되면 true를 리턴합니다. 
	 */
	public boolean insert(int x){
		if(isFull())
			return false;
		if(rear == maxSize-1) //If the back of the queue is the end of the array wrap around to the front
			rear = -1;
		rear++;
		queueArray[rear] = x;
		nItems++;
		return true;
	}
	
	/**
	 * Remove an element from the front of the queue
	 * 큐의 가장 앞에 있는 원소를 지웁니다. 
	 * 
	 * @return the new front of the queue
	 * 새로운 큐의 가장 앞부분의 우너소를 리턴합니다. 
	 */
	public int remove(){ //Remove an element from the front of the queue
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}	
		int temp = queueArray[front];
		front++;
		if(front == maxSize) //Dealing with wrap-around again
			front = 0;
		nItems--;
		return temp;
	}
	
	/**
	 * Checks what's at the front of the queue
	 * 큐의 가장 앞부분에 어떤 원소가 있는지 확인합니다.
	 * 
	 * @return element at the front of the queue
	 * 큐의 가장 앞부분에 있는 원소를 리턴합니다. 
	 */
	
	public int peekFront(){
		return queueArray[front];
	}
	
	/**
	 * Checks what's at the rear of the queue
	 *  큐의 가장 뒤에 어떤 원소가 있는지 확인합니다. 
	 * 
	 * @return element at the rear of the queue
	 *  큐의 가장 뒤에 있는 원소를 리턴합니다.
	 */
	public int peekRear(){
		return queueArray[rear];
	}
	
	/**
	 * Returns true if the queue is empty
	 * 큐가 비어있으면 true를 리턴합니다.
	 * 
	 * 
	 * @return true if the queue is empty
	 * 큐가 비어있으면 true를 리턴합니다. 
	 */
	public boolean isEmpty(){
		return(nItems == 0);
	}
	
	/**
	 * Returns true if the queue is full
	 * 큐가 꽉 차 있으면 true를 리턴합니다. 
	 * 
	 * @return true if the queue is full
	 * 큐가 꽉 차 있으면 true를 리턴합니다. 
	 */
	public boolean isFull(){
		return(nItems == maxSize);
	}
	
	/**
	 * Returns the number of elements in the queue
	 * 큐에 들어있는 원소들의 수를 리턴합니다. 
	 * 
	 * @return number of elements in the queue
	 * 큐에 들어있는 원소들의 수를 리턴합니다. 
	 */
	public int getSize(){
		return nItems;
	}
}

/**
 * This class is the example for the Queue class
 * 이 클래스는 큐 클래스의 한 예시입니다. 
 * @author Unknown
 *
 */
public class Queues{
	/**
	 * Main method
	 * 메인 메서드
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String args[]){
		Queue myQueue = new Queue(4);
		myQueue.insert(10);
		myQueue.insert(2);
		myQueue.insert(5);
		myQueue.insert(3);
		//[10(front), 2, 5, 3(rear)]
		
		System.out.println(myQueue.isFull()); //Will print true  true를 출력할 것입니다. 
		
		myQueue.remove(); //Will make 2 the new front, making 10 no longer part of the queue 
		// 10을 지움으로써 2가 가장 앞에 위치하게 됩니다. 
		//[10, 2(front), 5, 3(rear)]
		
		myQueue.insert(7); //Insert 7 at the rear which will be index 0 because of wrap around
		//7을 넣으면 7의 위치는 0이 되는데 이것은 배열의 가장 마지막인 3위 뒤를 배열의 가장 앞이라고 보기 때문입니다. 
		// [7(rear), 2(front), 5, 3]
		
		System.out.println(myQueue.peekFront()); //Will print 2    2를 출력할 것입니다. 
		System.out.println(myQueue.peekRear()); //Will print 7 	   7을 출력할 것입니다. 
	}
}