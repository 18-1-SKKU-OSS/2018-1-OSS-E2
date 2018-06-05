package sort;

import java.util.Arrays;
 
class RadixSort {
/*
raidx sort: 기수 정렬
정수의 자리수의 숫자를 기준으로 큐에 넣어서 순서대로 꺼내는 방식.
기준이 되는 자리수를 바꿔가면서 정렬
*/
 
    /* arr의 값 중 제일 큰 값을 구한다. */
    private static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

   /**/
    private static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0); //분포 수를 세기 위해 count 배열을 전부 0으로 초기화
 
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++; // 분포 수 세기
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1]; // 분포수를 누적해 저장하여 각 원소들이 들어갈 곳을 찾는다.
 
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        } // 원소를 배치한다.
 
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    private static void radixsort(int arr[], int n) {

        int m = getMax(arr, n);
 

        for (int exp = 1; m/exp > 0; exp *= 10) // exp가 m의 자리수가 될 때까지 countSort한다.
            countSort(arr, n, exp);
    }
 

    /* 배열을 출력한다. */
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
 


    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
}
// Written by James Mc Dermott(theycallmemac)
