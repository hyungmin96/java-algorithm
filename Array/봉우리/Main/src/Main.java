import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
    * 각 격자판의 자신의 숫자에서 상하좌우중 가장 큰 숫자는 봉우리 지역이며, 이 봉우리의 개수를 출력
    * 입력된 배열에서 가장자리는 '0' 으로 초기화

    Test case :
    5
    5 3 7 2 3
    3 7 1 6 1
    7 2 5 3 4
    4 3 6 4 1
    8 7 3 5 2

    Result :
    10
*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        
        int[][] field = new int[count + 2][count + 2];
        int[][] input = new int[count][count];

        for(int i = 0; i < count; i ++)
            input[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        for(int i = 1; i < field.length - 1; i ++){
            for(int j = 1; j <= input.length; j ++){
                field[i][j] = input[i - 1][j - 1];
            }
        }

        System.out.println(solution(field));
    }

    public static int solution(int[][] field){
        int answer = 0;

        for(int i = 1; i < field.length - 1; i ++){
            int current = 0;
            for(int j = 1; j < field.length - 1; j ++){
                current = field[i][j];
                if(current > field[i - 1][j] && current > field[i + 1][j] && current > field[i][j - 1] && current > field[i][j + 1]){
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}
