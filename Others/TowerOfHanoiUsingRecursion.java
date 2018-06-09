import java.util.Scanner;

class TowerOfHanoi
{
    public static void shift(int n, String startPole, String intermediatePole, String endPole)
    {
        if (n == 0) // if n becomes zero the program returns thus ending the loop.  n=0일 때, 프로그램은 리턴하고 루프를 종료시킵니다. 
        {
            return;
        }
      
      
        // Shift function is called in recursion for swapping the n-1 disc from the startPole to the intermediatePole
        // n-1개의 판을 시작 기둥부터 중간 기둥으로 옮겨야하기 때문에 Shift함수는 재귀적으로 호출됩니다.  
        shift(n - 1, startPole, endPole, intermediatePole);
        System.out.println("\nMove \"" + n + "\" from " + startPole + " --> " + endPole); // Result Printing  결과 출력
        // Shift function is called in recursion for swapping the n-1 disc from the intermediatePole to the endPole
        // n-1개의 판을 중간 기둥으로부터 끝 기둥으로 옮겨야하기 때문에 Shift 함수는 재귀적으로 호출됩니다. 
        shift(n - 1, intermediatePole, startPole, endPole);
    }
    public static void main(String[] args)
    {
        System.out.print("Enter number of discs on Pole 1: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfDiscs = scanner.nextInt(); //input of number of discs on pole 1  1번째 기둥의 판의 갯수를 입력합니다. 
        shift(numberOfDiscs, "Pole1", "Pole2", "Pole3"); //Shift function called   Shift 함수가 호출됩니다. 
    }
}
