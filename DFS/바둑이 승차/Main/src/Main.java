
import java.util.*;
import java.io.*;

public class Main {

/* 
    설명
        철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
        철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
        N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

    입력
        첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
        둘째 줄부터 N마리 바둑이의 무게가 주어진다.

    출력
        첫 번째 줄에 가장 무거운 무게를 출력한다.

    Input : 
        259 5
        81
        58
        42
        33
        61

    Output :
        242
*/

    static int n, k, total = 0;
    static int sum = 0;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        
        int[] arr = new int[k + 1];
        visited = new boolean[k + 1];

        for(int i = 0; i < k; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        dfs(0, 0, arr);
        
        System.out.println(answer);
    }

    public static void dfs(int start, int total, int[] arr){
        if(total > n) return;
        if(k == start){
            answer = Math.max(answer, total);
            return;
        }else{
            dfs(start + 1, total + arr[start], arr);
            dfs(start + 1, total, arr);
        }
    }
}
