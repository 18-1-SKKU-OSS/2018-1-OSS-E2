/**
 * This class implements a PriorityQueue.
 * �� Ŭ������ �켱���� ť�� �����մϴ�. 
 * 
 * A priority queue adds elements into positions based on their priority.
 * So the most important elements are placed at the front/on the top.
 * In this example I give numbers that are bigger, a higher priority.
 * Queues in theory have no fixed size but when using an array
 * implementation it does.
 * 
 * �켱���� ť�� ���ҵ��� �켱������ ������ ��ġ�� �����մϴ�.
 * �׷��� ���� �߿��� ���ҵ��� ���� �տ� ��ġ�մϴ�. 
 * �� ���ÿ����� ���ڰ� �������� �켱 ������ �����ϴ�.
 * ť�� �̷л����δ� ������ ũ�Ⱑ ������, �迭�� ���� �����ϰ� �Ǹ�
 * ������ ũ�Ⱑ �����ϰ� �˴ϴ�.  
 * 
 * 
 * @author Unknown
 *
 */
class PriorityQueue{
	/** The max size of the queue 
	 *  ť�� �ִ� ũ��
	 * */
	private int maxSize;
	/** The array for the queue 
	 *  ť�� ������ �迭
	 * */
	private int[] queueArray;
	/** How many items are in the queue 
	 *  ť�� �� �ִ� ������ ��
	 * */
	private int nItems;

	/**
	 * Constructor
	 * ������
	 * 
	 * @param size Size of the queue
	 * size��� ������ ť�� ũ�⸦ �ǹ��մϴ�. 
	 */
	public PriorityQueue(int size){
		maxSize = size;
		queueArray = new int[size];
		nItems = 0;
	}

	/**
	 * Inserts an element in it's appropriate place
	 * ���Ҹ� ������ ��ġ�� �����մϴ�. 
	 * 
	 * @param value Value to be inserted
	 * value��� ������ ������ ���� �����մϴ�. 
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
				//������ ������ ����� ���� ��� ���ҵ��� �����Դϴ�. 
				j--;
			}
			queueArray[j] = value; 
			//Once the correct position is found the value is inserted
			//�´� ��ġ�� ã������ ���� ���Ե˴ϴ�. 
		}
		nItems++;
	}

	/**
	 * Remove the element from the front of the queue
	 * ť�� ���� �պκп��� ���Ҹ� �����մϴ�. 
	 * 
	 * 
	 * @return The element removed
	 * ������ ������ ���� �����մϴ�. 
	 */
	public int remove(){
		return queueArray[--nItems];
	}

	/**
	 * Checks what's at the front of the queue
	 * ť�� ���� �տ� ������ �ִ��� Ȯ���մϴ�. 
	 * 
	 * @return element at the front of the queue
	 * ť�� ���� �տ� �ִ� ���Ҹ� �����մϴ�. 
	 */
	public int peek(){
		return queueArray[nItems-1];
	}

	/**
	 * Returns true if the queue is empty
	 * ť�� ��������� true�� �����մϴ�. 
	 * 
	 * @return true if the queue is empty
	 * ť�� ��������� true�� �����մϴ�. 
	 */
	public boolean isEmpty(){
		return(nItems == 0);
	}

	/**
	 * Returns true if the queue is full
	 * ť�� �� �������� true�� �����մϴ�. 
	 * 
	 * @return true if the queue is full
	 * ť�� �� �������� true�� �����մϴ�. 
	 */
	public boolean isFull(){
		return(nItems == maxSize);
	}

	/**
	 * Returns the number of elements in the queue
	 * ť�� ����ִ� ������ ���� �����մϴ�. 
	 * 
	 * @return number of elements in the queue
	 * ť�� ����ִ� ������ ���� �����մϴ�. 
	 */
	public int getSize(){
		return nItems;
	}
}

/**
 * This class implements the PriorityQueue class above.
 * �� Ŭ������ �켱���� ť�� �����մϴ�. 
 * 
 * @author Unknown
 *
 */
public class PriorityQueues{
	/**
	 * Main method
	 * ���� �޼���
	 * @param args Command Line Arguments
	 */
	public static void main(String args[]){
		PriorityQueue myQueue = new PriorityQueue(4);
		myQueue.insert(10);
		myQueue.insert(2);
		myQueue.insert(5);
		myQueue.insert(3);
		//[2, 3, 5, 10] Here higher numbers have higher priority, so they are on the top
		//              ���⼭ �� ū ���ڴ� �� ū �켱������ �����Ƿ� �� ���� ��ġ�մϴ�. 
		for(int i = 3; i>=0; i--)
			System.out.print(myQueue.remove() + " "); //will print the queue in reverse order [10, 5, 3, 2]
													  //ť�� �������� ����մϴ�. 
		//As you can see, a Priority Queue can be used as a sorting algorithm
		//���� �Ͱ� ����, �켱���� ť�� ���� �˰��� �̿�� �� �ֽ��ϴ�. 
	}
}