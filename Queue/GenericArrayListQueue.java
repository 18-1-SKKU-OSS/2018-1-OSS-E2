/** 
 * This class implements Generic Queue using ArrayList
 * 
 * A queue data structure functions the same as a real world queue.
 * The elements that are added first are the first to be removed.
 * New elements are added to the back/rear of the queue.
 * 
 * */
import java.util.ArrayList;


public class GenericArrayListQueue<T> {
    ArrayList<T> _queue = new ArrayList<T>();
    /** 
     * Check if queue has elements, by checking whether ArrayList is empty or not
     * If ArrayList is not empty return true
     * 
     * @return true if ArrayList is not empty
     * */
    private boolean hasElements() {
        return !_queue.isEmpty();
    }
    //Read element from front
    public T peek() {
        T result = null;
        if(this.hasElements()) { result = _queue.get(0); }
        return result;
    }
    //Insert an element to rear
    public boolean add(T element) {
        return _queue.add(element);
    }
    //Delete element in front
    public T poll() {
        T result = null;
        if(this.hasElements()) { result = _queue.remove(0); }
        return result;
    }
    /**
     *  Main method
     *  */
    public static void main(String[] args) {
        GenericArrayListQueue<Integer> queue = new GenericArrayListQueue<Integer>();
        System.out.println("Running...");
        assert queue.peek() == null;
        assert queue.poll() == null;
        assert queue.add(1) == true;
        assert queue.peek() == 1;
        assert queue.add(2) == true;
        assert queue.peek() == 1;
        assert queue.poll() == 1;
        assert queue.peek() == 2;
        assert queue.poll() == 2;
        assert queue.peek() == null;
        assert queue.poll() == null;
        System.out.println("Finished.");
    }
}
