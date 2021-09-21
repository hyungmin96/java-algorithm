import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(bf.readLine());
        System.out.println(solution(maximum));
    }

    /*
        첫 줄은 최댓값, 결과는 최댓값에 포함된 소수의 수
        Test case : 20
        Result : 8
    */

    public static int solution(int maximum){
        int answer = 0;
        int[] array = new int[maximum];

        for(int i = 2; i < array.length; i ++){
            if(array[i] == 0)
                answer ++;
            for(int j = i; j < array.length; j += i){
                array[j] = 1;
            }
        }

        return answer;
    }
}
