package sort;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

 

import java.util.Arrays;

 

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