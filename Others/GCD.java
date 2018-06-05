//Oskar Enmalm 3/10/17
//This is Euclid's algorithm which is used to find the greatest common denominator
//Overide function name gcd
// 이것은 최대 공약수를 찾기 위해 유클리드의 방법을 사용합니다. 
// gcd라는 함수를 오버라이드합니다. 


public class GCD{

      public static int gcd(int num1, int num2) {
	
        int gcdValue = num1 % num2;
        while (gcdValue != 0) {
            num2 = gcdValue;
            gcdValue = num2 % gcdValue;
        }
        return num2;
    }
	public static int gcd(int[] number) {
		  int result = number[0];
		  for(int i = 1; i < number.length; i++) 
			  //call gcd function (input two value) gcd 함수를 호출합니다. (두 개의 값을 입력합니다.)
		          result = gcd(result, number[i]);
		  
		  return result;
	}

	public static void main(String[] args) {
		int[] myIntArray = {4,16,32};
		//call gcd function (input array) gcd 함수를 호출합니다. (배열을 입력합니다.)
                System.out.println(gcd(myIntArray));
    }
}
