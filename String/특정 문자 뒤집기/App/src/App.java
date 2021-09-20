import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        System.out.println(otherSolution(str));
    }

    // other solution
    private static String otherSolution(String str){
        
        String answer;
        char[] c = str.toCharArray();
        int left = 0, right = c.length - 1;

        while(right > left){

            if(!Character.isAlphabetic(c[left]))
                left ++;
            else if(!Character.isAlphabetic(c[right]))
                right --;
            else {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left ++;
                right --;
            }
        }
        answer = String.valueOf(c);

        return answer;
    }

    // my first solution
    private static char[] solution(String str){
        int strIndex = 0;
        char[] sentence = str.toCharArray();
        // add to index of alphabet
        // how to many number of alphabet in str
        ArrayList<Integer> list = new ArrayList<>(); 

        for(char c : sentence){
            // case : character 'c' is alphabet
            if((c >= 65 && c <= 122) || c >= 48 && c <= 57)
                list.add(strIndex);

            strIndex ++;
        }

        int left = 0;
        int right = list.size() - 1;
        char temp;
        
        while(right > left){
            temp = sentence[list.get(left)];
            sentence[list.get(left++)] = sentence[list.get(right)];
            sentence[list.get(right--)] = temp;
        }
        return sentence;
    }

}
