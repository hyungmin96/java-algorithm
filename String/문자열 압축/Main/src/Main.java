import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test case : KSTTTSEEKFKKKDJJGG
        // Result : KST3SE2KFK3DJ2G2 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        System.out.println(solution(str));
    }

    public static String solution(String str){
        
        String answer = "";
        char[] array = str.toCharArray();
        char temp = '.';

        for (int i = 0; i < array.length; i++) {
            int index = 1;
            if (temp != array[i]) {
                temp = array[i];
                while (i + index < array.length && array[i] == array[i + index]) {
                    index ++;
                }   
                answer += (index > 1) ? String.valueOf(array[i]) + index : String.valueOf(array[i]);
            }
        }

        return answer;
    }

}
