import java.util.*;

public class RedBlackTree<T extends Comparable<T>> {

    /*
    레드블랙 트리
    */

    

    public static final int red   = 0;

    public static final int black = 1;

	

	//비교시 편의를 위해 인스턴스 변수 명ㅁ명 규칙을 사용

    private int               __color;

    private T                 __val;

    private RedBlackTree<T>   __left;

    private RedBlackTree<T>   __right;



    private RedBlackTree(RedBlackTree<T> b) {

        __val      = b.__val;

        __left     = b.__left;

        __right    = b.__right;

        __color    = red;

    }



    private void copy(RedBlackTree<T> x) {

        __val     = x.__val;

        __left    = x.__left;

        __right   = x.__right;

		__color   = x.__color;

	}

    

    private RedBlackTree<T> RBinsertLeft(T k,int sw) {

        RedBlackTree<T> l;

        RedBlackTree<T> b;

        

        l = __left;

        if (l == null) {

            __left = b = new RedBlackTree<T>(k);

        }

        else {

            b = l.RBinsert(k,sw);

        }

        return b;

    }

        

    private RedBlackTree<T> RBinsertRight(T k,int sw) {

        RedBlackTree<T> r;

        RedBlackTree<T> b;

        

        r = __right;

        if (r == null) {

            __right = b = new RedBlackTree<T>(k

            );

        }

        else {

            b = r.RBinsert(k,sw);

        }

        return b;

    }

    

    private RedBlackTree<T> rotLeft()

    {

       RedBlackTree<T> x;

       RedBlackTree<T> me;



	   if (__right == null) return null;

      // 현재 노드 __self의 복사본에 변화를 준다.
      // 반환으로, 호출자는 'me'에서 현재 노드로 복사한다.

	   me          = new RedBlackTree<T>(this);

       x           = me.__right;

       me.__right  = x.__left;

       x.__left    = me;

       return   x;

    }



    private RedBlackTree<T> rotRight()

    {

       RedBlackTree<T> x;

       RedBlackTree<T> me;



	   if (__left == null) return null;



      // 현재 노드 __self의 복사본에 변화를 준다.
      // 반환으로, 호출자는 'me'에서 현재 노드로 복사한다.

	   me          = new RedBlackTree<T>(this);

       x           = me.__left;

       me.__left   = x.__right;

       x.__right   = me;

       return x;

    }



    private RedBlackTree<T> RBinsert(T k,int sw) {

        RedBlackTree<T> b = null;

        RedBlackTree<T> x;

        RedBlackTree<T> l;

        RedBlackTree<T> ll;

        RedBlackTree<T> r;

        RedBlackTree<T> rr;

        

        // 현재 노드가 4 노드인 경우 색상을 뒤집어서 분할한다.

        //이 노드의 두 자식이 모두 빨간색인 경우 이 노드를 빨간색으로 변경하고
        //자식 노드를 검정으로 변경한다.
        l = __left;

        r = __right;

        if ((l != null)&&(l.__color==red)&&(r != null)&&(r.__color==red)) {

            __color = red;

            l.__color = black;

            r.__color = black;

        }

        

        // key 관계에 따라 왼쪽 또는 오른쪽으로 간다.

        if (k.compareTo(__val) < 0) {

            // 재귀적 삽입

            b = RBinsertLeft(k,0);

            

            // 돌아오는 길에 회전이 필요한지 확인한다.

            // 탐색 경로에 동일한 방향으로 두  개의 빨간색 링크가 있는 경우
            // 한 번의 회전을 수행하고 색상 비트를 뒤집는다.

            l = __left;

            if ((__color == red)&&(l != null)&&(l.__color == red)&&(sw == 1)) {

                x = rotRight();

        		if (x != null) {

        		    // copy가 'this'에 노드를 반환한다.

        		    copy(x);

            	}

            }

            

            // 색상 비트 뒤집기.
            l = __left;

            if (l != null) {

                ll = l.__left;

                if (ll != null) {

                    if ((l.__color == red)&&(ll.__color == red)) {

                        x = rotRight();

                		if (x != null) {

                		    copy(x);

                    	}

                        __color = black;

                        r = __right;

                        if (r != null) {

                           r.__color = red;

                        }

                    }

                }

            }

        }

        else {

            b = RBinsertRight(k,1);

            
 	    // 돌아오는 길에 회전이 필요한지 확인한다.

            // 탐색 경로에 동일한 방향으로 두  개의 빨간색 링크가 있는 경우
            // 한 번의 회전을 수행하고 색상 비트를 뒤집는다.
            r = __right;

            if ((__color == red)&&(r != null)&&(r.__color == red)&&(sw == 0)) {

                x = rotLeft();

        		if (x != null) {

        		    // copy가 'this'에 노드를 반환한다.

        		    copy(x);

            	}

            }

            

            // 색상 비트 

            r = __right;

            if (r != null) {

                rr = r.__right;

                if (rr != null) {

                    if ((r.__color == red)&&(rr.__color == red)) {

                        x = rotLeft();

                		if (x != null) {

                		    // copy가 'this'에 노드를 반환한다.

                		    copy(x);

                    	}

                        __color = black;

                        l = __left;

                        if (l != null) {

                           l.__color = red;

                        }

                    }

                }

            }

        }            

        

        return b;

    }

	

// ==================================================

// PUBLIC METHODS

// ==================================================

    public RedBlackTree(T x) {

        __val      = x;

        __left     = null;

        __right    = null;

        __color  = red;

    }



    public String toString() {

        String s = "";

        s = "[" + __val + "," + __color + "]";

        return s;

    }



    public T val() {

        return __val;

    }

    

    public int color() {

        return __color;

    }



	public RedBlackTree<T> find(T key) {

        RedBlackTree<T> result = null;

        if (key == __val) {

            result = this;

        }

        else if (key.compareTo(__val) < 0) {

            if (__left != null) {

                result = __left.find(key);

            }

        }

        else {

            if (__right != null) {

                result = __right.find(key);

            }

        }

        return result;

	}

    

    public void inorder(NodeVisitor visitor,int depth) {

        if (__left != null) {

            __left.inorder(visitor,depth+1);

        }

        visitor.visit(this,depth);

        if (__right != null) {

            __right.inorder(visitor,depth+1);

        }

    }

    

    public RedBlackTree<T> insert(T k) {

        RedBlackTree<T> b;

        b = RBinsert(k,0);

        __color = black;

        return b;

    }



/* NODE VISITOR interface from 'NodeVisitor.java'
public interface NodeVisitor {
    public void visit(RedBlackTree node,int depth);
}
    
*/



// ==================================

// test program

// ==================================

    public static void main(String[] args) {

        int[] nodelist = {11,4,8,14,17,6,9,7,16,15,13,5,19,18,12,10,3,20,1};

        NodeVisitor v;

        

        // insert all the data into the tree
	// 트리에 모든 데이터를 삽입한다.
        RedBlackTree<Integer> root = new RedBlackTree<Integer>(2);

        for(int n:nodelist) {

            root.insert(n);

        }

        

        // anonymous class implementing the NodeVisitor interface

        v = new NodeVisitor() {

            public void visit(RedBlackTree node,int depth) {

                if (node.val() != null) {

                    System.out.print("(" + node.val().toString() + ":" + node.color()  + ":" + depth + "), ");

                }

            }

        };

        System.out.print("Java     = ");    

        root.inorder(v,0);

        System.out.println();

        

        RedBlackTree<Integer> x = root.find(16);

        System.out.println(x.toString());

    }

}
