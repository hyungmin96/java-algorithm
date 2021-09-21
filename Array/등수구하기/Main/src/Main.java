import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        System.out.println(solution(totalElements, str));
    }

    /* 
        * 점수 별 학생의 등수를 return
        Complexity : O(n2)
        Test case : 5 \n 87 89 92 100 76
        Result : 4 3 2 1 5
    */

    public static String solution(int totalElements, String[] str){
        String answer = "";

        int[] scores = Arrays.stream(str).mapToInt(i -> Integer.parseInt(i)).toArray();

        for(int i = 0; i < scores.length; i ++){
            int rank = 1;
            for(int j = 0; j < scores.length; j ++){
                if(scores[i] < scores[j]){
                    rank += 1;
                }
            }
            answer += rank + " ";
        }

        return answer;
    }
}
