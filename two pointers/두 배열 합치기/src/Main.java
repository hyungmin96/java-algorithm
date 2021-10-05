import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
    입력
        첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
        두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
        세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
        네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
        각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

    출력
        오름차순으로 정렬된 배열을 출력합니다.

    input : 
    3
    1 3 5
    5
    2 3 6 7 9

    output : 
    1 2 3 3 5 6 7 9
*/
public class Main {
    public static void main(String[] args) throws Exception {
     
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(bf.readLine());
        String[] arr1 = bf.readLine().split(" ");

        int two = Integer.parseInt(bf.readLine());
        String[] arr2 = bf.readLine().split(" ");

        System.out.println(solution(arr1, arr2));

    }

    // my solution
    public static String solution(String[] arr1, String[] arr2){
        String answer = "";
        
        int first = 0;
        int two = 0;

        while(first < arr1.length || two < arr2.length){
            if(first >= arr1.length){
                answer += arr2[two++] + " ";
            }else if(two >= arr2.length){
                answer += arr1[first++] + " ";
            }else if(Integer.parseInt(arr1[first]) < Integer.parseInt(arr2[two])){
                answer += arr1[first++] + " ";
            }else{
                answer += arr2[two++] + " ";
            }
        }

        return answer;
    }
} 
