
import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
        이분검색(이진 탐색이란 데이터가 정렬돼 있는 배열에서 특정한 값을 찾아내는 알고리즘)으로 
        M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.

    입력
        첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
        두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

    출력
        첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.    

    Input : 
        8 32
        23 87 65 12 57 32 99 81

    Output :
        3
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr){

        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (high + low) / 2;
            if(arr[mid] > k){
                high = mid - 1;
            }else if(arr[mid] == k){
                return mid + 1;
            }else{
                low = mid + 1;
            }
        }

        return 1;
    }
}
