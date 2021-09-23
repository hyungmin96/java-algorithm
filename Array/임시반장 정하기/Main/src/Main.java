import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
    * 첫 줄은 학생의 수를 설정
    * 출력값은 학생중에 같은 반을 많이 한 학생의 번호를 출력

    Test case :
    5
    2 3 1 7 3
    4 1 9 6 8
    5 5 2 4 4
    6 5 2 6 7
    8 4 2 2 2

    Result : 
    4

*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        int[][] input = new int[totalElements][5];

        for(int i = 0; i < totalElements; i ++)
            input[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(solution(input));
    }

    public static int solution(int[][] input) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int j = 0; j < input.length; j++) { // 학생
            int count = 0;
            for (int k = 0; k < input.length; k++) { // 반
                for (int i = 0; i < 5; i++) { // 학년
                    if (input[k][i] == input[j][i] && j != k) {
                        count += 1;
                        break;
                    }
                }
            }
            if(max < count) {
                max = count;
                answer = j + 1;
            }
        }

        return answer;
    }
}
