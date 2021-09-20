import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int fix = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        System.out.println(solution(str, fix));
    }

    public static String solution(String str, int fix){
        String answer = "";
        String[] array = str.split(" ");
        for(int i = 0; i < array.length; i ++){
            if(i == 0){
                answer += array[i] + " ";
            }else if(Integer.parseInt(array[i]) == fix){
                answer += array[i] + " ";
            }else if(Integer.parseInt(array[i]) > Integer.parseInt(array[i - 1])){
                answer += array[i] + " ";
            }
        }
        return answer;
    }
}
