import java.util.Scanner;

public class FibToN {

	public static void main(String[] args) {
		//take input 입력 받기
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		// print fibonacci sequence less than N  N보다 작은 피보나치 수열 출력
		int first = 0, second = 1;
		//first fibo and second fibonacci are 0 and 1 respectively  피보나치 수열의 첫번째, 두번째 수는 0과 1 입니다. 
		scn.close();
		while(first <= N){
			//print first fibo 0 then add second fibo into it while updating second as well. Update first equal as second
			//첫번째 수 0을 출력하고 두번째 수를 첫번째 수에 더하여 second를 업데이트합니다. first 라는 변수를 second와 같은 수로 업데이트 합니다. 
			
			System.out.println(first);
			
			int next = first+ second;
			first = second;
			second = next;
		}
	}

}
