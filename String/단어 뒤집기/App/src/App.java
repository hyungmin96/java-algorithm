import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        String[] items = new String[count];
        if(count >= 3 && count <= 20){
            for(int i = 0; i < items.length; i ++){
                String str = bufferedReader.readLine();
                items[i] = str;
            }
            // for(String item : solution(items)) System.out.println(item);
            for(String item : changeOneOfOneWord(items)) System.out.println(item);

        }else{
            System.out.println("입력하실 단어의 갯수는 3개 이상, 20개 이하로 설정해주세요.");
        }
    }

    // change one of one word
    private static String[] changeOneOfOneWord(String[] items){

        for(int i = 0; i < items.length; i ++){
            int right = items[i].length() - 1;
            int left = 0;

            char[] c = items[i].toCharArray();

            while(left <= right){
                char temp = c[right];
                c[right--] = c[left];
                c[left++] = temp;
            }

            items[i] = String.valueOf(c);
        }

        return items;
    }

    // String type is immutable object so, when call the replace() or substring() method, new object was created then using memory
    // but StringBuilder is mutable
    private static String[] solution(String[] answer){
        for(int i = 0; i < answer.length; i ++){
            // Using StringBuilder's reverse() method
            String item = new StringBuilder(answer[i]).reverse().toString();
            answer[i] = item;
        }
        return answer;
    }

}
