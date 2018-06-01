package search;

import java.util.Scanner;

/**
  * Saddleback 검색을 수행하는 프로그램
 * 정렬 된 2D 배열 (요소는 모든 행과 열에 걸쳐 정렬되며 오름차순으로 가정)
 * 크기 n * m의 주어진 원소를 O (n + m)
 * 우리는 왼쪽 하단부터 시작합니다.
 현재 요소가 주어진 요소보다 큰 경우 위로 이동합니다.
 * 그렇지 않으면 우리는 오른쪽으로 움직인다.
 * 샘플 입력 :
 * 5 5 -> 치수
 * -10 -5 -3 4 9
 * -6 -2 0 5 10
 * -4 -1 1 6 12
 * 2 3 7 8 13
 * 100 120 130 140 150
 * 140 -> 검색 할 요소
 * 출력 : 4 3 // 첫 번째 값은 행이고, 두 번째 값은 열입니다.
 *
 * @author Nishita Aggarwal
 */
public class SaddlebackSearch {

    /**
      *이 방법은 새들백 검색을 수행합니다.
 *
      * @param arr 요소를 검색하는 ** Sorted ** 배열입니다.
      * @param row - 현재의 행.
      * @param col - 현재의 열.
      * @param key 검색 대상의 요소.
      * @return 요소의 인덱스 (행과 열).
     * Else returns -1 -1.
     */
    private static int[] find(int arr[][], int row, int col, int key) {

        //array to store the answer row and column
        int ans[] = {-1, -1};
        if (row < 0 || col >= arr[row].length) {
            return ans;
        }
        if (arr[row][col] == key) {
            ans[0] = row;
            ans[1] = col;
            return ans;
        }
        //if the current element is greater than the given element then we move up
        else if (arr[row][col] > key) {
            return find(arr, row - 1, col, key);
        }
        //else we move right
        return find(arr, row, col + 1, key);
    }

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int arr[][];
        int i, j, rows = sc.nextInt(), col = sc.nextInt();
        arr = new int[rows][col];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ele = sc.nextInt();
        //we start from bottom left corner
        int ans[] = find(arr, rows - 1, 0, ele);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }

}
