package search;

import java.util.Random;
import java.util.stream.Stream;

/**
 * ���� �˻��� ���� ���� �˻� �˰����Դϴ�.
 * ���ĵ� �迭, ���ĵ��� ���� �迭�� �Բ� �۵��մϴ� (���� �� �迭������ ���� �˻��� �۵� ��)
 *�� �˰����� �迭�� ��� ��Ҹ� ���Ͽ� ���� ã���ϴ�.
 *
 * �־��� ���	O(n)
 * �ֻ��� ���	O(1)
 * ���	O(n)
 * �־��� ��� �������⵵
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
     * �Ϲ����� ���� �˻� ���
     *
     * @param array�� �˻� ��� �迭�Դϴ�
     * @param value Key�� �˻� ����� Ű(��)�Դϴ�.
     * @return->Ű�� ��ġ�� �����մϴ�
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
        //�����͸� ����
        Random r = new Random();
        int size = 200;
        int maxElement = 100;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).toArray(Integer[]::new);


        //�츮�� ã�ƾ� �ϴ� ���
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        LinearSearch search = new LinearSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));
    }

}
