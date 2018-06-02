import java.util.LinkedList;

/**
*
* @author Varun Upadhyay (https://github.com/varunu28)
* @Translator Jaehun Lee
*/


// Driver Program
public class TreeTraversal {
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Prints 5 3 2 4 7 6 8
        System.out.println("Pre order traversal:");
        tree.printPreOrder();
        System.out.println();
        // Prints 2 3 4 5 6 7 8
        System.out.println("In order traversal:");
        tree.printInOrder();
        System.out.println();
        // Prints 2 4 3 6 8 7 5
        System.out.println("Post order traversal:");
        tree.printPostOrder();
        System.out.println();
        // Prints 5 3 7 2 4 6 8
        System.out.println("Level order traversal:");
        tree.printLevelOrder();
        System.out.println();
    }
}

/**
* The Node class which initializes a Node of a tree
* Consists of all 3 (+1) traversal methods: printInOrder, printPostOrder & printPreOrder and printLevelOrder
* printInOrder: LEFT -> ROOT -> RIGHT
* printPreOrder: ROOT -> LEFT -> RIGHT
* printPostOrder: LEFT -> RIGHT -> ROOT
* printLevelOrder: Prints by level (starting at root), from left to right.

--In Korean
* 트리의 노드를 초기화하는 노드 클래스
* 3(+1)가지의 순회 메소드로 구성됨 : printInOrder, printPostOrder & printPreOrder 그리고 printLevelOrder
* printInOrder: 왼쪽 -> ROOT -> 오른쪽
* printPreOrder: Root -> 왼쪽 -> 오른쪽
* printPostOrder: 왼쪽 -> 오른쪽 -> ROOT
* printLevelOrder: 레벨에 의한 출력 (root부터 시작), 왼쪽부터 오른쪽으로.
*/
class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert (int value) {
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if (right == null) {
                right = new Node(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(data + " ");
    }

    /**
    * O(n) time algorithm.
    * 시간복잡도 O(n)
    * Uses O(n) space to store nodes in a queue to aid in traversal.
    * 순회를 돕기 위한 큐에 노드를 저장하기 위해 O(n)의 공간을 사용한다.
    */
    public void printLevelOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0) {
            Node head = queue.remove();
            System.out.print(head.data + " ");
            // Add children of recently-printed node to queue, if they exist.
	    // 만약 존재한다면, 최근에 출력된 노드의 자식들을 큐에 추가한다.
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
