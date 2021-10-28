
import java.util.*;
import java.io.*;

public class Main {

    static int[][] memory;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());

        memory = new int[n + 1][n + 1];

        System.out.println(dfs(n, k));
    }

    public static int dfs(int n, int k){

       if(n == k || k == 0)
            return 1;
        else{
            if(memory[n][k] != 0)
                return memory[n][k];
            else
                return memory[n][k] = dfs(n - 1, k) + dfs(n - 1, k - 1);
        }

    }
}
