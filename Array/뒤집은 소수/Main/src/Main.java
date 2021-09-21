import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        System.out.println(solution(totalElements, str));
    }

    /* 
        Test case : 9 \n 32 55 62 20 250 370 200 30 100
        Result : 23 2 73 2 3
        * 뒤집은 소수의 맨 앞이 '0'일 경우 무시한다. '009' -> '9'
     */
    public static String solution(int totalElements, String str){
        
        String answer = "";
        int[] array = Arrays.stream(str.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        // 입력받은 소수를 뒤집기
        for(int i = 0; i < array.length; i ++)
            array[i] = Integer.parseInt(new StringBuilder(String.valueOf(array[i])).reverse().toString());

        /* 
            * 다른 방식으로 숫자 자리를 뒤집기
            for(int i = 0; i < str.length(); i ++){
                int res = 0;
                int temp = array[i];
                while(temep > 0){
                    int t = temp % 10; 
                    res = res * 10 + t;
                    temp = temp / 10;
                }
            }
        */

        for(int item : array){
            boolean isPrimeNumber = true;

            if(item == 1) break;

            for(int i = 2; i < item; i ++){
                if(item % i == 0){
                    isPrimeNumber = !isPrimeNumber;
                    break;
                }
            }
            if(isPrimeNumber) answer += item + " ";
        }

        return answer;
    }

}
