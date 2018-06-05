// Java program to print top view of Binary tree
// 이진 트리의 상위 뷰를 출력하는 자바 프로그램
import java.util.*;
 
// Class for a tree node
// 트리 노드를 위한 클래스
class TreeNode
{
    // Members
    // 멤버들
    int key;
    TreeNode left, right;
 
    // Constructor
    // 생성자
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}
 
// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
// distance of node from root
/* 큐 아이템을 표현하기 위한 클래스. 큐는 레벨 순서 순회에 사용된다. 
   모든 큐 아이템은 노드와 루트로 부터 수평의 거리를 가진다.
*/
class QItem
{
   TreeNode node;
   int hd;
   public QItem(TreeNode n, int h)
   {
        node = n;
        hd = h;
   }
}
 
// Class for a Binary Tree
// 이진 트리를 위한 클래스
class Tree
{
    TreeNode root;
 
    // Constructors
    // 생성자
    public Tree()  { root = null; }
    public Tree(TreeNode n) { root = n; }
 
    // This method prints nodes in top view of binary tree
    // 이 메소드는 이진트리의 상위 뷰로 노드들을 출력한다.
    public void printTopView()
    {
        // base case
	// 베이스 케이스
        if (root == null) {  return;  }
 
        // Creates an empty hashset
	// 빈 해쉬세트를 생성
        HashSet<Integer> set = new HashSet<>();
 
        // Create a queue and add root to it
	// 큐를 생성하고 루트를 이것에 더한다.
        Queue<QItem> Q = new LinkedList<QItem>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0
 				   // 루트의 수평 거리가 0이다.

        // Standard BFS or level order traversal loop
	// 표준 BFS 또는 레벨 순서 순회 반복
        while (!Q.isEmpty())
        {
            // Remove the front item and get its details
	    // 앞부분을 제거하고 그 세부 사항을 얻는다.
            QItem qi = Q.remove();
            int hd = qi.hd;
            TreeNode n = qi.node;
 
            // If this is the first node at its horizontal distance,
            // then this node is in top view
	    // 만약 수평 거리에서 이것이 처음 노드라면
	    // 이 노드는 상위 뷰에 있다.
            if (!set.contains(hd))
            {
                set.add(hd);
                System.out.print(n.key + " ");
            }
 
            // Enqueue left and right children of current node
	    // 현재 노드의 왼쪽 그리고 오른쪽 자식을 Enqueue(삽입)한다.
            if (n.left != null)
                Q.add(new QItem(n.left, hd-1));
            if (n.right != null)
                Q.add(new QItem(n.right, hd+1));
        }
    }
}
 
// Driver class to test above methods
// 상위 메소드를 테스트하기 위한 드라이버 클래스
public class PrintTopViewofTree
{
    public static void main(String[] args)
    {
        /* Create following Binary Tree    다음과 같은 이진 트리를 생성한다.
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();
    }
}
