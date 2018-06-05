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
 
public class ValidBSTOrNot
{
    //Root of the Binary Tree
    //이진 트리의 Root
    Node root;
 
    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. 
    당신의 코드에 따라 최소와 최대 값을 줄 수 있거나 트리의 최소
    혹은 최대 값을 찾는 메소드를 작성할 수 있다. */
 
    /* returns true if given search tree is binary
     search tree (efficient version) 
     만약 주어진 탐색 트리가 이진 탐새 트리라면 true를
     반환한다.*/
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. 
      만약 주어진 트리가 이진 탐색 트리이고 그것의 값이
      최소보다 크고 최대보다 작다면 true를 반환한다.*/
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
	/* 빈 트리는 이진 탐색 트리이다. */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
	/* 만약 이 노드가 최소/최대 제약을 위반한다면 false */
        if (node.data < min || node.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints 
	그렇지 않으면 하위 트리를 재귀적으로 확인하여
	최소/최대 제약을 유지합니다.*/
        // Allow only distinct values
	// 중복되지 않는 값만 허용
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
 
    /* Driver program to test above functions */
    /* 위의 메소드를 테스트하기 위한 드라이버 프로그램 */
    public static void main(String args[])
    {
        ValidBSTOrNot tree = new ValidBSTOrNot();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
