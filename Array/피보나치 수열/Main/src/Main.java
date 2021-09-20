import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        System.out.println(solution(totalElements));
    }

    /*
        Test case : 10
        Result : 1 1 2 3 5 8 13 21 34 55
    */
    
    public static String solution(int totalElements){
        String answer = "";
        int[] array = new int[totalElements];
        for(int i = 0; i < totalElements; i ++){
            array[i] += (i - 1 >= 1) ? array[i - 1] + array[i - 2] : 1;
            answer += array[i] + " ";
        }

        return answer;
    }
}
