import java.util.Scanner;

/**
 * This program will print out the factorial of any non-negative
 * number that you input into it.
 * �� ���α׷��� ���� �ƴ� ������ �Է¹ް�, �� ���� ���丮���� ������ݴϴ�.
 * 
 * @author Marcus
 *
 */
public class Factorial{

	/**
	 * The main method
	 * ���� �޼���
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
          System.out.print("Enter a non-negative integer: ");
          
       //If user does not enter an Integer, we want program to fail gracefully, letting the user know why it terminated   
          // ���� ����ڰ� ������ �Է����� ���� ���, �츮�� ����ڰ� �� ���α׷��� ����Ǵ����� �˷��ָ鼭 ���α׷��� �����մϴ�. 
          try{
            int number = input.nextInt();
            
       //We keep prompting the user until they enter a non-negative number 
            // ����ڰ� ���� �ƴ� ������ �Է��� �� ���� �Է��� �޽��ϴ�. 
            while(number < 0){
              System.out.println("Your input must be non-negative. Please enter a non-negative number: ");
              number = input.nextInt();
            }
       //Display the result ����� ����մϴ�. 
 	   System.out.println("The factorial of " + number + " will yield: " + factorial(number));  
           
          }catch(Exception e){
            System.out.println("Error: You did not enter an integer. Program has terminated.");
          }
          input.close();
        }
        
	/**
	 * Recursive Factorial Method
	 * ������� ������� ���丮���� ����մϴ�. 
	 * 
	 * @param n The number to factorial
	 * @return The factorial of the number
	 * 
	 * n�̶�� ������ ���丮���� ������ �� �Դϴ�. 
	 * ���� ���丮�� ���� �����մϴ�. 
	 */
	public static long factorial(int n){
          if(n == 0 || n == 1) return 1;
          return n * factorial(n - 1);
	}
}
