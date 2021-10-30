import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MIN_VALUE;

    static class Info {
        int score;
        int time;

        public Info(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());

        Info[] arr = new Info[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, n, k, 0, 0, arr, visited);

        System.out.println(answer);
    }

    public static void dfs(int depth, int level, int limit, int score, int time, Info[] arr, boolean[] visited) {

        if(limit < time) return;
        if (depth == level) {
            answer = (score > answer) ? score : answer;
            return;
        } else {
            dfs(depth + 1, level, limit, score + arr[depth].score, time + arr[depth].time, arr, visited);
            dfs(depth + 1, level, limit, score, time, arr, visited);
        }
    }

}
