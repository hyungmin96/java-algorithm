import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /* 
    설명
        A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

    입력
        첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
        두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
        네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        각 집합의 원소는 1,000,000,000이하의 자연수입니다.

    출력
        두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

    Input :
        5
        1 3 9 5 2
        5
        3 2 5 7 8

    Output :
        2 3 5
    
    */
    public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int c1 = Integer.parseInt(bf.readLine());
        int[] arr1 = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        
        int c2 = Integer.parseInt(bf.readLine());
        int[] arr2 = Arrays.stream(bf.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        for(Integer item : solution(c1, c2, arr1, arr2))
            System.out.print(item + " ");
    }

    // my solution
    public static ArrayList<Integer> solution(int c1, int c2, int[] arr1, int[] arr2){
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // 1 2 3 5 9
        // 2 3 5 7 8

        while(p1 < c1 && p2 < c2){
            if(arr1[p1] > arr2[p2]){
                p2 ++;
            }else if(arr1[p1] < arr2[p2]){
                p1 ++;
            }else if(arr1[p1] == arr2[p2]){
                answer.add(arr1[p1]);
                p1 ++;
                p2 ++;
            }
        }
        
        return answer;
    }

}
