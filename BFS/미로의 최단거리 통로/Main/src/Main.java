import java.util.*;
import java.io.*;

public class Main {

    static int answer = 1;

    static class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 7;

        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(bfs(0, 0, n, board, visited, dx, dy));
    }

    public static int bfs(int row, int col, int size, int[][] board, boolean[][] visited, int[] dx, int[] dy) {

        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(row, col, 0));
        visited[row][col] = true;

        while (!que.isEmpty()) {
            Position curr = que.poll();
            
            if(curr.x == size - 1 && curr.y == size - 1)
                return curr.distance;

            for (int i = 0; i < dx.length; i++) {
                int nr = curr.x + dx[i];
                int nc = curr.y + dy[i];
                if (nr >= 0 && nr < size && nc >= 0 && nc < size && board[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    que.offer(new Position(nr, nc, curr.distance + 1));
                }
            }
        }
        return - 1;
    }
}
