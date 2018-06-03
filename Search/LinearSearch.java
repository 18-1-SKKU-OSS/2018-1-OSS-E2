package search;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 선형 검색은 가장 쉬운 검색 알고리즘입니다.
 * 정렬된 배열, 정렬되지 않은 배열과 함께 작동합니다 (정렬 된 배열에서만 이진 검색이 작동 함)
 *이 알고리즘은 배열의 모든 요소를 비교하여 값을 찾습니다.
 *
 * 최악의 경우	O(n)
 * 최상의 경우	O(1)
 * 평균	O(n)
 * 최악의 경우 공간복잡도
 *
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 *
 * @see BinarySearch
 * @see SearchAlgorithm
 */

public class LinearSearch implements SearchAlgorithm {

    /**
     * 일반적인 선형 검색 방법
     *
     * @param array는 검색 대상 배열입니다
     * @param value Key는 검색 대상의 키(값)입니다.
     * @return->키의 위치를 리턴합니다
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        for (int i = 0; i < array.length ; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //데이터를 생성
        Random r = new Random();
        int size = 200;
        int maxElement = 100;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).toArray(Integer[]::new);


        //우리가 찾아야 하는 요소
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        LinearSearch search = new LinearSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));
    }

}
