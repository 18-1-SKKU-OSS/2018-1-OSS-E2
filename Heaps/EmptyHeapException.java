/**
 * 
 */
package heaps;

/**
 * @author Nicolas Renard
 * Exception to be thrown if the getElement method is used on an empty heap.
 * 저자 Nicloas Renard
 * getElement가 어떤 원소도 갖지 않는 힙 구조에서 사용될 경우, 넘겨질 예외
 */
@SuppressWarnings("serial")
public class EmptyHeapException extends Exception {
    
    public EmptyHeapException(String message) {
        super(message);
    }

}
