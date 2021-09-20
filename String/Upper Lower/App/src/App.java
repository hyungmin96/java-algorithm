import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String value = bufferedReader.readLine();

        if(value.length() < 100)
            System.out.println(usingASCIIcode(value.toCharArray()));
            // System.out.println(solution(value.toCharArray()));
        else
            System.out.println("100자 이하로 다시 시도해주세요.");

    }

    // Using ASCII number
    public static String usingASCIIcode(char[] array){
        String answer = "";
        for(char c : array){
            // 65 ~ 90 number is UpperCase character
            // 97 ~ 122 number is LowerCase charater
            // character type is numberic, so can use comperison operator
            if(c >= 97 && c <= 122){
                answer += Character.toUpperCase(c);
            }else{
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

    public static String solution(char[] array){
        String answer = "";
        for(char c : array){
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            }else{
                answer += Character.toUpperCase(c);
            }
        }
        return answer;
    }
}