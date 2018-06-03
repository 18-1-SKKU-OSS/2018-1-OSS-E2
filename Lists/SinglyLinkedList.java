/**
 * This class implements a SinglyLinked List. This is done
 * using SinglyLinkedList class and a LinkForLinkedList Class.
 * 이 클래스는 singly linked list를 구협합니다. SinglyLinkedList 클래스와 LinkForLinkedList 클래스를 이용하여 구현합니다.
 * 
 * 
 * A linked list is similar to an array, it hold values.
 * However, links in a linked list do not have indexes. With
 * a linked list you do not need to predetermine it's size as
 * it grows and shrinks as it is edited. This is an example of
 * a singly linked list. Elements can only be added/removed
 * at the head/front of the list.
 * 
 * linked list는 값을 저장한다는 점에서 배열과 비슷합니다. 하지만 linked list의 link는 
 * index값을 가지고 있지 않습니다. linked list를 사용할 때 리스트가 편집됨에 따라 크기가 늘거나 줄어들기 
 * 때문에 리스트의 크기를 정해줄 필요가 없습니다. 이것은 singly linked list의 한 예시입니다. 
 * 원소들은 리스트의 가장 앞에서만 더해지거나 지워집니다. 
 * 
 * @author Unknown
 *
 */
class SinglyLinkedList{
	/**Head referred to the front of the list 
	 * Head는 리스트의 앞부분을 가르킵니다. 
	 * */
	private Node head;

	/**
	 * Constructor of SinglyLinkedList
	 * SinglyLinkedList의 생성자
	 */
	public SinglyLinkedList(){
		head = null;
	}

	/**
	 * This method inserts an element at the head
	 * 이 메서드는 원소를 head에 추가합니다. 
	 * 
	 * @param x Element to be added
	 * x라는 변수는 추가할 원소의 값입니다. 
	 */
	public void insertHead(int x){
		Node newNode = new Node(x); //Create a new link with a value attached to it   값이 들어가 있는 새로운 link를 만듭니다. 
		newNode.next = head; 		//Set the new link to point to the current head   link가 현재 head를 가르키게 합니다. 
		head = newNode; 			//Now set the new link to be the head   새로운 link를 head로 지정합니다. 
	}


	/**
     * Inserts a new node at a specified position
     * @param head     head node of the linked list
     * @param data     data to be stored in a new node
     * @param position position at which a new node is to be inserted
     * @return  reference of the head of the linked list
     * 
     * 특정 위치에 새로운 노드를 추가합니다.
     * head라는 변수는 linked list의 가장 앞 노드입니다. 
     * data라는 변수는 새로운 노드에 들어갈 수입니다. 
     * position이라는 변수는 새로운 노드가 들어갈 위치를 의미합니다. 
     * linked list의 head를 리턴합니다. 
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
	 * 이 메서드는 head에 있는 원소를 삭제합니다.
	 * 
	 * 
	 * @return The element deleted
	 * 삭제된 원소를 리턴합니다. 
	 */
	public Node deleteHead(){
		Node temp = head;
		head = head.next; 
		//Make the second element in the list the new head, the Java garbage collector will later remove the old head
		//두번째 원소를 새로운 head로 지정합니다. Java garbage collector가 원래 head를 지울 것입니다. 
		return temp;
	}

	/**
	 * Checks if the list is empty
	 * 리스트 비었는지 확인합니다.
	 * 
	 * @return true is list is empty
	 * 리스타 비었으면 true를 리턴합니다. 
	 */
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * Prints contents of the list
	 * list의 내용물을 확인합니다. 
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
	 * 메인 메서드
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
 * 이 클래스는 SinglyLinkedList의 node클래스입니다. 
 * 이 클래스는 값(value)과 다음 노드를 가르키는 포인터(next)로 이루어져 있습니다. 
 * 
 * @author Unknown
 *
 */
class Node{
	/** The value of the node 
	 * 노드의 값
	 * */
	public int value;
	/** Point to the next node 
	 * 다음 노드를 가르키는 포인터
	 * */
	public Node next; //This is what the link will point to

	/**
	 * Constructor
	 * 생성자
	 * 
	 * @param valuein Value to be put in the node
	 * valuein은 노드에 넣을 값입니다. 
	 */
	public Node(int valuein){
		value = valuein;
	}
	public Node() {
	}

	/**
	 * Returns value of the node
	 * node의 value를 리턴합니다. 
	 */
	public int getValue(){
		return value;
	}

}
