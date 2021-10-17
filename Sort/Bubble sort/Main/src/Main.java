
import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
        정렬하는 방법은 버블정렬입니다.

    입력
        첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
        두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

    출력
        오름차순으로 정렬된 수열을 출력합니다.

    Input : 
        13 5 11 7 23 15

    Output : 
        5 7 11 13 15 23
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        for(Integer item : solution(n, arr)){
            System.out.print(item + " ");
        }
    }

    public static int[] solution(int n, int[] arr){

        int temp;

        for(int i = 0; i < n - 1; i ++){
            for (int j = 0; j < n - i - 1; j ++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

}
