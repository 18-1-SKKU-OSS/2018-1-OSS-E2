package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * 이진 검색은 가장 널리 사용되는 알고리즘 중 하나입니다.
 *이 클래스는 반복 버전을 나타냅니다. BinarySearch
 * 반복적 인 이진 검색은 호출 스택을 조작하는 오버 헤드를 포함하지 않기 때문에 상수 요소가 더 낮을 수 있습니다.
 * 그러나 자바에서 재귀 버전은이 버전의 컴파일러에 의해 최적화 될 수 있습니다.
 *
 * 최악의 경우	O(log n)
 * 최상의 경우	O(1)
 * 평균	O(log n)
 * 최악의 경우 공간복잡도	O(1)
 *
 * @author Gabriele La Greca : https://github.com/thegabriele97
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SearchAlgorithm
 * @see BinarySearch
 *
 */

public final class IterativeBinarySearch implements SearchAlgorithm {

    /**
     * This method implements an iterative version of binary search algorithm
     * 
     * @param array는 정렬된 배열입니다
     * @param key는 찾아야하는 값입니다.
     * 
     * @return the index of key in the array or -1 if not found
     */
    @Override
    public  <T extends Comparable<T>> int find(T[] array, T key) {
        int l, r, k, cmp;

        l = 0;
        r = array.length - 1;

        while (l <= r) {
            k = (l + r) / 2;
            cmp = key.compareTo(array[k]);

            if (cmp == 0) {
                return k;
            } else if (cmp < 0) {
                r = --k;
            } else {
                l = ++k;
            }
        }

        return -1;
    }

    //Only a main method for test purpose
    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);


        //the element that should be found
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        IterativeBinarySearch search = new IterativeBinarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}
