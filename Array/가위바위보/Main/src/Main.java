import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(bf.readLine());
        String userA = bf.readLine();
        String userB = bf.readLine();
        
        System.out.println(solution(round, userA, userB));
    }

    /* 
        Test case :
        5
        2 3 3 1 3
        1 1 2 2 3
        
        Result : 
        A
        B
        A
        B
        D
    */

    public static String solution(int round, String userA, String userB){
        String answer = "";

        int[] a_array = Arrays.stream(userA.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int[] b_array = Arrays.stream(userB.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        for(int i = 0; i < round; i ++){
            if(a_array[i] == b_array[i]){
                answer += "D\n";
            }else if(a_array[i] > b_array[i] && a_array[i] - b_array[i] == 2){
                answer += "B\n";
            }else if(a_array[i] > b_array[i]){
                answer += "A\n";
            }else if(a_array[i] < b_array[i]){
                answer += "B\n";
            }else{
                answer += "A\n";
            }
        }

        return answer;
    }
}
