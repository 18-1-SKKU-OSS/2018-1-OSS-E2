package search;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 *
 *
 *
 * 삼항 검색 알고리즘은 컴퓨터 과학에서 단봉 함수의 최소 또는 최대를 찾는 기술입니다
 * 알고리즘은 최소 또는 최대가 도메인의 1/3에 위치 할 수 없음을 결정합니다.
 * 도메인의 마지막 3 분의 1에있을 수 없다고 가정하면 나머지 3 분의 1에서 반복됩니다.
 *
 * 최악의 경우	Θ(log3(N))
 * 최상의 경우	O(1)
 * 평균	Θ(log3(N))
 * 최악의 경우 공간복잡도	O(1)
 *
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SearchAlgorithm
 * @see IterativeBinarySearch
 *
 */

public class TernarySearch implements SearchAlgorithm{

    /**
     * @param arr The **Sorted** array는 요소를 찾을 배열입니다
     * @param value 찾고자 하는 값입니다
     * @return The index-> 찾고자 하는 값에 해당되는 요소가 배열에 있으면 인덱스를 리턴합니다.
     * Else returns -1.
     */
    @Override
    public <T extends Comparable<T>> int find(T[] arr, T value){
        return ternarySearch(arr, value, 0, arr.length - 1);
    }

    /**
      * @param arr 요소를 검색하는 ** Sorted ** 배열입니다.
      * @param key 검색하고 싶은 값.
      * @param start 검색을 개시하는 개시 인덱스.
      * @param end 우리가 검색할 때 접근할 수 있는 마지막 인덱스.
      * @return 발견된 경우 요소의 색인을 리턴합니다.
     * Else returns -1.
     */
    private <T extends Comparable<T>> int ternarySearch(T[] arr, T key, int start, int end) {
        if (start > end){
            return -1;
        }
       / * 첫 번째 경계 : 시작에 길이의 1/3을 더합니다 * /
        int mid1 = start + (end - start) / 3;
        / * 두 번째 경계 : 시작에 길이의 2/3을 추가 * /
        int mid2 = start + 2 * (end - start) / 3;

        if (key.compareTo(arr[mid1]) == 0) {
            return mid1;
        }
        else if (key.compareTo(arr[mid2]) == 0) {
            return mid2;
        }

       / * 배열의 첫 번째 (1/3) 부분을 찾습니다. * /

        else if (key.compareTo(arr[mid1]) < 0) {
            return ternarySearch(arr, key, start, --mid1);
        }
        / * 배열의 3 번째 (1/3) 부분 검색 * /

        else if (key.compareTo(arr[mid2]) > 0) {
            return ternarySearch(arr, key, ++mid2, end);
        }
       / * 배열의 중간 부분 (1/3)을 검색 * /

        else {
            return ternarySearch(arr, key, mid1, mid2);
        }
    }

    public static void main(String[] args) {
        // 데이터를 생성.
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);


        //찾아야 하는 요소
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        TernarySearch search = new TernarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));

    }
}