
import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
        정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

    입력
        첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
        두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

    출력
        N개의 좌표를 정렬하여 출력하세요.

    Input :
        5
        2 7
        1 3
        1 2
        2 5
        3 6

    Output :
        1 2
        1 3
        2 5
        2 7
        3 6
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cordinate[] cordinates = new cordinate[n];
        
        for(int i = 0; i < n; i ++){
            String input = br.readLine();
            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);
            cordinates[i] = new cordinate(x, y);
        }
        Arrays.sort(cordinates);
        for(cordinate item : cordinates) System.out.println(item.x + " " + item.y);
    }
}

class cordinate implements Comparable<cordinate>{

    int x;
    int y;

    public cordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(cordinate o) {
        if(this.x == o.x) 
            return this.y - o.y;
        else
            return this.x - o.x;
    }
}
