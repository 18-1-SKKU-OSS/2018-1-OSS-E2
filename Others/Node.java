public class Node {
	 public Object anElement;
	 public Node less;
	 public Node greater;
	 /** 
	  * an empty node at the end will be by itself with no children, therefore the other 2 parameters are always null
	  * obviously the node can still be a child of other elements
	  * 비어 있는 노드는 자식 없이 자기 자신을 가르킵니다. 그러므로 less, grater 노드는 항상 null입니다. 
	  * 노드는 다른 노드의 자식 노드가 될 수 있습니다. 
	  * */
	 public Node(Object theElement) {
	    this(theElement, null, null);
    }
	 
	 public Node(Object currentElement, Node lessSide, Node greaterSide) {
	  anElement = currentElement;
	  this.less = lessSide;
	  this.greater = greaterSide;
	 }
}
