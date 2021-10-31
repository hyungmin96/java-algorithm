import java.util.*;
import java.io.*;

public class Main {

    /*
     * 설명 N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은
     * 바다입니다. 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요. 만약 위와 같다면 섬의 개수는 5개입니다.
     * 
     * 입력 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다. 두 번째 줄부터 격자판 정보가 주어진다.
     * 
     * 출력 첫 번째 줄에 섬의 개수를 출력한다.
     * 
     * Input : 7 1 1 0 0 0 1 0 0 1 1 0 1 1 0 0 1 0 0 0 0 0 0 0 0 1 0 1 1 1 1 0 1 1 0
     * 0 1 0 0 0 1 0 0 1 0 1 0 1 0 0
     * 
     * Output : 5
     */

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
        int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

        int board[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 1) {
                    answer++;
                    dfs(i, j, n, board, dx, dy);
                }

        System.out.println(answer);
    }

    public static void dfs(int row, int col, int size, int[][] board, int[] dx, int[] dy) {
        for (int i = 0; i < dx.length; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];
            if (nr >= 0 && nr < size && nc >= 0 && nc < size && board[nr][nc] != 0) {
                board[nr][nc] = 0;
                dfs(nr, nc, size, board, dx, dy);
            }
        }
    }

}
