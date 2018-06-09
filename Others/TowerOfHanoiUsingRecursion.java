import java.util.Scanner;

class TowerOfHanoi
{
    public static void shift(int n, String startPole, String intermediatePole, String endPole)
    {
        if (n == 0) // if n becomes zero the program returns thus ending the loop.  n=0�� ��, ���α׷��� �����ϰ� ������ �����ŵ�ϴ�. 
        {
            return;
        }
      
      
        // Shift function is called in recursion for swapping the n-1 disc from the startPole to the intermediatePole
        // n-1���� ���� ���� ��պ��� �߰� ������� �Űܾ��ϱ� ������ Shift�Լ��� ��������� ȣ��˴ϴ�.  
        shift(n - 1, startPole, endPole, intermediatePole);
        System.out.println("\nMove \"" + n + "\" from " + startPole + " --> " + endPole); // Result Printing  ��� ���
        // Shift function is called in recursion for swapping the n-1 disc from the intermediatePole to the endPole
        // n-1���� ���� �߰� ������κ��� �� ������� �Űܾ��ϱ� ������ Shift �Լ��� ��������� ȣ��˴ϴ�. 
        shift(n - 1, intermediatePole, startPole, endPole);
    }
    public static void main(String[] args)
    {
        System.out.print("Enter number of discs on Pole 1: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfDiscs = scanner.nextInt(); //input of number of discs on pole 1  1��° ����� ���� ������ �Է��մϴ�. 
        shift(numberOfDiscs, "Pole1", "Pole2", "Pole3"); //Shift function called   Shift �Լ��� ȣ��˴ϴ�. 
    }
}
