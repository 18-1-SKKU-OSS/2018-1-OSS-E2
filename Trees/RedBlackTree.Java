import java.util.*;

public class RedBlackTree<T extends Comparable<T>> {

    /*
    Red/Black tree implementation based on 
    Algorithms in C++, Sedgewick
    Introduction To Algorithms Cormen, Thomas H. / Leiserson, Charl es E . / Rivest, Ronald L . The MIT Press 07/1990
 
    */

    

    public static final int red   = 0;

    public static final int black = 1;

	

	// use the instance variable naming convention for convenience in comparing

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

      // make the changes in a copy of current node __self

      // on return, the caller will copy in 'me' to current node

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



      // make the changes in a copy of current node __self

      // on return, the caller will copy in 'me' to current node

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

        

        // if current node is a 4 node, split it by flipping its colors

        // if both children of this node are red, change this one to red

        // and the children to black

        l = __left;

        r = __right;

        if ((l != null)&&(l.__color==red)&&(r != null)&&(r.__color==red)) {

            __color = red;

            l.__color = black;

            r.__color = black;

        }

        

        // go left or right depending on key relationship

        if (k.compareTo(__val) < 0) {

            // recursively insert

            b = RBinsertLeft(k,0);

            

            // on the way back up check if a rotation is needed

            // if search path has two red links with same orientation

            // do a single rotation and flip the color bits

            l = __left;

            if ((__color == red)&&(l != null)&&(l.__color == red)&&(sw == 1)) {

                x = rotRight();

        		if (x != null) {

        		    // copy returned node to 'this'

        		    copy(x);

            	}

            }

            

            // flip the color bits

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

            

            // on the way back up check if a rotation is needed

            // if search path has two red links with same orientation

            // do a single rotation and flip the color bits

            r = __right;

            if ((__color == red)&&(r != null)&&(r.__color == red)&&(sw == 0)) {

                x = rotLeft();

        		if (x != null) {

        		    // copy returned node to 'this'

        		    copy(x);

            	}

            }

            

            // flip the color bits

            r = __right;

            if (r != null) {

                rr = r.__right;

                if (rr != null) {

                    if ((r.__color == red)&&(rr.__color == red)) {

                        x = rotLeft();

                		if (x != null) {

                		    // copy returned node to 'this'

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
