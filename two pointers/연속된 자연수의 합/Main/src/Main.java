
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(solution(n));

    }

    // Using two pointers algorithm
    public static int solution(int n){
        
        int answer = 0;
        int left = 0, right = 0, sum = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i ++)
            arr[i] = i + 1;

        for(; left < n; left ++){
            while(sum < n && right < n - 1){
                sum += arr[right++];
            }
            if(sum == n) answer ++;
            sum -= arr[left];
        }
        
        return answer;
    }
}
