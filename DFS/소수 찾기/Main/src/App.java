import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers){

        int length = numbers.length();
        
        boolean[] visited = new boolean[length];
        int[] arr = new int[length];
        HashSet<Integer> hash = new HashSet<>();

        for(int i = 0; i < length; i ++){
            arr[i] = numbers.charAt(i) - 48;
        }

        dfs(0, length, 0, arr, visited, hash);

        return hash.size();
    }

    public static void dfs(int depth, int length, int curr, int[] arr, boolean[] visited, HashSet<Integer> hash){

        if(depth == length){
            if(isPrime(curr)){
                hash.add(curr);
            }
            return;
        }else{
            for(int i = 0; i < length; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(depth + 1, length, curr * 10 + arr[i], arr, visited, hash);
                    visited[i] = false;
                }
            }
            if(isPrime(curr)){
                hash.add(curr);
            }
        }
    }

    public static boolean isPrime(int n){

        if(n == 0 || n == 1 || n == 2) {
            return false;
        }else{
            for(int i = 2; i <= Math.sqrt(n); i ++){
                if(n % i == 0){
                    return false;
                }
            }
        }

        return true;
    }

}
