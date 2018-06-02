package heaps;

/**
 * Interface common to heap data structures.<br>
 * 힙 자료구조에 자주 쓰는 인터페이스.(인터페이스 개념을 잘 모르신다면 공부를 해두실 필요가 있습니다.)
 * <p>Heaps are tree-like data structures that allow storing elements in a specific
 * way. Each node corresponds to an element and has one parent node (except for the root) and
 * at most two children nodes. Every element contains a key, and those keys
 * indicate how the tree shall be built. For instance, for a min-heap, the key of a node shall
 * be greater than or equal to its parent's and lower than or equal to its children's (the opposite rule applies to a
 * max-heap).</p>
 * <p>All heap-related operations (inserting or deleting an element, extracting the min or max) are performed in
 * O(log n) time.</p>
 * @author Nicolas Renard
 *힙은 트리와 닯은 자료구조로 특별한 방식을 추구합니다. 각 노드들은 원소(element)로 보며 부모노드는 최대 2개의 자식 노드를 가집니다. 
 * (사실 꼭 2개일 필요는 없지만 번역은 2개로 입니다.)
 *
 *
 */
public interface Heap {
    
    /**
     * 
     * @return the top element in the heap, the one with lowest key for min-heap or with
     * the highest key for max-heap
     * @throws Exception if heap is empty
     */
    public abstract HeapElement getElement() throws EmptyHeapException;
    /**
     * Inserts an element in the heap. Adds it to then end and toggle it until it finds its
     * right position.
     * 
     * @param element an instance of the HeapElement class.
     */
    public abstract void insertElement(HeapElement element);
    
    /**
     * Delete an element in the heap.
     * 
     * @param elementIndex int containing the position in the heap of the element to be deleted.
     */
    public abstract void deleteElement(int elementIndex);

}
