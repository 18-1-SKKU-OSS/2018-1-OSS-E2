package search;

/**
 *  대부분의 검색 알고리즘의 공용 인터페이스
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 **/
public interface SearchAlgorithm {

    /**
     *
     * @param key is an element which should be found
     * @param array is an array where the element should be found
     * @param <T> Comparable type
     * @return first found index of the element
     */
    <T extends Comparable<T>> int find(T array[], T key);

}
