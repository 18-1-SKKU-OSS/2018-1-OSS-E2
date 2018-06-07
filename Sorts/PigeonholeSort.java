package sort;

import static java.lang.System.out;
import java.util.Arrays;

/*
	분배 정렬의 한 종류
	원래의 배열 공간보다 더 큰 임의의 공간(비둘기집)을 만들어, 원소(비둘기)를 차례로 넣은 다음, 원래 위치로 정렬시키는 방식
*/


public class PigeonholeSort {

        public static void main(String[] args) {

    int[] array = { 30, 50, 7, 40, 88, 15, 44, 55, 22, 33, 77, 99, 11, 66, 1, 85 };

               array = pigeonholeSort(array);
		 // array = pigeonholeSort(array, 1, 99999);

               out.print(Arrays.toString(array));
        }

 

        public static int[] pigeonholeSort(int[] array) {
               int min = array[0], max = array[0];
               for (int x : array) {
                       min = Math.min(x, min);
                       max = Math.max(x, max);
               }

               return pigeonholeSort(array, min, max);
        }


       public static <E extends Comparable<? super E>> int[] pigeonholeSort(int[] array, int min, int max) {

               final int size = max - min + 1;
		
	      // our array of pigeonholes
               int[] holes = new int[size];

               // Populate the pigeonholes.
               for (int x : array)
                       holes[x - min]++;


               // Put the elements back into the array in order.
               int i = 0;
               for (int count = 0; count < size; count++)
                       while (holes[count]-- > 0)
                              array[i++] = count + min;


               return array;

        }
}
