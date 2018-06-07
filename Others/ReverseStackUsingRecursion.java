/* Program to reverse a Stack using Recursion
 * ��͸� ����Ͽ� ������ ������ ���α׷��Դϴ�. 
 * */


import java.util.Stack;

public class ReverseStackUsingRecursion {

    //Stack ����
    private static Stack<Integer> stack=new Stack<>();

    //Main function ���� �޼���
    public static void main(String[] args) {
        //To Create a Dummy Stack containing integers from 0-9  0���� 9������ ������ ���ҷ� ������ �ִ� ���� ������ ����ϴ�. 
        for(int i=0;i<10;i++)
        {
            stack.push(i);
        }
        System.out.println("STACK");

        //To print that dummy Stack ���� ������ ����մϴ�. 
        for(int k=9;k>=0;k--)
        {
            System.out.println(k);
        }

        //Reverse Function called Reverse �Լ��� ����մϴ�. 
        reverseUsingRecursion(stack);

        System.out.println("REVERSED STACK : ");
        //To print reversed  stack  �������� ������ ����մϴ�. 
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }


    }

    //Function Used to reverse Stack Using Recursion  ������ ������ �Լ��Դϴ�. ��͸� ����Ͽ� �����Ͽ����ϴ�. 
    private static void reverseUsingRecursion(Stack<Integer> stack) {
        if(stack.isEmpty()) // If stack is empty then return  ������ ����ִٸ� �����մϴ�. 
        {
            return;
        }
        /* All items are stored in call stack until we reach the end
         * ��� �����۵��� ������ ���� �����ϱ� �������� �ҷ��� ���ÿ� ����Ǿ� �ֽ��ϴ�. 
         * */

        int temptop=stack.peek();
        stack.pop();
        reverseUsingRecursion(stack); //Recursion call ���
        insertAtEnd(temptop); // Insert items held in call stack one by one into stack �ҷ��� ���ÿ� �ִ� ���ҵ��� ������ ���� �Ʒ��� �ֽ��ϴ�. 
    }

    //Function used to insert element at the end of stack  ���Ҹ� ������ �ٴڿ� �����ϱ� ���� ����ϴ� �Լ��Դϴ�
    private static void insertAtEnd(int temptop) {
        if(stack.isEmpty())
        {
            stack.push(temptop); // If stack is empty push the element ������ ����ִٸ� ���Ҹ� �ֽ��ϴ�. 
        }
        else {
            int temp = stack.peek(); /* All the items are stored in call stack until we reach end  ��� ���ҵ��� ������ ���� �Ʒ��� ���� �Ҷ����� �ҷ��� ���ÿ� ����˴ϴ�. */
            stack.pop();

            insertAtEnd(temptop); //Recursive call ����� ȣ��

            stack.push(temp);
        }

    }

}
