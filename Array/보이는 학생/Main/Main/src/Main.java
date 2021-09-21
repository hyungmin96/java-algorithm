import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        System.out.println(solution(str));
    }

    // Test case : 8 \n 130 135 148 140 145 150 150 153
    // Result : 5
    public static String solution(String str){

        String answer = "";
        String[] array = str.split(" ");
        int count = 0;
        int temp = Integer.MIN_VALUE;

        for(String item : array){
            int current = Integer.parseInt(item);
            if(temp < current){
                count ++;
                temp = current;
            }
        }

        return answer + count;

    }

}
