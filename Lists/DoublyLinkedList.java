/**
 * This class implements a DoublyLinkedList. This is done using the classes
 * LinkedList and Link.
 * 이 클래스는 doubly linked list를 구현합니다. LinkedList, Link클래스를 사용하여 구현합니다. 
 * 
 * 
 * A linked list is similar to an array, it holds values. However,
 * links in a linked list do not have indexes. With a linked list
 * you do not need to predetermine it's size as it grows and shrinks
 * as it is edited. This is an example of a double ended, doubly
 * linked list. Each link references the next link and the previous
 * one.
 * 
 * linked list는 값을 저장한다는 점에서 배열과 비슷합니다. 하지만 linked list의 link는 
 * index값을 가지고 있지 않습니다. linked list를 사용할 때 리스트가 편집됨에 따라 크기가 늘거나 줄어들기 
 * 때문에 리스트의 크기를 정해줄 필요가 없습니다. 이것은 doubly linked list의 한 예입니다. 
 * 각각의 link는 다음 link, 이전 link를 가르킵니다.
 *  
 * 
 * @author Unknown
 *
 */

class DoublyLinkedList{
	/** Head refers to the front of the list */
	/** Head는 리스트의 맨 앞을 가르킵니다. */
	private Link head;
	/** Tail refers to the back of the list */
	/** Tail은 리스트의 맨 끝을 가르킵니다. */
	private Link tail;

	/**
	 * Constructor
	 * 생성자
	 */
	public DoublyLinkedList(){
		head = null;
		tail = null;
	}

	/**
	 * Insert an element at the head
	 * 맨 앞에 원소를 추가합니다. 
	 * 
	 * @param x Element to be inserted
	 * x라는 변수는 들어가는 원소의 값입니다.
	 */
	public void insertHead(int x){
		Link newLink = new Link(x); //Create a new link with a value attached to it  값이 저장된 새로운 link를 만듭니다. 
		if(isEmpty()) //Set the first element added to be the tail  첫번째 원소가 tail에 더해지도록 합니다. 
			tail = newLink;
		else
			head.previous = newLink; // newLink <-- currenthead(head)   
		newLink.next = head; // newLink <--> currenthead(head)
		head = newLink; // newLink(head) <--> oldhead
	}

	/**
	 * Insert an element at the tail
	 * 맨 뒤에 원소를 추가합니다. 
	 * 
	 * @param x Element to be inserted
	 * x라는 변수는 들어가는 원소의 값입니다.
	 */
	public void insertTail(int x){
		Link newLink = new Link(x);
		newLink.next = null; // currentTail(tail)     newlink -->
		tail.next = newLink; // currentTail(tail) --> newLink -->
		newLink.previous = tail; // currentTail(tail) <--> newLink -->
		tail = newLink; // oldTail <--> newLink(tail) -->
	}

	/**
	 * Delete the element at the head
	 * head에 있는 원소를 삭제합니다. 
	 * 
	 * @return The new head
	 * 새로운 head를 리턴합니다. 
	 */
	public Link deleteHead(){
		Link temp = head;
		head = head.next; // oldHead <--> 2ndElement(head)
		head.previous = null; // oldHead --> 2ndElement(head) nothing pointing at old head so will be removed
		if(head == null)
			tail = null;
		return temp;
	}

	/**
	 * Delete the element at the tail
	 * 맨 뒤에 있는 우너소를 삭제합니다. 
	 * 
	 * @return The new tail
	 * 새로운 tail을 리턴합니다. 
	 */
	public Link deleteTail(){
		Link temp = tail;
		tail = tail.previous; // 2ndLast(tail) <--> oldTail --> null
 		tail.next = null; // 2ndLast(tail) --> null
		return temp;
	}

	/**
	 * Delete the element from somewhere in the list
	 * 리스트 어딘가에 있는 원소를 삭제합니다. 
	 * 
	 * @param x element to be deleted
	 * @return  Link deleted
	 * 
	 * x는 삭제할 원소의 값입니다. 
	 * 삭제된 link를 리턴합니다. 
	 */
	public Link delete(int x){
		Link current = head;

		while(current.value != x) //Find the position to delete
			current = current.next;

		if(current == head)
			deleteHead();

		else if(current == tail)
			deleteTail();

		else{ //Before: 1 <--> 2(current) <--> 3
			current.previous.next = current.next;  // 1 --> 3
			current.next.previous = current.previous; // 1 <--> 3
		}
		return current;
	}

	/**
	 * Inserts element and reorders
	 * 원소를 삽입하고 재정렬합니다. 
	 * 
	 * @param x Element to be added
	 * x라는 변수는 추가할 원소입니다.
	 */
	public void insertOrdered(int x){
		Link newLink = new Link(x);
		Link current = head;
		while(current != null && x > current.value) //Find the position to insert
			current = current.next;

		if(current == head)
			insertHead(x);

		else if(current == null)
			insertTail(x);

		else{ //Before: 1 <--> 2(current) <--> 3
			newLink.previous = current.previous; // 1 <-- newLink
			current.previous.next = newLink; // 1 <--> newLink
			newLink.next = current; // 1 <--> newLink --> 2(current) <--> 3
			current.previous = newLink; // 1 <--> newLink <--> 2(current) <--> 3
		}
	}

	/**
	 * Returns true if list is empty
	 * 리스트가 비어있다면 true를 리턴합니다. 
	 * 
	 * @return true if list is empty
	 * 리스트가 비어있다면 true를 리턴합니다. 
	 */
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * Prints contents of the list
	 * 리스트의 원소들을 출력합니다.
	 * 
	 */
	public void display(){ //Prints contents of the list  리스트의 원소들을 출력합니다. 
		Link current = head;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}

/**
 * This class is used to implement the nodes of the
 * linked list.
 * 이 클래스는 linked list의 node들을 구현하기 위해 쓰입니다. 
 * 
 * @author Unknown
 *
 */
class Link{
	/** Value of node 
	 * 노드의 값
	 * */
	public int value;
	/** This points to the link in front of the new link 
	 *  이것은 새로운 링크의 다음 링크를 가르킵니다. 
	 * */
	public Link next;
	/** This points to the link behind the new link 
	 * 이것은 새로운 링크의 뒷 링크를 가르킵니다. 
	 * */
	public Link previous;

	/**
	 * Constructor
	 * 생성자
	 * 
	 * @param value Value of node
	 * value 는 노드에 들어가는 값입니다. 
	 */
	public Link(int value){
		this.value = value;
	}

	/**
	 * Displays the node
	 * node를 출력합니다. 
	 */
	public void displayLink(){
		System.out.print(value+" ");
	}

	/**
	 * Main Method
	 * 메인 메서드
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String args[]){
		DoublyLinkedList myList = new DoublyLinkedList();

		myList.insertHead(13);
		myList.insertHead(7);
		myList.insertHead(10);
		myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

		myList.insertTail(11);
		myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

		myList.deleteTail();
		myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

		myList.delete(7);
		myList.display(); // <-- 10(head) <--> 13(tail) -->

		myList.insertOrdered(23);
		myList.insertOrdered(67);
		myList.insertOrdered(3);
		myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
	}
}