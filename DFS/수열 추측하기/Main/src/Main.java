import java.util.*;
import java.io.*;
public class Main {

/* 
    설명
        가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
        예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
        3   1   2   4
          4   3   6
            7   9
              16
        N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
        단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

    입력
        첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
        N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

    출력
        첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
        답이 존재하지 않는 경우는 입력으로 주어지지 않는다. 

    Input :
        4 16

    Output :
        3 1 2 4
*/

    static int[] p;
    static int[] numbers;
    static int[][] memory;
    static boolean[] visited;
    static int nums, total, sum = 0;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        
        nums = Integer.parseInt(stz.nextToken());
        total = Integer.parseInt(stz.nextToken());

        numbers = new int[nums];
        p = new int[nums];
        visited = new boolean[nums + 1];
        memory = new int[35][35];

        for(int i = 0; i < nums; i ++){
            p[i] = getCombi(nums - 1, i);
        } 

        dfs(0, 0);

    }

    public static void dfs(int start, int sum){
        if(flag) return;
        if(start == nums){
            if(total == sum){
                for(int i = 0; i < nums; i ++) System.out.print(numbers[i] + " ");
                flag = true; 
            } 
        }
        else{
            // numbers 배열에 새로운 순열조합을 생성하면서 dfs를 통해 최종 값이 얼마가 나오는지 확인
            for(int i = 1; i <= nums; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    numbers[start] = i;
                    dfs(start + 1, sum + (p[start] * numbers[start]));
                    visited[i] = false;
                }
            }
        }
    }

    public static int getCombi(int n, int r){
        if(n == r || r == 0)
            return 1;
        else{
            if(memory[n][r] != 0) return memory[n][r];
            return memory[n][r] = getCombi(n - 1, r - 1) + getCombi(n - 1, r);
        }
    }
}
