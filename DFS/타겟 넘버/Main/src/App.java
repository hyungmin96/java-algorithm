import java.util.*;
import java.io.*;

public class App {

    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int target = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[stz.countTokens()];

        int index = 0;
        while(stz.hasMoreTokens()){
            numbers[index++] = Integer.parseInt(stz.nextToken());
        }

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){

        dfs(0, numbers.length, 0, numbers, target);

        return answer;

    }

    public static void dfs(int depth, int level, int curr, int[] numbers, int target){
        if(depth == level){
            if(target == curr){
                answer ++;
            }
            return;
        }else{
            dfs(depth + 1, level, curr + numbers[depth], numbers, target);
            dfs(depth + 1, level, curr - numbers[depth], numbers, target);
        }
    }
}
