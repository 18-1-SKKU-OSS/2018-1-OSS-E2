package sort;

import static sort.SortUtils.*;


/**
 *
 * Comb Sort algorithm implementation
 *
 * Best-case performance O(n * log(n))
 * Worst-case performance O(n ^ 2)
 * Worst-case space complexity O(1)
 *
 * Comb sort improves on bubble sort.
 *
 *
 * @see BubbleSort
 * @see SortAlgorithm
 *
 * @author Sandeep Roy (https://github.com/sandeeproy99)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */

/*
빗질 정렬은 특정한 감소량(shrink factor)에 의해 gap(비교하는 단위)을 줄여가면서 버블 정렬을 수행한다. 감소량은 약 1.3이 가장 이상적이다. 비교하는 단위가 계속 줄어들다가 1단위 버블 정렬을 수행하게 되면 1단위 정렬은 자료의 교환이 없을 때까지, 즉 정렬이 완료될 때까지 반복한다.
*/

class CombSort implements SortAlgorithm {

    // To find gap between elements // gap을 구한다.
    private int nextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = ( gap * 10 ) / 13;
        return  ( gap < 1 ) ? 1 : gap;
    }

    /**
     * Function to sort arr[] using Comb
     * @param arr - an array should be sorted
     * @return sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T arr[]) {
        int size  = arr.length;

        // initialize gap // gap은 처음에 총 자료의 개수로 초기화된다.
        int gap = size;
 
        // Initialize swapped as true to make sure that loop runs  // 교환됐는지 아닌지 확인하는 변수
        boolean swapped = true;
 
        // Keep running while gap is more than 1 and last iteration caused a swap // 1단위보다 높은 단위일 때 gap을 계속 줄여가면서 단위별로 버블 정렬 수행
        while (gap != 1 || swapped) {
            // Find next gap
            gap = nextGap(gap);
 
            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;
 
            // Compare all elements with current gap // 1단위 정렬일때 정렬이 끝날 때까지 1단위 정렬 반복
            for (int i = 0; i < size - gap ; i++) {
                if (less(arr[i + gap], arr[i])) {
                    // Swap arr[i] and arr[i+gap]
                    swapped = swap(arr, i, i + gap);
                }
            }
        }
        return arr;
    }
 
    // Driver method 
    // 정수형 배열로 빗질 정렬 실행
    public static void main(String args[]) {
        CombSort ob = new CombSort();
        Integer arr[] = {8, 4, 1, 56, 3, -44, -1 , 0 , 36, 34, 8, 12 , -66, - 78, 23, -6, 28, 0};
        ob.sort(arr);
 
        System.out.println("sorted array");
        print(arr);
    }
}
