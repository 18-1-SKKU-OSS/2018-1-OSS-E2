package sort;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static sort.SortUtils.print;

/**
 *
 * @author Youssef Ali (https://github.com/youssefAli11997)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 */

/*
counting sort, 즉 계수정렬은 각 숫자가 몇 개 있는지 개수를 세어서 다른 한 배열에 저장해놓은 뒤에 정렬은 하는 알고리즘이다.
*/
class CountingSort implements SortAlgorithm {



    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    /**
     * This method implements the Generic Counting Sort
     *
     * @param list The list to be sorted
     *
     * Sorts the list in increasing order
     * The method uses list elements as keys in the frequency map
     **/
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {

        Map<T, Integer> frequency = new TreeMap<>();
        // The final output array // 최종 결과를 저장할 배열
        List<T> sortedArray = new ArrayList<>(list.size());

        // Counting the frequency of @param array elements // 배열 요소들의 빈도 세기
        list.forEach(v -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));

        // Filling the sortedArray // 정렬된 배열 채우기
        for(Map.Entry<T, Integer> element : frequency.entrySet()) {
            for(int j=0; j<element.getValue(); j++){
                sortedArray.add(element.getKey());
            }
        }

        return sortedArray;
    }


    /**
     * Stream Counting Sort
     * The same as method {@link CountingSort#sort(List)} } but this method uses stream API
     *
     * @param list The list to be sorted
     *
     **/
    private static <T extends Comparable<T>> List<T> streamSort(List<T> list) {
        return  list.stream()
                .collect(toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, TreeMap::new))
                .entrySet()
                .stream()
                .flatMap(entry -> IntStream.rangeClosed(1, entry.getValue()).mapToObj(t -> entry.getKey()))
                .collect(toList());
    }


// 상수형 배열과 문자열형 배열으로 counting sort 실행
    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        List<Integer> unsortedInts = Stream.of(4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12).collect(toList());
        CountingSort countingSort = new CountingSort();

        System.out.println("Before Sorting:");
        print(unsortedInts);

        // Output => 1 1 4 6 9 9 12 23 23 54 78 231
        System.out.println("After Sorting:");
        print(countingSort.sort(unsortedInts));
        System.out.println("After Sorting By Streams:");
        print(streamSort(unsortedInts));

        System.out.println("\n------------------------------\n");

        // String Input
        List<String> unsortedStrings = Stream.of("c", "a", "e", "b","d", "a", "f", "g", "c").collect(toList());

        System.out.println("Before Sorting:");
        print(unsortedStrings);

        //Output => a a b c c d e f g
        System.out.println("After Sorting:");
        print(countingSort.sort(unsortedStrings));

        System.out.println("After Sorting By Streams:");
        print(streamSort(unsortedStrings));

    }
}
