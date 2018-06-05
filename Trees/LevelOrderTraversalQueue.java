import java.util.Queue;
import java.util.LinkedList;
 
/* Class to represent Tree node */
// 트리 노드 표현을 위한 클래스
class Node {
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}
 
/* Class to print Level Order Traversal */
// 레벨 순서 순회를 출력하기 위한 클래스
public class LevelOrderTraversalQueue {
 
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    /* 이진 트리가 주어진다. 이것의 노드들을 큐 구현을 위한 배열을
     사용하여 레벨 순서로 출력한다. */
    void printLevelOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
 
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
	    /* poll()은 현재 헤드를 제거한다.
		더 자세한 정보는 위의 링크.
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            /*Enqueue left child */
	    /*왼쪽 자식 삽입 (Enqueue)*/
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
	    /*오른쪽 자식 삽입 (Enqueue)*/
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
 
    public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
	/* 이진트리를 생성하고 노드에 접근한다.*/
    	LevelOrderTraversalQueue tree_level = new LevelOrderTraversalQueue();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
