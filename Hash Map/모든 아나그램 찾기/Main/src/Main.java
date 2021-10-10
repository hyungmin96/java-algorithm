import java.io.*;
import java.util.*;

public class Main {

    /*
     * 설명 S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
     * 부분문자열은 연속된 문자열이어야 합니다.
     * 
     * 입력 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다. S문자열의 길이는 10,000을 넘지 않으며, T문자열은
     * S문자열보다 길이가 작거나 같습니다.
     * 
     * 출력 S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
     * 
     * Input : bacaAacba abc
     * 
     * Output : 3
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(solution(s, t));
    }

    public static Integer solution(String s, String t) {

        int answer = 0;
        int left = 0, right = 0, count = 0;

        Map<Character, Integer> amap = new HashMap<>();
        Map<Character, Integer> bmap = new HashMap<>();

        for (int j = 0; j < t.length(); j++)
            bmap.put(t.charAt(j), bmap.getOrDefault(t.charAt(j), 0) + 1);

        for (; right < s.length(); right++) {
            boolean isAnagram = false;
            amap.put(s.charAt(right), amap.getOrDefault(s.charAt(right), 0) + 1);
            count ++;

            if (count == t.length()) {
                for (Character c : amap.keySet()) {
                    // if (bmap.containsKey(c) && bmap.get(c) == amap.get(c)) {
                    if(amap.equals(bmap)){
                        isAnagram = true;
                    } else {
                        isAnagram = false;
                        break;
                    }
                }

                if (isAnagram)
                    answer++;

                if (amap.getOrDefault(s.charAt(left), 0) < 2) {
                    amap.remove(s.charAt(left));
                } else {
                    amap.put(s.charAt(left), amap.getOrDefault(s.charAt(left), 0) - 1);
                }

                count--;
                left++;
            }
        }

        return answer;
    }
}
