import java.util.*;
import java.io.*;


public class Main {

    /* 
        설명
            N개의 수로 이루어진 수열이 주어집니다.
            이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
            만약 N=8, M=6이고 수열이 다음과 같다면
            1 2 1 3 1 1 1 2
            합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

        입력
            첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
            수열의 원소값은 1,000을 넘지 않는 자연수이다.

        출력
            첫째 줄에 경우의 수를 출력한다.

        Input : 
            8 6
            1 2 1 3 1 1 1 2

        Output :
            3
    */

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(solution(n, m, arr));
    }

    public static Integer solution(int n, int m, int[] arr){

        int answer = 0, sum = 0, start = 0, end = 0;

        for(; start < n; start ++){
            while(sum < m && end < n){
                sum += arr[end++];
            }
            if(sum == m) answer ++;
            sum -= arr[start];
        }

        return answer;

    }
}
