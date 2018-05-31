package search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * ���� �˻��� ���� �θ� ���Ǵ� �˰��� �� �ϳ��Դϴ�.
 *�� Ŭ������ �ݺ� ������ ��Ÿ���ϴ�. BinarySearch
 * �ݺ��� �� ���� �˻��� ȣ�� ������ �����ϴ� ���� ��带 �������� �ʱ� ������ ��� ��Ұ� �� ���� �� �ֽ��ϴ�.
 * �׷��� �ڹٿ��� ��� �������� ������ �����Ϸ��� ���� ����ȭ �� �� �ֽ��ϴ�.
 *
 * �־��� ���	O(log n)
 * �ֻ��� ���	O(1)
 * ���	O(log n)
 * �־��� ��� �������⵵	O(1)
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
     * @param array�� ���ĵ� �迭�Դϴ�
     * @param key�� ã�ƾ��ϴ� ���Դϴ�.
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
