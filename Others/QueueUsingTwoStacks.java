import java.util.Stack;

/**
 * This implements Queue using two Stacks.
 *
 * Big O Runtime:
 *      insert(): O(1)
 *      remove(): O(1) amortized
 *      isEmpty(): O(1)
 *
 * A queue data structure functions the same as a real world queue.
 * The elements that are added first are the first to be removed.
 * New elements are added to the back/rear of the queue.
 * 
 * 두개의 스택을 이용하여 큐를 구현합니다. 
 * 
 * 빅-오 시간복잡도
 * 		insert 삽입 : O(1)
 * 		remove 삭제 : O(1) (분할상환분석 사용시)
 * 		isEmpty 비어있는지 확인 : O(1)
 * 
 *
 * @author sahilb2 (https://www.github.com/sahilb2)
 *
 */
class QueueWithStack {

    // Stack to keep track of elements inserted into the queue
    private Stack inStack;
    // Stack to keep track of elements to be removed next in queue
    private Stack outStack;

    /**
	 * Constructor
	 * 생성자
	 */
    public QueueWithStack() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }

    /**
     * Inserts an element at the rear of the queue
     * 큐의 가장 마지막에 원소를 삽입합니다. 
     *
     * @param x element to be added
     * 변숫 x는 들어갈 원소입니다. 
     */
    public void insert(Object x) {
        // Insert element into inStack
        this.inStack.push(x);
    }

    /**
     * Remove an element from the front of the queue
     * 큐의 가장 앞부분에서 원소를 지웁니다. 
     *
     * @return the new front of the queue
     * 새롭게 큐의 가장 앞부분에 있는 원소를 리턴합니다. 
     */
    public Object remove() {
        if(this.outStack.isEmpty()) {
            // Move all elements from inStack to outStack (preserving the order)
            while(!this.inStack.isEmpty()) {
                this.outStack.push( this.inStack.pop() );
            }
        }
        return this.outStack.pop();
    }

    /**
     * Peek at the element from the front of the queue
     * 큐의 가장 앞에 있는 원소를 읽어들입니다. 
     *
     * @return the front element of the queue
     * 큐의 가장 앞부분에 있는 원소를 리턴합니다.
     */
    public Object peekFront() {
        if(this.outStack.isEmpty()) {
            // Move all elements from inStack to outStack (preserving the order)
        	// inStack에 있는 모든 원소를 outStack으로 옮깁니다. (순서를 보존)
            while(!this.inStack.isEmpty()) {
                this.outStack.push( this.inStack.pop() );
            }
        }
        return this.outStack.peek();
    }

    /**
     * Peek at the element from the back of the queue
     * 큐의 뒤에 있는 원소를 읽어들입니다. 
     *
     * @return the back element of the queue
     * 큐의 맨 뒤에 있는 원소를 리턴합니다. 
     */
    public Object peekBack() {
        return this.inStack.peek();
    }

    /**
     * Returns true if the queue is empty
     * 큐가 비었다면 true를 리턴합니다. 
     *
     * @return true if the queue is empty
     * 큐가 비었다면 true를 리턴합니다.
     */
    public boolean isEmpty() {
        return (this.inStack.isEmpty() && this.outStack.isEmpty());
    }

}

/**
 * This class is the example for the Queue class
 * 이것은 큐 클래스에 대한 예시입니다.
 *
 * @author sahilb2 (https://www.github.com/sahilb2)
 *
 */
public class QueueUsingTwoStacks {

    /**
     * Main method
     * 메인 메서드
     *
     * @param args Command line arguments
     */
    public static void main(String args[]){
        QueueWithStack myQueue = new QueueWithStack();
        myQueue.insert(1);
        System.out.println(myQueue.peekBack()); //Will print 1 
        // instack: [(top) 1]  // 두 개의 스택에 있는 원소들의 상태를 나타내는 주석입니다.
        // outStack: []
        myQueue.insert(2);
        System.out.println(myQueue.peekBack()); //Will print 2
        // instack: [(top) 2, 1]
        // outStack: []
        myQueue.insert(3);
        System.out.println(myQueue.peekBack()); //Will print 3
        // instack: [(top) 3, 2, 1]
        // outStack: []
        myQueue.insert(4);
        System.out.println(myQueue.peekBack()); //Will print 4
        // instack: [(top) 4, 3, 2, 1]
        // outStack: []

        System.out.println(myQueue.isEmpty()); //Will print false

        System.out.println(myQueue.remove()); //Will print 1
        System.out.println(myQueue.peekBack()); //Will print NULL
        // instack: []
        // outStack: [(top) 2, 3, 4]

        myQueue.insert(5);
        System.out.println(myQueue.peekFront()); //Will print 2
        // instack: [(top) 5]
        // outStack: [(top) 2, 3, 4]

        myQueue.remove();
        System.out.println(myQueue.peekFront()); //Will print 3
        // instack: [(top) 5]
        // outStack: [(top) 3, 4]
        myQueue.remove();
        System.out.println(myQueue.peekFront()); //Will print 4
        // instack: [(top) 5]
        // outStack: [(top) 4]
        myQueue.remove();
        // instack: [(top) 5]
        // outStack: []
        System.out.println(myQueue.peekFront()); //Will print 5
        // instack: []
        // outStack: [(top) 5]
        myQueue.remove();
        // instack: []
        // outStack: []

        System.out.println(myQueue.isEmpty()); //Will print true

    }
}
