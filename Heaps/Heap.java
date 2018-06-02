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
 * 모든 원소들은 값(key)를 가지며 그 값들은 그 트리가 어떤 방식으로 세워졌는지의 척도가 됩니다. 예컨대, 최소 힙(min-heap)인 경우,
 * 노드의 값들은 부모보다 작지 않아야 하며 자식보다 크지 않아야 합니다.(최대 힙(max-heap)은 이와 반대입니다.) 
 * 모든 힙 관련 기능(삽입, 원소 삭제, 추출)들은 O(log n)에서 이뤄집니다.
 * 저자: Nicolas Renard
 * 번역: 박지열
 */
public interface Heap {
    
    /**
     * 
     * @return the top element in the heap, the one with lowest key for min-heap or with
     * the highest key for max-heap
     * @throws Exception if heap is empty
     * 가장 높은 원소의 값을 반환할 것(최소 힙이라면 가장 작은 값, 최대 힙이라면 가장 큰 값)
     * 만약 힙이 빈 경우, 예외처리를 할 것  	
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
