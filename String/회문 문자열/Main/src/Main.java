import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        System.out.println(usingForMethod(str));
    }

    // Ohter solution using for() until half of string length
    private static String usingForMethod(String str){
        String answer = "Yes";
        for(int i = 0; i < str.length(); i ++)
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return "No";
        
        return answer;
    }

    // Ohter solution Using while()
    private static String usingWhileMethod(String str){
        String answer = "NO";
        char[] c = str.toCharArray();
        int left = 0, right = c.length - 1;
        while(right > left)
            if(c[left++] != c[right--]) return "NO"; else answer = "YES";

        return answer;
    }

    // my first solution
    // Using StringBuilder reverse() method
    private static String solution(String str){
        String answer = "No";
        if(str.equals(new StringBuilder(str).reverse().toString()))
            answer = "YES";
            
        return answer;
    }

}
