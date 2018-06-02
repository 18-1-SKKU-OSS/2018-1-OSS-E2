/**
 * This implements Queues by using the class Queue.
 * �̰��� ť Ŭ������ ����Ͽ� ť�� �����մϴ�. 
 * A queue data structure functions the same as a real world queue.
 * The elements that are added first are the first to be removed.
 * New elements are added to the back/rear of the queue.
 *
 * ť�� ���� ��Ȱ������ ť�� �����ϰ� �۵��ϴ� �ڷᱸ���Դϴ�. 
 * ���� ���� ���� ���� ���� ���� �����˴ϴ�. (FIFO)
 * ���ο� ���ҵ��� ť�� ���� �ڿ� ���Ե˴ϴ�. 
 * 
 * 
 * @author Unknown
 *
 */
class Queue{
	/** Max size of the queue */
	/** ť�� �ִ� ũ�� */
	private int maxSize;
	/** The array representing the queue */
	/** ť�� ��Ÿ���� �迭 */
	private int[] queueArray;
	/** Front of the queue */
	/** ť�� �պκ�*/
	private int front;
	/** Rear of the queue */
	/** ť�� �޺κ�*/
	private int rear;
	/** How many items are in the queue */
	/** ť�� ����ִ� ������ ��*/
	private int nItems;
	
	/**
	 * Constructor
	 * ������
	 * 
	 * @param size Size of the new queue
	 * size ������ ���ο� ť�� �ִ� ũ�⸦ ��Ÿ���ϴ�. 
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
	 * ť�� ���� �޺κп� ���Ҹ� �ֽ��ϴ�. 
	 * 
	 * @param x element to be added
	 * @return True if the element was added successfully
	 * 
	 * x ������ ť�� ������ �����Դϴ�.
	 * ť�� ���Ұ� ���������� ���ԵǸ� true�� �����մϴ�. 
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
	 * ť�� ���� �տ� �ִ� ���Ҹ� ����ϴ�. 
	 * 
	 * @return the new front of the queue
	 * ���ο� ť�� ���� �պκ��� ��ʼҸ� �����մϴ�. 
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
	 * ť�� ���� �պκп� � ���Ұ� �ִ��� Ȯ���մϴ�.
	 * 
	 * @return element at the front of the queue
	 * ť�� ���� �պκп� �ִ� ���Ҹ� �����մϴ�. 
	 */
	
	public int peekFront(){
		return queueArray[front];
	}
	
	/**
	 * Checks what's at the rear of the queue
	 *  ť�� ���� �ڿ� � ���Ұ� �ִ��� Ȯ���մϴ�. 
	 * 
	 * @return element at the rear of the queue
	 *  ť�� ���� �ڿ� �ִ� ���Ҹ� �����մϴ�.
	 */
	public int peekRear(){
		return queueArray[rear];
	}
	
	/**
	 * Returns true if the queue is empty
	 * ť�� ��������� true�� �����մϴ�.
	 * 
	 * 
	 * @return true if the queue is empty
	 * ť�� ��������� true�� �����մϴ�. 
	 */
	public boolean isEmpty(){
		return(nItems == 0);
	}
	
	/**
	 * Returns true if the queue is full
	 * ť�� �� �� ������ true�� �����մϴ�. 
	 * 
	 * @return true if the queue is full
	 * ť�� �� �� ������ true�� �����մϴ�. 
	 */
	public boolean isFull(){
		return(nItems == maxSize);
	}
	
	/**
	 * Returns the number of elements in the queue
	 * ť�� ����ִ� ���ҵ��� ���� �����մϴ�. 
	 * 
	 * @return number of elements in the queue
	 * ť�� ����ִ� ���ҵ��� ���� �����մϴ�. 
	 */
	public int getSize(){
		return nItems;
	}
}

/**
 * This class is the example for the Queue class
 * �� Ŭ������ ť Ŭ������ �� �����Դϴ�. 
 * @author Unknown
 *
 */
public class Queues{
	/**
	 * Main method
	 * ���� �޼���
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
		
		System.out.println(myQueue.isFull()); //Will print true  true�� ����� ���Դϴ�. 
		
		myQueue.remove(); //Will make 2 the new front, making 10 no longer part of the queue 
		// 10�� �������ν� 2�� ���� �տ� ��ġ�ϰ� �˴ϴ�. 
		//[10, 2(front), 5, 3(rear)]
		
		myQueue.insert(7); //Insert 7 at the rear which will be index 0 because of wrap around
		//7�� ������ 7�� ��ġ�� 0�� �Ǵµ� �̰��� �迭�� ���� �������� 3�� �ڸ� �迭�� ���� ���̶�� ���� �����Դϴ�. 
		// [7(rear), 2(front), 5, 3]
		
		System.out.println(myQueue.peekFront()); //Will print 2    2�� ����� ���Դϴ�. 
		System.out.println(myQueue.peekRear()); //Will print 7 	   7�� ����� ���Դϴ�. 
	}
}