import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int[][] board;
    static int n, k, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        board = new int[n + 1][n + 1];

        for(int i = 1; i <= k; i ++){
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(stz.nextToken());
            int col = Integer.parseInt(stz.nextToken());
            board[row][col] = 1;
        }

        visited[1] = true;
        dfs(1);

        System.out.println(answer);
    }

    public static void dfs(int node){

        if(n == node)
            answer ++;
        else{
            for(int i = 1; i <= n; i ++){
                if(!visited[i] && board[node][i] == 1){
                    visited[i] = true;
                    dfs(i);
                    visited[i] = false;
                }
            }
        }
    }

}
