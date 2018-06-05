package sort;

import java.util.Random;
import static sort.SortUtils.*;


/**
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 비효율적인 알고리즘으로 대부분 교육을 위해 많이 사용된다.
 * @see SortAlgorithm
 *
 */
public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random(); // 난수 발생기 생성


    private static <T extends Comparable<T>> boolean isSorted(T array[]){
        for(int i = 0; i<array.length - 1; i++){
            if(less(array[i + 1], array[i])) return false; // i+1번째 값이 i번째 값보다 작다면 false이다.
        }
        return true; // 모든 값이 정렬되어있다면 true를 반환한다.
    }

    // Randomly shuffles the array : 배열을 임의로 섞는다.
    private static <T> void nextPermutation(T array[]){
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i); // 0부터  length - i - 1 사이의 난수를 i와 더한 값(즉, 0부터 length - 1 사이의 난수)을 randomIndex에 저장한다.
            swap(array, randomIndex, i);
        }
    }

// 배열이 모두 정렬될 때까지 nextPermutation 메서드를 실행한다.
    public <T extends Comparable<T>> T[] sort(T array[]) {
        while(!isSorted(array)){
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        print(bogoSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};

        print(bogoSort.sort(strings));
    }
}
