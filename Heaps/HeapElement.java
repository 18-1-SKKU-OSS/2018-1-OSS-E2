/**
 * 
 */
package heaps;

import java.lang.Double;
import java.lang.Object;

/**
 * Class for heap elements.<br>
 * <p>A heap element contains two attributes: a key which will be used to build the tree (int
 * or double, either primitive type or object) and any kind of IMMUTABLE object the user sees fit
 * to carry any information he/she likes. Be aware that the use of a mutable object might
 * jeopardize the integrity of this information. </p>
 * @author Nicolas Renard
 *
 * 힙 원소들을 위한 클래스
 * <p>힙 원소들은 두가지 특성을 갖는다: 트리를 쌓기 위해 쓰일 키 (int
 * ,double 등의 자료형) 사용자가 좋아할 만한 정보들을 쌓기에 적합하게 쓰일 불변의 객체
 *  변할 수 있는 객체를 사용하는 것은 정보의 총체성을 흔들 수 있으므로 주의하라.</p>
 * @저자 Nicolas Renard
 *
 */
public class HeapElement {
    private final double key;
    private final Object additionalInfo;
    
    // 생성자

    /**
     * 
     * @매개 변수 key : 기본적인 실수형 타입
     * @ 매개 변수 정보: 불변의 객체. 아마 NULL일 수 있다, 왜냐면 목적은 오직 운반이기 때문이다.
     * 사용자를 위해 부가적으로 사용된 정보
     */
    public HeapElement(double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }
    
    /**
     * 
      * @매개 변수 key : 기본적인 정수형 타입
     * @ 매개 변수 정보: 불변의 객체. 아마 NULL일 수 있다, 왜냐면 목적은 오직 운반이기 때문이다.
     * 사용자를 위해 부가적으로 사용된 정보
     */
    public HeapElement(int key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }
    
    /**
     * 
      * @매개 변수 key : 기본적인 정수형 타입 -> 여기서 주의할 점은 Integer은 int와 다르다. wrapper class인데 공부를 하고 보도록 하자.
     * @ 매개 변수 정보: 불변의 객체. 아마 NULL일 수 있다, 왜냐면 목적은 오직 운반이기 때문이다.
     * 사용자를 위해 부가적으로 사용된 정보     */
    public HeapElement(Integer key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }
    
    /**
     *  * @매개 변수 key : 기본적인 더블형 타입 -> 위와 마찬가지로 wrapper class이다. 공부를 하고 보도록 하자.
     * @ 매개 변수 정보: 불변의 객체. 아마 NULL일 수 있다, 왜냐면 목적은 오직 운반이기 때문이다.
     * 사용자를 위해 부가적으로 사용된 정보
     */
    public HeapElement(Double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }
    
    /**
     * 
     * @매개 변수 key : 기본적인 더블형 타입
     */
    public HeapElement(double key) {
        this.key = key;
        this.additionalInfo = null;
    }
    
    /**
     * 
     * @매개 변수 key : 기본적인 정수형 타입 
     */
    public HeapElement(int key) {
        this.key = key;
        this.additionalInfo = null;
    }
    
    /**
     * 
     * @매개 변수 key : 기본적인 정수형 타입 -> 위와 마찬가지로 wrapper class이다. 공부를 하고 보도록 하자.
     */
    public HeapElement(Integer key) {
        this.key = key;
        this.additionalInfo = null;
    }
    
    /**
     * 
     * @매개 변수 key : 기본적인 더블형 타입 -> 위와 마찬가지로 wrapper class이다. 공부를 하고 보도록 하자.
     */
    public HeapElement(Double key) {
        this.key = key;
        this.additionalInfo = null;
    }
    
    // 얻는 함수들(메소드들)
    /**
     * @유저에 의해 부가적인 정보를 가지고 있는 객체를 반환할 필요가 있다!
     */
    public Object getInfo() {
        return additionalInfo;
    }
    /**
     * @원소의 값을 반환하라
     */
    public double getKey() {
        return key;
    }
    
    // 오버라이드된 객체의 메소드들(오버라이드를 모른다면 반드시 공부하도록 하자.)
    
    public String toString() {
        return "Key: " + key + " - " +additionalInfo.toString();
    }
    /**
     * 
     * @변수 : 다른 힙의 원소들
     * @키값과 부가적인 정보 모두 동일하다면 참을 반환하고 그렇지 않으면 거짓을 반환하는 메소드
     */
    public boolean equals(HeapElement otherHeapElement) {
        return (this.key == otherHeapElement.key) && (this.additionalInfo.equals(otherHeapElement.additionalInfo));
    }
}
