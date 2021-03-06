package sort;

import static sort.SortUtils.*;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SortAlgorithm
 *
 */
/*
가장 작은 값을 찾아서 swap하는 방식으로 정렬하는 알고리즘이다.
*/

public class SelectionSort implements SortAlgorithm {

    /**
     * This method implements the Generic Selection Sort
     *
     * @param arr The array to be sorted
     * Sorts the array in increasing order // 오름차순으로 정렬한다.
     **/
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Initial index of min // min의 값 초기화
            int min = i;

            for (int j = i +1 ; j < n; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }

            // Swapping if index of min is changed // 최솟값인 min이 변경되었다면 swap하여 정렬한다.
            if (min != i) {
                swap(arr, i , min);
            }
        }

        return arr;
    }


// 상수형 배열과 문자열형 배열으로 Selection Sort 실행
    // Driver Program
    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        SelectionSort selectionSort = new SelectionSort();

        Integer[] sorted = selectionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        String[] sortedStrings = selectionSort.sort(strings);

        //Output => a	b	 c  d	e
        print(sortedStrings);
    }
}
