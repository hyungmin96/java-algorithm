
import java.util.*;
import java.io.*;

public class App {

    static int[] arr;
    static int[] permutation;
    static boolean[] visited;
    static int n;
    static int workCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stz.nextToken());

        arr = new int[n + 1];
        permutation = new int[n];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i ++) arr[i] = i;

        dfs(0);


    }

    public static void dfs(int start){

        if(start == n){
            for(int item : permutation) System.out.print(item + " ");
            System.out.println();
            return;
        }
        else{
            for(int i = 1; i <= n; i ++){
                if(visited[i]) continue;
                visited[i] = true;
                permutation[start] = arr[i];
                dfs(start + 1);
                System.out.println("work Count : " + i);
                visited[i] = false;
            }
        }

    }

}
