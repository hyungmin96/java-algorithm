import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        for(Integer item : solution(n, arr)){
            System.out.print(item + " ");
        }
    }

    public static int[] solution(int n, int[] arr){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i ++){
            for(int j = i; j < n; j ++){
                if(arr[i] > arr[j]){
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }

        return arr;
    }
}
