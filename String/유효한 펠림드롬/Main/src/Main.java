import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toLowerCase();
        System.out.println(solution(str));
    }

    private static String solution(String str){
        String answer = "Yes";
        String[] array = str.replaceAll(",", ";").split("; ");
        
        int left = 0, right = array.length - 1;

        while(right > left)
            if(!array[left++].equals(reverseString(array[right--])))
                return "No";

        return answer;
    }

    private static String reverseString(String str){
        String value = "";
        for(int i = str.toCharArray().length - 1; i >= 0; i --)
            value += str.charAt(i);
            
        return value;
    }

}
