import java.util.*;
import java.io.*;

public class Main {

/*
     * 설명 
     *  다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가? 각 단위의
     *  동전은 무한정 쓸 수 있다.
     * 
     * 입력 
     *  첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러
     *  줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
     * 
     * Input : 
     *  3
     *  1 2 5
     *  15
     * 
     * Output : 
     *  3
*/
    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i ++) numbers[i] = Integer.parseInt(stz.nextToken());
        Arrays.sort(numbers, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int total) {

        if (total > m) return;
        if (total == m) {
            answer = Math.min(answer, start);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(start + 1, total + numbers[i]);
            }
        }
    }
}
