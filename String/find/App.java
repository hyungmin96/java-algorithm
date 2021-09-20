
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String value = bufferedReader.readLine();
        value = value.toLowerCase();
        char findValue = (char) bufferedReader.read(); // BufferedReader를 이용해서 char로 입력값을 받는 방법
        System.out.println(findStringCount(value, findValue));
    }

    // Using forEach method
    private static int findStringCount(String value, char findValue){
        int count = 0;
        findValue = Character.toLowerCase(findValue);
        for(char item : value.toCharArray()){
            if(item == findValue) count ++;
        }
        return count;
    }



}
