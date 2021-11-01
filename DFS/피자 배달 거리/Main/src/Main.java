import java.util.*;
import java.io.*;

public class Main {
/* 
    설명
        N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
        각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
        행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
        도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
        피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
        집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
        예를 들어, 도시의 지도가 아래와 같다면
        (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
        최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
        도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
        시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
        도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.

    입력
        첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
        둘째 줄부터 도시 정보가 입력된다.

    출력
        첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.

    Input :
        4 4
        0 1 2 0
        1 0 2 1
        0 2 1 2
        2 0 1 2

    Output :
        6
*/

    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int sum = 0, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());

        int[][] board = new int[n][n];
        Position[] output = new Position[m];
        int dx[] = { 0,0,1,-1,1,1,-1,-1 };
        int dy[] = { 1,-1,0,0,1,-1,1,-1 }; 
        
        ArrayList<Position> pizza = new ArrayList<>();
        ArrayList<Position> house = new ArrayList<>();
        
        for(int x = 0; x < n; x ++)
        board[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();
        
        for(int x = 0; x < n; x ++)
            for(int y = 0; y < n; y ++){
                if(board[x][y] == 1)
                    house.add(new Position(x, y));
                else if(board[x][y] == 2)
                    pizza.add(new Position(x, y));
        }

        boolean[] visited = new boolean[pizza.size()];
        dfs(0, 0, m, pizza, house, output, board, visited, dx, dy);
        System.out.println(answer);
    }

    public static void dfs(int depth, int index, int size, ArrayList<Position> pizza, ArrayList<Position> house, Position[] output, int[][] board, boolean[] visited, int[] dx, int[] dy){

        if(depth == size){
            for(Position houseLocation : house){
                int root = Integer.MAX_VALUE;
                for(Position pizzaLocation : output){
                    int distance = 0;
                    distance = (Math.abs(houseLocation.x - pizzaLocation.x)) + (Math.abs(houseLocation.y - pizzaLocation.y));
                    root = (root > distance) ? distance : root;
                }
                sum += root;
            }
            answer = (answer > sum) ? sum : answer;
            sum = 0;
            return;
        }else{
            for(int i = index; i < pizza.size(); i ++){
                if(!visited[i]){
                    visited[i] = true;
                    output[depth] = pizza.get(i);
                    dfs(depth + 1, i, size, pizza, house, output, board, visited, dx, dy);
                    visited[i] = false;
                }
            }
        }

    }

}
