package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 *
  * 삼항 검색 알고리즘의 반복 버전
  * 재귀적 버전은 스택에 약간의 오버 헤드를 추가하기 때문에 이것은 3 진 검색을 구현하는 더 좋은 방법입니다.
  * 그러나 자바에서 컴파일은 재귀 버전을 암시 적으로 반복적으로 변형 할 수 있습니다.
  * 이 두 알고리즘 간에는 큰 차이가 없습니다.
 *
 * 최악의 경우	Θ(log3(N))
 * 최상의 경우	O(1)
 * 평균	Θ(log3(N))
 * 최악의 경우 공간복잡도  O(1)
 *
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-13
 *
 * @see SearchAlgorithm
 * @see TernarySearch
 *
 */

public class IterativeTernarySearch implements SearchAlgorithm {


    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int left = 0;
        int right = array.length - 1;

         while (right > left) {

            int leftCmp =  array[left].compareTo(key);
            int rightCmp =  array[right].compareTo(key);
            if (leftCmp == 0) return left;
            if (rightCmp == 0) return right;

            int leftThird = left + (right - left) / 3 + 1;
            int rightThird = right - (right - left) / 3 - 1;


            if (array[leftThird].compareTo(key) <= 0) {
                left = leftThird;
            } else {
                right = rightThird;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //데이터를 생성
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement))
                .limit(size)
                .sorted()
                .toArray(Integer[]::new);


        //발견되어야 할 요소
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        IterativeTernarySearch search = new IterativeTernarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d",
                shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b",
                toCheck, toCheck == atIndex));

    }


}
