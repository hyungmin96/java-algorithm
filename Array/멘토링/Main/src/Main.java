import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
    * 첫 번째 줄의 첫 번째 값은 학생 수(N) 두 번째 값은 시험을 볼 횟수(M)
    * 두 번째 줄부터 M개의 줄에 걸쳐  수학테스트 결과가 학생번호로 주어진다 학생번호가 제일 앞 부터 1, 2, 3... N 표현됨
    * 한 줄에 N=4이고, 결과가 3 4 1 2로 입력되면, 3번학생이 1등, 4번 학생이 2등을 의미함

    Test case : 
    4 3
    3 4 1 2
    4 3 2 1
    3 1 4 2

    Result : 
    3
*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int n = Integer.parseInt(str.split(" ")[1]); // 시험 횟 수
        int m = Integer.parseInt(str.split(" ")[0]); // 학생 수
        int[][] input = new int[n][m];

        for (int i = 0; i < n; i++)
            input[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(solution(n, m, input));
    }

    public static int solution(int n, int m, int[][] input) {
        int answer = 0;
        
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= m; j ++){
                int count = 0; 
                for(int k = 0; k < n; k ++){
                    int pi = 0;
                    int pj = 0;
                    for(int s = 0; s < m; s ++){
                        if(input[k][s] == i) pi = s;
                        if(input[k][s] == j) pj = s;
                    }
                    if(pi > pj) count ++;
                }
                if(count == n) answer ++;
            }
        }

        return answer;
    }
}
