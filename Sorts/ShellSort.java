package sort;

import static sort.SortUtils.*;


/**
 * @author dpunosevac
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SortAlgorithm
 *
 */

/*
셸 정렬은 삽입 정렬과 달리 전체 배열(리스트)을 한 번에 정렬하지 않는다. 대신 먼저 정렬해야 할 리스트를 일정한 기준(gap, 일반적으로 gap = 3n+1이다)에 따라 분류하여 연속적이지 않은 여러 부분 리스트를 만들고, 각 부분 리스트를 삽입 정렬을 이용하여 정렬한다.
*/

public class ShellSort implements SortAlgorithm {

  /**
   * This method implements Generic Shell Sort.
   * @param array The array to be sorted
   */
  @Override
  public <T extends Comparable<T>> T[] sort(T[] array) {
    int N = array.length;
    int h = 1;

  // 여기서는 h가 위 설명에서의 gap을 의미한다. h를 구함.
    while (h < N/3) {
        h = 3 * h + 1;
    }

// 나눈 리스트들에 대하여 삽입 정렬을 실행한다.
    while (h >= 1) {
        for (int i = h; i < N; i++) {
            for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                swap(array, j, j - h);
            }
        }

        h /= 3;
    }

    return array;
  }

// 정수형 배열을 이용해 shell sort를 수행한다.
  public static void main(String[] args) {
      Integer[] toSort = {4, 23, 6, 78, 1, 54, 231, 9, 12};

      ShellSort sort = new ShellSort();
      Integer[] sorted = sort.sort(toSort);

      print(sorted);

  }
}
