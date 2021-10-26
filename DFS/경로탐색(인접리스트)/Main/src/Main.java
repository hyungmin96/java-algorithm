
import java.util.*;
import java.io.*;

public class Main {

    static int n, k, answer;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());

        visited = new boolean[n + 1];
    
        for(int i = 0; i <= n; i ++)
            nodes.add(new ArrayList<>());

        for(int i = 1; i <= k; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int childs = Integer.parseInt(st.nextToken());
            nodes.get(node).add(childs);
        }

        for(int i = 0; i < nodes.size(); i ++)
            Collections.sort(nodes.get(i));

        visited[1] = true;
        dfs(1);

        System.out.println(answer);
            
    }

    public static void dfs(int value){
        if(value == n)
            answer ++;
        else{
            for(int child : nodes.get(value)){
                if(!visited[child]){
                    visited[child] = true;
                    dfs(child);
                    visited[child] = false;
                }
            }
        }
    }
}
