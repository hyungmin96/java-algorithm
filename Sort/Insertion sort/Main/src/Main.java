
import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.(삽입 정렬)
        정렬하는 방법은 삽입정렬입니다.

    입력
        첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
        두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

    출력
        오름차순으로 정렬된 수열을 출력합니다.    

    Input :
        6
        11 7 5 6 10 9

    Output :
        5 6 7 9 10 11
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

        for(int i = 1; i < n; i ++){
            int temp = arr[i];
            int j;
            for(j = i - 1; j >= 0; j --){
                if(arr[j] > temp)
                    arr[j + 1] = arr[j];
                else
                    break;
            }
            arr[j + 1] = temp;
        }

        return arr;
    }

}
