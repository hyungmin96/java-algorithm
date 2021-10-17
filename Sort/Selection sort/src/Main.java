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
        
        int temp = 0;

        for(int i = 0; i < n; i ++){
            int idx = i;
            for(int j = i + 1; j < n; j ++){
               if(arr[j] < arr[idx]) {
                    idx = j;
               }
            }
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        return arr;
    }
}
