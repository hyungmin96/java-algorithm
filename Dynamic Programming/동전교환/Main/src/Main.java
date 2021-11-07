import java.io.*;
import java.util.Arrays;
public class Main {
/* 
    설명
        다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
        각 단위의 동전은 무한정 쓸 수 있다.

    입력
        첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
        두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
        각 동전의 종류는 100원을 넘지 않는다.

    출력
        첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

    Input :
        3
        1 2 5
        15

    Output :
        3
*/
    public static int answer = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] category = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        int total = Integer.parseInt(br.readLine());

        int[] arr = new int[total];
        Arrays.fill(arr, Integer.MAX_VALUE);
        System.out.println(solution(n, category, arr));
    }

    public static int solution(int n, int[] category, int[] arr){

        arr[0] = 1;

        for(int i = 0; i < n; i ++) // 동전의 종류만큼 반복
            for(int j = category[i]; j < arr.length; j ++) // j의 초기값을 동전 종류의 첫 번째 값으로 설정
                arr[j] = Math.min(arr[j], arr[j - category[i]] + 1);

        return arr[arr.length - 1];
    }
}
