package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 *  @author Podshivalov Nikita (https://github.com/nikitap492)
 */
/*
�ڷ���� cycle ���迡 �ִ� �׷��� ã�Ƴ��� ���� ���ؿ� �°� �ڷ���� ȸ��(rotate)���� �����ϴ� ����̴�.
*/
class CycleSort implements SortAlgorithm {


    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;

        // traverse array elements  //�迭 ��ҵ��� �� Ȯ���Ѵ�.
        for (int j = 0; j <= n - 2; j++) {
            // initialize item as starting point //item�� ���������� �ʱ�ȭ�Ѵ�.
            T item = arr[j];

            // Find position where we put the item.  //item�� ���� ��ġ�� ã�´�.
            int pos = j;
            for (int i = j + 1; i < n; i++)
                if (less(arr[i], item)) pos++;

            // If item is already in correct position  //���� item�� �̹� ��Ȯ�� ��ġ�� �ִٸ�
            if (pos == j)  continue;

            // ignore all duplicate elements  //��� �ߺ��� ��Ҹ� �����Ѵ�.
            while (item.compareTo(arr[pos]) == 0)
                pos += 1;

            // put the item to it's right position //item�� ��Ȯ�� ��ġ�� �ִ´�.
            if (pos != j) {
                item = replace(arr, pos, item);
            }

            // Rotate rest of the cycle //������ ����Ŭ�� ȸ���Ѵ�.
            while (pos != j) {
                pos = j;

                // Find position where we put the element. //��Ҹ� ���� ��ġ�� ã�´�.

                for (int i = j + 1; i < n; i++)
                    if (less(arr[i], item)){
                        pos += 1;
                    }


                // ignore all duplicate elements  //��� �ߺ��� ��Ҹ� �����Ѵ�.
                while (item.compareTo(arr[pos]) == 0)
                    pos += 1;

                // put the item to it's right position // item�� ��Ȯ�� ��ġ�� �ִ´�.
                if (item != arr[pos]) {
                    item = replace(arr, pos, item);
                }
            }
        }

        return arr;
    }

    private <T extends Comparable<T>> T replace(T[] arr, int pos, T item){
        T temp = item;
        item = arr[pos];
        arr[pos] = temp;
        return item;
    }


// ����� �迭���� cycle sort ����
    public static void main(String[] args) {
        Integer arr[] = { 4, 23, 6, 78, 1, 26, 11, 23 , 0, -6, 3, 54, 231, 9, 12 };
        CycleSort cycleSort = new CycleSort();
        cycleSort.sort(arr);

        System.out.println("After sort : ");
        print(arr);
    }

}