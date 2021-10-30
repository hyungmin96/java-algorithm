import java.util.*;
import java.io.*;

public class App {

    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());

        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        int[] combi = new int[n];

        for(int r = 0; r < n; r ++){
            combi[r] = getCombi(n - 1, r);
        }

        dfs(0, n, 0, k, arr, combi, visited);

    }

    public static void dfs(int depth, int level, int curr, int target, int[] arr, int[] combi, boolean[] visited){
        if(flag) return;
        if(depth == level){
            if(curr == target){
                flag = true;
                for(int item : arr) System.out.print(item + " ");
                System.out.println();
            }
            return;
        }else{
            for(int i = 0; i < level; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1, level, curr + (arr[depth] * combi[depth]), target, arr, combi, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static int getCombi(int n, int r){
        if(n == r || r == 0){
            return 1;
        }else{
            return getCombi(n - 1, r) + getCombi(n - 1, r - 1);
        }
    }

}
