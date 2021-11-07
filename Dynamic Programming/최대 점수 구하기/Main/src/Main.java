import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
/* 
    설명
        이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
        각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
        제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
        (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

    입력
        첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
        두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

    출력
        첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

    Input :
        5 20
        10 5
        25 12
        15 8
        6 3
        7 4

    Output :
        41
*/
    static class Class{
        int score, time;
        public Class(int score, int time){
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());

        Class[] array = new Class[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);

        for(int i = 0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            array[i] = new Class(score, time);
        }

        solution(n, k, dp, array);
    }

    public static void solution(int n, int k, int[] dp, Class[] array){

        for(int i = 0; i < n; i ++){
            for(int j = dp.length - 1; j >= array[i].time; j --){
                dp[j] = Math.max(dp[j], dp[(j) - array[i].time] + array[i].score);
            }
            array[i] = new Class(0, 0);
        }

        System.out.println(dp[dp.length - 1]);
    }
}
