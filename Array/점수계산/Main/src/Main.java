import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        System.out.println(solution(totalElements, str));
    }

    public static String solution(int totalElements, String[] str){
        
        int answer = 0;
        int count = 0;

        for(String item : str){
            if(item.equals("1")){
                count ++;
            }else{
                count = 0;
            }
            answer += count;
        }

        return String.valueOf(answer);
    }
}
