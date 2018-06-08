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

        // traverse array elements  //배열 요소들을 쭉 확인한다.
        for (int j = 0; j <= n - 2; j++) {
            // initialize item as starting point //item을 시작점으로 초기화한다.
            T item = arr[j];

            // Find position where we put the item.  //item을 넣을 위치를 찾는다.
            int pos = j;
            for (int i = j + 1; i < n; i++)
                if (less(arr[i], item)) pos++;

            // If item is already in correct position  //만약 item이 이미 정확한 위치에 있다면
            if (pos == j)  continue;

            // ignore all duplicate elements  //모든 중복된 요소를 무시한다.
            while (item.compareTo(arr[pos]) == 0)
                pos += 1;

            // put the item to it's right position //item을 정확한 위치에 넣는다.
            if (pos != j) {
                item = replace(arr, pos, item);
            }

            // Rotate rest of the cycle //나머지 사이클을 회전한다.
            while (pos != j) {
                pos = j;

                // Find position where we put the element. //요소를 넣을 위치를 찾는다.

                for (int i = j + 1; i < n; i++)
                    if (less(arr[i], item)){
                        pos += 1;
                    }


                // ignore all duplicate elements  //모든 중복된 요소를 무시한다.
                while (item.compareTo(arr[pos]) == 0)
                    pos += 1;

                // put the item to it's right position // item을 정확한 위치에 넣는다.
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
