import java.util.Scanner;

public class FibToN {

	public static void main(String[] args) {
		//take input �Է� �ޱ�
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		// print fibonacci sequence less than N  N���� ���� �Ǻ���ġ ���� ���
		int first = 0, second = 1;
		//first fibo and second fibonacci are 0 and 1 respectively  �Ǻ���ġ ������ ù��°, �ι�° ���� 0�� 1 �Դϴ�. 
		scn.close();
		while(first <= N){
			//print first fibo 0 then add second fibo into it while updating second as well. Update first equal as second
			//ù��° �� 0�� ����ϰ� �ι�° ���� ù��° ���� ���Ͽ� second�� ������Ʈ�մϴ�. first ��� ������ second�� ���� ���� ������Ʈ �մϴ�. 
			
			System.out.println(first);
			
			int next = first+ second;
			first = second;
			second = next;
		}
	}

}
