import java.util.*;
import java.io.*;
public class App {

    static int[] p;
    static int[] numbers;
    static int n, k;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());

        p = new int[k];
        visited = new boolean[n];

        numbers = new int[n];
        for(int i = 0; i < n; i ++) numbers[i] = i + 1;

        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == k){
            for(int item : p) System.out.print(item + " ");
            System.out.println();
            return;
        }
        else{
            for(int i = 0; i < n; i ++){
                if(visited[i]) continue;
                visited[i] = true;
                p[depth] = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
