import static java.lang.System.out;
import java.util.Arrays;

/*
	교환정렬 알고리즘의 한 종류이다.
	거품정렬과 비슷하게 인접 원소들을 스왑하여 정렬한다.
*/


public class CombSort {
        public static void main(String[] args) {

	   int[] array = { 30, 50, 7, 40, 88, 15, 44, 55, 22, 33, 77, 99, 11, 66, 1, 85 };
               array = combSort(array);
               out.print(Arrays.toString(array));
        }


        private static int newGap(int gap) {
               gap = gap * 10 / 13;
               if (gap == 9 || gap == 10) gap = 11;
               if (gap < 1) return 1;
               
	     return gap;
        }

        private static int[] combSort(int array[]) {

               int n = array.length;
               boolean swapped;

               do {
                       swapped = false;
                       n = newGap(n);

                       for (int i = 0; i < (array.length - n); i++) {
                              if (array[i] > array[i + n]) {
                                      swapped = true;
                                      int temp = array[i];
                                      array[i] = array[i + n];
                                      array[i + n] = temp;
                              }

                       }

               } while (n > 1 || swapped);


               return array;
        }


}