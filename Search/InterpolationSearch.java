package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 *
 * Interpolation search algorithm implementation
 *
 * 최악의 경우	 O(n)
 * 최상의 경우	O(1)
 * 평균	O(log(log(n))) 요소가 균일하게 분포하지 않은 경우 O(n)
 * 최악의 경우 공간복잡도	O(1)
 *
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */
class InterpolationSearch {


	/**
	 * @param array는 정렬된 배열입니다.
	 * @param key는 배열안에서 찾아야 하는 값입니다
	 * @return an index->배열이 키값을 가지고 있으면 인덱스를 리턴합니다 unless -1
	 */
	public int find(int array[], int key) {
		// 왼쪽끝, 오른쪽 끝값들을 찾는다
		int start = 0, end = (array.length - 1);
	
		// 배열이 소트되기 (위해) 때문에, 요소가 존재합니다.
		// 배열은 정의된 범위 내에 있어야합니다.
		while (start <= end && key >= array[start] && key <= array[end])
		{
			// 유지와 함께 위치 탐색
			// 균일한 분포를 염두에 두어야합니다.
			int pos = start + (((end-start) / (array[end]-array[start]))*(key - array[start]));
	
			// 발견될 타겟의 조건
			if (array[pos] == key)
				return pos;
	
			// 키가 크면, 키가 위쪽에 있습니다.
			if (array[pos] < key)
				start = pos + 1;
	
			// 키가 작으면 x가 아래 부분에 있습니다.
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


		//발견되어야 할 요소
		Integer shouldBeFound = integers[r.nextInt(size - 1)];

		InterpolationSearch search = new InterpolationSearch();
		int atIndex = search.find(integers, shouldBeFound);

		System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
				, shouldBeFound, integers[atIndex], atIndex, size));


		int toCheck = Arrays.binarySearch(integers, shouldBeFound);
		System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
	}
}

