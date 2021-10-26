
import java.util.*;
import java.io.*;

public class App {

    static int v, e, answer = 1;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(stz.nextToken());
        e = Integer.parseInt(stz.nextToken());

        distance = new int[v + 1];
        visited = new boolean[v + 1];

        for(int i = 0; i <= v; i ++)
            nodes.add(new ArrayList<>());

        for(int i = 1; i <= e; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            nodes.get(node).add(child);
        }

        for(ArrayList<Integer> node : nodes)
            Collections.sort(node);

        bfs(1);
        for(int i = 1; i < distance.length; i ++) System.out.println(i + " : " + distance[i]);
    }
    
    public static void bfs(int n){

        Queue<Integer> que = new LinkedList<>();
       
        visited[1] = true;
        distance[n] = 0;
        que.offer(n);

        while(!que.isEmpty()){
            int curr = que.poll();
            for(int child : nodes.get(curr)){
                if(!visited[child]){
                    visited[child] = true;
                    que.offer(child);
                    distance[child] = distance[curr] + 1;
                }
            }
        }
       
    }

}
