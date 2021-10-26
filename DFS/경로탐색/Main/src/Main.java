import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);
        
        board = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < k; i ++){
            String str = br.readLine();
            int row = Integer.parseInt(str.split(" ")[0]);
            int col = Integer.parseInt(str.split(" ")[1]);
            board[row][col] = 1;
        }

        dfs(n);
    }

    public static int solution(int n, int k, int[][] board){
        int answer = 0;

        return answer;
    }

    public static void dfs(int n){
        
        visited[n] = true;
        for(int i = 1; i < board.length; i ++){
            if(!visited[n] && board[n][i] == 1){
                System.out.println(n + " ");
                dfs(n);
            }
        }

    }

}
