import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        
        String answer = "";
        Stack<String> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            int left = Integer.parseInt(stack.pop());
            int right = Integer.parseInt(stack.pop());
            if(c == '+'){
                stack.push(String.valueOf(left + right));
            }else if(c == '-'){
                stack.push(String.valueOf(left - right));
            }else if(c == '*'){
                stack.push(String.valueOf(left * right));
            }else if(c == '/'){
                stack.push(String.valueOf(left / right));
            }else{
                stack.push(String.valueOf(c));
            }
        }
           
        return stack.pop();
    }
}
