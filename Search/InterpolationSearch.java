package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 *
 * Interpolation search algorithm implementation
 *
 * �־��� ���	 O(n)
 * �ֻ��� ���	O(1)
 * ���	O(log(log(n))) ��Ұ� �����ϰ� �������� ���� ��� O(n)
 * �־��� ��� �������⵵	O(1)
 *
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */
class InterpolationSearch {


	/**
	 * @param array�� ���ĵ� �迭�Դϴ�.
	 * @param key�� �迭�ȿ��� ã�ƾ� �ϴ� ���Դϴ�
	 * @return an index->�迭�� Ű���� ������ ������ �ε����� �����մϴ� unless -1
	 */
	public int find(int array[], int key) {
		// ���ʳ�, ������ �������� ã�´�
		int start = 0, end = (array.length - 1);
	
		// �迭�� ��Ʈ�Ǳ� (����) ������, ��Ұ� �����մϴ�.
		// �迭�� ���ǵ� ���� ���� �־���մϴ�.
		while (start <= end && key >= array[start] && key <= array[end])
		{
			// ������ �Բ� ��ġ Ž��
			// ������ ������ ���ο� �ξ���մϴ�.
			int pos = start + (((end-start) / (array[end]-array[start]))*(key - array[start]));
	
			// �߰ߵ� Ÿ���� ����
			if (array[pos] == key)
				return pos;
	
			// Ű�� ũ��, Ű�� ���ʿ� �ֽ��ϴ�.
			if (array[pos] < key)
				start = pos + 1;
	
			// Ű�� ������ x�� �Ʒ� �κп� �ֽ��ϴ�.
			else
				end = pos - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int size = 100;
		int maxElement = 100000;
		int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();


		//�߰ߵǾ�� �� ���
		Integer shouldBeFound = integers[r.nextInt(size - 1)];

		InterpolationSearch search = new InterpolationSearch();
		int atIndex = search.find(integers, shouldBeFound);

		System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
				, shouldBeFound, integers[atIndex], atIndex, size));


		int toCheck = Arrays.binarySearch(integers, shouldBeFound);
		System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
	}
}

