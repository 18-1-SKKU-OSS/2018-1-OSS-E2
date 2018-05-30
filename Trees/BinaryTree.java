/**
* This entire class is used to build a Binary Tree data structure.
* There is the Node Class and the Tree Class, both explained below.
*
* @author Unknown
*
*/


/**
* This class implements the nodes that will go on the Binary Tree.
* They consist of the data in them, the node to the left, the node
* to the right, and the parent from which they came from.
*
* @author Unknown
*
*/
class Node{
	/** 노드에 들어갈 데이터 */
	public int data;
	/** 이것의 왼쪽 자식 노드 */
	public Node left;
	/** 이것의 오른쪽 자식 노드 */
	public Node right;
	/** 이것의 부모 노드 */
	public Node parent;

	/**
	* 노드의 생성자
	*
	* @param value Value to put in the node
	*/
	public Node(int value){
		data = value;
		left = null;
		right = null;
		parent = null;
	}
}


/**
* 이진 트리는 한 요소에 두 개의 하위 요소 (자식 - children)이 있는 자료구조입니다.
* 왼쪽 자식은 보통 부모보다 작고
* 오른쪽 자식은 보통 부모보다 더 큽니다.
*
* @author 이재훈
*
*/
class Tree{
	/** 이진 트리의  루트*/
	private Node root;

	/**
	* 생성자
	*/
	public Tree(){
		root = null;
	}

	/**
	* 특정 값을 가진 노드를 찾는 메소드
	*
	* @param 찾고 있는 키 값
	* @만약 키 노드를 찾았다면 그 값을 반환하고,  아니라면 부모를 반환합니다.
	*/
	public Node find(int key) {
		Node current = root;
		while (current != null) {
			if(key < current.data) {
				current = current.left;
			} else if(key > current.data) {
				current = current.right;
			} else {	// 값을 찾았다면 반환합니다.
				return current;
			}
		}
		return null;
	}

	/**
	* 특정 값을 이진 트리로 삽입합니다.
	*
	* @param value 삽입 될 
	*/
	public void put(int value){
		Node newNode = new Node(value);
		if(root == null)
		root = newNode;
		else{
			//이것은 곧 삽입 할 값의 상위가 될 것입니다.
			Node parent = find(value);

			//이 if/else 문은 새 노드를 부모의 왼쪽 혹은 오른쪽 자식 노드로 지정합니다.
			if(value < parent.data){
				parent.left = newNode;
				parent.left.parent = parent;
				return;
			}
			else{
				parent.right = newNode;
				parent.right.parent = parent;
				return;
			}
		}
	}

	/**
	* 주어진 값을 이진 트리에서 삭제합니다.
	*
	* @param value 지워질 값
	* @그 값이 지워졌다면 반환합니다. (return 합니다.)
	*/
	public boolean remove(int value){
		//temp 는 지워질 노드입니다.
		Node temp = find(value);

		//그 값이 존재하지 않는다면,
		if(temp.data != value)
		return false;

		//자식이 없음.
		if(temp.right == null && temp.left == null){
			if(temp == root)
			root = null;

			//This if/else assigns the new node to be either the left or right child of the parent
			else if(temp.parent.data < temp.data)
			temp.parent.right = null;
			else
			temp.parent.left = null;
			return true;
		}

		//Two children
		else if(temp.left != null && temp.right != null){
			Node successor = findSuccessor(temp);

			//The left tree of temp is made the left tree of the successor
			successor.left = temp.left;
			successor.left.parent = successor;

			//If the successor has a right child, the child's grandparent is it's new parent
			if(successor.right != null && successor.parent != temp){
				successor.right.parent = successor.parent;
				successor.parent.left = successor.right;
				successor.right = temp.right;
				successor.right.parent = successor;
			}
			if(temp == root){
				successor.parent = null;
				root = successor;
				return true;
			}

			//If you're not deleting the root
			else{
				successor.parent = temp.parent;

				//This if/else assigns the new node to be either the left or right child of the parent
				if(temp.parent.data < temp.data)
				temp.parent.right = successor;
				else
				temp.parent.left = successor;
				return true;
			}
		}
		//One child
		else{
			//If it has a right child
			if(temp.right != null){
				if(temp == root){
					root = temp.right; return true;}

					temp.right.parent = temp.parent;

					//Assigns temp to left or right child
					if(temp.data < temp.parent.data)
					temp.parent.left = temp.right;
					else
					temp.parent.right = temp.right;
					return true;
				}
				//If it has a left child
				else{
					if(temp == root){
						root = temp.left; return true;}

						temp.left.parent = temp.parent;

						//Assigns temp to left or right side
						if(temp.data < temp.parent.data)
						temp.parent.left = temp.left;
						else
						temp.parent.right = temp.left;
						return true;
					}
				}
			}

			/**
			* This method finds the Successor to the Node given.
			* Move right once and go left down the tree as far as you can
			*
			* @param n Node that you want to find the Successor of
			* @return The Successor of the node
			*/
			public Node findSuccessor(Node n){
				if(n.right == null)
				return n;
				Node current = n.right;
				Node parent = n.right;
				while(current != null){
					parent = current;
					current = current.left;
				}
				return parent;
			}

			/**
			* Returns the root of the Binary Tree
			*
			* @return the root of the Binary Tree
			*/
			public Node getRoot(){
				return root;
			}

			/**
			* Prints leftChild - root - rightChild
			*
			* @param localRoot The local root of the binary tree
			*/
			public void inOrder(Node localRoot){
				if(localRoot != null){
					inOrder(localRoot.left);
					System.out.print(localRoot.data + " ");
					inOrder(localRoot.right);
				}
			}

			/**
			* Prints root - leftChild - rightChild
			*
			* @param localRoot The local root of the binary tree
			*/
			public void preOrder(Node localRoot){
				if(localRoot != null){
					System.out.print(localRoot.data + " ");
					preOrder(localRoot.left);
					preOrder(localRoot.right);
				}
			}

			/**
			* Prints rightChild - leftChild - root
			*
			* @param localRoot The local root of the binary tree
			*/
			public void postOrder(Node localRoot){
				if(localRoot != null){
					postOrder(localRoot.left);
					postOrder(localRoot.right);
					System.out.print(localRoot.data + " ");
				}
			}
		}
