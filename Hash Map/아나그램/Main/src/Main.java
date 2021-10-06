import java.io.*;
import java.util.*;

public class Main {

/*
    설명
        Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
        예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
        알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
        길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

    입력
        첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
        단어의 길이는 100을 넘지 않습니다.

    출력
        두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.

    Input :
        AbaAeCe
        baeeACA

    Output : 
        YES
*/    

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2){
        
        String answer = "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for(Character ch2 : s2.toCharArray()){
            if(map.containsKey(ch2)){
                map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            }else return "NO";
        }

        for(Integer item : map.values()){
            if(item != 0) 
                return "NO";
            else
                answer = "YES";
        }

        return answer;
    }

}
