package search;

/**
 *  ��κ��� �˻� �˰����� ���� �������̽�
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 **/
public interface SearchAlgorithm {

    /**
     *
      * @param key�� �߰ߵǾ�� �� ����Դϴ�.
      * @param array�� ��Ҹ� ã�ƾ��ϴ� �迭�Դϴ�.
      * @param <T> ���� Ÿ��
      * @return ���ʷ� �߰ߵ� ����� �ε���
     */
    <T extends Comparable<T>> int find(T array[], T key);

}



