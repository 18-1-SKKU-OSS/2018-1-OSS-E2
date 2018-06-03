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
      * @param key는 발견되어야 할 요소입니다.
      * @param array는 요소를 찾아야하는 배열입니다.
      * @param <T> 같은 타입
      * @return 최초로 발견된 요소의 인덱스
     */
    <T extends Comparable<T>> int find(T array[], T key);

}



