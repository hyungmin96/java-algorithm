import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.io.*;

public class Main {
    /*
     * 문제 링크 : https://cote.inflearn.com/contest/10/problem/05-03 입력 첫 줄에 자연수
     * N(5<=N<=30)이 주어집니다. 두 번째 줄부터 N*N board 배열이 주어집니다. board의 각 칸에는 0 이상 100 이하인
     * 정수가 담겨있습니다. 0은 빈 칸을 나타냅니다. 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의
     * 인형을 나타냅니다. board배열이 끝난 다음줄에 moves 배열의 길이 M이 주어집니다. 마지막 줄에는 moves 배열이 주어집니다.
     * moves 배열의 크기는 1 이상 1,000 이하입니다. moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인
     * 자연수입니다.
     * 
     * 출력 첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.
     * 
     * Input : 5 0 0 0 0 0 0 0 1 0 3 0 2 5 0 1 4 2 4 4 2 3 5 1 3 1 8 1 5 3 5 1 2 1 4
     * 
     * Output : 4
     * 
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        int k = Integer.parseInt(br.readLine());
        int[] moves = new int[k];
        moves = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(solution(n, arr, k, moves));
    }

    public static Integer solution(int n, int[][] arr, int k, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (Integer move : moves) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][move - 1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == arr[i][move - 1]){
                        stack.pop();
                        answer ++;
                    }else {
                        stack.push(arr[i][move - 1]);
                    }
                    arr[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer * 2;
    }
}
