/* Program to reverse a Stack using Recursion
 * 재귀를 사용하여 스택을 뒤집는 프로그램입니다. 
 * */


import java.util.Stack;

public class ReverseStackUsingRecursion {

    //Stack 스택
    private static Stack<Integer> stack=new Stack<>();

    //Main function 메인 메서드
    public static void main(String[] args) {
        //To Create a Dummy Stack containing integers from 0-9  0부터 9까지의 정수를 원소로 가지고 있는 더비 스택을 만듭니다. 
        for(int i=0;i<10;i++)
        {
            stack.push(i);
        }
        System.out.println("STACK");

        //To print that dummy Stack 더미 스택을 출력합니다. 
        for(int k=9;k>=0;k--)
        {
            System.out.println(k);
        }

        //Reverse Function called Reverse 함수를 사용합니다. 
        reverseUsingRecursion(stack);

        System.out.println("REVERSED STACK : ");
        //To print reversed  stack  뒤집어진 스택을 출력합니다. 
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }


    }

    //Function Used to reverse Stack Using Recursion  스택을 뒤집는 함수입니다. 재귀를 사용하여 구현하였습니다. 
    private static void reverseUsingRecursion(Stack<Integer> stack) {
        if(stack.isEmpty()) // If stack is empty then return  스택이 비어있다면 리턴합니다. 
        {
            return;
        }
        /* All items are stored in call stack until we reach the end
         * 모든 아이템들은 스택의 끝에 도달하기 전까지는 불러진 스택에 저장되어 있슴니다. 
         * */

        int temptop=stack.peek();
        stack.pop();
        reverseUsingRecursion(stack); //Recursion call 재귀
        insertAtEnd(temptop); // Insert items held in call stack one by one into stack 불러온 스택에 있는 원소들을 스택의 가장 아래에 넣습니다. 
    }

    //Function used to insert element at the end of stack  원소를 스택의 바닥에 삽입하기 위해 사용하는 함수입니다
    private static void insertAtEnd(int temptop) {
        if(stack.isEmpty())
        {
            stack.push(temptop); // If stack is empty push the element 스택이 비어있다면 원소를 넣습니다. 
        }
        else {
            int temp = stack.peek(); /* All the items are stored in call stack until we reach end  모든 원소들은 스택의 가장 아래에 접근 할때까지 불러온 스택에 저장됩니다. */
            stack.pop();

            insertAtEnd(temptop); //Recursive call 재귀적 호출

            stack.push(temp);
        }

    }

}
