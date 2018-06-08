package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 *  @author Podshivalov Nikita (https://github.com/nikitap492)
 */
/*
자료들이 cycle 관계에 있는 그룹을 찾아내어 정렬 기준에 맞게 자료들을 회전(rotate)시켜 정렬하는 방법이다.
*/
class CycleSort implements SortAlgorithm {


    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;

        // traverse array elements
        for (int j = 0; j <= n - 2; j++) {
            // initialize item as starting point
            T item = arr[j];

            // Find position where we put the item.
            int pos = j;
            for (int i = j + 1; i < n; i++)
                if (less(arr[i], item)) pos++;

            // If item is already in correct position
            if (pos == j)  continue;

            // ignore all duplicate elements
            while (item.compareTo(arr[pos]) == 0)
                pos += 1;

            // put the item to it's right position
            if (pos != j) {
                item = replace(arr, pos, item);
            }

            // Rotate rest of the cycle
            while (pos != j) {
                pos = j;

                // Find position where we put the element
                for (int i = j + 1; i < n; i++)
                    if (less(arr[i], item)){
                        pos += 1;
                    }


                // ignore all duplicate elements
                while (item.compareTo(arr[pos]) == 0)
                    pos += 1;

                // put the item to it's right position
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


// 상수형 배열으로 cycle sort 수행
    public static void main(String[] args) {
        Integer arr[] = { 4, 23, 6, 78, 1, 26, 11, 23 , 0, -6, 3, 54, 231, 9, 12 };
        CycleSort cycleSort = new CycleSort();
        cycleSort.sort(arr);

        System.out.println("After sort : ");
        print(arr);
    }

}
