import java.util.*;
import java.io.*;

public class App {

    static int[] p;
    static int[] numbers;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());

        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        int[] output = new int[k];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(0, 0, k, arr, visited, output);
    }

    public static void dfs(int index, int depth, int level, int[] arr, boolean[] visited, int[] output) {

        if(depth == level){
            for(int item : output) System.out.print(item + " ");
            System.out.println();
            return;
        }else{
            for(int i = index; i < arr.length; i ++){
                output[depth] = arr[i];
                dfs(i + 1, depth + 1, level, arr, visited, output);
            }
        }

    }

}
