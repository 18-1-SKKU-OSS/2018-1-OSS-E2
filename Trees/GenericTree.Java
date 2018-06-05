import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class treeclass {
	private class Node {
		int data;
		ArrayList<Node> child = new ArrayList<>();
	}

	private Node root;
	private int size;

	/*
	일반 트리는 될 수있는 한 많은 자식을 가질 수있는 트리입니다.
	존재하는 모든 노드가 루트 노드에 직접 연결될 수 있습니다.

	이 코드에서 모든 함수에는 두 개의 복사본이 있습니다. 
	한 함수는 main에서 호출 할 수있는 보조 함수이며 실제 함수를 호출하는 private 함수가 호출됩니다. 
	main 호출을 호출 할 때 최소한의 매개 변수를 주어야합니다.

	*/
	public treeclass() {     //생성자
		Scanner scn = new Scanner(System.in);
		root = create_treeG(null, 0, scn);
	}

	private Node create_treeG(Node node, int childindx, Scanner scn) {
		// 보여주기
		if (node == null) {
			System.out.println("Enter root's data");
		} else {
			System.out.println("Enter data of parent of index " + node.data + " " + childindx);
		}
		// input
		node = new Node();
		node.data = scn.nextInt();
		System.out.println("number of children");
		int number = scn.nextInt();
		for (int i = 0; i < number; i++) {
			Node childd = create_treeG(node, i, scn);
			size++;
			node.child.add(childd);
		}
		return node;
	}

	/*
	일반 트리를 보여주기 위한 메소드
	*/
	public void display() {  //Helper 메소드
		display_1(root);
		return;
	}

	private void display_1(Node parent) {
		System.out.print(parent.data + "=>");
		for (int i = 0; i < parent.child.size(); i++) {
			System.out.print(parent.child.get(i).data + " ");
		}
		System.out.println(".");
		for (int i = 0; i < parent.child.size(); i++) {
			display_1(parent.child.get(i));
		}
		return;
	}

	/*
	 One call store the size directly but if you are asked compute size this function to calcuate
	 size goes as follows
	한번의 호출은 크기를 바로 저장하지만 만약 당신이 이 함수가 크기를 계산하기를 요청한다면 
	크기는 다음과 같이 된다.
	 */

	public int size2call() {
		return size2(root);
	}

	public int size2(Node roott) {
		int sz = 0;
		for (int i = 0; i < roott.child.size(); i++) {
			sz += size2(roott.child.get(i));
		}
		return sz + 1;
	}

	/*
	Function to compute maximum value in the generic tree
	일반 트리에서 최대값을 계산하기 위한 메소드
	*/
	public int maxcall() {
		int maxi = root.data;
		return max(root, maxi);
	}

	private int max(Node roott, int maxi) {
		if (maxi < roott.data)
			maxi = roott.data;
		for (int i = 0; i < roott.child.size(); i++) {
			maxi = max(roott.child.get(i), maxi);
		}

		return maxi;
	}

	/*
	Function to compute HEIGHT of the generic tree
	일반 트리에서 높이를 계산하기 위한 메소드
	*/

	public int heightcall() {
		return height(root) - 1;
	}

	private int height(Node node) {
		int h = 0;
		for (int i = 0; i < node.child.size(); i++) {
			int k = height(node.child.get(i));
			if (k > h)
				h = k;
		}
		return h + 1;
	}

	/*
	Function to find whether a number is present in the generic tree or not
	일반 트리에서 숫자가 있는지 없는지를 찾는 메소드
	*/

	public boolean findcall(int info) {
		return find(root, info);
	}

	private boolean find(Node node, int info) {
		if (node.data == info)
			return true;
		for (int i = 0; i < node.child.size(); i++) {
			if (find(node.child.get(i), info))
				return true;
		}
		return false;
	}

	/*
	Function to calculate depth of generic tree
	일반 트리에서 깊이를 계산하기 위한 메소드
	*/
	public void depthcaller(int dep) {
		depth(root, dep);
	}

	public void depth(Node node, int dep) {
		if (dep == 0) {
			System.out.println(node.data);
			return;
		}
		for (int i = 0; i < node.child.size(); i++)
			depth(node.child.get(i), dep - 1);
		return;
	}

	/*
	Function to print generic tree in pre-order
	pre-order로 일반 트리를 출력하는 메소드
	*/
	public void preordercall() {
		preorder(root);
		System.out.println(".");
	}

	private void preorder(Node node) {
		System.out.print(node.data + " ");
		for (int i = 0; i < node.child.size(); i++)
			preorder(node.child.get(i));
	}

	/*
	Function to print generic tree in post-order
	post-order로 일반 트리를 출력하는 메소드
	*/
	public void postordercall() {
		postorder(root);
		System.out.println(".");
	}

	private void postorder(Node node) {
		for (int i = 0; i < node.child.size(); i++)
			postorder(node.child.get(i));
		System.out.print(node.data + " ");
	}

	/*
	Function to print generic tree in level-order
	level-order로 일반 트리를 출력하는 
	*/

	public void levelorder() {
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(root);
		while (!q.isEmpty()) {
			int k = q.getFirst().data;
			System.out.print(k + " ");

			for (int i = 0; i < q.getFirst().child.size(); i++) {
				q.addLast(q.getFirst().child.get(i));
			}
			q.removeFirst();
		}
		System.out.println(".");
	}

	/*
	 Function to remove all leaves of generic tree
	 일반 트리에서 모든 leaf들을 제거하는 메소드
	 */
	public void removeleavescall() {
		removeleaves(root);
	}

	private void removeleaves(Node node) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < node.child.size(); i++) {
			if (node.child.get(i).child.size() == 0) {
				arr.add(i);
				// node.child.remove(i);
				// i--;
			} else
				removeleaves(node.child.get(i));
		}
		for (int i = arr.size() - 1; i >= 0; i--) {
			node.child.remove(arr.get(i) + 0);
		}
	}

