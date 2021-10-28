import java.util.*;
import java.io.*;

public class Main {
    /*
     * 설명 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면
     * 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다. 현수는 스카이 콩콩을 타고
     * 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지
     * 구하는 프로그램을 작성하세요.
     * 
     * 입력 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
     * 
     * 출력 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
     * 
     * Input : 5 14 Output : 3
     */
    static int level = 0;
    static Queue<Integer> que = new LinkedList<>();
    static int[] ch;
    static int[] dis = {1, -1, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);
        System.out.println(recursive(n, k));
    }

    public static int recursive(int n, int k) {

        int curr = 0;
        ch = new int[10001];
        ch[n] = 1;
        que.offer(n);
        
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                curr = que.poll();
                for(int j = 0; j < dis.length; j ++){
                    if(curr == k) return level ++;
                    if(curr + dis[j] >= 1 && curr + dis[j] <= 100000 && ch[curr + dis[j]] != 1){
                        ch[curr + dis[j]] = 1;
                        que.offer(curr + dis[j]);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
