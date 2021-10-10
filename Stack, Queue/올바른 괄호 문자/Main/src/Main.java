import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
        (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

    입력
        첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

    출력
        첫 번째 줄에 YES, NO를 출력한다.

    Input :
        (()(()))(()

    Output :
        NO
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && c == ')' && stack.peek() != ')')
                stack.pop();
            else
                stack.push(c);
        }

        answer = (stack.size() == 0) ? "YES" : "NO";

        return answer;
    }

}
