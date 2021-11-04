import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
/* 
    설명
        원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
        원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
        아래의 그림은 그 한 예를 설명하는 그림이다.
        위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.

    입력
        첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
        다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
        이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

    출력
        모든 도시를 연결하면서 드는 최소비용을 출려한다.

    Input :
        9 12
        1 2 12
        1 9 25
        2 3 10
        2 8 17
        2 9 8
        3 4 18
        3 7 55
        4 5 44
        5 6 60
        5 7 38
        7 8 35
        8 9 15

    Output :
        196
*/

    static class Node implements Comparable<Node>{
        int f1, f2, cost;
        public Node(int f1, int f2, int cost){
            this.f1 = f1;
            this.f2 = f2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    public static final int INF = Integer.MAX_VALUE;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        
        int v = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());

        Node[] arr = new Node[e];
        int[] nodes = new int[v + 1];
        for(int i = 1; i < nodes.length; i ++) nodes[i] = i;

        for(int i = 0; i < e; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[i] = new Node(node, next, cost);
        }

        Arrays.sort(arr);
        createTree(arr, nodes);

        System.out.println(answer);
    }

    public static void createTree(Node[] arr, int[] nodes){
        for(Node item : arr){
            if(union(nodes, item.f1, item.f2))
                answer += item.cost;
        }
    }

    public static boolean union(int[] nodes, int a, int b){
        if(find(nodes, a) != find(nodes, b)){
            nodes[find(nodes, a)] = find(nodes, b);
            return true;
        }
        return false;
    }

    public static int find(int[] nodes, int a){
        if(nodes[a] == a) return a;
        return nodes[a] = find(nodes, nodes[a]);
    }
}
