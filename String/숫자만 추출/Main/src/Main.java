import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        System.out.println(solution(str));
    }

    // test case : g0en2T0s8eSoft
    private static String solution(String str){
        String answer = "";
        for(char c : str.toCharArray())
            if(Character.isDigit(c))
                if(!(answer.length() == 0 && c == '0'))
                    answer += c;

        return answer;
    }

}
