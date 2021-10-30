import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {

        HashSet<Integer> hash = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length();
        boolean[] visited = new boolean[len];

        for(int i = 1; i <= len; i ++){
            dfs(0, i, len, str, sb, visited, hash);
        }

        System.out.println(hash.size());

    }

    public static void dfs(int depth, int level, int len, String str, StringBuilder sb, boolean[] visited, HashSet<Integer> hash){
        
        if(depth == level){
            System.out.println(sb.toString());
            if(isPrime(Integer.parseInt(sb.toString()))){
                hash.add(Integer.parseInt(sb.toString()));
            }
            return;
        }else{
            for(int i = 0; i < len; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(str.charAt(i));
                    dfs(depth + 1, level, len, str, sb, visited, hash);
                    sb.delete(sb.length() - 1, sb.length());
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i ++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
