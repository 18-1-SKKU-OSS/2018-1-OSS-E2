/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * Translator Jaehun Lee
 */
import java.util.LinkedList;

public class FindHeightOfTree {

    // Driver Program
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(-1);
        tree.insert(29);
        tree.insert(93);
        tree.insert(6);
        tree.insert(0);
        tree.insert(-5);
        tree.insert(-6);
        tree.insert(-8);
        tree.insert(-1);

        // A level order representation of the tree
	// 트리의 레벨 오더 표현
        tree.printLevelOrder();
        System.out.println();

        System.out.println("Height of the tree is: " + tree.findHeight());
    }
}

/**
 * The Node class which initializes a Node of a tree
 * printLevelOrder: ROOT -> ROOT's CHILDREN -> ROOT's CHILDREN's CHILDREN -> etc
 * findHeight: Returns the height of the tree i.e. the number of links between root and farthest leaf

 * 트리의 노드를 초기화하는 노드 클래스
 * printLevelOrder: ROOT -> ROOT의 자식 -> ROOT의 자식의 자식 -> etc
 * findHeihgt: tree의 높이를 반환한다. 즉, 루트와 가장 먼 리프 노드와의 link의 수를 반환한다.
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

    public void printLevelOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.data + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public int findHeight() {
        return findHeight(this);
    }

    private int findHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        else if (root.left != null && root.right != null) {
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }
        else if (root.left == null && root.right != null) {
            return 1 + findHeight(root.right);
        }
        else {
            return 1 + findHeight(root.left);
        }
    }
}

