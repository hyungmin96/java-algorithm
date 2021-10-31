import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
        출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
        격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
        위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.

    입력
        7*7 격자판의 정보가 주어집니다.

    출력
        첫 번째 줄에 경로의 가지수를 출력한다.

    Input : 
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

    Output :
        8
*/

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[7][7];
        int[] dx = { -1, 0, 1, 0 }; // 왼쪽 오른쪽
        int[] dy = { 0, 1, 0, -1 }; // 위 아래

        for(int i = 0; i < board.length; i ++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        }

        board[0][0] = 1;
        dfs(0, 0, board, dx, dy);
        System.out.println(answer);
    }

    public static void dfs(int row, int col, int[][] board, int[] dx, int[] dy){
        
        if(row == 6 && col == 6){
            answer ++;
        }
        else{
            for(int i = 0; i < dx.length; i ++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                if(nr >= 0 && nr < 7 && nc >= 0 && nc < 7 && board[nr][nc] != 1){
                    board[nr][nc] = 1;
                    dfs(nr, nc, board, dx, dy);
                    board[nr][nc] = 0;
                }
            }
        }

    }

}
