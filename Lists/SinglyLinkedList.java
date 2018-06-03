/**
 * This class implements a SinglyLinked List. This is done
 * using SinglyLinkedList class and a LinkForLinkedList Class.
 * �� Ŭ������ singly linked list�� �����մϴ�. SinglyLinkedList Ŭ������ LinkForLinkedList Ŭ������ �̿��Ͽ� �����մϴ�.
 * 
 * 
 * A linked list is similar to an array, it hold values.
 * However, links in a linked list do not have indexes. With
 * a linked list you do not need to predetermine it's size as
 * it grows and shrinks as it is edited. This is an example of
 * a singly linked list. Elements can only be added/removed
 * at the head/front of the list.
 * 
 * linked list�� ���� �����Ѵٴ� ������ �迭�� ����մϴ�. ������ linked list�� link�� 
 * index���� ������ ���� �ʽ��ϴ�. linked list�� ����� �� ����Ʈ�� �����ʿ� ���� ũ�Ⱑ �ðų� �پ��� 
 * ������ ����Ʈ�� ũ�⸦ ������ �ʿ䰡 �����ϴ�. �̰��� singly linked list�� �� �����Դϴ�. 
 * ���ҵ��� ����Ʈ�� ���� �տ����� �������ų� �������ϴ�. 
 * 
 * @author Unknown
 *
 */
class SinglyLinkedList{
	/**Head referred to the front of the list 
	 * Head�� ����Ʈ�� �պκ��� ����ŵ�ϴ�. 
	 * */
	private Node head;

	/**
	 * Constructor of SinglyLinkedList
	 * SinglyLinkedList�� ������
	 */
	public SinglyLinkedList(){
		head = null;
	}

	/**
	 * This method inserts an element at the head
	 * �� �޼���� ���Ҹ� head�� �߰��մϴ�. 
	 * 
	 * @param x Element to be added
	 * x��� ������ �߰��� ������ ���Դϴ�. 
	 */
	public void insertHead(int x){
		Node newNode = new Node(x); //Create a new link with a value attached to it   ���� �� �ִ� ���ο� link�� ����ϴ�. 
		newNode.next = head; 		//Set the new link to point to the current head   link�� ���� head�� ����Ű�� �մϴ�. 
		head = newNode; 			//Now set the new link to be the head   ���ο� link�� head�� �����մϴ�. 
	}


	/**
     * Inserts a new node at a specified position
     * @param head     head node of the linked list
     * @param data     data to be stored in a new node
     * @param position position at which a new node is to be inserted
     * @return  reference of the head of the linked list
     * 
     * Ư�� ��ġ�� ���ο� ��带 �߰��մϴ�.
     * head��� ������ linked list�� ���� �� ����Դϴ�. 
     * data��� ������ ���ο� ��忡 �� ���Դϴ�. 
     * position�̶�� ������ ���ο� ��尡 �� ��ġ�� �ǹ��մϴ�. 
     * linked list�� head�� �����մϴ�. 
     */

    Node InsertNth(Node head, int data, int position) {
        
        Node newNode = new Node();
        newNode.value = data;
        
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;

        while (--position > 0) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
    
	/**
	 * This method deletes an element at the head
	 * �� �޼���� head�� �ִ� ���Ҹ� �����մϴ�.
	 * 
	 * 
	 * @return The element deleted
	 * ������ ���Ҹ� �����մϴ�. 
	 */
	public Node deleteHead(){
		Node temp = head;
		head = head.next; 
		//Make the second element in the list the new head, the Java garbage collector will later remove the old head
		//�ι�° ���Ҹ� ���ο� head�� �����մϴ�. Java garbage collector�� ���� head�� ���� ���Դϴ�. 
		return temp;
	}

	/**
	 * Checks if the list is empty
	 * ����Ʈ ������� Ȯ���մϴ�.
	 * 
	 * @return true is list is empty
	 * ����Ÿ ������� true�� �����մϴ�. 
	 */
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * Prints contents of the list
	 * list�� ���빰�� Ȯ���մϴ�. 
	 */
	public void display(){
		Node current = head;
		while(current!=null){
			System.out.print(current.getValue()+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * Main method
	 * ���� �޼���
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String args[]){
		SinglyLinkedList myList = new SinglyLinkedList();

		System.out.println(myList.isEmpty()); //Will print true

		myList.insertHead(5);
		myList.insertHead(7);
		myList.insertHead(10);

		myList.display(); // 10(head) --> 7 --> 5

		myList.deleteHead();

		myList.display(); // 7(head) --> 5
	}
}

/**
 * This class is the nodes of the SinglyLinked List.
 * They consist of a value and a pointer to the node
 * after them.
 * �� Ŭ������ SinglyLinkedList�� nodeŬ�����Դϴ�. 
 * �� Ŭ������ ��(value)�� ���� ��带 ����Ű�� ������(next)�� �̷���� �ֽ��ϴ�. 
 * 
 * @author Unknown
 *
 */
class Node{
	/** The value of the node 
	 * ����� ��
	 * */
	public int value;
	/** Point to the next node 
	 * ���� ��带 ����Ű�� ������
	 * */
	public Node next; //This is what the link will point to

	/**
	 * Constructor
	 * ������
	 * 
	 * @param valuein Value to be put in the node
	 * valuein�� ��忡 ���� ���Դϴ�. 
	 */
	public Node(int valuein){
		value = valuein;
	}
	public Node() {
	}

	/**
	 * Returns value of the node
	 * node�� value�� �����մϴ�. 
	 */
	public int getValue(){
		return value;
	}

}
