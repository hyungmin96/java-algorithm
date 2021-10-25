import java.util.*;
import java.io.*;

public class Main {

    public static int[] array;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        solution(n);
        for(int i = 1; i <= n; i ++) System.out.print(array[i] + " ");
    }

    public static int solution(int n){
        if(array[n] == 0){
            if(n == 1)
            return array[n] = 1;
            else if(n == 2){
                return array[n] = 1;
            }else{
                return array[n] = solution(n - 2) + solution(n - 1);
            }
        }else return array[n];
    }
}
