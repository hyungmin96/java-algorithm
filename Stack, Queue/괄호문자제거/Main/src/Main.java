import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
/* 
    설명
        입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

    입력
        첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

    출력
        남은 문자만 출력한다.

    Input : 
        (A(BC)D)EF(G(H)(IJ)K)LM(N)

    Output :
        EFLM
*/

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!c.equals(')'))
                stack.push(c);
            else{
                while (!stack.isEmpty() && stack.peek() != '('){
                    stack.pop();
                }
                if(stack.peek() == '(') stack.pop();
            }
        }

        for(int i = 0; i < stack.size(); i ++)
            answer += stack.get(i);

        return answer;
    }
}
