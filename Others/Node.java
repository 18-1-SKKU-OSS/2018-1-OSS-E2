public class Node {
	 public Object anElement;
	 public Node less;
	 public Node greater;
	 /** 
	  * an empty node at the end will be by itself with no children, therefore the other 2 parameters are always null
	  * obviously the node can still be a child of other elements
	  * ��� �ִ� ���� �ڽ� ���� �ڱ� �ڽ��� ����ŵ�ϴ�. �׷��Ƿ� less, grater ���� �׻� null�Դϴ�. 
	  * ���� �ٸ� ����� �ڽ� ��尡 �� �� �ֽ��ϴ�. 
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
