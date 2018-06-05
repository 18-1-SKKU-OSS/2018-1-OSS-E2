package sort;

import java.util.Random;
import static sort.SortUtils.*;


/**
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * ��ȿ������ �˰������� ��κ� ������ ���� ���� ���ȴ�.
 * @see SortAlgorithm
 *
 */
public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random(); // ���� �߻��� ����


    private static <T extends Comparable<T>> boolean isSorted(T array[]){
        for(int i = 0; i<array.length - 1; i++){
            if(less(array[i + 1], array[i])) return false; // i+1��° ���� i��° ������ �۴ٸ� false�̴�.
        }
        return true; // ��� ���� ���ĵǾ��ִٸ� true�� ��ȯ�Ѵ�.
    }

    // Randomly shuffles the array : �迭�� ���Ƿ� ���´�.
    private static <T> void nextPermutation(T array[]){
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i); // 0����  length - i - 1 ������ ������ i�� ���� ��(��, 0���� length - 1 ������ ����)�� randomIndex�� �����Ѵ�.
            swap(array, randomIndex, i);
        }
    }

// �迭�� ��� ���ĵ� ������ nextPermutation �޼��带 �����Ѵ�.
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
