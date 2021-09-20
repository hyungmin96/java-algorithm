import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        System.out.println(otherSolution(wordCount, str));
    }

    // Other solution
    public static String otherSolution(int wordCount, String str){

        String answer = "";
        str = str.replace('#', '1').replace('*', '0');

        for(int i = 0; i < wordCount; i ++){
            String temp = str.substring(0, 7);
            answer += (char)(Integer.parseInt(temp, 2));
            str = str.substring(7);
        }
        return answer;

    }

    // Test case : #****###**#####**#####**##**
    // Test case : #****## #**#### #**#### #**##** 7자단위이고 공백은 이를 구분하기위해 처리, input은 모든 공백을 지우고 넣어야함
    // Result : 'COOL'
    public static String solution(int wordCount, String str){
        String answer = "";
        String[] words = new String[wordCount];
        str = str.replaceAll("#", "1").replaceAll("[*]", "0");

        for(int i = 0; i < words.length; i ++){
            String word = "";
            word += str.substring(0, 7);
            str = str.substring(7);
            words[i] = word;
        }

        for(int i = 0; i < words.length; i++){
            int count = 0;
            for(int j = 0; j < words[i].length(); j++)
                if(words[i].charAt(j) == '1')
                    count += Math.pow(2, 6 - j);
            
            answer += Character.toString((char)count);
        }
        return answer;
    }

}
