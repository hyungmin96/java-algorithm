import java.io.BufferedReader;
import java.io.InputStreamReader;

    /*
        * 첫 줄 자연수 N
        * 두 번째 줄 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다 각 자연수는 100을 넘지 않는다.
        Test case : 
            5
            10 13 10 12 15
            12 39 30 23 11
            11 25 50 53 15
            19 27 29 37 27
            19 13 30 13 19

        Result : 
            155
    */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalElements = Integer.parseInt(bf.readLine());
        String[][] array = new String[totalElements][totalElements];

        for(int i = 0; i < totalElements; i ++){
            array[i] = bf.readLine().split(" ");
        }
        System.out.println(solution(totalElements, array));

    }
    public static String solution(int totalElements, String[][] array){
            
        int maximum = Integer.MIN_VALUE;
        int temp = 0;
        int value1, value2;
        for(int i = 0; i < array.length; i ++){
            value1 = value2 = 0;
            for(int j = 0; j < array.length; j ++){
                value1 += Integer.parseInt(array[i][j]);
                value2 += Integer.parseInt(array[j][i]);
            }

            if(value1 <= value2) temp = value2; else temp = value1;
            if(maximum < temp) maximum = temp;
        }

        value1 = value2 = 0;
        for(int i = 0; i < array.length; i ++){
            value1 += Integer.parseInt(array[i][i]);
            value2 += Integer.parseInt(array[i][(array.length - 1) - i]);
        }
        if(value1 <= value2) temp = value2; else temp = value1;
        if(maximum < temp) maximum = temp;

        return String.valueOf(maximum);
    }

}
