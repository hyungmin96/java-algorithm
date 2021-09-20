import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// test case : teachermode e
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        System.out.println(getDistance(str.split(" ")[0], str.split(" ")[1].charAt(0)));
    }

    // Other solution 
    // Using for() two times
    public static String getDistance(String str, char findChar){

        int[] distance = new int[str.length()];
        int count = Integer.MAX_VALUE;

        for(int i = 0; i < distance.length; i ++){
            if(str.charAt(i) == findChar)
                count = 0;
            else
                count ++;
                
            distance[i] = count;
        }
        
        for(int j = distance.length -1; j >= 0; j --){
            if(str.charAt(j) == findChar)
                count = 0;
            else
                count ++;

            if(count < distance[j])
                distance[j] = count;
        }
        return Arrays.toString(distance).replaceAll("[^0-9 ]", "");
    }

    // my firsh solution
    public static String solution(String str, String findChar){
        
        String answer = "";
        int[] indexs = getSpectificIndex(str, findChar);
        
        for(int j = 0; j < str.length(); j ++){
            int min = Integer.MAX_VALUE;
            if(str.charAt(j) == findChar.charAt(0))
                min = 0;
            else{
                for(int i = 0; i < indexs.length; i ++){
                    if(min > Math.abs(indexs[i] - j))
                        min = Math.abs(indexs[i] - j);
                }
            }
            answer += min + " ";
        }

        return answer;
    }

    public static int[] getSpectificIndex(String str, String findChar){
        int index = 0;
        ArrayList<Integer> indexs = new ArrayList<>();
        for(char c : str.toCharArray()){
            if(c == findChar.charAt(0))
                indexs.add(index);

            index ++;
        }
        return indexs.stream().mapToInt(i -> i).toArray();
    }
}
