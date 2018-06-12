package sort;

import static sort.SortUtils.*;

/**
 *
 * @author Mateus Bizzo (https://github.com/MattBizzo)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */

/*
칵테일 셰이커 알고리즘은 버블 정렬의 비교 횟수를 줄이기 위해 버블 정렬을 변형한 정렬 알고리즘이다. 
좌측 지점부터 우측 지점까지 정렬을 진행한다. 마지막 교환이 이루어진 곳을 우측 지점으로 설정한 후 우측 지점부터 좌측 지점까지 정렬을 진행한다. 이 과정을 정렬이 완료될 때까지 반복한다.
*/

class CocktailShakerSort implements SortAlgorithm {

	/**
	 * This method implements the Generic Cocktail Shaker Sort
	 *
	 * @param array The array to be sorted
	 * Sorts the array in increasing order
	 **/

	@Override
	public <T extends Comparable<T>> T[] sort(T[] array){

		// 우측 지점 설정
		int last = array.length;
		
		// Sorting
		boolean swap;
		do {
			swap = false;
			
			//front //좌측부터 우측까지 정렬
			for (int count = 0; count <= last - 2; count++) {
				if (less(array[count + 1], array[count])) {
					swap = swap(array, count, count + 1);
				}
			}
			//break if no swap occurred // 정렬할 게 없다면 정렬 종료
			if (!swap) {
				break;
			}
			swap = false;
			
			//back // 우측부터 좌측까지 정렬
			for (int count = last - 2; count >= 0; count--) {
				if (less(array[count + 1], array[count])) {
					swap = swap(array, count, count + 1);
				}
			}
			last--;
		//end
		} while (swap);
		return array;
	}

	// Driver Program
	// 정수형, 문자열형 배열으로 칵테일 셰이커 정렬 실행
	public static void main(String[] args) {
		// Integer Input
		Integer[] integers = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		CocktailShakerSort shakerSort = new CocktailShakerSort();

		// Output => 1 4 6 9 12 23 54 78 231
		print(shakerSort.sort(integers));

		// String Input
		String[] strings = { "c", "a", "e", "b", "d" };
		print(shakerSort.sort(strings));
	}


}
