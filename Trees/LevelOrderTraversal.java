class Node
{
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
public class LevelOrderTraversal
{
    // Root of the Binary Tree
    // 이진 트리의 루트
    Node root;
 
    public LevelOrderTraversal()
    {
        root = null;
    }
 
    /* function to print level order traversal of tree*/
    /* 트리의 레벨 순서 순회 출력을 위한 메소드 */
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/

    /* 트리의 "높이" -- 루트노드에서 가장 멀리 있는 리프
       노드까지 있는 노드의 갯수 -- 를 계산 */
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
	    // 각 하위 트리의 높이 계산
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
	    // 더 큰 것 사용
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    /* Print nodes at the given level */
    // 주어진 레벨에서 노드들 출력
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
     
    /* Driver program to test above functions */
    public static void main(String args[])
    {
       LevelOrderTraversal tree = new LevelOrderTraversal();
       tree.root= new Node(1);
       tree.root.left= new Node(2);
       tree.root.right= new Node(3);
       tree.root.left.left= new Node(4);
       tree.root.left.right= new Node(5);
        
       System.out.println("Level order traversal of binary tree is ");
       tree.printLevelOrder();
    }
}
