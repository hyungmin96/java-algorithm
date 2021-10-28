import java.util.*;
import java.io.*;

public class App {

    static int n, m = 0;
    static int[] numbers;
    static int[] pm;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        numbers = new int[n];
        pm = new int[m];
        visited = new boolean[n];

        for(int i = 0; i < n; i ++)
            numbers[i] = i + 1;

        dfs(0);
    }

    public static void dfs(int start){

        if(start == m){
            for(int item : pm) System.out.print(item + " ");
            System.out.println();
            return;
        }
        else{
            for(int i = 0; i < numbers.length; i ++){
                if(visited[i]) continue;
                visited[i] = true;
                pm[start] = numbers[i];
                dfs(start + 1);
                visited[i] = false;
            }
        }
    }

}
