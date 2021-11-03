import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
/* 
    설명
        현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
        각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
        단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

    입력
        첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.

    출력
        첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

    Input :
        6
        50 2
        20 1
        40 2
        60 3
        30 3
        30 1

    Output :
        150
*/
    static class Class implements Comparable<Class>{
        int money, day;
        public Class(int money, int day){
            this.money = money;
            this.day = day;
        }
        @Override
        public int compareTo(Main.Class o) {
            if(this.day == o.day){
                return o.money - this.money;
            }else{
                return o.day - this.day;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        Class[] arr = new Class[n];

        for(int i = 0; i < n; i ++){
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(stz.nextToken()); 
            int day = Integer.parseInt(stz.nextToken());
            arr[i] = new Class(money, day);
            if(max < day) max = day;
        }

        System.out.println(solution(max, arr));
    }

    public static int solution(int max, Class[] arr){
        
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(arr);

        int j = 0;
        for(int i = max; i >= 1; i --){
            for(; j < arr.length; j ++){
                if(arr[j].day < i){
                    break;
                }
                pq.offer(arr[j].money);
            }
            if(!pq.isEmpty()) answer += pq.poll();
            
        }

        return answer;
    }
}



