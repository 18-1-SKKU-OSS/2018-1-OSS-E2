package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 *
 *
 *
 * 이진 검색은 가장 널리 사용되는 알고리즘 중 하나입니다.
 * 알고리즘은 정렬 된 배열 내에서 대상 값의 위치를 찾습니다.
 *
 * 최악의 경우	O(log n)
 * 최상의 경우	O(1)
 * 평균	O(log n)
 * 최악의 경우 공간복잡도	O(1)
 *
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SearchAlgorithm
 * @see IterativeBinarySearch
 *
 */

class BinarySearch implements SearchAlgorithm {

    /**
     *
     * @param array는 찾고자 하는 요소를 가지고 있는 배열입니다
     * @param key는 찾고자 하는 요소입니다
     * @param <T> 모든 비교 가능한 유형입니다
     * @return index->요소의 인덱스를 리턴합니다.
     */
    @Override
    public  <T extends Comparable<T>> int find(T array[], T key) {
        return search(array, key, 0, array.length);
    }

    /**
     * 이 메소드는 일반 이진 검색을 구현합니다.
     *
     * @param 배열 바이너리 검색을 실시하는 배열
     * @param key 찾고있는 번호
     * @param left 하한
     * @param right 상한
     * @return 키의 위치를 리턴합니다
     **/
    private <T extends Comparable<T>> int search(T array[], T key, int left, int right){
        if (right < left) return -1; // this means that the key not found

        // find median
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if (comp < 0) {
            return search(array, key, left, median - 1);
        }

        if (comp > 0) {
            return search(array, key, median + 1, right);
        }

        return median;
    }

    public static void main(String[] args) {

        //데이터 생성
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);


        //발견되어야 할 요소
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        BinarySearch search = new BinarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}
