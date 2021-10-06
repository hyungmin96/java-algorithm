
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
/* 
    설명
        0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
        만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
        1 1 0 0 1 1 0 1 1 0 1 1 0 1
        여러분이 만들 수 있는 1이 연속된 연속부분수열은
        Image1.jpg
        이며 그 길이는 8입니다.

    입력
        첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
        두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

    출력
        첫 줄에 최대 길이를 출력하세요.

    Input : 
        14 2
        1 1 0 0 1 1 0 1 1 0 1 1 0 1

    Output : 
        8
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(input.split(" ")[0]); // 자연수 배열의 수
        int k = Integer.parseInt(input.split(" ")[1]); // '0' 을 '1'로 변경할 횟수
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(solution(n, k, arr));
    }

    // other solution
    public static int otherSolution(int n, int k, int[] arr){
        int answer = 0, left = 0, right = 0, count = 0;

        for(; right < n; right ++){
            if(arr[right] == 0) count ++;

            while(count > k){
                if(arr[left] == 0) count --;
                left ++;
            }

            answer = (right - left + 1 > answer) ? right - left + 1 : answer;
        }

        return answer;
    }

    // my solution
    public static int solution(int n, int k, int[] arr){
        int answer = 0, left = 0, right = 0;

        ArrayList<Integer> change = new ArrayList<>();

        for(; right < n; right ++){
            while(arr[right] == 0 && change.size() < k){
                arr[right] = 1;
                change.add(right);
            }
            
            if(change.size() == k){
                int length = 0;
                while(arr[left++] != 0 && left < n){
                    length ++;
                }
                if(answer < length) answer = length;
                arr[change.get(0)] = 0;
                left = change.get(0) + 1;
                change.remove(0);
            }
        }

        return answer;
    }
}
