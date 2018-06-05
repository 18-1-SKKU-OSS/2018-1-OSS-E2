import java.util.Scanner;

/**
 * This program will print out the factorial of any non-negative
 * number that you input into it.
 * 이 프로그램은 음이 아닌 정수를 입력받고, 그 수이 팩토리얼을 계산해줍니다.
 * 
 * @author Marcus
 *
 */
public class Factorial{

	/**
	 * The main method
	 * 메인 메서드
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
          System.out.print("Enter a non-negative integer: ");
          
       //If user does not enter an Integer, we want program to fail gracefully, letting the user know why it terminated   
          // 만약 사용자가 정수를 입력하지 않을 경우, 우리는 사용자가 왜 프로그램이 종료되는지를 알려주면서 프로그램을 종료합니다. 
          try{
            int number = input.nextInt();
            
       //We keep prompting the user until they enter a non-negative number 
            // 사용자가 음이 아닌 정수를 입력할 때 까지 입력을 받습니다. 
            while(number < 0){
              System.out.println("Your input must be non-negative. Please enter a non-negative number: ");
              number = input.nextInt();
            }
       //Display the result 결과를 출력합니다. 
 	   System.out.println("The factorial of " + number + " will yield: " + factorial(number));  
           
          }catch(Exception e){
            System.out.println("Error: You did not enter an integer. Program has terminated.");
          }
          input.close();
        }
        
	/**
	 * Recursive Factorial Method
	 * 재귀적인 방법으로 팩토리얼을 계산합니다. 
	 * 
	 * @param n The number to factorial
	 * @return The factorial of the number
	 * 
	 * n이라는 변수는 팩토리얼을 적용할 수 입니다. 
	 * 수의 팩토리얼 값을 리턴합니다. 
	 */
	public static long factorial(int n){
          if(n == 0 || n == 1) return 1;
          return n * factorial(n - 1);
	}
}
