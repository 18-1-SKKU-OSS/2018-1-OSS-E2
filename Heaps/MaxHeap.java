package heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap tree where a node's key is higher than or equal to its parent's and lower than or equal
 * to its children's.
 * @author Nicolas Renard
 *
 * 노드의 값이 부모보다 크지 않으면서도 자신보다 작지 않은 트리
 *저자 : Nicolas Renard
 */
public class MaxHeap implements Heap {
    
    private final List<HeapElement> maxHeap;
    
    public MaxHeap(List<HeapElement> listElements) throws Exception {
        maxHeap = new ArrayList<HeapElement>();
        for (HeapElement heapElement : listElements) {
            if (heapElement != null) insertElement(heapElement);
            else System.out.println("Null element. Not added to heap");
        }
        if (maxHeap.size() == 0) System.out.println("No element has been added, empty heap.");
        }
    
    // Get the element at a given index. The key for the list is equal to index value - 1
    // 주어진 색인에 대한 원소를 찾아라. 핵심은 색인은 0부터 시작하므로 항상 받은 값에서 1을 빼서 찾아야 하는 것이다.	
    public HeapElement getElement(int elementIndex) {
        if ((elementIndex <= 0) && (elementIndex > maxHeap.size())) throw new IndexOutOfBoundsException("Index out of heap range");
        return maxHeap.get(elementIndex - 1);
    }
    
    // Get the key of the element at a given index
    // 주어진 색인에 위치한 원소의 값을 얻어라.
    private double getElementKey(int elementIndex) {
        return maxHeap.get(elementIndex - 1).getKey();
    }
    
    // Swaps two elements in the heap
    // 힙에서 두 원소를 바꿔라.
    private void swap(int index1, int index2) {
        HeapElement temporaryElement = maxHeap.get(index1 - 1);
        maxHeap.set(index1 - 1, maxHeap.get(index2 - 1));
        maxHeap.set(index2 - 1, temporaryElement);
    }
    
    // Toggle an element up to its right place as long as its key is lower than its parent's
    // 부모의 값보다 작다는 가정 하에 올바른 자리로 갈때까지 이동한다.(이해가 안된다면 배열기반으로 힙을 짰다고 생각하고 정렬하는 과정을 배울 필요가 있다.) 
    private void toggleUp(int elementIndex) {
        double key = maxHeap.get(elementIndex - 1).getKey();
        while (getElementKey((int) Math.floor(elementIndex/2)) < key) {
            swap(elementIndex, (int) Math.floor(elementIndex/2));
            elementIndex = (int) Math.floor(elementIndex/2);
        }
    }
    
    // Toggle an element down to its right place as long as its key is higher
    // than any of its children's 
    // 	부모의 값보다 크다는 가정 하에 올바른 자리로 갈때까지 이동한다.(이해가 안된다면 배열기반으로 힙을 짰다고 생각하고 정렬하는 과정을 배울 필요가 있다.)
    private void toggleDown(int elementIndex) {
        double key = maxHeap.get(elementIndex - 1).getKey();
        boolean wrongOrder = (key < getElementKey(elementIndex*2)) || (key < getElementKey(Math.min(elementIndex*2, maxHeap.size())));
        while ((2*elementIndex <= maxHeap.size()) && wrongOrder) {
            // Check whether it shall swap the element with its left child or its right one if any.
	    // 왼쪽 오른쪽 둘중에 하나라도 바꿀 수 있는지  확인한다.
            if ((2*elementIndex < maxHeap.size()) && (getElementKey(elementIndex*2 + 1) > getElementKey(elementIndex*2))) {
                swap(elementIndex, 2*elementIndex + 1);
                elementIndex = 2*elementIndex + 1;
            }
            else {
                swap(elementIndex, 2*elementIndex);
                elementIndex = 2*elementIndex;
            }
            wrongOrder = (key < getElementKey(elementIndex*2)) || (key < getElementKey(Math.min(elementIndex*2, maxHeap.size())));
            
        }
    }

    private HeapElement extractMax() {
        HeapElement result = maxHeap.get(0);
        deleteElement(0);
        return result;
    }
s
    @Override
    public void insertElement(HeapElement element) {
        maxHeap.add(element);
        toggleUp(maxHeap.size());

    }

    @Override
    public void deleteElement(int elementIndex) {
		if (maxHeap.isEmpty())
			try {
				throw new EmptyHeapException("Attempt to delete an element from an empty heap");
			} catch (EmptyHeapException e) {
				e.printStackTrace();
			}
        if ((elementIndex > maxHeap.size()) && (elementIndex <= 0)) throw new IndexOutOfBoundsException("Index out of heap range");
        // The last element in heap replaces the one to be deleted
	// 힙의 마지막 원소는 삭제될 원소를 대신한다.
        maxHeap.set(elementIndex - 1, getElement(maxHeap.size()));
        maxHeap.remove(maxHeap.size());
        // Shall the new element be moved up...
	// 새로운 원소가 위로 올라갈까?
        if (getElementKey(elementIndex) > getElementKey((int) Math.floor(elementIndex/2))) toggleUp(elementIndex);
        // ... or down ?
	// ... 아래로 갈까?
        else if (((2*elementIndex <= maxHeap.size()) && (getElementKey(elementIndex) < getElementKey(elementIndex*2))) ||
                ((2*elementIndex < maxHeap.size()) && (getElementKey(elementIndex) < getElementKey(elementIndex*2)))) toggleDown(elementIndex);
    }

    @Override
    public HeapElement getElement() throws EmptyHeapException {
        try {
            return extractMax();
        } catch (Exception e) {
            throw new EmptyHeapException("Heap is empty. Error retrieving element");
        }
    }

}


