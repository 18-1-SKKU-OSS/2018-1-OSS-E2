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
�� ������ ���� ���İ� �޸� ��ü �迭(����Ʈ)�� �� ���� �������� �ʴ´�. ��� ���� �����ؾ� �� ����Ʈ�� ������ ����(gap, �Ϲ������� gap = 3n+1�̴�)�� ���� �з��Ͽ� ���������� ���� ���� �κ� ����Ʈ�� �����, �� �κ� ����Ʈ�� ���� ������ �̿��Ͽ� �����Ѵ�.
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

  // ���⼭�� h�� �� �������� gap�� �ǹ��Ѵ�. h�� ����.
    while (h < N/3) {
        h = 3 * h + 1;
    }

// ���� ����Ʈ�鿡 ���Ͽ� ���� ������ �����Ѵ�.
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

// ������ �迭�� �̿��� shell sort�� �����Ѵ�.
  public static void main(String[] args) {
      Integer[] toSort = {4, 23, 6, 78, 1, 54, 231, 9, 12};

      ShellSort sort = new ShellSort();
      Integer[] sorted = sort.sort(toSort);

      print(sorted);

  }
}
