import java.util.*;
import java.io.*;

public class Main {

/* 
    설명
        N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
        두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
        둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
        예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

    입력
        첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
        두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.

    출력
     번째 줄에 “YES" 또는 ”NO"를 출력한다.

    Input :
        6
        1 3 5 6 7 10

    Output :
        YES

*/

    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        
        total = Arrays.stream(arr).sum();

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int l, int sum){
        if(flag || sum > total / 2) return;
        // 마지막 노드의 Level(n)이 재귀적으로 들어온 l 인자와 같아질 경우 return
        if(n == l){
            if(total - sum == sum){
                answer = "YES"; 
                flag = true;
            }
            return;
        }else{
            // l + 1의 자식노드를 사용할 경우 sum 값에 해당 자식값을 더함
            dfs(l + 1, sum + arr[l]);

            // l + 1 자식노드를 사용하지 않음, 이 경우 sum 값에 해당 자식값을 더하지 않고 l값만 + 1
            dfs(l + 1, sum);
        }
    }

}
