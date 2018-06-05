package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */

class InsertionSort implements SortAlgorithm {

    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     *
     * @param array The array to be sorted
     *
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int j = 1; j < array.length; j++) {

            // Picking up the key(Card) 키 받기
            T key = array[j];
            int i = j - 1;

            while (i >= 0 && less(key, array[i])) {
                array[i + 1] = array[i];
                i--;
            } // key보다 작은 값을 찾을 때까지 뒤로 배열을 한 칸씩 미룬다.

            // Placing the key (Card) at its correct position in the sorted subarray
	 // key를 적절한 위치에 넣는다.
            array[i + 1] = key;
        }
        return array;
    }

/*상수와 문자열 배열로 Insertion sort 실행*/
    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        InsertionSort sort = new InsertionSort();

        sort.sort(integers);

        // Output => 1 4 6 9 12 23 54 78 231
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};

        sort.sort(strings);

        //Output => a	b	c	d	e
        print(strings);
    }
}
