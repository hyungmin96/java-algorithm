import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

       String str = bufferedReader.readLine();

        System.out.println(usingIndexOf(str));
    }

    // Using indexOf() method
    private static String usingIndexOf(String str){
        int pos = Integer.MIN_VALUE;
        String answer = "";

        // extract 'time' word
        // The last word, 'study', is not extracted because of indexOf ("")
        while((pos = str.indexOf(" ")) != -1){
            String temp = str.substring(0, pos);
            int len = temp.length();
            if(len > answer.length()) answer = temp;
            str = str.substring(pos + 1);
        }
        // when while{} exit, compare the length of last word and rest of str
        if(str.length() > answer.length()) answer = str;
        return answer;
    }

    // Using forEach method
    private static String solution(String str){
        String answer = "";
        String[] array = str.split(" ");

        for(String item : array){
            if(answer.length() < item.length()) answer = item;
        }
        return answer;
    }
}
