public class CircleLinkedList<E>{
     private static class Node<E>{
         Node<E> next;
         E value;
         private Node(E value, Node<E> next){
              this.value = value;
              this.next = next;
         }
     }
     //For better O.O design this should be private allows for better black box design
     private int size; 
     //this will point to dummy node;
     //이것은 더미 노드를 가르킵니다. 
     private Node<E> head; 
     //constructor for class.. here we will make a dummy node for circlar linked list implementation with reduced error catching as our list will never be empty
     //클래스의 생성자 여기서 우리는 원형 연결 리스트의 더미 노드를 만들 것인데 리스트가 절대로 비어있지 않게 되므로 오류가 줄어듭니다. 
     public CircleLinkedList(){ 
          //creation of the dummy node
    	 // 더미노드 생성
         head = new Node<E>(null,head); 
         size = 0;
     }
      // getter for the size... needed because size is private.
     // 리스트의 사이즈를 얻습니다. size변수가 private이기 때문에 필요합니다. 
     public int getSize(){ return size;} 
     // for the sake of simplistiy this class will only contain the append function or addLast other add functions can be implemented however this is the basses of them all really.
     // 간단한 구현을 위해 이 클래스는 오직 덧붙이기(마지막에 추가) 함수만 가지고 있을 것입니다. 그러나 그것은 다른 것의 베이스가 될것입니다.  
     public void append(E value){ 
         if(value == null){
          // we do not want to add null elements to the list.
          // 리스트에 null을 추가하지 않습니다. 
         	throw new NullPointerException("Cannot add null element to the list"); 
         }
          //head.next points to the last element;
          //head.next는 마지막 원소를 가르킵니다. 
         head.next = new Node<E>(value,head); 
         size++;}
     public E remove(int pos){
     	if(pos>size || pos< 0){
               //catching errors
     		   //에러를 잡습니다. 
     		throw new IndexOutOfBoundsException("position cannot be greater than size or negative"); 
     	}
     	Node<E> iterator = head.next; 
          //we need to keep track of the element before the element we want to remove we can see why bellow.
     	  //우리가 지우고자 하는 원소를 찾을 때 까지 원소를 따라가야만 합니다. 
     	Node<E> before = head;
     	for(int i = 1; i<=pos; i++){
            iterator = iterator.next;
            before = before.next;   
     	}
     	E saved = iterator.value;
          // assigning the next reference to the the element following the element we want to remove... the last element will be assigned to the head.
     	  //next를 우리가 지우고자하는 것의 다음 노드로 지정합니다. 마지막 원소는 head에 지정 될것입니다. 
     	before.next = iterator.next; 
          // scrubbing 
     	iterator.next = null; 
     	iterator.value = null; 
     	return saved;

     	}

     }

