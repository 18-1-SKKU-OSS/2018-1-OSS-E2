package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SortAlgorithm
 *
 */
public class BinaryTreeSort implements SortAlgorithm {

	interface TreeVisitor<T extends Comparable<T>>  {
		void visit(Node<T> node);
	}

	// 노드의 값을 얻기
	private static class SortVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

		private final T[] array;
		private int counter;

		SortVisitor(T[] array) {
			this.array = array;
		}

		@Override
		public void visit(Node<T> node) {
			array[counter++] = node.value;
		}
	}

	// 노드를 나타낸 클래스
	private static class Node<T extends Comparable<T>>{
		// 노드가 가지는 값과 자식 노드들(left, right)
		private T value;
		private Node<T> left;
		private Node<T> right;

		
		Node(T value) {
			this.value = value;
		}

		// 자식 노드 추가
		void insert(Node<T> node) {
			if (less(node.value, value)){
				if (left != null) left.insert(node);
				else left = node;
			}
			else {
				if (right != null) right.insert(node);
				else right = node;
			}
		}

		// 노드 찾기
		void traverse(TreeVisitor<T> visitor) {
			if ( left != null)
				left.traverse(visitor);

			visitor.visit(this);

			if ( right != null )
				right.traverse(visitor );
		}

	}


	@Override
	public  <T extends Comparable<T>> T[] sort(T[] array) {

		// 배열 순서대로 이진 트리에 넣는다.
		Node<T> root = new Node<>(array[0]);
		for (int i = 1; i < array.length; i++) {
			root.insert(new Node<>(array[i]));
		}

		root.traverse(new SortVisitor<>(array));

		return array;
	}

	// 정수형, 실수형, 문자열형 배열을 이용해 정렬 수행
	public static void main(String args[]) {

		Integer[] intArray = {12, 40, 9, 3, 19, 74, 7, 31, 23, 54, 26, 81, 12};
		BinaryTreeSort treeSort = new BinaryTreeSort();
		Integer[] sorted = treeSort.sort(intArray);
		print(sorted);

		Double[] decimalArray = {8.2, 1.5, 3.14159265, 9.3, 5.1, 4.8, 2.6};
		print(treeSort.sort(decimalArray));

		String[] stringArray = {"c", "a", "e", "b","d", "dd","da","zz", "AA", "aa","aB","Hb", "Z"};
		print(treeSort.sort(stringArray));
	}

}

