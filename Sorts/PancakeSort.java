package sort;

import static sort.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 *
 **/

/*
팬케이크 정렬 알고리즘은 펜케이크를 뒤집듯이 배열을 뒤집어 정렬을 하는 알고리즘이다.
*/
public class PancakeSort implements SortAlgorithm {


    @Override
    public <T extends Comparable<T>> T[] sort(T[] array){
        int size = array.length;

	// 가장 큰 크기를 갖는 원소를 찾는다.
        for (int i = 0; i < size; i++) {
            T max = array[0];
            int index = 0;
            for (int j = 0; j < size - i; j++) {
                if ( less(max, array[j]) ) {
                    max = array[j];
                    index = j;
                }
            }
	// 그 후 가장 큰 크기의 원소가 제일 뒤에 오도록 배열의 일부를 뒤집는다.
            flip(array, index, array.length - 1 - i);
        }
        return array;
    }


    public static void main(String[] args) {

        Integer[] arr = {10, 9, 8, 7, 6, 15, 14, 7, 4, 3, 8, 6, 3, 1 ,2, -2, -5, -8, -3, -1, 13, 12, 11, 5, 4, 3, 2, 1};
        PancakeSort pancakeSort = new PancakeSort();
        System.out.println("After sorting:");
        pancakeSort.sort(arr);
        print(arr);
    }





}
