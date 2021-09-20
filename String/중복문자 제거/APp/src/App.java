import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        if(str.length() <= 100){
            System.out.println(usingIndexOf(str));
        }else 
            System.out.println("100글자 이하로 설정해주세요.");
    }

    // Using indexOf() method solution
    private static String usingIndexOf(String str){
        
        String answer = "";
        // How to delete duplicated char in str ?
        // Using if{} when, indexOf(str.charAt(i) > )
        for(int i = 0; i < str.toCharArray().length; i ++)
            if(i == str.indexOf(str.charAt(i)))
                answer += str.charAt(i);

        return answer;
    }

    // my first solution
    private static String solution(String str){

        StringBuilder sb = new StringBuilder(str);

        for(int i = 0; i < sb.length(); i ++)
            for(int j = str.toCharArray().length - 1; j > 0; j --)
                if(sb.charAt(i) == sb.charAt(j))
                    sb.deleteCharAt(j);
                    
        return sb.toString();
    }
}
