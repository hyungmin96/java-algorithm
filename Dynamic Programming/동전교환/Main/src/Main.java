import java.io.*;
import java.util.Arrays;
public class Main {

    public static int answer = 0;
    public static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] damage = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        int[] happy = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        solution(0, n, 0, 100, damage, happy);
    }

    public static void solution(int depth, int n, int score, int stamina, int[] damage, int[] happy){
        if(depth == n){
            System.out.println("happy : " + score + ", damage : " + stamina);
            answer = (answer > sum) ? answer : sum;
            return;
        }else{
            solution(depth + 1, n, score + happy[depth], stamina - damage[depth], damage, happy);
            solution(depth + 1, n, score, stamina, damage, happy);
        }
    }
}
